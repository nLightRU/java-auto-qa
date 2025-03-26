import SwagLabs.SwagLabsBase;
import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Selenide;
import me.nlight.PageObjects.SwagLabsPageObject;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class SwagLabsTest extends SwagLabsBase {
    @Test
    public void addToCartTest() {
        String username = "standard_user", password = "secret_sauce";
        SwagLabsPageObject productsPage = open("/", SwagLabsPageObject.class);
        productsPage.login(username, password);
        productsPage.addToCard();
        sleep(5000);
    }
}
