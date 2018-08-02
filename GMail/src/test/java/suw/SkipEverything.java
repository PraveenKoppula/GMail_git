package suw;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Functions.SetupBaseFunctions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.Settings_objects;
import pageObjects.Suw_objects;

public class SkipEverything {

	private static AndroidDriver<AndroidElement> driver;
	public Suw_objects suw; 
	public Settings_objects settings; 
	public SetupBaseFunctions base;
	
	@BeforeClass
    public void Start() throws InterruptedException, IOException
    {
//		Runtime.getRuntime().exec("cmd /c start C:\\appium");
//		Thread.sleep(15000L);		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "My Phone");
		//bluffing setup wizard app...		
		cap.setCapability("appPackage", "com.android.phone");
		cap.setCapability("appActivity", "com.android.phone.EmergencyDialer");								
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		System.out.println("Emergency dialer opened");
		driver.navigate().back();

		suw = new Suw_objects(driver);
		settings = new Settings_objects(driver);
		base = new SetupBaseFunctions();
    }

	@Test
	public void SUW_SkipEverything() throws InterruptedException {
		suw.Start.click();
		suw.Skip.click(); //Skip mobile network
		suw.Skip.click(); //Skip wifi
		suw.Continue.click(); //Confirm to continue without network
		Thread.sleep(3000);
		suw.Next.click(); //Next in Date and Time screen
		base.GoogleServices_WithNoNetwork(driver, settings);
		suw.SkipFingerPrint.click();
		suw.Security_Skip.click();
		suw.FingerPrint_SkipAnyway.click();
		driver.quit();
	}
	
	@AfterClass
	public void AfterTest() throws InterruptedException
	{
		driver.quit();
	}
	
}
