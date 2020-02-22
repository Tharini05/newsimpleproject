package com.selenium.pages;

import com.selenium.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends DriverFactory
{
       public void selectFilter(String filterOption)
    {
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".findability-facet__rating-label"),5));
        List<WebElement> ratingWebElements=driver.findElements(By.cssSelector(".findability-facet__rating-label"));
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
        List<Double> ratingList=new ArrayList<>();
        List<WebElement> ratingStar=driver.findElements(By.cssSelector("div[data-test='component-ratings']"));
        for (WebElement rating:ratingStar)
        {
            String ratingInString = rating.getAttribute("data-star-rating");
            Double ratingInDouble = Double.parseDouble(ratingInString);
            ratingList.add(ratingInDouble);
        }
        return ratingList;

    }
}