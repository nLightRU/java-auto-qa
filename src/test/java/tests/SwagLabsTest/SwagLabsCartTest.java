package tests.SwagLabsTest;

import me.nlight.PageObjects.SwagLabsCartPage;
import me.nlight.PageObjects.SwagLabsLoginPage;
import me.nlight.PageObjects.SwagLabsProductsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SwagLabsCartTest extends SwagLabsBaseTest {

    @BeforeEach
    public void login_as_standard()
    {
        SwagLabsLoginPage loginPage = open("/", SwagLabsLoginPage.class);
        loginPage.login_as_standard();
    }

    @Test
    @DisplayName("Удаление первого товара из корзины")
    public void removeFirstItemTest() {
        SwagLabsProductsPage products = open("/inventory.html", SwagLabsProductsPage.class);
        String addedProduct = products.addFirstToCart();
        SwagLabsCartPage cart = products.goToCart();
        cart.removeProductFromCart(0);
        assertFalse(cart.productInCart(addedProduct));
    }

    @Test
    @DisplayName("Удаление двух товаров из корзины")
    public void removeTwoItemsTest() {
        SwagLabsProductsPage products = open("/inventory.html", SwagLabsProductsPage.class);
        String product_1 = products.addToCart(0);
        String product_2 = products.addToCart(1);
        SwagLabsCartPage cart = products.goToCart();
        cart.removeProductFromCart(0);
        cart.removeProductFromCart(0);
    }
}
