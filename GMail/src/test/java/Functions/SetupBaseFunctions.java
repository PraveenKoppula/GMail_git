package Functions;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.AnythingElse_objects;
import pageObjects.Device;
import pageObjects.Settings_objects;
import pageObjects.Suw_objects;

public class SetupBaseFunctions {
	File scrFile ;
	public Device device;
	
	public void AndroidBetaProgram(AndroidDriver<AndroidElement> driver, Suw_objects suw, Device device)
	{
		if(device.isElementPresent(driver, "OK"))
		{
			suw.BetaProgram_OK.click();
		}
	}
	
	   public void StartSUW() throws InterruptedException, IOException
	    {
//			Runtime.getRuntime().exec("cmd /c start C:\\appium");
//			Thread.sleep(15000L);		
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "My Phone");
			//bluffing setup wizard app...		
			//cap.setCapability("appPackage", "com.android.phone");
			//cap.setCapability("appActivity", "com.android.phone.EmergencyDialer");								
			cap.setCapability("appPackage", "com.google.android.setupwizard");
			cap.setCapability("appActivity", "com.google.android.setupwizard.SetupWizardActivity");
			cap.setCapability("appWaitActivity", "com.google.android.setupwizard.user.WelcomeActivity");		
			AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
			System.out.println("Emergency dialer opened");
			driver.navigate().back();
			Thread.sleep(2000);
	    }

	public void StartSUW(AndroidDriver<AndroidElement> driver, Suw_objects suw) throws IOException, InterruptedException {
			suw.Start.click();
			Thread.sleep(5000);
	}
	
	public void SkipMobileNetwork(AndroidDriver<AndroidElement> driver, Suw_objects suw) throws IOException, InterruptedException {
		suw.Skip.click();
		Thread.sleep(2000);
	}
	   
	public void ConnectToMobileNetwork(AndroidDriver<AndroidElement> driver, Suw_objects suw) throws IOException, InterruptedException {
		//Code to be written
	}	
	
	public void ConnectToWifi(AndroidDriver<AndroidElement> driver, Suw_objects suw, Device device) throws IOException {
		try {
			boolean isHomeWifiDisplayed = Device.isElementPresent(driver, "3idiots-2.4");
			boolean isManuWifiDisplayed = Device.isElementPresent(driver, "Manusaran");
			
			if(isHomeWifiDisplayed)
			{			
				scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
				FileUtils.copyFile(scrFile, new File("D:\\Wifi_Home.png"));
				suw.HomeWifi.click();
				suw.WifiPassword.sendKeys("chotu123$");
				suw.Connect.click();
				Thread.sleep(5000);
				if(device.isElementPresent(driver, "Connected"))
				{
					//wifi not connecting automatically ...so clicking the wifi and connecting again
					suw.HomeWifi.click();
					suw.Connect.click();
				}
			}
			else if(isManuWifiDisplayed)
			{
				scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
				FileUtils.copyFile(scrFile, new File("D:\\Wifi_Manu.png"));
				suw.ManuWifi.click();
				suw.WifiPassword.sendKeys("ucancheckin");
				suw.Connect.click();
				Thread.sleep(5000);
				//wifi not connecting automatically ...so clicking the wifi and connecting again
				if(device.isElementPresent(driver, "Connected"))
				{
					suw.ManuWifi.click();
					suw.Connect.click();
				}
			}
			else
			{
				suw.SeeAllWifiNetworks.click();
				Thread.sleep(3000);
				Device.ScrollTo(driver, "GoogleGuest");
				//wifi not connecting automatically ...so clicking the wifi again
				Thread.sleep(5000);
				if(device.isElementPresent(driver, "Connected"))
				{
					Device.ScrollTo(driver, "GoogleGuest");
				}
			}
			Thread.sleep(40000);
			System.out.println("wifi connected");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void SkipDataCopy(AndroidDriver<AndroidElement> driver, Suw_objects suw) throws InterruptedException {
		System.out.println(suw.D2D_screen1Title.getText().toString() + " screen appeared");
//		suw.DontCopy.click();
		suw.CopyOtherWays.click();
		suw.DontCopy_Confirm.click();
		Thread.sleep(3000);
		System.out.println("skip data copy ended");
	}
	
	public void ChooseCloudFlow(AndroidDriver<AndroidElement> driver, Suw_objects suw, Device device) throws InterruptedException
	{
		suw.D2DNext.click();
		suw.D2DNext.click();
		suw.D2DNext.click();
		suw.D2DNext.click();
		suw.D2DNext.click();
		//Thread.sleep(10000);
		Device.WaitTillButtonAppears(driver, "Copy another way");
		suw.CopyOtherWays.click();
		suw.BackupFromCloud.click();
		//Thread.sleep(10000);
		Device.WaitTillViewAppears(driver, "Sign in");
	}
	
	
	public void AddAccount(AndroidDriver<AndroidElement> driver, Suw_objects suw, String userid, String password, Device device) throws InterruptedException {
		System.out.println("addaccount started");
		suw.UserID.sendKeys(userid);
		suw.SignIn_Next.click(); // or 		driver.pressKeyCode(AndroidKeyCode.ENTER);
		suw.Password.sendKeys(password);
		suw.Password_Next.click();
		Thread.sleep(2000);
		suw.AddAccount_IAgree.click();		
		/*
		if(Device.isElementPresent(driver, "Verify it's you"))
		{
			suw.ConfirmRecoveryEmail.click();
			suw.RecoveryEmail_EditBox.sendKeys("crazyfunda22@gmail.com");
			suw.NEXT.click();
		}
		*/
		Thread.sleep(10000);
		System.out.println("addaccount ended");
	}	

	public void ChooseBackupSetAndRestore(AndroidDriver<AndroidElement> driver, Suw_objects suw, Device device) throws InterruptedException {	
	{
			Device.WaitTillTextAppears(driver, "Choose a backup to restore");
			if(Device.isElementPresent(driver, "Choose a backup to restore"))
			{
				driver.findElementByXPath("//android.widget.TextView[@text='Pixel 2 backup']").click();
				if(Device.isElementPresent(driver, suw.DecryptBackup))
				{
					suw.PixelMigrate_Next.click();
					driver.findElementByXPath("//android.widget.EditText").sendKeys("aaaa");
					suw.PixelMigrate_SecurityConfirm.click();
					Device.WaitTillTextAppears(driver, "Choose what to restore");
					if(Device.isElementPresent(driver, "Choose what to restore"))
					{
						suw.Restore.click();
						Thread.sleep(10000);
					}
				}	
			}
		}
	}
	
	public void GoogleServices(AndroidDriver<AndroidElement> driver, Suw_objects suw) {
		while(suw.GoogleServices_Next.getText().equals("More"))
		{
			suw.GoogleServices_Next.click();
		}			
		suw.GoogleServices_Next.click(); // Button label changes to Accept 
	}
	
	public void GoogleServices_WithNoNetwork(AndroidDriver<AndroidElement> driver, Settings_objects settings) {
		while(settings.DeferGaia_GoogleServices_Accept.getText().equals("More"))
		{
			settings.DeferGaia_GoogleServices_Accept.click();
		}			
		settings.DeferGaia_GoogleServices_Accept.click(); // Button label changes to Accept 
	}
	
	public void Security_PIN(AndroidDriver<AndroidElement> driver, Suw_objects suw) throws InterruptedException {
		System.out.println(suw.ScreenTitle.getText());
		suw.FingerPrint_Next.click();
		Thread.sleep(2000);
		suw.PIN_Password.sendKeys("1111");
		suw.Security_Next.click();
		Thread.sleep(2000);
		suw.PIN_Password.sendKeys("1111");
		suw.Security_Next.click();
		suw.Security_Skip.click();
		suw.FingerPrint_SkipAnyway.click();				
	}

	public void Security_Password(AndroidDriver<AndroidElement> driver, Suw_objects suw) throws InterruptedException {
		System.out.println(suw.ScreenTitle.getText());
		suw.FingerPrint_Next.click();
		Thread.sleep(2000);
		suw.ScreenLockOptions.click();
		suw.ScreenLock_Password.click();
		suw.PIN_Password.sendKeys("aaaa");
		suw.Security_Next.click();
		Thread.sleep(2000);
		suw.PIN_Password.sendKeys("aaaa");
		suw.Security_Next.click();
		suw.Security_Skip.click();
		suw.FingerPrint_SkipAnyway.click();				
	}	
	
	public void GoogleAssistant(AndroidDriver<AndroidElement> driver, Suw_objects suw) throws InterruptedException {
		suw.GoogleAssistant_Next.click();
		suw.GoogleAssistant_Permissions_TurnON.click();
		suw.VoiceMatch_NoThanks.click();
		suw.LetTheAssistantUseWhatsOnYourScreen_ToggleSwitch.click();
		suw.GoogleAssistant_Next.click();
	}	
	
	public void SqueezeForAssistant(AndroidDriver<AndroidElement> driver, Suw_objects suw) throws InterruptedException {
		suw.Squeeze_Next.click();
		Thread.sleep(2000);
		suw.Squeeze_DoItLater.click();
	}	
	
	public void GooglePay(AndroidDriver<AndroidElement> driver, Suw_objects suw) throws InterruptedException {
		suw.GooglePay_AddACard.click();
		suw.GooglePay_EnterDetailsManually.click();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().back();
		suw.GooglePay_Skip.click();
	}
	
	public void OneLastTip(AndroidDriver<AndroidElement> driver, Suw_objects suw) throws InterruptedException {
		suw.OneLastTip_Toggle.click();
		suw.OneLastTip_AllSet.click();
	}

}
