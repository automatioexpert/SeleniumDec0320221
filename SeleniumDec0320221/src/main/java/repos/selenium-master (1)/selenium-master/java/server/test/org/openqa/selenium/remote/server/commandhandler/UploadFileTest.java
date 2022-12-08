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

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.io.Zip;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.remote.Dialect;
import org.openqa.selenium.remote.ErrorHandler;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.remote.server.ActiveSession;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class UploadFileTest {

  private TemporaryFilesystem tempFs;
  private File tempDir;

  @Before
  public void setUp() {
    tempDir = Files.createTempDir();
    tempFs = TemporaryFilesystem.getTmpFsBasedOn(tempDir);
  }

  @After
  public void cleanUp() {
    tempFs.deleteTemporaryFiles();
    tempDir.delete();
  }

  @Test
  public void shouldWriteABase64EncodedZippedFileToDiskAndKeepName() throws Exception {
    ActiveSession session = mock(ActiveSession.class);
    when(session.getId()).thenReturn(new SessionId("1234567"));
    when(session.getFileSystem()).thenReturn(tempFs);
    when(session.getDownstreamDialect()).thenReturn(Dialect.OSS);

    File tempFile = touch(null, "foo");
    String encoded = Zip.zip(tempFile);

    Gson gson = new Gson();
    UploadFile uploadFile = new UploadFile(new Json(), session);
    Map<String, Object> args = ImmutableMap.of("file", encoded);
    HttpRequest request = new HttpRequest(HttpMethod.POST, "/session/%d/se/file");
    request.setContent(gson.toJson(args).getBytes(UTF_8));
    HttpResponse response = new HttpResponse();
    uploadFile.execute(request, response);

    Response res = new Json().toType(response.getContentString(), Response.class);
    String path = (String) res.getValue();
    assertTrue(new File(path).exists());
    assertTrue(path.endsWith(tempFile.getName()));
  }

  @Test
  public void shouldThrowAnExceptionIfMoreThanOneFileIsSent() throws Exception {
    ActiveSession session = mock(ActiveSession.class);
    when(session.getId()).thenReturn(new SessionId("1234567"));
    when(session.getFileSystem()).thenReturn(tempFs);
    when(session.getDownstreamDialect()).thenReturn(Dialect.OSS);

    File baseDir = Files.createTempDir();
    touch(baseDir, "example");
    touch(baseDir, "unwanted");
    String encoded = Zip.zip(baseDir);

    Gson gson = new Gson();
    UploadFile uploadFile = new UploadFile(new Json(), session);
    Map<String, Object> args = ImmutableMap.of("file", encoded);
    HttpRequest request = new HttpRequest(HttpMethod.POST, "/session/%d/se/file");
    request.setContent(gson.toJson(args).getBytes(UTF_8));
    HttpResponse response = new HttpResponse();
    uploadFile.execute(request, response);

    try {
      new ErrorHandler(false).throwIfResponseFailed(
          new Json().toType(response.getContentString(), Response.class),
          100);
      fail("Should not get this far");
    } catch (WebDriverException ignored) {
      // Expected
    }
  }

  private File touch(File baseDir, String stem) throws IOException {
    File tempFile = File.createTempFile(stem, ".txt", baseDir);
    tempFile.deleteOnExit();
    Files.asCharSink(tempFile, UTF_8).write("I like cheese");
    return tempFile;
  }
}
