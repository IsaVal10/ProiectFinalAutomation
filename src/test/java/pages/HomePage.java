package pages;

import configFiles.DataConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
    this.driver = driver;

    WebElement acceptCookieButton = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
    acceptCookieButton.click();

    DataConfig dataConfig = DataConfig.loadConfig("inputData.Login.json");
    }
    }
