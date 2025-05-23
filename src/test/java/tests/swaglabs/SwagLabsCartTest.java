package tests.swaglabs;

import me.nlight.pageobjects.SwagLabsCartPage;
import me.nlight.pageobjects.SwagLabsLoginPage;
import me.nlight.pageobjects.SwagLabsProductsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Корзина")
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

    @Disabled
    @Test
    @DisplayName("Удаление двух товаров из корзины")
    public void removeTwoItemsTest() {
        SwagLabsProductsPage products = open("/inventory.html", SwagLabsProductsPage.class);
        products.addToCart(0);
        products.addToCart(1);
        SwagLabsCartPage cart = products.goToCart();
        cart.removeProductFromCart(0);
        cart.removeProductFromCart(0);
        // TO DO: add assertion
        assert false;
    }
}
