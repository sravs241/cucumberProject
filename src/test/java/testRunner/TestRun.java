package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@CucumberOptions( features=".//features//Login.feature", glue="stepDefinitions")
public class TestRun{

}
