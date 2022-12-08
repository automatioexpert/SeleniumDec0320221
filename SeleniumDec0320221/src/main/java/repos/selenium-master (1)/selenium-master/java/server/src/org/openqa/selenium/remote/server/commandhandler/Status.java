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
import static java.net.HttpURLConnection.HTTP_OK;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.openqa.selenium.remote.ErrorCodes.SUCCESS;

import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.internal.BuildInfo;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.remote.server.CommandHandler;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class Status implements CommandHandler {

  private final Json json;

  Status(Json json) {
    this.json = Objects.requireNonNull(json);
  }

  @Override
  public void execute(HttpRequest req, HttpResponse resp) throws IOException {
    ImmutableMap.Builder<String, Object> value = ImmutableMap.builder();

    // W3C spec
    value.put("ready", true);
    value.put("message", "Server is running");

    // And now more information
    BuildInfo buildInfo = new BuildInfo();
    value.put("build", ImmutableMap.of(
        // We need to fix the BuildInfo to properly fill out these values.
          "revision", buildInfo.getBuildRevision(),
          "time", buildInfo.getBuildTime(),
        "version", buildInfo.getReleaseLabel()));

    value.put("os", ImmutableMap.of(
        "arch", System.getProperty("os.arch"),
        "name", System.getProperty("os.name"),
        "version", System.getProperty("os.version")));

    value.put("java", ImmutableMap.of("version", System.getProperty("java.version")));

    Map<String, Object> payloadObj = ImmutableMap.of(
        "status", SUCCESS,
        "value", value.build());

    // Write out a minimal W3C status response.
    byte[] payload = json.toJson(payloadObj).getBytes(UTF_8);

    resp.setStatus(HTTP_OK);
    resp.setHeader("Content-Type", JSON_UTF_8.toString());
    resp.setHeader("Content-Length", String.valueOf(payload.length));

    resp.setContent(payload);
  }
}
