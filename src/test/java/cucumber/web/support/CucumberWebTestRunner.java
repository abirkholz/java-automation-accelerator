package cucumber.web.support;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "junit:target/test-results/web/cucumber-junit.xml",
                "html:target/test-results/web/cucumber-html",
                "json:target/test-results/web/cucumber-report.json"
        },
        features = {"src/test/resources/cucumber/features/web"},
        glue = {"cucumber.web.steps"}
)
public class CucumberWebTestRunner {
}
