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

package org.openqa.selenium.devtools.v85;

import org.openqa.selenium.devtools.idealized.Domains;
import org.openqa.selenium.devtools.idealized.fetch.Fetch;
import org.openqa.selenium.devtools.idealized.log.Log;
import org.openqa.selenium.devtools.idealized.page.Page;
import org.openqa.selenium.devtools.idealized.runtime.RuntimeDomain;
import org.openqa.selenium.devtools.idealized.target.Target;

public class V85Domains implements Domains {
  @Override
  public Fetch fetch() {
    return new V85Fetch();
  }

  @Override
  public Log log() {
    return new V85Log();
  }

  @Override
  public Page page() {
    return new V85Page();
  }

  @Override
  public RuntimeDomain runtime() {
    return new V85Runtime();
  }

  @Override
  public Target target() {
    return new V85Target();
  }
}
