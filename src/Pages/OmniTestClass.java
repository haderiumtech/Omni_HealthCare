package Pages;

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

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
    	Thread.sleep(9000);
        forClick(xpaths.alreadyHaveAccountButton);
        Thread.sleep(5000);
        sendKeys(xpaths.loginEmail,xpaths.Email);
        sendKeys(xpaths.loginPassword, xpaths.Password);
        forClick(xpaths.loginButton);
        
        Thread.sleep(12000);
        //getText(xpaths.getTextVerifyDashboard);
        verifyText(getText(xpaths.getTextVerifyDashboard),"Welcome to the Disease Classification App!");
        
    }
    
    @Test(priority = 2)
    public void diabetesForm() throws InterruptedException {
    	loginTest();
    	Thread.sleep(5000);
    	forClick(xpaths.diabetesButton);
    	Thread.sleep(2000);
    	sendKeys(xpaths.pregnanciesTextField,"1");
    	sendKeys(xpaths.glucoseTextField,"100");
    	sendKeys(xpaths.bloodPressureTextField,"90");
    	sendKeys(xpaths.skinThicknessTextField,"1");
    	sendKeys(xpaths.InsulinTextField,"1");
    	sendKeys(xpaths.bmiTextField,"50");
    	sendKeys(xpaths.diabetesPedigreeFunctionTextField,"2");
    	sendKeys(xpaths.ageTextField,"24");
        Thread.sleep(5000);

        swipeUp();
        Thread.sleep(5000);
        forClick(xpaths.diabetesSubmitButton);
        
        Thread.sleep(12000);
        //getText(xpaths.getTextVerifyDashboard);
        verifyText(getText(xpaths.resultPopup),"Result");
        
    }
    

    @AfterMethod
    public void closeApp() {
        quitDriver(); // Close the application after each test method
    }
}
