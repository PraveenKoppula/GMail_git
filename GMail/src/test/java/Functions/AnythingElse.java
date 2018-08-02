package Functions;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.AnythingElse_objects;
import pageObjects.Device;
import pageObjects.Suw_objects;

public class AnythingElse {
	
	public void CheckElements(AndroidDriver<AndroidElement> driver) throws IOException, InterruptedException {		
		System.out.println("Screen Title is: " + Device.ScreenTitle(driver));

		if(Device.isElementPresent(driver, "Add another email account"))
		{
			System.out.println( "Add another email account tile Present !!!");
		}else{
			System.out.println( "Add another email account tile NOT Present !!!");			
		}
		
		if(Device.isElementPresent(driver, "Change font size"))
		{
			System.out.println("Change font size tile Present !!!");
		}else{
			System.out.println("Change font size tile NOT Present !!!");			
		}
		
		if(Device.isElementPresent(driver, "Change wallpaper"))		
		{
			System.out.println("Change wallpaper tile Present !!!");
		}else{
			System.out.println("Change wallpaper tile NOT Present !!!");
		}
		
		if(Device.isElementPresent(driver, "Discover songs with Now Playing"))
		{
			System.out.println("Discover songs with Now Playing tile Present !!!");
		}else{
			System.out.println("Discover songs with Now Playing tile NOT Present !!!");
		}
		
		if(Device.isElementPresent(driver, "Review additional apps"))		
		{
			System.out.println("Review additional apps tile Present !!!");
		}else{
			System.out.println("Review additional apps tile NOT Present !!!");
		}

		if(Device.isElementPresent(driver, "No thanks"))		
		{
			System.out.println("No thanks button Present !!!");
		}else{
			System.out.println("No thanks button NOT Present !!!");
		}
		
		if(Device.isElementPresent(driver, "Done for now"))		
		{
			System.out.println("Done for now button Present !!!");
		}else{
			System.out.println("Done for now button NOT Present !!!");
		}
	
	}
	
	public void NowPlaying(AndroidDriver<AndroidElement> driver, AnythingElse_objects AnythingElse) throws InterruptedException {
		AnythingElse.DiscoverSongs.click();
		AnythingElse.DiscoverSongs_TurnON.click();
	}	
	
	public void ReviewAdditionalApps(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		//AnythingElse.AnythingElse_ReviewAdditionalApps_SelectAllCheckBox.click();
		Device.ScrollTo(driver,"OK");
	}
	
	public void AddGMail(AndroidDriver<AndroidElement> driver, AnythingElse_objects AnythingElse,Suw_objects suw) throws InterruptedException {		
		AnythingElse.AddAnotherEmail.click();
		AnythingElse.Google.click();
		suw.UserID.sendKeys("crazyfunda22");
		suw.SignIn_Next.click();
		suw.Password.sendKeys("test1233");
		suw.Password_Next.click();
		suw.AddAccount_IAgree.click();
		Thread.sleep(2000);
	}
		
	public void AddPOPAccount(AndroidDriver<AndroidElement> driver, AnythingElse_objects AnythingElse,Suw_objects suw) throws InterruptedException {		
		AnythingElse.OtherEMail_ID.click();
		AnythingElse.OtherEMail_ID.sendKeys("androidtest@juno.com");
		AnythingElse.Next.click();
		AnythingElse.OtherEMail_Password.sendKeys("androidpass");
		AnythingElse.Next.click();
		Thread.sleep(2000);
	}

	public void Actions(AndroidDriver<AndroidElement> driver, AnythingElse_objects AnythingElse) throws InterruptedException {
		
		AnythingElse.OutlookHotMailAndLive.click();
		Thread.sleep(3000);
		driver.navigate().back();
		
		AnythingElse.Yahoo.click();
		driver.navigate().back();
		
		AnythingElse.ExchangeAndOffice.click();
		driver.hideKeyboard();		
		driver.navigate().back();
		
		AnythingElse.NotNow.click();
		AnythingElse.DoneForNow.click();
	}	
	
}
