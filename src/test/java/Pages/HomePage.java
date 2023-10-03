package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public WebDriver driver;
    public WebDriverWait wait;
    WebElement formAuthenticationButton;
    WebElement javaScriptAlerts;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getFormAuthenticationButton() {
        formAuthenticationButton = driver.findElement(By.linkText("Form Authentication"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formAuthenticationButton);
        return formAuthenticationButton;
    }

    public WebElement getJavaScriptAlerts() {
        javaScriptAlerts = driver.findElement(By.linkText("JavaScript Alerts"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", javaScriptAlerts);
        return javaScriptAlerts;
    }

    public void clickOnGetFormAuthenticationButton() {
        getFormAuthenticationButton().click();
    }

    public void clickOnJavaScriptAlerts() {
        getJavaScriptAlerts().click();
    }
}
