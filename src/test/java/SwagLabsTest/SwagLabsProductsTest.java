package SwagLabsTest;

import me.nlight.PageObjects.SwagLabsCartPage;
import me.nlight.PageObjects.SwagLabsLoginPage;
import me.nlight.PageObjects.SwagLabsProductsPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwagLabsProductsTest extends SwagLabsBaseTest {

    @Test
    @DisplayName("Добавить первый в корзину")
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
    void addTwoProductsToCartTest() {
        SwagLabsLoginPage loginPage = open("/", SwagLabsLoginPage.class);
        SwagLabsProductsPage productsPage = loginPage.login_as_standard();
        String product_1 = productsPage.addToCart(0);
        String product_2 = productsPage.addToCart(1);
        String[] products = new String[]{product_1, product_2};
        SwagLabsCartPage cart = productsPage.goToCart();
        String[] cart_items = new String[]{cart.getProductName(0), cart.getProductName(1)};
        assertArrayEquals(products, cart_items);
    }

    @Disabled
    @Test
    public void sortByNameTest() {

    }

    @Disabled
    @Test
    public void sortByPriceTest() {

    }
}
