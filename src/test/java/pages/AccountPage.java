package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LoggerUtility;

public class AccountPage {

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logoutButton = By.xpath("//ul/li[contains(@class, 'is-logOut')]");

    public void clickLogoutButton() {
        LoggerUtility.info("Click pe butonul de logout");
        WebElement logoutBtn = driver.findElement(logoutButton);
        logoutBtn.click();
    }
}