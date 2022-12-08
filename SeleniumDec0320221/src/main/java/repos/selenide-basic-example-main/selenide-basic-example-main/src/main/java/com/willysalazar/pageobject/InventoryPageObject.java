package com.willysalazar.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class InventoryPageObject {
    private SelenideElement cartButton = $("#shopping_cart_container");

    private SelenideElement buttonAddBackpackToCart = $("#add-to-cart-sauce-labs-backpack");

    public void clickCartButton(){
        cartButton.click();
    }

    public InventoryPageObject addBackPackToCart(){
        buttonAddBackpackToCart.click();
        return this;
    }







}
