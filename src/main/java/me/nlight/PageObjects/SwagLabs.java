package me.nlight.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SwagLabs {

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

    public SwagLabs login(String username, String password) {
        loginFieldUsername.setValue(username);
        loginFieldPassword.setValue(password);
        loginButton.click();
        return page(SwagLabs.class);
    }

    public SwagLabs logout() {
        burgerMenu.click();
        logoutLink.click();
        return page(SwagLabs.class);
    }

    public boolean hasBurgerMenu() {
        return $("#react-burger-menu-btn").exists();
    }

    public boolean isLoginPage() {
        return $(".login_container").exists();

    }
}
