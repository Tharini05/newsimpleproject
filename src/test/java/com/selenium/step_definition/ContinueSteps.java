package com.selenium.step_definition;

import com.selenium.pages.HomePage;
import com.selenium.pages.ResultPage;
import com.selenium.pages.TrolleyPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ContinueSteps
{
    HomePage homePage=new HomePage();
    ResultPage resultPage=new ResultPage();
    TrolleyPage trolleyPage=new TrolleyPage();
    int noOfQuantity;


    @When("^It should select any product randomly$")
    public void it_should_select_any_product_randomly()
    {
        resultPage.selectAnyProduct();
    }
    @And("^No of quantity should be increased by \"([^\"]*)\"$")
    public void noOfQuantityShouldBeIncreasedBy(String quantity)
    {
        noOfQuantity=trolleyPage.noOfQuantity(quantity);

    }

    @And("^Select Continue shopping$")
    public void select_Continue_shopping()
    {
        trolleyPage.addToTrolley();
        trolleyPage.goToContinueShopping();
    }

    @Then("^Check the actual and expected results$")
    public void check_the_actual_and_expected_results()
    {
        double actualResult=trolleyPage.getActualResult();
        double expectedResult=trolleyPage.expectedResultContinue();
        assertThat(actualResult,is(equalTo(expectedResult)));
    }



}
