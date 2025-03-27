package SwagLabsTest;

import com.codeborne.selenide.Configuration;
import me.nlight.PageObjects.SwagLabsCartPage;
import me.nlight.PageObjects.SwagLabsLoginPage;
import me.nlight.PageObjects.SwagLabsProductsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class SwagLabsProductsTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.saucedemo.com";

        // remove password popups
        // https://www.repeato.app/disabling-chromes-password-save-pop-up-using-selenium-webdriver/
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        Configuration.browserCapabilities = options;

    }

    @AfterEach
    public void cleanUp() {
        clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Добавить первый в корзину")
    @Tag("Products")
    public void addOneToCartTest() {
        SwagLabsLoginPage loginPage = open("/", SwagLabsLoginPage.class);
        SwagLabsProductsPage products = loginPage.login_as_standard();
        String addedProduct = products.addFirstToCart();
        SwagLabsCartPage cart = products.goToCart();
        String cartProduct = cart.getProductName(0);
        assertEquals(addedProduct, cartProduct);
    }

    @Test
    @DisplayName("Добавить два товара в корзину")
    @Tag("Products")
    void addTwoProductsToCartTest() {
        SwagLabsLoginPage loginPage = open("/", SwagLabsLoginPage.class);
        SwagLabsProductsPage productsPage = loginPage.login_as_standard();
        ArrayList<String> products = new ArrayList<>();
        products.add(productsPage.addToCart(0));
        products.add(productsPage.addToCart(1));
        SwagLabsCartPage cart = productsPage.goToCart();
        for (String product : products) {
            assertTrue(cart.productInCart(product));
        }
    }

    @Disabled
    @Test
    @Tag("Products")
    public void sortByNameTest() {

    }

    @Disabled
    @Test
    @Tag("Products")
    public void sortByPriceTest() {

    }
}
