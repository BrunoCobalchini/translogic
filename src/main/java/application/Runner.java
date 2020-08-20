package application;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = "stepDefinition",
        tags = "@PARADADETREM",
        plugin = {
                "json:target/cucumber-report/cucumber.json"
        },
        features = "src/main/feature")

public class Runner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

