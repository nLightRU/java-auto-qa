import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SwagLabsTest {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.saucedemo.com";
    }

    @Test
    void TestLogin() {
        open("/");
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $(by("data-test", "title")).shouldHave(text("Products"));
    }

    @Test
    void TestOther() {

    }
}
