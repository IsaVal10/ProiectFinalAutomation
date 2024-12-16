package utils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends SharedData{

    public String testClassName;

    @BeforeMethod

    public void prepareEnvironments(){
        testClassName= this.getClass().getName();
        setUpDriver();

    }

    private void setUpDriver() {
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result) {

    }
}
