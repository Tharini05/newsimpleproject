package com.selenium.pages;

import com.selenium.driver.DriverFactory;
import com.selenium.utills.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class ResultPage extends DriverFactory {
    @FindBy(css = ".findability-facet__rating-label")
    private List<WebElement> ratingWebElements;

    @FindBy(css = "div[data-test='component-ratings']")
    private List<WebElement> ratingStar;

    @FindBy(css = ".search-title__term")
    private WebElement searchedTitle;

    @FindBy(css = "a[data-test=\"component-product-card-title\"]")
    private List<WebElement> allProductNames;

    public void selectFilter(String filterOption) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".findability-facet__rating-label"), 5));

        for (WebElement review : ratingWebElements) {
            String availableFilter = review.getText();
            if (availableFilter.equalsIgnoreCase(filterOption)) {
                review.click();
                break;
            }
        }
    }

    public List<Double> getProductRating() {
        sleep(3000);
        List<Double> ratingList = new ArrayList<>();

        for (WebElement rating : ratingStar) {
            String ratingInString = rating.getAttribute("data-star-rating");
            Double ratingInDouble = Double.parseDouble(ratingInString);
            ratingList.add(ratingInDouble);
        }
        return ratingList;
    }

    public String selectAnyProduct()
    {
        List<WebElement> productWebElements=isProductAvailable();
        int productSize=productWebElements.size()-1;
        int randomNumber=new Helpers().randomNumberGenerator(productSize);
        WebElement selectedElement = productWebElements.get(randomNumber);
        String selectedProductName = selectedElement.getText();
        selectedElement.click();
        return selectedProductName;
    }

    public List<WebElement> isProductAvailable()
    {
        List<WebElement> productWebElements = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));
        if (productWebElements.size() == 0) {
            fail("No Products found with: " + "nike");
        }
        return productWebElements;
    }


    @FindBy(css=".Checkboxstyles__LabelValue-e3lxpy-6.fOQrQk")
    private List<WebElement> filterSelection;

    @FindBy(css="div[data-test=\"findability-facet\"]")
    private List<WebElement> allCategory;
    public void filterSelectionForAll(String filterOption)
    {
        String nameOfFilter="";
        for (WebElement selectedFilter:filterSelection)
        {
            nameOfFilter=selectedFilter.getText();
            if(nameOfFilter.equalsIgnoreCase(filterOption))
            {
                selectedFilter.click();
                break;
            }
        }
    }

    @FindBy(css=".filter-list__name")
    private List<WebElement> filterAppliedFor;
    public String filterApplied()
    {
        String nameOfTheProduct="";
        //List<String> filteredProductFor=new ArrayList<>();
        for (WebElement productSelected:filterAppliedFor)
        {
            nameOfTheProduct=productSelected.getText();
            //filteredProductFor.add(nameOfTheProduct);
        }
        //return filteredProductFor;
        return nameOfTheProduct;
    }

}