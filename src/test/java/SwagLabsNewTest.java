import SwagLabsTest.SwagLabsBaseTest;

import SwagLabsTest.SwagLabsProductsTest;
import me.nlight.PageObjects.SwagLabsCartPage;
import me.nlight.PageObjects.SwagLabsLoginPage;
import me.nlight.PageObjects.SwagLabsProductsPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static me.nlight.PageObjects.SwagLabsLoginPage.*;


public class SwagLabsNewTest extends SwagLabsBaseTest {
    @Test
    public void addToCartTestNew() {
        SwagLabsLoginPage loginPage = open("/", SwagLabsLoginPage.class);
        SwagLabsProductsPage products = loginPage.login_as_standard();
        String addedProduct = products.addFirstToCart();
        SwagLabsCartPage cart = products.goToCart();
        sleep(5000);
    }
}
