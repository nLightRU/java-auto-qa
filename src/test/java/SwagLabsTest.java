import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class SwagLabsTest {
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

}
