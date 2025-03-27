package me.nlight.PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class SwagLabsProductsPage {

    private static ElementsCollection inventoryList = $$(".inventory_item");

    public String addFirstToCart() {
        inventoryList.first().find("button").click();
        return inventoryList.first().find(by("data-test", "inventory-item-name")).text();
    }

    public SwagLabsProductsPage addTwoToCart() {
        inventoryList.get(0).find("button").click();
        inventoryList.get(1).find("button").click();
        return page(SwagLabsProductsPage.class);
    }

    public SwagLabsCartPage goToCart() {
        $(by("data-test", "shopping-cart-link")).click();
        return page(SwagLabsCartPage.class);
    }
}
