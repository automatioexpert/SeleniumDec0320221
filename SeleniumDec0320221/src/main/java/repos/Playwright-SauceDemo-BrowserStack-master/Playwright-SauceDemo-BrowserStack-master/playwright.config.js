
const { devices } = require('@playwright/test');
const config = {
  testDir: 'tests',
  testMatch: '**/*.test.js',
  timeout: 60000,
  use:{
    viewport: null
  },
  projects: [
    {
      name:  'chrome@latest:Windows 10@browserstack',
      use: {
        browserName: 'chromium',
        channel: 'chrome'
      },
    },
    {
      name: 'chrome@latest-beta:OSX Big Sur@browserstack',
      use: {
        browserName: 'chromium',
        channel: 'chrome',
      },
    },
    {
      name: 'edge@90:Windows 10@browserstack',
      use: {
        browserName: 'chromium'
      },
    },
    {
      name: 'playwright-firefox@latest:OSX Catalina@browserstack',
      use: {
        browserName: 'firefox',
        ignoreHTTPSErrors: true
      },
    },
    {
      name: 'playwright-webkit@latest:OSX Big Sur@browserstack',
      use: {
        browserName: 'webkit',
      },
    },
  ],
}
module.exports = config;