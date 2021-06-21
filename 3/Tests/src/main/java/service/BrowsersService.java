package service;

import enums.BaseHtmlId;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.Closeable;

@Getter
@Slf4j
public class BrowsersService implements Closeable {

    private WebDriver driver;
    private DriverManagerType driverManagerType;
    private Waits waits;

    public BrowsersService(final String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                //System.setProperty( "webdriver.chrome.driver", DriverManagerType.CHROME.browserClass() );
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                driverManagerType = DriverManagerType.IEXPLORER;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                driverManagerType = DriverManagerType.SAFARI;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new SafariDriver();
                break;
            case "remote":
                break;
            case "edge":
                driverManagerType = DriverManagerType.EDGE;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new WebDriverManagerException("Browser " + browserName + " is not supported.");
        }
        waits = new Waits(driver);
    }

    public void sleep(final int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getByIdAndSendKeys(final BaseHtmlId enumValue, final @NonNull String keys) {
        getByIdAndSendKeys(enumValue.getHtmlId(), keys);
    }

    public void getByIdAndSendKeys(final String htmlId, final @NonNull String keys) {
        try {
            driver.findElement(By.id(htmlId)).sendKeys(keys);
        } catch (final Exception e) {
            BrowsersService.log.error("Unable to execute. Stacktrace:", e);
        }
    }

    public void getByNameAndSendKeys(final BaseHtmlId enumValue, final @NonNull String keys) {
        getByIdAndSendKeys(enumValue.getHtmlId(), keys);
    }

    public void getByNameAndSendKeys(final String htmlId, final @NonNull String keys) {
        try {
            driver.findElement(By.name(htmlId)).sendKeys(keys);
        } catch (final Exception e) {
            BrowsersService.log.error("Unable to execute. Stacktrace:", e);
        }
    }

    public void navigate(final String url) {
        driver.navigate().to(url);
    }

    /**
     * Closes the browser and kills the process
     */
    @Override
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
