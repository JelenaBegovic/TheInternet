package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    String validUsername = "tomsmith";
    String validPassword = "SuperSecretPassword!";
    String invalidUsername = "asdfdf";
    String invalidPassword = "fdbgriub";
    String emptyUsername = "";
    String emptyPassword = "";

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    @Test
    public void verifyThatUserCanLogin() {
        homePage.clickOnGetFormAuthenticationButton();
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(secureArea.getMessage().isDisplayed());
        Assert.assertTrue(secureArea.getLogoutButton().isDisplayed());
    }

    @Test
    public void verifyThatUserCannotLoginWithInvalidUsername() {
        homePage.clickOnGetFormAuthenticationButton();
        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getMessage().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
    }

    @Test
    public void verifyThatUserCannotLoginWithInvalidPassword() {
        homePage.clickOnGetFormAuthenticationButton();
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getMessage().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
    }

    @Test
    public void verifyThatUserCannotLoginWithEmptyUsername() {
        homePage.clickOnGetFormAuthenticationButton();
        loginPage.inputUsername(emptyUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getMessage().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
    }

    @Test
    public void verifyThatUserCannotLoginWithEmptyPassword() {
        homePage.clickOnGetFormAuthenticationButton();
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(emptyPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getMessage().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
    }

    @Test
    public void verifyThatUserCanLogout() {
        verifyThatUserCanLogin();
        secureArea.getLogoutButton().click();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
    }


}
