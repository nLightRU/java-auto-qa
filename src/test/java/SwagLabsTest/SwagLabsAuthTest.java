package SwagLabsTest;

import me.nlight.PageObjects.SwagLabsLoginPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;


public class SwagLabsAuthTest extends SwagLabsBaseTest {
    @Test
    @Tag("auth")
    @DisplayName("Логин стандартным")
    void TestLogin() {
        String username = "standard_user", password = "secret_sauce";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assert page.hasBurgerMenu();
    }

    @Test
    @Tag("auth")
    @DisplayName("Выход из магазина")
    void TestLogout() {
        String username = "standard_user", password = "secret_sauce";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        page.logout();
        assert page.isLoginPage();
    }

    @Test
    @Tag("auth")
    @DisplayName("Логин заблокированным")
    void TestLockedOutLogin() {
        String username = "locked_out_user", password ="secret_sauce";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assert page.hasLoginError("Epic sadface");
    }
}
