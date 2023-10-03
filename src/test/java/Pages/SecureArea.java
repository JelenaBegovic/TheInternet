package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecureArea {
    public WebDriver driver;
    public WebDriverWait wait;
    WebElement message;
    WebElement logoutButton;

    public SecureArea(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getMessage() {
        return driver.findElement(By.id("flash"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.linkText("Logout"));
    }
}
