package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;
@Listeners(listeners.CustomListeners.class)
public class SpreeTestCase extends SpreeBase implements ITestListener {
    LoginPage login = new LoginPage(driver);
    HomePage home = new HomePage(driver);


    @Test
    public void loginFunctionality() {

        home.clickLogin();
        String success = login.logInSpree();
        Assert.assertEquals(success, "Logged in successfully");
        String logOut = login.logOutSpree();
        Assert.assertEquals(logOut, "Signed out successfully.");
    }


    @Test()
    public void searchProduct() {
        home.clickHome();
        home.searchKeyword("Ruby");
        Boolean checkRuby = home.verifyKeyword("Ruby");
        Assert.assertTrue(checkRuby);
        home.searchKeyword("Apache");
        Boolean checkApache= home.verifyKeyword("Apache");
        Assert.assertTrue(checkApache);

    }

    @Test()
    public void searchByFilter() {

        home.clickHome();
        home.filterSearch();
        Boolean value = home.checkSearch();
        Assert.assertTrue(value);
    }

    @Test()
    public void addToCartAndEmptyCart() {
        home.clickLogin();
        login.logInSpree();
        home.searchKeyword("Ruby on Rails Mug");
        login.addToCart();
        boolean verifyCart = login.verifyAddToCart();
        Assert.assertFalse(verifyCart);
        login.deleteProductInCart();
        String deleteMsg = login.verifyDeleteProduct();
        Assert.assertEquals("Your cart is empty", deleteMsg);
        login.logOutSpree();

    }



    }


