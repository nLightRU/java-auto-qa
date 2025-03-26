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

}
