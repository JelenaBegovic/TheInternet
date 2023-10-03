package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlertsTests extends BaseTest {
    public String emptyPrompt = "";
    public String prompt = "bhjb";

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    @Test
    public void verifyJavaScriptAlertButton() {
        homePage.clickOnJavaScriptAlerts();
        javaScriptAlerts.clickOnClickForJSAlertButton();
        driver.switchTo().alert().accept();
        Assert.assertEquals(javaScriptAlerts.getMessageText(), "You successfully clicked an alert");
    }

    @Test
    public void verifyJavaScriptConfirmButtonCancel() {
        homePage.clickOnJavaScriptAlerts();
        javaScriptAlerts.clickOnClickForJSConfirmButton();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(javaScriptAlerts.getMessageText(), "You clicked: Cancel");
    }
    @Test
    public void verifyJavaScriptConfirmButtonOK() {
        homePage.clickOnJavaScriptAlerts();
        javaScriptAlerts.clickOnClickForJSConfirmButton();
        driver.switchTo().alert().accept();
        Assert.assertEquals(javaScriptAlerts.getMessageText(), "You clicked: Ok");
    }

    @Test
    public void verifyJavaScriptPromptButton() {
        homePage.clickOnJavaScriptAlerts();
        javaScriptAlerts.clickOnClickForJSPromptButton();
        driver.switchTo().alert().sendKeys(prompt);
        driver.switchTo().alert().accept();
        Assert.assertEquals(javaScriptAlerts.getMessageText(), "You entered: " + prompt);
    }
}
