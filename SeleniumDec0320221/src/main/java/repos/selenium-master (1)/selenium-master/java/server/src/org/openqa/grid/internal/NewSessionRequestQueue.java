// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.openqa.grid.internal;

import net.jcip.annotations.ThreadSafe;

import org.openqa.grid.internal.listeners.Prioritizer;
import org.openqa.grid.web.servlet.handler.RequestHandler;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * The queue of all incoming "new session" requests to the grid.
 *
 * Currently still uses the readerwriterlock/condition model that is used in the
 * GridRegistry and is tightly coupled to the registry
 */
@ThreadSafe
public class NewSessionRequestQueue {

  private static final Logger log = Logger.getLogger(NewSessionRequestQueue.class.getName());

  private final List<RequestHandler> newSessionRequests = new ArrayList<>();


  /**
   * Adds a request handler to this queue.
   * @param request the RequestHandler to add
   */
  public synchronized void add(RequestHandler request) {
    newSessionRequests.add(request);
  }

  /**
   * Processes all the entries in this queue.
   *
   * @param handlerConsumer The consumer that returns true if it has taken the item from the queue
   * @param prioritizer     The prioritizer to use
   */

  public synchronized void processQueue(
      Predicate<RequestHandler> handlerConsumer,
      Prioritizer prioritizer) {

    List<RequestHandler> copy = new ArrayList<>(newSessionRequests);
    if (prioritizer != null) {
      copy.sort((a,b) -> prioritizer.compareTo(
          a.getRequest().getDesiredCapabilities(), b.getRequest().getDesiredCapabilities()));
    }

    copy.stream()
        .filter(handlerConsumer)
        .forEach(requestHandler -> {
          if (!removeNewSessionRequest(requestHandler)) {
            log.severe("Bug removing request " + requestHandler);
          }
        });
  }

  /**
   * clear the entire list of requests
   */
  public synchronized void clearNewSessionRequests() {
    newSessionRequests.clear();
  }

  /**
   * Remove a specific request
   * @param request The request to remove
   * @return A boolean result from doing a newSessionRequest.remove(request).
   */
  public synchronized boolean removeNewSessionRequest(RequestHandler request) {
    return newSessionRequests.remove(request);
  }

  /**
   * Provides the desired capabilities of all the items in this queue.
   *
   * @return An Iterable of unmodifiable maps.
   */
  public synchronized Iterable<DesiredCapabilities> getDesiredCapabilities() {
    return newSessionRequests.stream()
        .map(req -> new DesiredCapabilities(req.getRequest().getDesiredCapabilities()))
        .collect(Collectors.toList());
  }

  /**
   * Returns the number of unprocessed items in this request queue.
   * @return the size of the queue
   */
  public synchronized int getNewSessionRequestCount() {
    return newSessionRequests.size();
  }

  public synchronized void stop() {
    newSessionRequests.forEach(RequestHandler::stop);
  }
}
