package service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    private final WebDriverWait wait;

    public Waits(final WebDriver driver) {
        wait = new WebDriverWait(driver, new ReadProperties().getTimeout());
    }

    public WebElement waitForVisibility(final By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForVisibility(final WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public boolean waitForAttributeContains(By by, String attributeName, String attributeValue) {
        return wait.until(ExpectedConditions.attributeContains(by, attributeName, attributeValue));
    }
}
