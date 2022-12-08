package com.willysalazar.examples;

import com.willysalazar.base.BaseConfig;
import com.willysalazar.pageobject.LoginPageObject;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;

@Feature("Login")
class LoginTest extends BaseConfig {

    @Test
    void shouldHaveLoginWithStandardUser() {
        LoginPageObject loginPage = new LoginPageObject();
        loginPage.doLogin("standard_user", "secret_sauce");
        loginPage.title().shouldHave(text("Products"));
    }

    @Test
    void shouldHaveLoginWithProblemUser() {
        LoginPageObject loginPage = new LoginPageObject();
        loginPage.doLogin("problem_user", "secret_sauce");
        loginPage.title().shouldHave(text("Products"));
    }

    @Test
    void shouldHaveLoginWithPerformanceGlitchUser() {
        LoginPageObject loginPage = new LoginPageObject();
        loginPage.doLogin("performance_glitch_user", "secret_sauce");
        loginPage.title().shouldHave(text("Products"));
    }

    @Test
    void shouldHaveLoginWithLockedOutUser() {
        LoginPageObject loginPage = new LoginPageObject();
        loginPage.doLogin("locked_out_user", "secret_sauce");
        loginPage.getErrorUserLocked().shouldHave(text("Epic sadface: Sorry, this user has been locked out."));
    }
}
