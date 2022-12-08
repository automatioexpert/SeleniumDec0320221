package com.willysalazar.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageObject {
    SelenideElement username = $("#user-name");
    SelenideElement password = $("#password");
    SelenideElement loginButton = $("#login-button");
    SelenideElement errorUserLocked = $("div>h3");

    public void doLogin(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.pressEnter();
    }

    public SelenideElement title() {
        return $("div>span.title");
    }

    public SelenideElement getErrorUserLocked() {
        return errorUserLocked;
    }
}
