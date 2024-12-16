package browserServices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeServices implements BrowserServices {

    private WebDriver driver;

    @Override
    public void setupDriver() {
    WebDriverManager.chromedriver().setup();
    }

    @Override
    public WebDriver getDriver() {
        if (driver == null) {
            setupDriver();
            driver = new ChromeDriver();
        }
        return driver;
    }
}
