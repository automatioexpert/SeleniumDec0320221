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

package org.openqa.selenium.support.ui;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;

import java.util.concurrent.TimeUnit;

/**
 * Represents an immutable duration of time.
 *
 * @deprecated use {@link java.time.Duration}
 */
@Deprecated
public class Duration {

  private final long time;
  private final TimeUnit unit;

  /**
   * @deprecated use {@link java.time.Duration}
   *
   * @param time The amount of time.
   * @param unit The unit of time.
   */
  @Deprecated
  public Duration(long time, TimeUnit unit) {
    checkArgument(time >= 0, "Duration < 0: %d", time);
    checkNotNull(unit);
    this.time = time;
    this.unit = unit;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Duration) {
      Duration other = (Duration) o;
      return this.time == other.time
          && this.unit == other.unit;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(time, unit);
  }

  @Override
  public String toString() {
    return String.format("%d %s", time, unit);
  }

  /**
   * Converts this duration to the given unit of time.
   *
   * @deprecated use {@link java.time.Duration}
   *
   * @param unit The time unit to convert to.
   * @return The value of this duration in the specified unit of time.
   */
  @Deprecated
  public long in(TimeUnit unit) {
    return unit.convert(time, this.unit);
  }
}
