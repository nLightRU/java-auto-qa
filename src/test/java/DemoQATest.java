import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
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
    void goToNextTest() {
        open("https://demoqa.com/text-box");
        $("li#item-1").click();
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

    @Test
    void formTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Vasya");
        $("#submit").click();
    }
}
