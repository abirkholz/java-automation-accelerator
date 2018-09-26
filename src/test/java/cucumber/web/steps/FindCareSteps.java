package cucumber.web.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.web.support.Hooks;
import org.junit.Assert;
import web.pages.FindCarePage;

/**
 * FindCareSteps
 * All cucumber step definitions that pertain to the FindCarePage
 */
public class FindCareSteps {
    private FindCarePage page;

    public FindCareSteps(Hooks hooks) throws Exception {
        this.page = new FindCarePage(hooks.factory.getDriver());
    }

    @Given("^I am on the find care page$")
    public void i_am_on_the_healthpartners_homepage() throws Throwable {
        this.page.trait();
    }

    @Then("^I should see the \"([^\"]*)\" displayed on the find care page$")
    public void i_should_see_the_displayed_on_the_find_care_page(String element) throws Throwable {
        Assert.assertTrue(this.page.getElement(element).isDisplayed());
    }
}
