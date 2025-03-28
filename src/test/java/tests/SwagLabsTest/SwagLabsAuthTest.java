package tests.SwagLabsTest;

import me.nlight.PageObjects.SwagLabsLoginPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;


public class SwagLabsAuthTest extends SwagLabsBaseTest {

    /*
    For copy paste
    @Test
    @Tag("auth")
    @DisplayName("")
    void Test() {

    }
    */

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
        assert page.checkErrorText("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    @Tag("auth")
    @DisplayName("Логин с неправильным паролем")
    void TestWrongPassword() {
        String username =  "standard_user", password = "1234";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assert page.checkErrorText("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    @Tag("auth")
    @DisplayName("Неправильный юзернейм, правильный пароль")
    void TestWrongLogin() {
        String username =  "wrong", password = "secret_sauce";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assert page.checkErrorText("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    @Tag("auth")
    @DisplayName("Логин без пароля")
    void TestLoginWithoutPassword() {
        String username = "standard_user";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, "");
        assert page.checkErrorText("Epic sadface: Password is required");
    }
}
