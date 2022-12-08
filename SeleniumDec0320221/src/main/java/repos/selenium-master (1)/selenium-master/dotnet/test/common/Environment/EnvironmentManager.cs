using System;
using System.Reflection;
using System.IO;
using Newtonsoft.Json;
using NUnit.Framework;

namespace OpenQA.Selenium.Environment
{
    public class EnvironmentManager
    {
        private static EnvironmentManager instance;
        private Type driverType;
        private Browser browser;
        private IWebDriver driver;
        private UrlBuilder urlBuilder;
        private TestWebServer webServer;
        private DriverFactory driverFactory;
        private RemoteSeleniumServer remoteServer;
        private string remoteCapabilities;

        private EnvironmentManager()
        {
            string currentDirectory = this.CurrentDirectory;
            string content = File.ReadAllText(Path.Combine(currentDirectory, "appconfig.json"));
            TestEnvironment env = JsonConvert.DeserializeObject<TestEnvironment>(content);

            string activeDriverConfig = TestContext.Parameters.Get("ActiveDriverConfig", env.ActiveDriverConfig);
            string activeWebsiteConfig = TestContext.Parameters.Get("ActiveWebsiteConfig", env.ActiveWebsiteConfig);
            string driverServiceLocation = TestContext.Parameters.Get("DriverServiceLocation", env.DriverServiceLocation);
            DriverConfig driverConfig = env.DriverConfigs[activeDriverConfig];
            WebsiteConfig websiteConfig = env.WebSiteConfigs[activeWebsiteConfig];
            this.driverFactory = new DriverFactory(driverServiceLocation);

            Assembly driverAssembly = Assembly.Load(driverConfig.AssemblyName);
            driverType = driverAssembly.GetType(driverConfig.DriverTypeName);
            browser = driverConfig.BrowserValue;
            remoteCapabilities = driverConfig.RemoteCapabilities;

            urlBuilder = new UrlBuilder(websiteConfig);

            DirectoryInfo info = new DirectoryInfo(currentDirectory);
            while (info != info.Root && string.Compare(info.Name, "buck-out", StringComparison.OrdinalIgnoreCase) != 0 && string.Compare(info.Name, "build", StringComparison.OrdinalIgnoreCase) != 0)
            {
                info = info.Parent;
            }

            info = info.Parent;
            webServer = new TestWebServer(info.FullName);
            bool autoStartRemoteServer = false;
            if (browser == Browser.Remote)
            {
                autoStartRemoteServer = driverConfig.AutoStartRemoteServer;
            }

            remoteServer = new RemoteSeleniumServer(info.FullName, autoStartRemoteServer);
        }

        ~EnvironmentManager()
        {
            if (remoteServer != null)
            {
                remoteServer.Stop();
            }
            if (webServer != null)
            {
                webServer.Stop();
            }
            if (driver != null)
            {
                driver.Quit();
            }
        }

        public Browser Browser 
        {
            get { return browser; }
        }

        public string DriverServiceDirectory
        {
            get { return this.driverFactory.DriverServicePath; }
        }

        public string CurrentDirectory
        {
            get
            {
                string assemblyLocation = Path.GetDirectoryName(typeof(EnvironmentManager).Assembly.Location);
                string testDirectory = TestContext.CurrentContext.TestDirectory;
                if (assemblyLocation != testDirectory)
                {
                    return assemblyLocation;
                }
                return testDirectory;
            }
        }
        
        public TestWebServer WebServer
        {
            get { return webServer; }
        }

        public RemoteSeleniumServer RemoteServer
        {
            get { return remoteServer; }
        }

        public string RemoteCapabilities
        {
            get { return remoteCapabilities; }
        }

        public IWebDriver GetCurrentDriver()
        {
            if (driver != null)
            { 
                return driver; 
            }
            else 
            { 
                return CreateFreshDriver(); 
            }
        }

        public IWebDriver CreateDriverInstance()
        {
            return driverFactory.CreateDriver(driverType);
        }

        public IWebDriver CreateDriverInstance(DriverOptions options)
        {
            return driverFactory.CreateDriverWithOptions(driverType, options);
        }

        public IWebDriver CreateFreshDriver()
        {
            CloseCurrentDriver();
            driver = CreateDriverInstance();
            return driver;
        }

        public void CloseCurrentDriver()
        {
            if (driver != null) 
            {
                driver.Quit(); 
            }
            driver = null;
        }

        public static EnvironmentManager Instance
        {
            get
            {
                if (instance == null)
                {
                    instance = new EnvironmentManager();
                }

                return instance;
            }
        }

        public UrlBuilder UrlBuilder
        {
            get
            {
                return urlBuilder;
            }
        }

    }
}
