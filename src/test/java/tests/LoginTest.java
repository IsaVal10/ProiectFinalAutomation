package tests;
import helpMethods.ElementsMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Hooks;


public class LoginTest extends Hooks {

    public WebDriver driver;

    //@Before
    //public void setUp() {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();}

    @Test
    public void LoginTest() {
        ElementsMethods elementsMethods = new ElementsMethods(driver);

        driver.get("https://ccc.eu/registration/");
        driver.manage().window().maximize();

        By acceptCookieButton = By.xpath("//button[@id='onetrust-accept-btn-handler']");
        elementsMethods.clickElement(acceptCookieButton);
        System.out.println("Cookie-urile au fost acceptate!");

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("Nu multumesc");
        } catch (Exception e) {
            System.out.println("Nu a apărut nicio alertă.");
        }

        By emailField = By.id("enp_customer_form_login_username");
        elementsMethods.enterText(emailField, "somacescuisabela@gmail.com");

        By passwordField = By.xpath("//input[@id='enp_customer_form_login_password']");
        elementsMethods.enterText(passwordField, "Miro10@Isa");

        By loginButton = By.xpath("//input[@class='c-btn is-primary is-wide is-submitBtn']");
        elementsMethods.clickElement(loginButton);

        System.out.println("Autentificare realizată!");

        driver.quit();
    }
}
