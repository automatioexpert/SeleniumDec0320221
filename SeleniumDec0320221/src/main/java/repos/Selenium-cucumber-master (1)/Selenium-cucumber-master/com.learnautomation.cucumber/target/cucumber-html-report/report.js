$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Myapplication.feature");
formatter.feature({
  "line": 1,
  "name": "Test Facebook smoke scenario",
  "description": "",
  "id": "test-facebook-smoke-scenario",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Test login with valid Credentials",
  "description": "",
  "id": "test-facebook-smoke-scenario;test-login-with-valid-credentials",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Open firefox and start application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I enter valid \"\u003cusername\u003e\" and \"password\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user should be able to login successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "application should be closed",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "test-facebook-smoke-scenario;test-login-with-valid-credentials;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 11,
      "id": "test-facebook-smoke-scenario;test-login-with-valid-credentials;;1"
    },
    {
      "cells": [
        "kunal@pedagogy.study",
        "kunal@123"
      ],
      "line": 12,
      "id": "test-facebook-smoke-scenario;test-login-with-valid-credentials;;2"
    },
    {
      "cells": [
        "kunal@pedagogy.study",
        "kunal@1234"
      ],
      "line": 13,
      "id": "test-facebook-smoke-scenario;test-login-with-valid-credentials;;3"
    },
    {
      "cells": [
        "kunal@pedagogy.study",
        "kunal@12345"
      ],
      "line": 14,
      "id": "test-facebook-smoke-scenario;test-login-with-valid-credentials;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "Test login with valid Credentials",
  "description": "",
  "id": "test-facebook-smoke-scenario;test-login-with-valid-credentials;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Open firefox and start application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I enter valid \"kunal@pedagogy.study\" and \"password\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user should be able to login successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "application should be closed",
  "keyword": "Then "
});
formatter.match({
  "location": "smokeTest.open_firefox_and_start_application()"
});
formatter.result({
  "duration": 10290844799,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "kunal@pedagogy.study",
      "offset": 15
    },
    {
      "val": "password",
      "offset": 42
    }
  ],
  "location": "smokeTest.i_enter_valid_and(String,String)"
});
formatter.result({
  "duration": 302783864,
  "status": "passed"
});
formatter.match({
  "location": "smokeTest.user_should_be_able_to_login_successfully()"
});
formatter.result({
  "duration": 1996441226,
  "status": "passed"
});
formatter.match({
  "location": "smokeTest.application_should_be_closed()"
});
formatter.result({
  "duration": 674642903,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Test login with valid Credentials",
  "description": "",
  "id": "test-facebook-smoke-scenario;test-login-with-valid-credentials;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Open firefox and start application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I enter valid \"kunal@pedagogy.study\" and \"password\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user should be able to login successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "application should be closed",
  "keyword": "Then "
});
formatter.match({
  "location": "smokeTest.open_firefox_and_start_application()"
});
formatter.result({
  "duration": 6832930441,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "kunal@pedagogy.study",
      "offset": 15
    },
    {
      "val": "password",
      "offset": 42
    }
  ],
  "location": "smokeTest.i_enter_valid_and(String,String)"
});
formatter.result({
  "duration": 284030383,
  "status": "passed"
});
formatter.match({
  "location": "smokeTest.user_should_be_able_to_login_successfully()"
});
formatter.result({
  "duration": 1625343864,
  "status": "passed"
});
formatter.match({
  "location": "smokeTest.application_should_be_closed()"
});
formatter.result({
  "duration": 673751102,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Test login with valid Credentials",
  "description": "",
  "id": "test-facebook-smoke-scenario;test-login-with-valid-credentials;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Open firefox and start application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I enter valid \"kunal@pedagogy.study\" and \"password\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user should be able to login successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "application should be closed",
  "keyword": "Then "
});
formatter.match({
  "location": "smokeTest.open_firefox_and_start_application()"
});
formatter.result({
  "duration": 6088993166,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "kunal@pedagogy.study",
      "offset": 15
    },
    {
      "val": "password",
      "offset": 42
    }
  ],
  "location": "smokeTest.i_enter_valid_and(String,String)"
});
formatter.result({
  "duration": 281373308,
  "status": "passed"
});
formatter.match({
  "location": "smokeTest.user_should_be_able_to_login_successfully()"
});
formatter.result({
  "duration": 1362544064,
  "status": "passed"
});
formatter.match({
  "location": "smokeTest.application_should_be_closed()"
});
formatter.result({
  "duration": 670528084,
  "status": "passed"
});
});