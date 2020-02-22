package com.selenium.step_definition;

import com.selenium.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;

public class CommonSteps
{
    private HomePage homePage=new HomePage();

    @Given("^I am homepage$")
    public void i_am_homepage()
    {
        String actual=homePage.getCurrentUrl();
        assertThat(actual,endsWith(".co.uk/"));
    }

    @When("^I search for product \"([^\"]*)\"$")
    public void i_search_for_product(String searchTerm){
        homePage.doSearch(searchTerm);
    }
}
