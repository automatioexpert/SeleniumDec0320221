/*
 * Copyright 2012-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.actuate.autoconfigure.observation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.micrometer.core.instrument.observation.MeterObservationHandler;
import io.micrometer.observation.ObservationHandler;
import io.micrometer.observation.ObservationHandler.FirstMatchingCompositeObservationHandler;
import io.micrometer.observation.ObservationRegistry.ObservationConfig;
import io.micrometer.tracing.handler.TracingObservationHandler;

/**
 * {@link ObservationHandlerGrouping} used by {@link ObservationAutoConfiguration} if
 * micrometer-tracing is on the classpath.
 *
 * Groups all {@link MeterObservationHandler} into a
 * {@link FirstMatchingCompositeObservationHandler}, and all
 * {@link TracingObservationHandler} into a
 * {@link FirstMatchingCompositeObservationHandler}. All other handlers are added to the
 * {@link ObservationConfig} directly.
 *
 * @author Moritz Halbritter
 */
class TracingObservationHandlerGrouping implements ObservationHandlerGrouping {

	@Override
	public void apply(Collection<ObservationHandler<?>> handlers, ObservationConfig config) {
		List<ObservationHandler<?>> meterObservationHandlers = new ArrayList<>();
		List<ObservationHandler<?>> tracingObservationHandlers = new ArrayList<>();
		for (ObservationHandler<?> handler : handlers) {
			if (handler instanceof MeterObservationHandler<?>) {
				meterObservationHandlers.add(handler);
			}
			else if (handler instanceof TracingObservationHandler<?>) {
				tracingObservationHandlers.add(handler);
			}
			else {
				config.observationHandler(handler);
			}
		}

		if (!meterObservationHandlers.isEmpty()) {
			config.observationHandler(
					new FirstMatchingCompositeObservationHandler(castToRawType(meterObservationHandlers)));
		}
		if (!tracingObservationHandlers.isEmpty()) {
			config.observationHandler(
					new FirstMatchingCompositeObservationHandler(castToRawType(tracingObservationHandlers)));
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<ObservationHandler> castToRawType(List<ObservationHandler<?>> handlers) {
		// See https://github.com/micrometer-metrics/micrometer/issues/3064
		return (List) handlers;
	}

}
