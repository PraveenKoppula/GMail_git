package suw;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Functions.AnythingElse;
import Functions.SetupBaseFunctions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.AnythingElse_objects;
import pageObjects.Device;
import pageObjects.Suw_objects;

public class AddAccountComplete {
	private static AndroidDriver<AndroidElement> driver;
	public Suw_objects suw; 
	public AnythingElse_objects anythingelsepom; 
	public SetupBaseFunctions base;
	public AnythingElse AnythingElse;
	public Device device;
	
	@BeforeTest
    public void Start() throws InterruptedException, IOException
    {
//		Runtime.getRuntime().exec("cmd /c start C:\\appium");
//		Thread.sleep(15000L);		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "My Phone");
		//cap.setCapability("appPackage", "com.google.android.setupwizard");
		//cap.setCapability("appActivity", "com.google.android.setupwizard.SetupWizardActivity");
		//cap.setCapability("appWaitActivity", "com.google.android.setupwizard.user.WelcomeActivity");		
		//bluffing setup wizard app...		
		cap.setCapability("appPackage", "com.android.phone");
		cap.setCapability("appActivity", "com.android.phone.EmergencyDialer");								
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		System.out.println("Emergency dialer opened");
		driver.navigate().back();

		suw = new Suw_objects(driver);
		anythingelsepom = new AnythingElse_objects(driver);
		base = new SetupBaseFunctions();
		AnythingElse = new AnythingElse();
		
		System.out.println(driver.getCapabilities().getCapability("platformVersion").toString());
		System.out.println(driver.getCapabilities().getCapability("deviceName").toString());
    }
	
	@Test (priority=0)	
	public void StartSUWFlow() throws IOException, InterruptedException {
		base.StartSUW(driver, suw);
	}			
	
	@Test (priority=1)	
	public void ConnectToWifi() throws IOException {
		base.ConnectToWifi(driver, suw, device);
	}	
		
	@Test  (priority=2)
	public void SkipDataCopy() throws InterruptedException {
		base.SkipDataCopy(driver, suw);
	}	
	
	@Test  (priority=3, dataProvider = "login details")
	public void AddAccount(String userid, String password) throws InterruptedException {
		base.AddAccount(driver, suw, userid, password, device);
		if(Device.isElementPresent(driver, "Verify it's you"))
		{
			suw.ConfirmRecoveryEmail.click();
			suw.RecoveryEmail_EditBox.sendKeys("crazyfunda22@gmail.com");
			suw.NEXT.click();
		}
		else
		{
			System.out.println("Account verfication not asked");
		}
	}	

	@Test  (priority=4)
	public void DateTime() {
		System.out.println("Date & time screen displayed");
		suw.Next.click();
	}
	
	
	@Test (priority=5)
	public void GoogleServices() {
		base.GoogleServices(driver, suw);
	}		
	
	@Test (priority=6)
	public void Security() throws InterruptedException {
		//base.Security_PIN(driver, suw);
		base.Security_Password(driver, suw);
	}
	
	
	@Test (priority=7)
	public void Baseline() throws InterruptedException {
		//suw.Skip.click();
		suw.Next.click();
	}	
	
	@Test (priority=8)
	public void GAssistant() throws InterruptedException {
		base.GoogleAssistant(driver, suw);
	}	
		
	@Test (priority=9)
	public void Squeeze() throws InterruptedException {
		base.SqueezeForAssistant(driver, suw);
	}
	
	@Test (priority=10)
	public void GPay() throws InterruptedException {
		base.GooglePay(driver, suw);
	}
	
	@Test (priority=11)
	public void AnythingElse_Elements() throws InterruptedException, IOException {
		AnythingElse.CheckElements(driver);
	}
	
	@Test (priority=12)
	public void AnythingElse_PAI() throws InterruptedException
	{
		AnythingElse.ReviewAdditionalApps(driver);
	}
	
	@Test (priority=13)
	public void AnythingElse_NowPlaying() throws InterruptedException
	{
		AnythingElse.NowPlaying(driver, anythingelsepom);
	}

	@Test (priority=14)
	public void AnythingElse_GMail() throws InterruptedException
	{
		AnythingElse.AddGMail(driver, anythingelsepom, suw);
	}
	
	@Test (priority=15)
	public void AnythingElse_OtherEMail() throws InterruptedException
	{
		AnythingElse.AddPOPAccount(driver, anythingelsepom, suw);
	}
	
	@Test (priority=16)
	public void AnythingElse_OtherActions() throws InterruptedException
	{
		AnythingElse.Actions(driver, anythingelsepom);
	}
	
	@Test (priority=17)
	public void OneLastTip() throws InterruptedException {
		base.OneLastTip(driver, suw);
	}
	
	@AfterTest
	public void End() throws InterruptedException {
		driver.quit();
	}
	
	@DataProvider(name = "login details") public static Object[][] Credentials() {
		return new Object[][] { { "chotucrazy435", "test1233" } }; }
	
}
