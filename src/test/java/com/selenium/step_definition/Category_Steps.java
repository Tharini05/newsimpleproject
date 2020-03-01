package com.selenium.step_definition;

import com.selenium.pages.ResultPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.hamcrest.Matchers;


import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class Category_Steps
{
    ResultPage resultPage=new ResultPage();

    @And("^I need to apply filter techniques \"([^\"]*)\"$")
    public void iNeedToApplyFilterTechniques(String filterOption)
    {
        resultPage.filterSelectionForAll(filterOption);
    }

    @Then("^I should be able to see the products for \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeTheProductsFor(String filterOption)
    {
        //List<String> filteredSelectedFor=resultPage.filterApplied();
        String filteredSelectedFor=resultPage.filterApplied();
        //assertThat(filteredSelectedFor,everyItem(is(equalToIgnoringCase(filterOption))) );
        assertThat(filteredSelectedFor,is(filterOption));
    }


}
