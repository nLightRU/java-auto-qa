import SwagLabsTest.SwagLabsBaseTest;

import me.nlight.PageObjects.SwagLabsPageObject;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class SwagLabsNewTest extends SwagLabsBaseTest {
    @Test
    public void addToCartTest() {
        String username = "standard_user", password = "secret_sauce";
        SwagLabsPageObject productsPage = open("/", SwagLabsPageObject.class);
        productsPage.login(username, password);
        productsPage.addToCard();
        sleep(5000);
    }
}
