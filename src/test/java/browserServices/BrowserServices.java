package browserServices;

import org.openqa.selenium.WebDriver;

public interface BrowserServices {

    void setupDriver();

    WebDriver getDriver();
}
