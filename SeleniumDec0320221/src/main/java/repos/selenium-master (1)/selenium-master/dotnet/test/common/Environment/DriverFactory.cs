using NUnit.Framework;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Edge;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.IE;
using OpenQA.Selenium.Opera;
using OpenQA.Selenium.Safari;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace OpenQA.Selenium.Environment
{
    public class DriverFactory
    {
        string driverPath;
        private Dictionary<Browser, Type> serviceTypes = new Dictionary<Browser, Type>();
        private Dictionary<Browser, Type> optionsTypes = new Dictionary<Browser, Type>();

        public DriverFactory(string driverPath)
        {
            if (string.IsNullOrEmpty(driverPath))
            {
                this.driverPath = TestContext.CurrentContext.TestDirectory;
            }
            else
            {
                this.driverPath = driverPath;
            }

            this.PopulateServiceTypes();
            this.PopulateOptionsTypes();
        }

        private void PopulateOptionsTypes()
        {
            this.optionsTypes[Browser.Chrome] = typeof(ChromeOptions);
            this.optionsTypes[Browser.Edge] = typeof(EdgeOptions);
            this.optionsTypes[Browser.Firefox] = typeof(FirefoxOptions);
            this.optionsTypes[Browser.IE] = typeof(InternetExplorerOptions);
            this.optionsTypes[Browser.Opera] = typeof(OperaOptions);
            this.optionsTypes[Browser.Safari] = typeof(SafariOptions);
        }

        private void PopulateServiceTypes()
        {
            this.serviceTypes[Browser.Chrome] = typeof(ChromeDriverService);
            this.serviceTypes[Browser.Edge] = typeof(EdgeDriverService);
            this.serviceTypes[Browser.Firefox] = typeof(FirefoxDriverService);
            this.serviceTypes[Browser.IE] = typeof(InternetExplorerDriverService);
            this.serviceTypes[Browser.Opera] = typeof(OperaDriverService);
            this.serviceTypes[Browser.Safari] = typeof(SafariDriverService);
        }

        public string DriverServicePath
        {
            get { return this.driverPath; }
        }

        public IWebDriver CreateDriver(Type driverType)
        {
            return CreateDriverWithOptions(driverType, null);
        }

        public IWebDriver CreateDriverWithOptions(Type driverType, DriverOptions driverOptions)
        {
            Browser browser = Browser.All;
            object service = null;
            object options = null;

            List<Type> constructorArgTypeList = new List<Type>();
            IWebDriver driver = null;
            if (typeof(ChromeDriver).IsAssignableFrom(driverType))
            {
                browser = Browser.Chrome;
                options = GetDriverOptions<ChromeOptions>(driverType, driverOptions);
                service = CreateService<ChromeDriverService>(driverType);
            }

            if (typeof(InternetExplorerDriver).IsAssignableFrom(driverType))
            {
                browser = Browser.IE;
                options = GetDriverOptions<InternetExplorerOptions>(driverType, driverOptions);
                service = CreateService<InternetExplorerDriverService>(driverType);
            }

            if (typeof(EdgeDriver).IsAssignableFrom(driverType))
            {
                browser = Browser.Edge;
                options = GetDriverOptions<EdgeOptions>(driverType, driverOptions);
                service = CreateService<EdgeDriverService>(driverType);
            }

            if (typeof(FirefoxDriver).IsAssignableFrom(driverType))
            {
                browser = Browser.Firefox;
                options = GetDriverOptions<FirefoxOptions>(driverType, driverOptions);
                service = CreateService<FirefoxDriverService>(driverType);
            }

            if (typeof(SafariDriver).IsAssignableFrom(driverType))
            {
                browser = Browser.Safari;
                options = GetDriverOptions<SafariOptions>(driverType, driverOptions);
                service = CreateService<SafariDriverService>(driverType);
            }

            constructorArgTypeList.Add(this.serviceTypes[browser]);
            constructorArgTypeList.Add(this.optionsTypes[browser]);
            ConstructorInfo ctorInfo = driverType.GetConstructor(constructorArgTypeList.ToArray());
            if (ctorInfo != null)
            {
                return (IWebDriver)ctorInfo.Invoke(new object[] { service, options });
            }

            driver = (IWebDriver)Activator.CreateInstance(driverType);
            return driver;
        }

        private T GetDriverOptions<T>(Type driverType, DriverOptions overriddenOptions) where T : DriverOptions, new()
        {
            T options = new T();
            Type optionsType = typeof(T);

            PropertyInfo defaultOptionsProperty = driverType.GetProperty("DefaultOptions", BindingFlags.Public | BindingFlags.Static);
            if (defaultOptionsProperty != null && defaultOptionsProperty.PropertyType == optionsType)
            {
                options = (T)defaultOptionsProperty.GetValue(null, null);
            }

            if (overriddenOptions != null)
            {
                options.PageLoadStrategy = overriddenOptions.PageLoadStrategy;
                options.UnhandledPromptBehavior = overriddenOptions.UnhandledPromptBehavior;
            }

            return options;
        }


        private T MergeOptions<T>(object baseOptions, DriverOptions overriddenOptions) where T:DriverOptions, new()
        {
            // If the driver type has a static DefaultOptions property,
            // get the value of that property, which should be a valid
            // options of the generic type (T). Otherwise, create a new
            // instance of the browser-specific options class.
            T mergedOptions = new T();
            if (baseOptions != null && baseOptions is T)
            {
                mergedOptions = (T)baseOptions;
            }

            if (overriddenOptions != null)
            {
                mergedOptions.PageLoadStrategy = overriddenOptions.PageLoadStrategy;
                mergedOptions.UnhandledPromptBehavior = overriddenOptions.UnhandledPromptBehavior;
            }

            return mergedOptions;
        }

        private T CreateService<T>(Type driverType) where T:DriverService
        {
            T service = default(T);
            Type serviceType = typeof(T);

            // If the driver type has a static DefaultService property,
            // get the value of that property, which should be a valid
            // service of the generic type (T). Otherwise, invoke the
            // static CreateDefaultService method on the driver service's
            // type, which returns an instance of the type.
            PropertyInfo defaultServiceProperty = driverType.GetProperty("DefaultService", BindingFlags.Public | BindingFlags.Static);
            if (defaultServiceProperty != null && defaultServiceProperty.PropertyType == serviceType)
            {
                service = (T)defaultServiceProperty.GetValue(null, null);
            }
            else
            {
                MethodInfo createDefaultServiceMethod = serviceType.GetMethod("CreateDefaultService", BindingFlags.Public | BindingFlags.Static, null, new Type[] { typeof(string) }, null);
                if (createDefaultServiceMethod != null && createDefaultServiceMethod.ReturnType == serviceType)
                {
                    service = (T)createDefaultServiceMethod.Invoke(null, new object[] { this.driverPath });
                }
            }

            return service;
        }

        private object GetDefaultOptions(Type driverType)
        {
            PropertyInfo info = driverType.GetProperty("DefaultOptions", BindingFlags.Public | BindingFlags.Static);
            if (info != null)
            {
                object propertyValue = info.GetValue(null, null);
                return propertyValue;
            }

            return null;
        }
    }
}
