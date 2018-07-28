package GMail;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Functions.Device;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class ClickingMenuItems {

	AndroidDriver<AndroidElement> driver ;	
	List<AndroidElement> listOfStarredMails;
	
	@BeforeClass
    public void OpenGmailApp() throws InterruptedException, IOException
    {		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");		//Pixel 2 XL
		cap.setCapability("appPackage", "com.google.android.gm");
		cap.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");		
		cap.setCapability("noReset", "true");		
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		Thread.sleep(2000);
    }

	@Test (priority=0 , groups= {"MenuOptions"}) 
	public void UnreadMailsCount() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		String UnreadMailCount = driver.findElementByXPath("//android.widget.LinearLayout[@index=1]//android.widget.TextView[@resource-id='com.google.android.gm:id/unread']").getText().toString();
		System.out.println("UnreadMailCount : " + UnreadMailCount);
		driver.navigate().back();
		Thread.sleep(2000);
	}	
	
	@Test (priority=1 , groups= {"MenuOptions"})
	public void ClickSocial() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		if(Device.isElementPresent(driver, "Social"))
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Social\")").click();
			driver.navigate().back();
		}
		else
		{
			Device.ScrollTo(driver, "Social");
			driver.navigate().back();
		}
	}
	
	@Test (priority=2 , groups= {"MenuOptions"})
	public void ClickPromotions() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		if(Device.isElementPresent(driver, "Promotions"))
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Promotions\")").click();
			driver.navigate().back();
		}
		else
		{
			Device.ScrollTo(driver, "Promotions");
			driver.navigate().back();
		}
	}

	@Test (priority=3 , groups= {"MenuOptions"})
	public void ClickStarred() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		if(Device.isElementPresent(driver, "Starred"))
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Starred\")").click();
			driver.navigate().back();
		}
		else
		{
			Device.ScrollTo(driver, "Starred");
			driver.navigate().back();
		}
	}	
	
	@Test (priority=4 , groups= {"MenuOptions"})
	public void ClickSnoozed() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		if(Device.isElementPresent(driver, "Snoozed"))
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Snoozed\")").click();
			driver.navigate().back();
		}
		else
		{
			Device.ScrollTo(driver, "Snoozed");
			driver.navigate().back();
		}
	}	
	
	@Test (priority=5 , groups= {"MenuOptions"})
	public void ClickImportant() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		if(Device.isElementPresent(driver, "Important"))
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Important\")").click();
			driver.navigate().back();
		}
		else
		{
			Device.ScrollTo(driver, "Important");
			driver.navigate().back();
		}
	}	
	
	@Test (priority=6 , groups= {"MenuOptions"})
	public void ClickSent() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		if(Device.isElementPresent(driver, "Sent"))
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Sent\")").click();
			driver.navigate().back();
		}
		else
		{
			Device.ScrollTo(driver, "Sent");
			driver.navigate().back();
		}
	}	
	
	@Test (priority=7 , groups= {"MenuOptions"})
	public void ClickOutbox() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		if(Device.isElementPresent(driver, "Outbox"))
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Outbox\")").click();
			driver.navigate().back();
		}
		else
		{
			Device.ScrollTo(driver, "Outbox");
			driver.navigate().back();
		}
	}	
	
	@Test (priority=8 , groups= {"MenuOptions"})
	public void ClickDrafts() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		if(Device.isElementPresent(driver, "Drafts"))
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Drafts\")").click();
			driver.navigate().back();
		}
		else
		{
			Device.ScrollTo(driver, "Drafts");
			driver.navigate().back();
		}
	}	

	@Test (priority=9 , groups= {"MenuOptions"})
	public void ClickAllMail() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		if(Device.isElementPresent(driver, "All mail"))
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"All mail\")").click();
			driver.navigate().back();
		}
		else
		{
			Device.ScrollTo(driver, "All mail");
			driver.navigate().back();
		}
	}		
	
	@Test (priority=10 , groups= {"MenuOptions"})
	public void ClickSpam() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		if(Device.isElementPresent(driver, "Spam"))
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Spam\")").click();
			driver.navigate().back();
		}
		else
		{
			Device.ScrollTo(driver, "Spam");
			driver.navigate().back();
		}
	}			
	
	@Test (priority=11 , groups= {"MenuOptions"})
	public void ClickTrash() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		if(Device.isElementPresent(driver, "Trash"))
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Trash\")").click();
			driver.navigate().back();
		}
		else
		{
			Device.ScrollTo(driver, "Trash");
			driver.navigate().back();
		}
	}			
	
	@Test (priority=12 , groups= {"MenuOptions"})
	public void ClickSettings() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		if(Device.isElementPresent(driver, "Settings"))
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Settings\")").click();
			driver.navigate().back();
		}
		else
		{
			Device.ScrollTo(driver, "Settings");
			driver.navigate().back();
		}
	}
	
	@Test (priority=13 , groups= {"MenuOptions"})
	public void ClickHelpAndFeedback() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		if(Device.isElementPresent(driver, "Help & feedback"))
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Help & feedback\")").click();
			Thread.sleep(3000);
			driver.navigate().back();
		}
		else
		{
			Device.ScrollTo(driver, "Help & feedback");
			Thread.sleep(3000);
			driver.navigate().back();
		}
	}			
	
	@AfterClass
	public void Close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();	
	}
	
}
