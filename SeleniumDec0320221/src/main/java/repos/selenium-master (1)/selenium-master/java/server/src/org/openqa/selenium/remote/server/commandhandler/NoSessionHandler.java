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

package org.openqa.selenium.remote.server.commandhandler;

import static com.google.common.net.MediaType.JSON_UTF_8;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.openqa.selenium.remote.ErrorCodes.NO_SUCH_SESSION;

import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.json.Json;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.remote.server.CommandHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NoSessionHandler implements CommandHandler {

  private final Json json;
  private final SessionId sessionId;

  public NoSessionHandler(Json json, SessionId sessionId) {
    this.json = Objects.requireNonNull(json);
    this.sessionId = Objects.requireNonNull(sessionId);
  }

  @Override
  public void execute(HttpRequest req, HttpResponse resp) throws IOException {
    // We're not using ImmutableMap for the outer map because it disallows null values.
    Map<String, Object> responseMap = new HashMap<>();
    responseMap.put("sessionId", sessionId.toString());
    responseMap.put("status", NO_SUCH_SESSION);
    responseMap.put("value", ImmutableMap.of(
        "error", "invalid session id",
        "message", String.format("No active session with ID %s", sessionId),
        "stacktrace", ""));
    responseMap = Collections.unmodifiableMap(responseMap);

    byte[] payload = json.toJson(responseMap).getBytes(UTF_8);

    resp.setStatus(HTTP_NOT_FOUND);
    resp.setHeader("Content-Type", JSON_UTF_8.toString());
    resp.setHeader("Content-Length", String.valueOf(payload.length));

    resp.setContent(payload);
  }
}
