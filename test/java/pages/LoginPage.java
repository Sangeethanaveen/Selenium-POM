package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.SpreeBase;

public class LoginPage extends SpreeBase {
    By username = By.id("spree_user_email");
    By password = By.cssSelector("#spree_user_password");
    By loginButton = By.xpath("//input[@value='Login']");
    By signOutAlert = By.xpath("//div[@class='alert alert-notice']");
    By successMessage = By.xpath("//div[@id='content']/div");
    By logout = By.linkText("Logout");
    By selectProduct = By.xpath("//span[@title='Ruby on Rails Mug']");
    By addToCart = By.cssSelector("button[id='add-to-cart-button']");
    By cartAmount = By.xpath("//span[@class='amount']");
    By deleteItem = By.xpath("//span[@class='glyphicon glyphicon-minus-sign']");
    By emptyAlert = By.xpath("//div[@class='alert alert-info']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String logInSpree() {
        String eMail ="sangeethanaveen@gmail.com";
        String pWord = "123456";
        driver.findElement(username).sendKeys(eMail);
        driver.findElement(password).sendKeys(pWord);
        driver.findElement(loginButton).click();
        String success = driver.findElement(successMessage).getText();
        System.out.println(success);
        return success;
    }

    public String logOutSpree() {
        driver.findElement(logout).click();
        String logOut = driver.findElement(signOutAlert).getText();
        return logOut;
    }

    public void addToCart() {
        driver.findElement(selectProduct).click();
        driver.findElement(addToCart).click();

    }

    public boolean verifyAddToCart() {
        String amount = driver.findElement(cartAmount).getText();
        Boolean verifyAmount = amount.isBlank();
        return verifyAmount;
    }

    public void deleteProductInCart() {
        driver.findElement(deleteItem).click();

    }
    public String verifyDeleteProduct(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-info']")));
        String delete = driver.findElement(emptyAlert).getText();
        // System.out.println(delete);
        return delete;


    }
}
