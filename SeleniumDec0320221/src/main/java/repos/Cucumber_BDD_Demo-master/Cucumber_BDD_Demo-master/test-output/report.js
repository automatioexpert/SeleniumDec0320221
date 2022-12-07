$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Selemuinn/FreeCrmBDDFramework/src/main/java/features/Contacts.Feature");
formatter.feature({
  "line": 1,
  "name": "Free CRM Contacts Feature",
  "description": "",
  "id": "free-crm-contacts-feature",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 3,
      "value": "#Data Driven approach with Scenario Outline and Examples keyword"
    }
  ],
  "line": 4,
  "name": "Free CRM Create a New Contact scenario",
  "description": "",
  "id": "free-crm-contacts-feature;free-crm-create-a-new-contact-scenario",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "user is already on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "title of login page is Free CRM",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user enters \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user clicks the login button",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "the user is on home page",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user clicks New contact link",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user enters contacts details \"\u003cfirstname\u003e\" and \"\u003clastname\u003e\" and \"\u003cposition\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user clicks on save button",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.examples({
  "line": 16,
  "name": "",
  "description": "",
  "id": "free-crm-contacts-feature;free-crm-create-a-new-contact-scenario;",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "firstname",
        "lastname",
        "position"
      ],
      "line": 17,
      "id": "free-crm-contacts-feature;free-crm-create-a-new-contact-scenario;;1"
    },
    {
      "cells": [
        "ananda",
        "123456",
        "cucuber10",
        "bdd10",
        "manager"
      ],
      "line": 18,
      "id": "free-crm-contacts-feature;free-crm-create-a-new-contact-scenario;;2"
    },
    {
      "cells": [
        "ananda",
        "123456",
        "cucuber20",
        "bdd20",
        "analyst"
      ],
      "line": 19,
      "id": "free-crm-contacts-feature;free-crm-create-a-new-contact-scenario;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 18,
  "name": "Free CRM Create a New Contact scenario",
  "description": "",
  "id": "free-crm-contacts-feature;free-crm-create-a-new-contact-scenario;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "user is already on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "title of login page is Free CRM",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user enters \"ananda\" and \"123456\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user clicks the login button",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "the user is on home page",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user clicks New contact link",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user enters contacts details \"cucuber10\" and \"bdd10\" and \"manager\"",
  "matchedColumns": [
    2,
    3,
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user clicks on save button",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.user_is_already_on_login_page()"
});
formatter.result({
  "duration": 38507393299,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.title_of_login_page_is_Free_CRM()"
});
formatter.result({
  "duration": 67060860,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ananda",
      "offset": 13
    },
    {
      "val": "123456",
      "offset": 26
    }
  ],
  "location": "LoginStepDefinition.user_enters_username_and_password(String,String)"
});
formatter.result({
  "duration": 880233992,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.user_clicks_the_login_button()"
});
formatter.result({
  "duration": 12472412474,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.the_user_is_on_home_page()"
});
formatter.result({
  "duration": 14723504,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.user_clicks_New_contact_link()"
});
formatter.result({
  "duration": 6516411144,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "cucuber10",
      "offset": 30
    },
    {
      "val": "bdd10",
      "offset": 46
    },
    {
      "val": "manager",
      "offset": 58
    }
  ],
  "location": "LoginStepDefinition.user_enters_contacts_details_and_and(String,String,String)"
});
formatter.result({
  "duration": 1075238475,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.user_clicks_on_save_button()"
});
formatter.result({
  "duration": 4044639871,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.close_the_browser()"
});
formatter.result({
  "duration": 6916947085,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Free CRM Create a New Contact scenario",
  "description": "",
  "id": "free-crm-contacts-feature;free-crm-create-a-new-contact-scenario;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "user is already on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "title of login page is Free CRM",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user enters \"ananda\" and \"123456\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user clicks the login button",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "the user is on home page",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user clicks New contact link",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user enters contacts details \"cucuber20\" and \"bdd20\" and \"analyst\"",
  "matchedColumns": [
    2,
    3,
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user clicks on save button",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.user_is_already_on_login_page()"
});
formatter.result({
  "duration": 17123020229,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.title_of_login_page_is_Free_CRM()"
});
formatter.result({
  "duration": 23644399,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ananda",
      "offset": 13
    },
    {
      "val": "123456",
      "offset": 26
    }
  ],
  "location": "LoginStepDefinition.user_enters_username_and_password(String,String)"
});
formatter.result({
  "duration": 607576015,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.user_clicks_the_login_button()"
});
formatter.result({
  "duration": 11240710799,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.the_user_is_on_home_page()"
});
formatter.result({
  "duration": 14485491,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.user_clicks_New_contact_link()"
});
formatter.result({
  "duration": 5798316259,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "cucuber20",
      "offset": 30
    },
    {
      "val": "bdd20",
      "offset": 46
    },
    {
      "val": "analyst",
      "offset": 58
    }
  ],
  "location": "LoginStepDefinition.user_enters_contacts_details_and_and(String,String,String)"
});
formatter.result({
  "duration": 1576058187,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.user_clicks_on_save_button()"
});
formatter.result({
  "duration": 3436364690,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.close_the_browser()"
});
formatter.result({
  "duration": 1535861066,
  "status": "passed"
});
});