package test.main;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature",
		glue = {"test/stepdef"},
		plugin = {"pretty", "json:target/report.json"}
//		,dryRun = true
		)
public class OnlineStoreIT {

}
