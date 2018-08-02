package settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import pageObjects.Device;
import pageObjects.Settings_objects;
import pageObjects.Suw_objects;

public class DeferGaia_account_test {
	public Suw_objects suw; 
	public Settings_objects settings; 
	File scrFile ;
	
	//@Parameters({ "username", "password" })
	@Test(dataProvider = "Sanity test")
    public void AddGoogleAccount(String username, String password) throws InterruptedException, IOException
    {		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL");
		cap.setCapability("appPackage", "com.android.settings");
		cap.setCapability("appActivity", "com.android.settings.Settings");								
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		suw = new Suw_objects(driver);
		settings = new Settings_objects(driver);
		
		Device.ScrollTo(driver, "Accounts");
		settings.AddAccount.click();
		settings.Google.click();
		Device.WaitTillViewAppears(driver, "Sign in");
		
		
        WebElement element = driver.findElement(By.xpath("//*[@resource-id='learnMore' and contains(@class, 'android.widget.Button')]"));
    	Point point = element.getLocation();
        int x = point.x +1;
        int y = point.y + element.getSize().getHeight() - 1;
    		// new TouchAction(driver).tap(tapOptions)(x, y)).perform();
        //new TouchAction(driver).tap(PointOption.point(x, y)).perform();		
        new TouchAction(driver).longPress(PointOption.point(x, y)).waitAction().perform();

    }

	@DataProvider(name = "Sanity test") public static Object[][] Credentials() {
		return new Object[][] { { "crazyfunda22", "test1233" } }; }
	
}
