package com.selenium.step_definition;

import com.selenium.driver.DriverFactory;
import com.selenium.pages.HomePage;
import com.selenium.pages.ResultPage;
import com.selenium.pages.TrolleyPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchSteps
{
    HomePage homepage=new HomePage();
    ResultPage resultsPage=new ResultPage();
    TrolleyPage trolleyPage=new TrolleyPage();

    String selectedProductName;
    int noOfQuantity;

    @When("^It should randomly select one product$")
    public void it_should_randomly_select_one_product()
    {
        selectedProductName=resultsPage.selectAnyProduct();
    }

    @Then("^Check the selected page is in trolley page$")
    public void check_the_selected_page_is_in_trolley_page()
    {
        String actual=trolleyPage.getProductInTrolley();
        assertThat(actual, is(equalToIgnoringCase(selectedProductName)));
    }

}
