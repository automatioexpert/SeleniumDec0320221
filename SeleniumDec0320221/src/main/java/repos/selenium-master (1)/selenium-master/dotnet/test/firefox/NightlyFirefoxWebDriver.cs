using OpenQA.Selenium.Remote;

namespace OpenQA.Selenium.Firefox
{
    // This is a simple wrapper class to create a FirefoxDriver that
    // uses the Marionette implementation and has no parameters in the
    // constructor.
    public class NightlyFirefoxWebDriver : FirefoxDriver
    {
        public NightlyFirefoxWebDriver(FirefoxDriverService service)
            : this(service, DefaultOptions)
        {
        }

        public NightlyFirefoxWebDriver(FirefoxDriverService service, FirefoxOptions options)
            : base(service, options)
        {
        }

        public static FirefoxOptions DefaultOptions
        {
            get { return new FirefoxOptions() { BrowserExecutableLocation = @"C:\Program Files (x86)\Nightly\firefox.exe" }; }
        }
    }
}
