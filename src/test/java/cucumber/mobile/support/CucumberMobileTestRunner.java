package cucumber.mobile.support;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "junit:target/test-results/mobile/cucumber-junit.xml",
                "html:target/test-results/mobile/cucumber-html",
                "json:target/test-results/mobile/cucumber-report.json"
        },
        features = {"src/test/resources/cucumber/features/mobile"},
        glue = {"cucumber.mobile.steps", "cucumber.mobile.support"}
)
public class CucumberMobileTestRunner {
}
