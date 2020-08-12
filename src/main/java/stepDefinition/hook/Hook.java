package stepDefinition.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static utils.baseTest.BaseTest.testScenario;
import static utils.properties.PropertiesHelper.initializeProps;
import static utils.browserManager.ChromeDriverManager.quitDriver;

public class Hook {

    @Before
    public void startCen (Scenario scenario){
        initializeProps();
        scenario.getName();
        testScenario.set(scenario);
    }

    @After
    public void stopCen (){
        quitDriver();
    }
}