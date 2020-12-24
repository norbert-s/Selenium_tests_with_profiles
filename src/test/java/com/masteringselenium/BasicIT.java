package com.masteringselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicIT extends DriverBase {

    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
    }

    private void googleExampleThatSearchesFor(final String searchString)  {

        WebDriver driver = DriverBase.getDriver();

        driver.get("http://www.google.com");

        WebElement searchField = driver.findElement(By.name("q"));

        searchField.clear();
        searchField.sendKeys(searchString);

        System.out.println("Page title is: " + driver.getTitle());


        searchField.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        wait.until(pageTitleStartsWith(searchString));
        //Thread.sleep(20000);
        String value = driver.findElement(By.cssSelector("input[type='text']")).getAttribute("value");
        System.out.println("talalt : "+value);
        //System.out.println("Page title is: " + driver.getTitle());

        Assert.assertEquals(searchString,value);
    }

    @Test
    public void googleCheeseExample()  {
        googleExampleThatSearchesFor("Cheese!");
    }

    @Test
    public void googleMilkExample()  {
        googleExampleThatSearchesFor("Milk!");
    }



    @Test
    public void googleCheeseExample3() {
        googleExampleThatSearchesFor("hi!");
    }

    @Test
    public void googleMilkExample4() {
        googleExampleThatSearchesFor("olol");
    }

    @Test
    public void googleCheeseExample5() {
        googleExampleThatSearchesFor("haha");
    }

    @Test
    public void googleMilkExample6() {
        googleExampleThatSearchesFor("cool");
    }
}
