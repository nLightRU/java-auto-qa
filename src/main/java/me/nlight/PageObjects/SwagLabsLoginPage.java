package me.nlight.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SwagLabsLoginPage {

    @FindBy(id="user-name")
    private static SelenideElement loginFieldUsername;

    @FindBy(id="password")
    private static SelenideElement loginFieldPassword;

    @FindBy(id="login-button")
    private static SelenideElement loginButton;

    @FindBy(id="react-burger-menu-btn")
    private static SelenideElement burgerMenu;

    @FindBy(xpath="//*[@id=\"logout_sidebar_link\"]")
    private static SelenideElement logoutLink;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private static SelenideElement addToCartButton;

    public static SwagLabsLoginPage login(String username, String password) {
        loginFieldUsername.setValue(username);
        loginFieldPassword.setValue(password);
        loginButton.click();
        return page(SwagLabsLoginPage.class);
    }

    public static SwagLabsLoginPage logout() {
        burgerMenu.click();
        logoutLink.click();
        return page(SwagLabsLoginPage.class);
    }

    public static SwagLabsLoginPage addToCart() {
        addToCartButton.click();
        return page(SwagLabsLoginPage.class);
    }

    public static boolean hasBurgerMenu() {
        return $("#react-burger-menu-btn").exists();
    }

    public static boolean isLoginPage() {
        return $(".login_container").exists();
    }

    public static boolean hasLoginError(String error_text) {
        String error = $(by("data-test", "error")).getText();
        return error.contains(error_text);
    }
}
