package com.willysalazar.examples;

import com.codeborne.selenide.CollectionCondition;
import com.willysalazar.base.BaseConfig;
import com.willysalazar.pageobject.CartPageObject;
import com.willysalazar.pageobject.InventoryPageObject;
import com.willysalazar.pageobject.LoginPageObject;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

@Feature("Add items to cart")
class AddItemToCartTest extends BaseConfig {

    @Test
    @Description("Should add backpack to cart and cart size to be one")
    void shouldAddBackpackToCartAndCartItemsSizeToBeOne() {
        LoginPageObject loginPage = new LoginPageObject();
        loginPage.doLogin("standard_user", "secret_sauce");

        InventoryPageObject inventoryPageObject = new InventoryPageObject();

        inventoryPageObject
                .addBackPackToCart()
                .clickCartButton();

        CartPageObject cartPageObject = new CartPageObject();

        cartPageObject.getCartItemsList()
                .shouldHave(CollectionCondition.size(1));

    }

}
