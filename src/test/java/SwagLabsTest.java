import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;


public class SwagLabsTest {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.saucedemo.com";
    }

}
