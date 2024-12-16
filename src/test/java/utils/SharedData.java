package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SharedData {
    private static WebDriver driver;
    private static String browserType;

    public static void setBrowserType(String browser) {
        browserType = browser.toLowerCase();
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            if ("chrome".equals(browserType)) {
                System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
            } else if ("edge".equals(browserType)) {
                System.setProperty("webdriver.edge.driver", "path_to_edgedriver");
                EdgeOptions options = new EdgeOptions();
                driver = new EdgeDriver(options);
            } else {
                throw new IllegalArgumentException("Browserul nu este suportat: " + browserType);
            }
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}