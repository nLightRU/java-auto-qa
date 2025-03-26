package SwagLabs;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class SwagLabsBase {
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
}
