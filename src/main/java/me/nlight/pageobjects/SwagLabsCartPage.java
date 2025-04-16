package me.nlight.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class SwagLabsCartPage {
    // need to copy
    // private static final SelenideElement
    private static final ElementsCollection cartList = $$(".cart_item");

    private static final SelenideElement continueShoppingButton = $(by("data-test","continue-shopping"));

    private SelenideElement getRemoveButton(int index) {
        return cartList.get(index).find(".btn");
    }

    public String getProductName(int index) {
        return cartList.get(index).find(".inventory_item_name").text();
    }

    public String getProductDescpription(int index) {
        return cartList.get(index).find(".inventory_item_desc").text();
    }

    public String getProductPrice(int index) {
        return cartList.get(index).find(".inventory_item_price").text();
    }

    public void removeProductFromCart(int index) {
        SelenideElement button = getRemoveButton(index);
        button.click();
    }

    public boolean productInCart(String name) {
        for(int i = 0; i < cartList.size(); ++i) {
            if(this.getProductName(i).equals(name)) {
                return true;
            }
        }
        return false;
    }

    // to do later
    public void goToProduct(int index) {

    }

}
