/*
 * (C) Copyright 2018 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia.wdm.test;

import static io.github.bonigarcia.wdm.WebDriverManager.seleniumServerStandalone;
import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.Assert.assertTrue;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.File;

import org.junit.Test;
import org.slf4j.Logger;

/**
 * Test with Selenium Server.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 3.0.1
 */
public class SeleniumServerStandaloneTest {

    final Logger log = getLogger(lookup().lookupClass());

    @Test
    public void testSeleniumServerLatest() {
        seleniumServerStandalone().setup();
        assertBinary();
    }

    @Test
    public void testSeleniumServerVersion() {
        seleniumServerStandalone().version("3.13").setup();
        assertBinary();
    }

    private void assertBinary() {
        File binary = new File(seleniumServerStandalone().getBinaryPath());
        log.debug("Binary path for selenium-server-standalone {}", binary);
        assertTrue(binary.exists());
    }

}
