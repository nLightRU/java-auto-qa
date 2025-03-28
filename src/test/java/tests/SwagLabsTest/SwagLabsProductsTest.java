package tests.SwagLabsTest;

import me.nlight.PageObjects.SwagLabsCartPage;
import me.nlight.PageObjects.SwagLabsLoginPage;
import me.nlight.PageObjects.SwagLabsProductsPage;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class SwagLabsProductsTest extends SwagLabsBaseTest{

    @BeforeEach
    public void login_as_standard()
    {
        SwagLabsLoginPage loginPage = open("/", SwagLabsLoginPage.class);
        SwagLabsProductsPage products = loginPage.login_as_standard();
    }

    @Test
    @DisplayName("Добавить первый в корзину")
    @Tag("Products")
    public void addOneToCartTest() {
        SwagLabsProductsPage products = open("/inventory.html", SwagLabsProductsPage.class);
        String addedProduct = products.addFirstToCart();
        SwagLabsCartPage cart = products.goToCart();
        String cartProduct = cart.getProductName(0);
        assertEquals(addedProduct, cartProduct);
    }

    @Test
    @DisplayName("Добавить два товара в корзину")
    @Tag("Products")
    void addTwoProductsToCartTest() {
        SwagLabsProductsPage productsPage = open("/inventory.html", SwagLabsProductsPage.class);
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
