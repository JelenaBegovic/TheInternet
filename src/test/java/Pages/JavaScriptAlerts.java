package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class JavaScriptAlerts {
    public WebDriver driver;
    public WebDriverWait wait;
    WebElement clickForJSAlertButton;
    WebElement clickForJSConfirmButton;
    WebElement clickForJSPromptButton;
    WebElement message;



    public JavaScriptAlerts(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getClickForJSAlertButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[1]/button"));
    }
    public WebElement getClickForJSConfirmButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[2]/button"));
    }

    public WebElement getClickForJSPromptButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[3]/button"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.id("result"));
    }

    public void clickOnClickForJSAlertButton() {
        getClickForJSAlertButton().click();
    }
    public void clickOnClickForJSConfirmButton() {
        getClickForJSConfirmButton().click();
    }
    public void clickOnClickForJSPromptButton() {
        getClickForJSPromptButton().click();
    }

    public String getMessageText() {
        return getMessage().getText();
    }

}
