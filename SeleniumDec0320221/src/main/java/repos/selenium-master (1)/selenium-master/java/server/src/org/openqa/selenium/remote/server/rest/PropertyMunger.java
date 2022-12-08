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

package org.openqa.selenium.remote.server.rest;

import org.openqa.selenium.json.SimplePropertyDescriptor;

import java.lang.reflect.Method;

class PropertyMunger {

  public static Object get(String name, Object on) {
    SimplePropertyDescriptor[] properties =
        SimplePropertyDescriptor.getPropertyDescriptors(on.getClass());
    for (SimplePropertyDescriptor property : properties) {
      if (property.getName().equals(name) && property.getReadMethod() != null) {
        Object result = property.getReadMethod().apply(on);
        return String.valueOf(result);
      }
    }

    return null;
  }

  public static void set(String name, Object on, Object value) throws Exception {
    SimplePropertyDescriptor[] properties =
        SimplePropertyDescriptor.getPropertyDescriptors(on.getClass());
    for (SimplePropertyDescriptor property : properties) {
      if (property.getName().equals(name)) {
        Method writeMethod = property.getWriteMethod();
        if (writeMethod == null) {
          return;
        }

        Class<?>[] types = writeMethod.getParameterTypes();
        if (types.length != 1) {
          return;
        }

        if (String.class.equals(types[0])) {
          writeMethod.invoke(on, value);
        }
      }
    }
  }
}
