package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@Activity_4",
    monochrome = true,
    plugin = { "pretty", "html:target/cucumber-reports/reports" },
    publish = true
   
)



public class TestRunner {

}
