package tests.SwagLabsTest;

import me.nlight.PageObjects.SwagLabsLoginPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Авторизация")
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
        assertTrue(page.hasBurgerMenu());
    }

    @Test
    @Tag("auth")
    @DisplayName("Выход из магазина")
    void TestLogout() {
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login_as_standard();
        page.logout();
        assertTrue(page.isLoginPage());
    }

    @Test
    @Tag("auth")
    @DisplayName("Логин заблокированным")
    void TestLockedOutLogin() {
        String username = "locked_out_user", password ="secret_sauce";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assertTrue(SwagLabsLoginPage.loginError.exists());
        SwagLabsLoginPage.loginError.shouldHave(text("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    @Tag("auth")
    @DisplayName("Логин с неправильным паролем")
    void TestWrongPassword() {
        String username =  "standard_user", password = "1234";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assertTrue(SwagLabsLoginPage.loginError.exists());
        SwagLabsLoginPage.loginError.shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    @Tag("auth")
    @DisplayName("Неправильный юзернейм, правильный пароль")
    void TestWrongLogin() {
        String username =  "wrong", password = "secret_sauce";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assertTrue(SwagLabsLoginPage.loginError.exists());
        SwagLabsLoginPage.loginError.shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    @Tag("auth")
    @DisplayName("Логин без пароля")
    void TestLoginWithoutPassword() {
        String username = "standard_user";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, "");
        assertTrue(SwagLabsLoginPage.loginError.exists());
        SwagLabsLoginPage.loginError.shouldHave(text("Epic sadface: Password is required"));
    }

    @Test
    @Tag("auth")
    @DisplayName("Логин без юзернейма")
    void TestLoginWithoutUsername() {
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login("", "1234");
        assertTrue(SwagLabsLoginPage.loginError.exists());
        SwagLabsLoginPage.loginError.shouldHave(text("Epic sadface: Username is required"));
    }

    @Test
    @Tag("auth")
    @DisplayName("Логин с пустыми полями")
    void TestLoginWithoutFill() {
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login("", "");
        assertTrue(SwagLabsLoginPage.loginError.exists());
        SwagLabsLoginPage.loginError.shouldHave(text("Epic sadface: Username is required"));
    }

    @Test
    @Tag("auth")
    @DisplayName("Закрывается сообщение об ошибке")
    void TestCloseLoginError() {
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login_as_locked_out();
        page.closeLoginError();
        assertFalse(SwagLabsLoginPage.loginError.exists());
    }
}
