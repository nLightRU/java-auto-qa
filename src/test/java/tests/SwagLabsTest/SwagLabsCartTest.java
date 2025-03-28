package tests.SwagLabsTest;

import me.nlight.PageObjects.SwagLabsCartPage;
import me.nlight.PageObjects.SwagLabsLoginPage;
import me.nlight.PageObjects.SwagLabsProductsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SwagLabsCartTest extends SwagLabsBaseTest {
    @Test
    @DisplayName("Удаление первого товара из корзины")
    public void removeFirstItemTest() {
        SwagLabsLoginPage loginPage = open("/", SwagLabsLoginPage.class);
        SwagLabsProductsPage products = loginPage.login_as_standard();
        String addedProduct = products.addFirstToCart();
        SwagLabsCartPage cart = products.goToCart();
        cart.removeProductFromCart(0);
        assertFalse(cart.productInCart(addedProduct));
    }

    @Test
    @DisplayName("Удаление двух товаров из корзины")
    public void removeTwoItemsTest() {
        SwagLabsLoginPage loginPage = open("/", SwagLabsLoginPage.class);

    }
}
