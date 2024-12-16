package browserServices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeServices implements BrowserServices {

    private WebDriver driver;

    @Override
    public void setupDriver() {

    WebDriverManager.edgedriver().setup();
    }

    @Override
    public WebDriver getDriver() {
        if (driver == null) {
            setupDriver();
            driver = new EdgeDriver();
        }
        return driver;
    }
}
