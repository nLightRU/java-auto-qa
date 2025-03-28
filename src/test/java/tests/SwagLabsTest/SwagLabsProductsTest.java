package tests.SwagLabsTest;

import com.codeborne.selenide.SelenideElement;
import me.nlight.PageObjects.SwagLabsCartPage;
import me.nlight.PageObjects.SwagLabsLoginPage;
import me.nlight.PageObjects.SwagLabsProductsPage;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Товары")
public class SwagLabsProductsTest extends SwagLabsBaseTest{

    /*
    For copy paste
    @Test
    @Tag("products")
    @DisplayName("")
    void Test() {

    }
    */

    @BeforeEach
    public void login_as_standard()
    {
        SwagLabsLoginPage loginPage = open("/", SwagLabsLoginPage.class);
        loginPage.login_as_standard();
    }

    @Test
    @DisplayName("У товара есть кнопка Добавить")
    @Tag("products")
    public void itemHasButton() {
        SwagLabsProductsPage products = open("/inventory.html", SwagLabsProductsPage.class);
        SelenideElement button = products.getItemButton(0);
        assertTrue(button.exists());
        assertEquals("Add to cart", button.innerText());
    }

    @Test
    @Tag("products")
    @DisplayName("Кнопка Добавить меняется на Удалить")
    void TestButtonChange() {
        SwagLabsProductsPage products = open("/inventory.html", SwagLabsProductsPage.class);
        SelenideElement button = products.getItemButton(0);
        assertTrue(button.exists());
        button.click();
        assertEquals("Remove", button.innerText());
    }

    @Test
    @Tag("products")
    @DisplayName("Открывается карточка с товаром")
    void TestOpenProduct() {
        assert false;
    }

    @Test
    @Tag("products")
    @DisplayName("Вернуться к списку товаров")
    void TestReturnToProducts() {
        assert false;
    }

    @Test
    @DisplayName("Товар появляется в корзине")
    @Tag("products")
    public void addOneToCartTest() {
        SwagLabsProductsPage products = open("/inventory.html", SwagLabsProductsPage.class);
        String addedProduct = products.addFirstToCart();
        SwagLabsCartPage cart = products.goToCart();
        String cartProduct = cart.getProductName(0);
        assertEquals(addedProduct, cartProduct);
    }

    @Test
    @DisplayName("Два товара появляются в корзине")
    @Tag("products")
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

    @Test
    @Tag("products")
    @DisplayName("Появляется счётчик у корзины")
    void TestBadgeAppear() {
        SwagLabsProductsPage productsPage = open("/inventory.html", SwagLabsProductsPage.class);
        productsPage.addFirstToCart();
        assertTrue(SwagLabsProductsPage.cartBadge.exists());
        assertEquals(1, productsPage.getBadgeValue());
    }

    @Test
    @Tag("products")
    @DisplayName("Пропадает счётчик у корзины")
    void TestBadgeDisappear() {
        SwagLabsProductsPage productsPage = open("/inventory.html", SwagLabsProductsPage.class);
        SelenideElement button = productsPage.getItemButton(0);
        button.click();
        assertTrue(SwagLabsProductsPage.cartBadge.exists());
        button.click();
        assertFalse(SwagLabsProductsPage.cartBadge.exists());
    }

    @Test
    @Tag("products")
    @DisplayName("Увеличивается счётчик у корзины")
    void TestBadgeIncrease() {
        SwagLabsProductsPage productsPage = open("/inventory.html", SwagLabsProductsPage.class);
        productsPage.addToCart(0);
        assertTrue(SwagLabsProductsPage.cartBadge.exists());
        assertEquals(1, productsPage.getBadgeValue());
        productsPage.addToCart(1);
        assertEquals(2, productsPage.getBadgeValue());
    }

    @Disabled
    @Test
    @Tag("products")
    @DisplayName("Сортировка по названию")
    public void sortByNameTest() {

    }

    @Disabled
    @Test
    @Tag("products")
    @DisplayName("Сортировка по цене")
    public void sortByPriceTest() {

    }
}
