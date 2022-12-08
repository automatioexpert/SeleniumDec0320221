/**
 # * @author Rajat Verma
 # * https://www.linkedin.com/in/rajat-v-3b0685128/
 # * https://github.com/rajatt95
 # * https://rajatt95.github.io/
 # *
 # * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
 # * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)

 # * Code Repository: https://github.com/rajatt95/TestAutomationFramework_UDEMY_OC_Web_Selenium_Java_V2

 # * Document(s): https://github.com/rajatt95/Documents

 # * Learnings from Tutor (Code Repository):
 # *    This course
 # *        https://github.com/stars/rajatt95/lists/udemy-oc-selenium
 # *    Other course(s):
 # *        https://github.com/stars/rajatt95/lists/udemy-omprakash-chavan
 # */

/***************************************************/

package com.learning.pom.utils;

import com.github.javafaker.Faker;
import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

    public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies){
        List<io.restassured.http.Cookie> restAssuredCookies = new ArrayList<>();
        restAssuredCookies = cookies.asList();

        List<Cookie> seleniumCookies = new ArrayList<>();

        for (io.restassured.http.Cookie restAssuredCookie: restAssuredCookies) {
            seleniumCookies.add(new Cookie(
                    restAssuredCookie.getName(),
                    restAssuredCookie.getValue(),
                    restAssuredCookie.getDomain(),
                    restAssuredCookie.getPath(),
                    restAssuredCookie.getExpiryDate(),
                    restAssuredCookie.isSecured(),
                    restAssuredCookie.isHttpOnly(),
                    restAssuredCookie.getSameSite()
                    ));
        }
        return seleniumCookies;
    }
}















