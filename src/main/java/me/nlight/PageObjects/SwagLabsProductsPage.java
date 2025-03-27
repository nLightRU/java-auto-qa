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

    private static final ElementsCollection inventoryList = $$(".inventory_item");

    public String addFirstToCart() {
        inventoryList.first().find("button").click();
        return inventoryList.first().find(".inventory_item_name").text();
    }

    public String addLastToCart() {
        inventoryList.last().find("button").click();
        return inventoryList.last().find(".inventory_item_name").text();
    }

    public String addToCart(int index) {
        inventoryList.get(index).find("button").click();
        return inventoryList.get(index).find(".inventory_item_name").text();
    }

    public SwagLabsCartPage goToCart() {
        $(by("data-test", "shopping-cart-link")).click();
        return page(SwagLabsCartPage.class);
    }
}
