package test;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SpreeBase {
    public static WebDriver driver;

    @BeforeClass
    public static void setUpDriver() {
       // /Users/sangeethanagarathinam/IdeaProjects/SpreeAutomationPOM/src/test/resource
        System.setProperty("webdriver.chrome.driver","/Users/sangeethanagarathinam/IdeaProjects/SpreeAutomationPOM/src/test/resource/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // waitBeforeTest();
        driver.getTitle();
    }
    @AfterClass
    public  void tearDown(){
        driver.quit();
    }

    public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException {
        Date d = new Date();
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        try {
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("/Users/sangeethanagarathinam/IdeaProjects/SpreeAutomationPOM/src/screenshots" +this.getClass().getName()+"_" +d + "_screenshot.png");
            Files.copy(srcFile, destFile);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
