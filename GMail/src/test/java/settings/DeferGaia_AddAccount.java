package settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
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
import pageObjects.Device;
import pageObjects.Settings_objects;
import pageObjects.Suw_objects;

public class DeferGaia_AddAccount {
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
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile, new File("D:\\DeferGaia\\SignIn.png"));
		suw.UserID.sendKeys(username);
		suw.SignIn_Next.click();
		Device.WaitTillViewAppears(driver, "Welcome");
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile, new File("D:\\DeferGaia\\Password.png"));
		suw.Password.sendKeys(password);
		suw.ShowPassword.click();
		suw.Password_Next.click();			
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile, new File("D:\\DeferGaia\\Terms_Iagree.png"));
		suw.AddAccount_IAgree.click();
		Device.WaitTillTextAppears(driver, "Google Services");
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile, new File("D:\\DeferGaia\\GoogleServices.png"));		
		settings.DeferGaia_GoogleServices_Accept.click();

    }

	@DataProvider(name = "Sanity test") public static Object[][] Credentials() {
		return new Object[][] { { "crazyfunda22", "test1233" } }; }
	
}
