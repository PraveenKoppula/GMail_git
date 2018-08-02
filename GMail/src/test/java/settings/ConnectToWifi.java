package settings;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

public class ConnectToWifi {
	private static AndroidDriver<AndroidElement> driver;
	public Suw_objects suw; 
	public Settings_objects settings; 
	public AnythingElse_objects anythingelsepom; 
	public SetupBaseFunctions base;
	public Device device;
	
	@BeforeClass
	public void StartSettings() throws MalformedURLException, InterruptedException 
    {		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL");
		cap.setCapability("appPackage", "com.android.settings");
		cap.setCapability("appActivity", "com.android.settings.Settings");								
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		suw = new Suw_objects(driver);
		settings = new Settings_objects(driver);
		base = new SetupBaseFunctions();
    }
	
	@Test
	public void Reset() throws InterruptedException, IOException 
	{
		settings.NetworkInternet.click();
		Thread.sleep(2000);
		settings.Wifi.click();
//		settings.Wifi_Toggle.click();
		Thread.sleep(5000);
//		suw.HomeWifi.click();
//		suw.WifiPassword.sendKeys("chotu123$");
//		suw.Connect.click();
//		Thread.sleep(5000);
//		base.ConnectToWifi(driver, suw, device);
		Device.ScrollTo(driver, "GoogleGuest");
		Thread.sleep(5000);
    }
	
	@AfterClass
	public void AfterTest() throws InterruptedException
	{
		driver.quit();
	}
	
}
