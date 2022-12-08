### Playwright with BrowserStack

An example project demonstrating automation of playwright tests running on BrowserStack Cloud Platform.

#### Application Under Test

We are using https://www.saucedemo.com/ as the Application Under Test. This App is a **React.js** Frontend

- URL: https://www.saucedemo.com/
- OS : macOS
- IDE : Visual Studio Code

#### Scenarios
 
```bash
Scenario 1: Login as a standard user to verify the products page and logout from the application

Scenario Description: User logs into the website and verifies all the elements on the products
page and logs out from the application. This is like a Smoke test.

Testname: TC_01_productPage.test.js
```

```bash
Scenario 2: Login as a standard user to complete the checkout workflow

Scenario Description: User logs into the website and completes the checkout workflow and logs out
from the application. This is a Happy path test scenario.

Testname: TC_02_checkoutWorkflow.test.js
```

```bash
Scenario: 3: Login as a standard user to select a product item and then login as a performance_glitch_user
to complete the checkout workflow

Scenario Description: The application is verified with all the necessary buttons and links on all the pages
including error messages by the standard user. Then the checkout process is therefore completed by the performance_glitch_user.

Testname: TC_03_checkoutWithSUandPGU.test.js
```

```bash
Scenario 4: Login as a “problem_user” to add a product item to the shopping cart and then complete
the checkout workflow by logging in as a “performance_glitch_user”

Scenario Description: User is logged in as “Problem_user” and adds an item to the cart. User fills in
the firstname, lastname and postal code. Since the “Problem_user” cannot perform the checkout process because
of the lastname error message, user logs off the application.
Performance_glitch_user log into the application and completes the checkout workflow.

Testname: TC_04_checkoutWithPUandPGU.test.js
```

```bash
Scenario 5: Login as locked_out_user to verify error message and then Login as performance_glitch_user
to add a product item to the cart and logout from the application.
Login as a standard user now to complete the checkout workflow.

Scenario Description: User is logged in as “Locked_out_user” to validate the error message on the Login page.
Now, Login as a performace_glitch_user and add a product item to the cart and logout of the application.
Standard user is logged in and verifies the product item added by the performance glitch user earlier
and completes the checkout workflow.

Testname: TC_05_checkoutWithPGUandSU.test.js
```

#### Clone or Download Repo

- Clone (OR) Download this repo as zip folder on to your local machine
- Navigate to project's directory on terminal and run the following commands:

Clone the repository
```bash
git clone https://github.com/JayKishoreDuvvuri/Playwright-SauceDemo-BrowserStack.git
```

#### Run tests on BrowserStack
```bash
npm run test:smoke - Runs test on chrome@latest:Windows 10
```

```bash
npm run test  - Runs all tests on chrome@latest:Windows 10, chrome@latest-beta:OSX Big Sur, edge:Windows 10, firefox@latest:OSX Catalina and safari@latest:OSX Big Sur
```
