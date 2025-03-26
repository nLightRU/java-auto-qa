package SwagLabs;

import com.codeborne.selenide.Configuration;
import me.nlight.PageObjects.SwagLabs;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;


public class SwagLabsAuthTest {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.saucedemo.com";
    }

    @Test
    @Tags({@Tag("Positive"), @Tag("Auth")})
    @DisplayName("Логин. Пользователь не заблокирован")
    void TestLogin() {
        open("/");
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $(by("data-test", "title")).shouldHave(text("Products"));
    }
//
//    @Disabled
//    @Test
//    @DisplayName("Логин. Пользователь заблокирован")
//    void TestLockedOut() {
//        open("/");
//        $("#user-name").setValue("locked_out_user");
//        $("#password").setValue("secret_sause");
//        $("#login-button").click();
//        $(by("data-test", "error")).shouldHave(text("Epic sadface"));
//    }

    @Disabled
    @Test
    @DisplayName("Обычный логин")
    @Tag("Auth")
    void TestLoginWithPageObject() {
        String username = "standard_user", password = "secret_sauce";
        SwagLabs page = open("/", SwagLabs.class);
        SwagLabs pageAfterLogin = page.login(username, password);
        sleep(5000);
        assert pageAfterLogin.hasBurgerMenu();
    }

    @Disabled
    @Test
    @DisplayName("Логин заблокированным")
    @Tag("Auth")
    void TestLoginLockedOutPageObject() {
        String username = "locked_out_user", password = "secret_sause";
        SwagLabs pageAfterLogin = open("/", SwagLabs.class).login(username, password);
        assert pageAfterLogin.hasLoginError("Epic sadface");
    }


    @Test
    @Tags({@Tag("Positive"), @Tag("Auth")})
    void TestLogout() {
        open("/");
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $(by("data-test", "title")).shouldHave(text("Products"));
        $("#react-burger-menu-btn").click();
        $("#logout_sidebar_link").click();
        sleep(5000);
        $(byClassName("login_container")).shouldBe();
    }


    @Disabled
    @Test
    @Tags({@Tag("Positive"), @Tag("Auth")})
    void TestLogoutWithPageObject() {
        open("/");
        String username = "standard_user", password = "secret_sauce";
        SwagLabs initPage = open("/", SwagLabs.class);
        SwagLabs result_page = initPage.login(username, password);
        result_page.hasBurgerMenu();
        SwagLabs login_page = result_page.logout();
        assert login_page.isLoginPage();
        clearBrowserLocalStorage();
    }
}
