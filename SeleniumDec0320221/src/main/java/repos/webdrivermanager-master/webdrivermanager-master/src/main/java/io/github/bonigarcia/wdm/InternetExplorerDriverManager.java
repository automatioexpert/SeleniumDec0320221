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
package io.github.bonigarcia.wdm;

import static io.github.bonigarcia.wdm.DriverManagerType.IEXPLORER;
import static java.util.Optional.empty;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

/**
 * Manager for Internet Explorer.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.0.0
 */
public class InternetExplorerDriverManager extends WebDriverManager {

    protected InternetExplorerDriverManager() {
        driverManagerType = IEXPLORER;
        exportParameterKey = "wdm.internetExplorerDriverExport";
        driverVersionKey = "wdm.internetExplorerDriverVersion";
        driverUrlKey = "wdm.internetExplorerDriverUrl";
        driverName = "IEDriverServer";
    }

    @Override
    protected List<URL> getDrivers() throws IOException {
        URL driverUrl = config().getDriverUrl(driverUrlKey);
        return getDriversFromXml(driverUrl);
    }

    @Override
    protected Optional<String> getBrowserVersion() {
        return empty();
    }

}
