package Pages;

//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Xpaths.ApplicationXpaths;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;

public class OmniTestClass extends BaseClass {

	ApplicationXpaths xpaths = new ApplicationXpaths();
   
    @BeforeMethod
    public void startApp() {
        initializeDriver();
        // Perform any necessary setup actions before each test method
    }

    @Test
    public void loginTest() throws InterruptedException {
    	Thread.sleep(9000);
        forClick(xpaths.alreadyHaveAccountButton);
        Thread.sleep(5000);
        sendKeys(xpaths.loginEmail,xpaths.Email);
        sendKeys(xpaths.loginPassword, xpaths.Password);
        forClick(xpaths.loginButton);
       
    }

    @AfterMethod
    public void closeApp() {
        quitDriver(); // Close the application after each test method
    }
}
