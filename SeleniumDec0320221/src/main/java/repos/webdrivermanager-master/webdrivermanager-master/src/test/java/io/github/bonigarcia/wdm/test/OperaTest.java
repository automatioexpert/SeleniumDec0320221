/*
 * (C) Copyright 2015 Boni Garcia (http://bonigarcia.github.io/)
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

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;
import static org.junit.Assume.assumeTrue;

import java.io.File;

import org.junit.Before;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.base.BrowserTestParent;

/**
 * Test with Opera browser.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.0.0
 */
public class OperaTest extends BrowserTestParent {

    @Before
    public void setupTest() {
        String operaBinary = IS_OS_WINDOWS
                ? "C:\\Program Files\\Opera\\launcher.exe"
                : IS_OS_MAC ? "/Applications/Opera.app/Contents/MacOS/Opera"
                        : "/usr/bin/opera";
        File opera = new File(operaBinary);
        assumeTrue(opera.exists());

        WebDriverManager.operadriver().setup();
        OperaOptions options = new OperaOptions();
        options.setBinary(operaBinary);
        driver = new OperaDriver(options);
    }

}
