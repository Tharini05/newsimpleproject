package com.selenium.step_definition;

import com.selenium.pages.HomePage;
import com.selenium.pages.ResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FilterSteps
{
    private ResultPage resultPage=new ResultPage();

    @When("^I apply filter review \"([^\"]*)\"$")
    public void i_apply_filter_review(String filter)
    {
        resultPage.selectFilter(filter);
    }

    @Then("^I should be able to see product rating \"([^\"]*)\"$")
    public void i_should_be_able_to_see_product_rating(double expected)
    {
        List<Double> actual=resultPage.getProductRating();
        assertThat(actual,everyItem(is(greaterThanOrEqualTo(expected))));
    }

}
