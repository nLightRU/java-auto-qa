package SwagLabsTest;

import me.nlight.PageObjects.SwagLabsLoginPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;


public class SwagLabsAuthTest extends SwagLabsBaseTest {
    @Test
    @Tag("Auth")
    @DisplayName("Standard login")
    void TestLogin() {
        String username = "standard_user", password = "secret_sauce";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assert page.hasBurgerMenu();
    }

    @Test
    @Tag("Auth")
    @DisplayName("Standard logout")
    void TestLogout() {
        String username = "standard_user", password = "secret_sauce";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        page.logout();
        assert page.isLoginPage();
    }

    @Test
    @Tag("Auth")
    @DisplayName("Locked out login")
    void TestLockedOutLogin() {
        String username = "locked_out_user", password ="secret_sauce";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assert page.hasLoginError("Epic sadface");
    }
}
