package settings;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Functions.SetupBaseFunctions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.AnythingElse_objects;
import pageObjects.Device;
import pageObjects.Settings_objects;
import pageObjects.Suw_objects;

public class FactoryResetDevice {
	private static AndroidDriver<AndroidElement> driver;
	public Suw_objects suw; 
	public Settings_objects settings; 
	public AnythingElse_objects anythingelsepom; 
	public SetupBaseFunctions base;
	public Device device;
	
	@BeforeTest
	public void StartSettings() throws MalformedURLException, InterruptedException 
    {		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL");
		cap.setCapability("appPackage", "com.android.settings");
		cap.setCapability("appActivity", "com.android.settings.Settings");								
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		suw = new Suw_objects(driver);
		settings = new Settings_objects(driver);
    }
	
	@Test
	public void Reset() throws InterruptedException 
	{
		Device.ScrollTo(driver, "System");
		settings.Advanced.click();
		Thread.sleep(2000);
		settings.ResetOptions.click();
		settings.EraseAllData.click();
		settings.FactoryReset.click();
		if(Device.isElementPresent(driver, "Re-enter your PIN"))
		{
			suw.PIN_Password.sendKeys("1111");
		}
		else if(Device.isElementPresent(driver, "Re-enter your password"))
		{
			suw.PIN_Password.sendKeys("aaaa");
		}
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(2000);
		settings.EraseEveryThing.click();
		Thread.sleep(2000);
		System.out.println("Factory rest button clicked");
		driver.quit();		
    }
	
}
