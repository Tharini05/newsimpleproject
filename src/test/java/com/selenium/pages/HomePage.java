package com.selenium.pages;

import com.selenium.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverFactory
{
    //@FindBy(css = "input[data-test='search-input']")
    //WebElement searchBox;
    public void doSearch(String item) {
      driver.findElement(By.id("searchTerm")).sendKeys(item);
        driver.findElement(By.id("searchTerm")).sendKeys(Keys.ENTER);
    }
    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }
}
