package SwagLabs;

import me.nlight.PageObjects.SwagLabs;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;


public class SwagLabsAuthTest extends SwagLabsBase {
    @Test
    @Tag("Auth")
    @DisplayName("Standard login")
    void TestLogin() {
        String username = "standard_user", password = "secret_sauce";
        SwagLabs loginPage = open("/", SwagLabs.class);

        assert loginPage.login(username, password).hasBurgerMenu();
    }

    @Test
    @Tag("Auth")
    @DisplayName("Standard logout")
    void TestLogout() {
        String username = "standard_user", password = "secret_sauce";
        SwagLabs pageAfterLogIn = open("/", SwagLabs.class).login(username, password);
        SwagLabs pageAfterLogOut = pageAfterLogIn.logout();

        assert pageAfterLogOut.isLoginPage();
    }

    @Test
    @Tag("Auth")
    @DisplayName("Locked out login")
    void TestLockedOutLogin() {
        String username = "locked_out_user", password ="secret_sauce";
        SwagLabs pageAfterLogin = open("/", SwagLabs.class).login(username, password);
        pageAfterLogin.hasLoginError("Epic sadface");
    }
}
