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

package org.openqa.selenium.remote.server;

import com.google.common.collect.ImmutableList;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.Dialect;
import org.openqa.selenium.remote.NewSessionPayload;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public class NewSessionPipeline {

  private final List<SessionFactory> factories;
  private final SessionFactory fallback;
  private final List<Function<Capabilities, Capabilities>> mutators;

  private NewSessionPipeline(
      List<SessionFactory> factories,
      SessionFactory fallback,
      List<Function<Capabilities, Capabilities>> mutators) {
    this.factories = factories;
    this.fallback = fallback;
    this.mutators = mutators;
  }

  public static Builder builder() {
    return new Builder();
  }

  public ActiveSession createNewSession(NewSessionPayload payload) throws IOException {
    return payload.stream()
        .map(caps -> {
          for (Function<Capabilities, Capabilities> mutator : mutators) {
            caps = mutator.apply(caps);
          }
          return caps;
        })
        .map(caps -> factories.stream()
            .filter(factory -> factory.isSupporting(caps))
            .map(factory -> factory.apply(payload.getDownstreamDialects(), caps))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .findFirst())
        .filter(Optional::isPresent)
        .map(Optional::get)
        .findFirst()
        .orElseGet(() ->
          fallback.apply(payload.getDownstreamDialects(), new ImmutableCapabilities())
              .orElseThrow(
                  () -> new SessionNotCreatedException("Unable to create session from " + payload))
        );
  }

  public static class Builder {
    private List<SessionFactory> factories = new LinkedList<>();
    private SessionFactory fallback = new SessionFactory() {
      @Override
      public boolean isSupporting(Capabilities capabilities) {
        return false;
      }

      @Override
      public Optional<ActiveSession> apply(Set<Dialect> downstreamDialects, Capabilities capabilities) {
        return Optional.empty();
      }
    };
    private List<Function<Capabilities, Capabilities>> mutators = new LinkedList<>();

    private Builder() {
      // Private class
    }

    public Builder add(SessionFactory factory) {
      factories.add(Objects.requireNonNull(factory, "Factory must not be null"));
      return this;
    }

    public Builder fallback(SessionFactory factory) {
      fallback = Objects.requireNonNull(factory, "Fallback must not be null");
      return this;
    }

    public Builder addCapabilitiesMutator(
        Function<Capabilities, Capabilities> mutator) {
      mutators.add(Objects.requireNonNull(mutator, "Mutator must not be null"));
      return this;
    }

    public NewSessionPipeline create() {
      return new NewSessionPipeline(ImmutableList.copyOf(factories), fallback, mutators);
    }
  }
}
