package com.selenium.pages;

import com.selenium.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends DriverFactory
{
    @FindBy(css=".findability-facet__rating-label")
    private List<WebElement> ratingWebElements;

    @FindBy(css="div[data-test='component-ratings']")
    private List<WebElement> ratingStar;
       public void selectFilter(String filterOption)
    {
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".findability-facet__rating-label"),5));

        for (WebElement review:ratingWebElements)
        {
            String availableFilter=review.getText();
            if(availableFilter.equalsIgnoreCase(filterOption))
            {
                review.click();
                break;
            }
        }
    }

    public List<Double> getProductRating()
    {
        sleep(3000);
        List<Double> ratingList=new ArrayList<>();

        for (WebElement rating:ratingStar)
        {
            String ratingInString = rating.getAttribute("data-star-rating");
            Double ratingInDouble = Double.parseDouble(ratingInString);
            ratingList.add(ratingInDouble);
        }
        return ratingList;

    }
}