package Base;

import java.net.URL;

//import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import Xpaths.ApplicationXpaths;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BaseClass extends ApplicationXpaths  {

    public AndroidDriver<MobileElement> mobileDriver;
	public String appiumServer = "127.0.0.1";
	public int appiumPort = 4723;
	URL appiumURL = null;

    public BaseClass() {
//        try {
//            initializeDriver();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public AndroidDriver<MobileElement> initializeDriver() {
        try {
            appiumURL = new URL("http://"+appiumServer+":"+appiumPort+"/wd/hub");
            mobileDriver= new AndroidDriver<MobileElement>(appiumURL,setCapabilities());
        } catch(Exception e){
            e.printStackTrace();
        }
        return mobileDriver;
    }

    public DesiredCapabilities setCapabilities()  {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
        capabilities.setCapability(MobileCapabilityType.APP, "E:\\Appium\\omni.apk");
        capabilities.setCapability("appium:waitAppPackage", true);
        capabilities.setCapability("appium:appPackage", "com.omni");
        capabilities.setCapability("appium:appActivity", "com.omni.MainActivity");
        capabilities.setCapability("androidInstallTimeout", 70000);
        return capabilities;
    }

    public void quitDriver() {
        if (mobileDriver != null) {
            mobileDriver.quit();
        }
    }

    public MobileElement findElement(String locator) {
        return (MobileElement) mobileDriver.findElement(MobileBy.xpath(locator));
    }

    public void forClick(String locator) {
        try {
            findElement(locator).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getText(String locator) {
        return findElement(locator).getText();
    }

    public void sendKeys(String locator, String value) {
        findElement(locator).sendKeys(value);
    }

    public boolean waitUntilDisplayed(String locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void verifyText(String expected, String actual) {
        Assert.assertEquals(expected, actual);
    }
}
