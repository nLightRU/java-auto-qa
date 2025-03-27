package me.nlight.PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$$;

public class SwagLabsProductsPage {

    private static ElementsCollection inventoryList = $$(".inventory_item");

    public static void addFirstToCart() {
        inventoryList.first().find("button").click();
    }
}
