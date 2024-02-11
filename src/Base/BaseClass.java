package Base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Xpaths.ApplicationXpaths;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BaseClass {

	ApplicationXpaths xpaths = new ApplicationXpaths();
	public AndroidDriver<MobileElement> mobileDriver;
	public WebDriverWait wait;
	public String appiumServer = "127.0.0.1";
	public int appiumPort = 4723;
	URL appiumURL = null;
	
	//this function is use to initialize driver
	public AndroidDriver initializeDriver() {
		try {
			
			appiumURL = new URL("http://"+ appiumServer + ":"+ appiumPort + "/wd/hub");
			this.mobileDriver= new AndroidDriver<MobileElement>(appiumURL,setCapabilities());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return mobileDriver;
	}
	
	//this function is use to set DesiredCapabilities
	public DesiredCapabilities setCapabilities() {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.APP, xpaths.appURL);
        capabilities.setCapability("androidInstallTimeout", 170000); // Set a higher timeout value
        
        return capabilities;
	}
	
	private MobileElement findElement(String locator) {
        return mobileDriver.findElement(MobileBy.xpath(locator));
    }
	
	public void forClick(String locator) {
        MobileElement element = findElement(locator);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath(locator))).click();
        } catch (Exception e) {
        	
        	e.getMessage();
        	e.printStackTrace();
            
        }
    }
	
	public String getText(String locator) 
	{
		String text = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(locator))).getText();
		return text;
		
	}
	
	public void sendKeys(String locator, String value) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).sendKeys(value);
	}
	
	public boolean waitUntilDisplayed(String locator) {
		boolean element;
		try {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).isDisplayed();
		}
		catch(Exception e) {
		element = false;
		}
		return element;
	}
	
	public void verifyText(String expected, String actual){
		Assert.assertEquals(expected, actual);
	}
}
