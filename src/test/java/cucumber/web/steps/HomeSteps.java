package cucumber.web.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.web.support.Hooks;
import driver.DriverFactory;
import web.pages.HomePage;

public class HomeSteps {
    private HomePage page;

    public HomeSteps(Hooks hooks) throws Exception {
        this.page = new HomePage(hooks.factory.getDriver());
    }

    @Given("^I am on the healthpartners homepage$")
    public void i_am_on_the_healthpartners_homepage() throws Throwable {
        this.page.trait();
    }

    @When("^I click the \"([^\"]*)\" on the homepage$")
    public void i_click_the_on_the_homepage(String element) throws Throwable {
        this.page.getElement(element).click();
    }
}
