import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class SwagLabsTest {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.saucedemo.com";

        // remove password popups
        // https://www.repeato.app/disabling-chromes-password-save-pop-up-using-selenium-webdriver/
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        Configuration.browserCapabilities = options;

    }
    @Test
    @Order(2)
    @Tag("Auth")
    @DisplayName("Логин. Пользователь не заблокирован")
    void TestLogin() {
        open("/");

        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $(by("data-test", "title")).shouldHave(text("Products"));
    }

    @Test
    @Order(1)
    @Tag("Auth")
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

}
