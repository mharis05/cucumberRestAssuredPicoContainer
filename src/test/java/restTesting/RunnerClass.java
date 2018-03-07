package restTesting;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/addNewWishlist.feature",
        plugin = { "pretty", "html:target/htmlreport"})

public class RunnerClass {
}