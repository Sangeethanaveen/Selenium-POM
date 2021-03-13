package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.SpreeBase;

import java.util.List;

public class HomePage extends SpreeBase {
    By login = By.linkText("Login");
    By home = By.xpath("//li[@id='home-link']/a");
    By searchKeyword = By.id("keywords");
    By searchButton = By.xpath("//input[@value='Search']");
    By bagLink = By.linkText("Bags");
    By priceFilter = By.xpath("//input[@id='Price_Range_$15.00_-_$18.00']");
    By searchFilter = By.cssSelector(".btn.btn-primary");
    By priceProperty = By.xpath("//span[@itemprop='price']");


    public HomePage(WebDriver driåver) {
        this.driver = driver;
    }

    public void clickLogin() {
        driver.findElement(login).click();
    }
    public void clickHome(){driver.findElement(home).click();}

    public void searchKeyword(String name) {
        driver.findElement(searchKeyword).clear();
        driver.findElement(searchKeyword).sendKeys(name);
        driver.findElement(searchButton).click();
    }

    public Boolean verifyKeyword(String name) {
        List<WebElement> titleName = driver.findElements(By.xpath("//span[contains(text(),'" + name + "')]"));
        int size = titleName.size();
        Boolean check = null;
        for (int i = 0; i < titleName.size(); i++) {
            String title = titleName.get(i).getText();
            //System.out.println(title);
            check = title.contains(name);
            Assert.assertTrue(check);
        }
        return check;
    }

    public void filterSearch() {
        driver.findElement(bagLink).click();
        driver.findElement(priceFilter).click();
        driver.findElement(searchFilter).click();

    }

    public Boolean checkSearch() {
        Boolean value = null;
        Boolean checkbox = driver.findElement(priceFilter).isSelected();
        Assert.assertTrue(checkbox);
        List<WebElement> priceValue = driver.findElements(priceProperty);
        //int size = priceValue.size();
        for (int i = 0; i < priceValue.size(); i++) {
            String price = priceValue.get(i).getText();
            String valueStr = price.substring(1);
            double priceText = Double.parseDouble(valueStr);
            value =((priceText > 15.00) && (priceText < 18.00));
        }
        return value;
    }
}
