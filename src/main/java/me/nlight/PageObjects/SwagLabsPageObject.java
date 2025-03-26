package me.nlight.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SwagLabsPageObject {

    @FindBy(id="user-name")
    private SelenideElement loginFieldUsername;

    @FindBy(id="password")
    private SelenideElement loginFieldPassword;

    @FindBy(id="login-button")
    private SelenideElement loginButton;

    @FindBy(id="react-burger-menu-btn")
    private SelenideElement burgerMenu;

    @FindBy(xpath="//*[@id=\"logout_sidebar_link\"]")
    private SelenideElement logoutLink;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private SelenideElement addToCartButton;

    public SwagLabsPageObject login(String username, String password) {
        loginFieldUsername.setValue(username);
        loginFieldPassword.setValue(password);
        loginButton.click();
        return page(SwagLabsPageObject.class);
    }

    public SwagLabsPageObject logout() {
        burgerMenu.click();
        logoutLink.click();
        return page(SwagLabsPageObject.class);
    }

    public SwagLabsPageObject addToCard() {
        addToCartButton.click();
        return page(SwagLabsPageObject.class);
    }

    public boolean hasBurgerMenu() {
        return $("#react-burger-menu-btn").exists();
    }

    public boolean isLoginPage() {
        return $(".login_container").exists();
    }

    public boolean hasLoginError(String error_text) {
        String error = $(by("data-test", "error")).getText();
        return error.contains(error_text);
    }
}
