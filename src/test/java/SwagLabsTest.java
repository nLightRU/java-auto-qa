import com.codeborne.selenide.Configuration;

import me.nlight.PageObjects.SwagLabs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class SwagLabsTest {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.saucedemo.com";
    }

    @Test
    @Disabled
    void TestLogin() {
        open("/");
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $(by("data-test", "title")).shouldHave(text("Products"));

    }

    @Test
    void TestLoginWithPageObject() {
        String username = "standard_user", password = "secret_sauce";
        SwagLabs page = open("/", SwagLabs.class);
        SwagLabs result = page.login(username, password);
    }

    @Test
    @Disabled
    void TestLogout() {
        open("/");
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $(by("data-test", "title")).shouldHave(text("Products"));
        $("#react-burger-menu-btn").click();
        $("#logout_sidebar_link").click();
        $(byClassName("login_container")).shouldBe();
    }

    @Test
    void TestLogoutWithPageObject() {
        String username = "standard_user", password = "secret_sauce";
        SwagLabs initPage = open("/", SwagLabs.class);
        SwagLabs result_page = initPage.login(username, password);
        result_page.hasBurgerMenu();
        SwagLabs login_page = result_page.logout();
        sleep(5000);
        assert login_page.isLoginPage();
    }

    @Test
    void TestLockedOut() {
        open("/");
        $("#user-name").setValue("locked_out_user");
        $("#password").setValue("secret_sause");
        $("#login-button").click();
        $(by("data-test", "error")).shouldHave(text("Epic sadface"));
    }


}
