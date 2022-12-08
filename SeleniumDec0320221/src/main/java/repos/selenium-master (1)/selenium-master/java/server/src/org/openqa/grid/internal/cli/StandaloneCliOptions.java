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

package org.openqa.grid.internal.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import org.openqa.grid.internal.utils.configuration.StandaloneConfiguration;

public class StandaloneCliOptions extends CommonCliOptions {

  public StandaloneCliOptions parse(String[] args) {
    JCommander.newBuilder().addObject(this).build().parse(args);
    return this;
  }

  /**
   * JSON config file to use. Defaults to {@code null}.
   */
  @Parameter(
      names = "-config",
      description = "<String> filename : JSON configuration file for the standalone server. Overrides default values",
      validateValueWith = FileExistsValueValidator.class
  )
  private String configFile;

  public StandaloneConfiguration toConfiguration() {
    StandaloneConfiguration configuration = new StandaloneConfiguration();
    if (configFile != null) {
      // read configuration from the file
    }

    fillCommonConfiguration(configuration);
    return configuration;
  }

}
