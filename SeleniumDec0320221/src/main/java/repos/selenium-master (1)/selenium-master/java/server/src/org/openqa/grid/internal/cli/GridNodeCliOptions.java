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

import static org.openqa.grid.internal.utils.configuration.GridNodeConfiguration.DEFAULT_NODE_CONFIG_FILE;

import com.beust.jcommander.IDefaultProvider;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import org.openqa.grid.common.exception.GridConfigurationException;
import org.openqa.grid.internal.utils.configuration.GridNodeConfiguration;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.json.Json;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GridNodeCliOptions extends CommonGridCliOptions {

  public static class Parser {

    public GridNodeCliOptions parse(String[] args) {
      GridNodeCliOptions result = new GridNodeCliOptions();
      JCommander.newBuilder().addObject(result).build().parse(args);

      if (result.configFile != null) {
        // Second round
        String configFile = result.configFile;
        result = new GridNodeCliOptions();
        JCommander.newBuilder().addObject(result)
            .defaultProvider(defaults(fromConfigFile(configFile))).build().parse(args);
      }

      return result;
    }
  }

  /**
   * @deprecated Use GridNodeCliOptions.Parser instead
   */
  @Deprecated
  public GridNodeCliOptions parse(String[] args) {
    JCommander.newBuilder().addObject(this).build().parse(args);

    if (configFile != null) {
      //re-parse the args using any -nodeConfig specified to init
      JCommander.newBuilder().addObject(this)
          .defaultProvider(defaults(fromConfigFile(configFile))).build().parse(args);
    }
    return this;
  }

  private static IDefaultProvider defaults(String json) {
    Map<String, Object> map = new Json().toType(json, Map.class);
    map.remove("custom");
    map.remove("capabilities");
    map.remove("servlets");
    map.remove("withoutServlets");
    return optionName -> {
      String option = optionName.replaceAll("-", "");
      return map.containsKey(option) ? map.get(option).toString() : null;
    };
  }

  /**
   * Node specific json config file to use. Defaults to {@code null}.
   */
  @Parameter(
      names = "-nodeConfig",
      description = "<String> filename : JSON configuration file for the node. Overrides default values",
      validateValueWith = FileExistsValueValidator.class
  )
  private String configFile;

  /**
   * The address to report to the hub. By default it's generated based on the host and port specified.
   * Setting a value overrides the default (http://<host>:<port>).
   */
  @Parameter(
      names = "-remoteHost",
      description = "<String> URL: Address to report to the hub. Used to override default (http://<host>:<port>)."
  )
  private String remoteHost;

  /**
   * The host name or IP of the hub. Defaults to {@code null}.
   */
  @Parameter(
      names = "-hubHost",
      description = "<String> IP or hostname : the host address of the hub we're attempting to register with. If -hub is specified the -hubHost is determined from it."
  )
  private String hubHost;

  /**
   * The port of the hub. Defaults to {@code null}.
   */
  @Parameter(
      names = "-hubPort",
      description = "<Integer> : the port of the hub we're attempting to register with. If -hub is specified the -hubPort is determined from it."
  )
  private Integer hubPort;

  /**
   * The id tu use for this node. Automatically generated when {@code null}. Defaults to {@code null}.
   */
  @Parameter(
      names = "-id",
      description = "<String> : optional unique identifier for the node. Defaults to the url of the remoteHost, when not specified."
  )
  private String id;

  /**
   * The capabilties of this node. Defaults from the capabilities specified in the
   * {@link GridNodeConfiguration#DEFAULT_NODE_CONFIG_FILE} or an empty list if the
   * {@link GridNodeConfiguration#DEFAULT_NODE_CONFIG_FILE}
   * can not be loaded.
   */
  @Parameter(
      names = { "-capabilities", "-browser" },
      description = "<String> : comma separated Capability values. Example: -capabilities browserName=firefox,platform=linux -capabilities browserName=chrome,platform=linux",
      listConverter = BrowserDesiredCapabilityConverter.class,
      converter = BrowserDesiredCapabilityConverter.class,
      splitter = NoOpParameterSplitter.class
  )
  private List<MutableCapabilities> capabilities;

  /**
   * The down polling limit for the node. Defaults to {@code null}.
   */
  @Parameter(
      names = "-downPollingLimit",
      description = "<Integer> : node is marked as \"down\" if the node hasn't responded after the number of checks specified in [downPollingLimit]."
  )
  private Integer downPollingLimit;

  /**
   * The hub url. Defaults to {@code http://localhost:4444}.
   */
  @Parameter(
      names = "-hub",
      description = "<String> : the url that will be used to post the registration request. This option takes precedence over -hubHost and -hubPort options."
  )
  private String hub;

  /**
   * How often to pull the node. Defaults to 5000 ms
   */
  @Parameter(
      names = "-nodePolling",
      description = "<Integer> in ms : specifies how often the hub will poll to see if the node is still responding."
  )
  private Integer nodePolling;

  /**
   * When to time out a node status check. Defaults is after 5000 ms.
   */
  @Parameter(
      names = "-nodeStatusCheckTimeout",
      description = "<Integer> in ms : connection/socket timeout, used for node \"nodePolling\" check."
  )
  private Integer nodeStatusCheckTimeout;

  /**
   * The proxy class name to use. Defaults to org.openqa.grid.selenium.proxy.DefaultRemoteProxy.
   */
  @Parameter(
      names = "-proxy",
      description = "<String> : the class used to represent the node proxy. Default is [org.openqa.grid.selenium.proxy.DefaultRemoteProxy]."
  )
  private String proxy;

  /**
   * Whether to register this node with the hub. Defaults to {@code true}
   */
  @Parameter(
      names = "-register",
      description = "if specified, node will attempt to re-register itself automatically with its known grid hub if the hub becomes unavailable.",
      arity = 1
  )
  private Boolean register;

  /**
   * How often to re-register this node with the hub. Defaults to every 5000 ms.
   */
  @Parameter(
      names = "-registerCycle",
      description = "<Integer> in ms : specifies how often the node will try to register itself again. Allows administrator to restart the hub without restarting (or risk orphaning) registered nodes. Must be specified with the \"-register\" option."
  )
  private Integer registerCycle;

  /**
   * How long to wait before marking this node down. Defaults is 60000 ms.
   */
  @Parameter(
      names = "-unregisterIfStillDownAfter",
      description = "<Integer> in ms : if the node remains down for more than [unregisterIfStillDownAfter] ms, it will stop attempting to re-register from the hub."
  )
  private Integer unregisterIfStillDownAfter;

  /**
   * Whether or not to drop capabilities that does not belong to the current platform family
   */
  @Parameter(
      names = "-enablePlatformVerification",
      arity = 1,
      description = "<Boolean>: Whether or not to drop capabilities that does not belong to the current platform family. Defaults to true."
  )
  private Boolean enablePlatformVerification;

  public GridNodeConfiguration toConfiguration() {
    GridNodeConfiguration configuration = GridNodeConfiguration.loadFromJSON(
        configFile == null ? DEFAULT_NODE_CONFIG_FILE : configFile);
    fillCommonConfiguration(configuration);
    fillCommonGridConfiguration(configuration);
    if (hub != null) {
      configuration.hub = hub;
      // -hub has precedence
      if (hubHost != null) {
        throw new GridConfigurationException("You can't specify both -hubHost and -hub options at the same time");
      }
      if (hubPort != null) {
        throw new GridConfigurationException("You can't specify both -hubPort and -hub options at the same time");
      }
      configuration.hubHost = null;
      configuration.hubPort = null;
    } else if (hubHost != null && hubPort != null) {
      configuration.hub = null;
      configuration.hubHost = hubHost;
      configuration.hubPort = hubPort;
    }
    if (configFile != null) {
      configuration.nodeConfigFile = configFile;
    }
    if (remoteHost != null) {
      configuration.remoteHost = remoteHost;
    }
    if (id != null) {
      configuration.id = id;
    }
    if (capabilities != null) {
      configuration.capabilities = capabilities;
    }
    if (downPollingLimit != null) {
      configuration.downPollingLimit = downPollingLimit;
    }
    if (nodePolling != null) {
      configuration.nodePolling = nodePolling;
    }
    if (nodeStatusCheckTimeout != null) {
      configuration.nodeStatusCheckTimeout = nodeStatusCheckTimeout;
    }
    if (proxy != null) {
      configuration.proxy = proxy;
    }
    if (register != null) {
      configuration.register = register;
    }
    if (registerCycle != null) {
      configuration.registerCycle = registerCycle;
    }
    if (unregisterIfStillDownAfter != null) {
      configuration.unregisterIfStillDownAfter = unregisterIfStillDownAfter;
    }
    if (enablePlatformVerification != null) {
      configuration.enablePlatformVerification = enablePlatformVerification;
    }
    return configuration;
  }

}
