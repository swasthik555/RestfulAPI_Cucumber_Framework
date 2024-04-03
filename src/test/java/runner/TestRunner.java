package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
glue = {"stepDefinitions"},
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class TestRunner {
	

}

//"html:target/cucumber-reports/reports.html",
//"pretty","json:target/cucumber-reports/Cucumber.json",
//"pretty","junit:target/cucumber-reports/Cucumber.xml"

