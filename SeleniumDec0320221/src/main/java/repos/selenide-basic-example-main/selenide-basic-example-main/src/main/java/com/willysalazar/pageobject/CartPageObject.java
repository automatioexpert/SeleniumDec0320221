package com.willysalazar.pageobject;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class CartPageObject {
    ElementsCollection cartItemsList = $$("div.cart_item_label");

    public ElementsCollection getCartItemsList(){
        return cartItemsList;
    }







}
