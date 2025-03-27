import SwagLabsTest.SwagLabsBaseTest;

import me.nlight.PageObjects.SwagLabsLoginPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static me.nlight.PageObjects.SwagLabsLoginPage.addToCart;
import static me.nlight.PageObjects.SwagLabsLoginPage.login;


public class SwagLabsNewTest extends SwagLabsBaseTest {
    @Test
    public void addToCartTest() {
        String username = "standard_user", password = "secret_sauce";
        SwagLabsLoginPage productsPage = open("/", SwagLabsLoginPage.class);
        login(username, password);
        addToCart();
    }
}
