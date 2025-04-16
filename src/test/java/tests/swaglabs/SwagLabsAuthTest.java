package tests.swaglabs;

import config.TestConfig;
import me.nlight.pageobjects.SwagLabsLoginPage;
import me.nlight.pageobjects.SwagLabsProductsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;


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
        String username = TestConfig.getStandardUser();
        String password = TestConfig.getPassword();
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        SwagLabsLoginPage.loginFieldUsername.setValue(username);
        SwagLabsLoginPage.loginFieldPassword.setValue(password);
        SwagLabsLoginPage.loginButton.click();
        SwagLabsProductsPage.title.shouldHave(text("Products"));
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
        String username = TestConfig.getLockedUser();
        String password = TestConfig.getPassword();
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assertTrue(SwagLabsLoginPage.loginError.exists());
        SwagLabsLoginPage.loginError.shouldHave(text("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    @Tag("auth")
    @DisplayName("Логин с неправильным паролем")
    void TestWrongPassword() {
        String username = TestConfig.getStandardUser();
        String password = "1234";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assertTrue(SwagLabsLoginPage.loginError.exists());
        SwagLabsLoginPage.loginError.shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    @Tag("auth")
    @DisplayName("Неправильный юзернейм, правильный пароль")
    void TestWrongLogin() {
        String username = "wrong";
        String password = TestConfig.getPassword();
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assertTrue(SwagLabsLoginPage.loginError.exists());
        SwagLabsLoginPage.loginError.shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    @Tag("auth")
    @DisplayName("Логин без пароля")
    void TestLoginWithoutPassword() {
        String username = TestConfig.getStandardUser();
        String password = "";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assertTrue(SwagLabsLoginPage.loginError.exists());
        SwagLabsLoginPage.loginError.shouldHave(text("Epic sadface: Password is required"));
    }

    @Test
    @Tag("auth")
    @DisplayName("Логин без юзернейма")
    void TestLoginWithoutUsername() {
        String username = "";
        String password = TestConfig.getPassword();
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assertTrue(SwagLabsLoginPage.loginError.exists());
        SwagLabsLoginPage.loginError.shouldHave(text("Epic sadface: Username is required"));
    }

    @Test
    @Tag("auth")
    @DisplayName("Логин с пустыми полями")
    void TestLoginWithoutFill() {
        String username = "";
        String password = "";
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        assertTrue(SwagLabsLoginPage.loginError.exists());
        SwagLabsLoginPage.loginError.shouldHave(text("Epic sadface: Username is required"));
    }

    @Test
    @Tag("auth")
    @DisplayName("Закрывается сообщение об ошибке")
    void TestCloseLoginError() {
        String username = TestConfig.getLockedUser();
        String password = TestConfig.getPassword();
        SwagLabsLoginPage page = open("/", SwagLabsLoginPage.class);
        page.login(username, password);
        page.closeLoginError();
        assertFalse(SwagLabsLoginPage.loginError.exists());
    }
}
