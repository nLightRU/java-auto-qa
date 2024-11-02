import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQATest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    @DisplayName("Demo QA Text Box")
    void textBoxTest() {
        open("/text-box");
        $("#userName").setValue("Vasya");
        $("#submit").click();
        $("#name").shouldBe(visible);
        $("#name").shouldHave(text("Vasya"));
    }

    @Disabled
    @Test
    @DisplayName("Demo QA Forms")
    void formTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Vasya");
        $("#submit").click();
    }
}
