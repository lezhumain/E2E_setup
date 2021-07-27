package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/features",
        glue= "stepDefinitions",
        tags= {"@all"},
        dryRun = false,
        monochrome = true,
        plugin = {
                "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports",
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ExtentReport.html"
        })

public class TestRunner {

    @AfterClass
    public static void writeExtentReport() {
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", System.getProperty("os.name") + " " + System.getProperty("os.version"));
//        Reporter.setSystemInfo("RestAssured", "4.1.1");
//        Reporter.setSystemInfo("Maven", System.getProperty("maven.version"));
        Reporter.setSystemInfo("Java Version", System.getProperty("java.version"));
    }
}
