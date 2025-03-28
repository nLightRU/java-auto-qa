package me.nlight.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.open;

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


    public static final SelenideElement loginError = $(by("data-test", "error"));

    public SwagLabsProductsPage login_as_standard() {
        this.login("standard_user", "secret_sauce");
        return page(SwagLabsProductsPage.class);
    }

    public SwagLabsLoginPage login_as_locked_out() {
        return this.login("locked_out_user", "secret_sauce");
    }

    public SwagLabsProductsPage login_as_problem() {
        this.login("problem_user", "secret_sauce");
        return page(SwagLabsProductsPage.class);
    }

    public SwagLabsLoginPage login(String username, String password) {
        if (!username.isEmpty()) {
            loginFieldUsername.setValue(username);
        }
        if (!password.isEmpty()) {
            loginFieldPassword.setValue(password);
        }
        loginButton.click();
        return page(SwagLabsLoginPage.class);
    }

    public SwagLabsLoginPage logout() {
        burgerMenu.click();
        logoutLink.click();
        return page(SwagLabsLoginPage.class);
    }

    public SwagLabsLoginPage closeLoginError() {
        $(by("data-test","error-button")).click();
        return page(SwagLabsLoginPage.class);
    }

    public boolean hasBurgerMenu() {
        return $("#react-burger-menu-btn").exists();
    }

    public boolean isLoginPage() {
        return $(".login_container").exists();
    }
}
