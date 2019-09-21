package com.zoopla.qa.testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\pkshank\\eclipse-workspace\\Zoople_BDD_Suite\\src\\test\\java\\com\\zoopla\\qa\\features\\zoopla.feature", 
glue = {"com.zoopla.qa.stepDefinitions" }, 
plugin = { "pretty", "html: test-output", "json:json_output/cucumber.json",
				"junit:junit_xml/cucumber.xml" }, 
monochrome = true, strict = true, 
dryRun = false
//tags= {"@AgentName"}
				)

public class Test_Runner {

}
