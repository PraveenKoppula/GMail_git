package NonRefined;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ScrollConvView {
	AndroidDriver<AndroidElement> driver ;
	
	@BeforeClass
    public void OpenGmailApp() throws InterruptedException, IOException
    {		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");		//Pixel 2 XL
		cap.setCapability("appPackage", "com.google.android.gm");
		cap.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");		
		cap.setCapability("noReset", "true");
		cap.setCapability("--session-override",true);
		//cap.setCapability("automationName","uiautomator2");
		//GMail activities: com.google.android.gm/com.google.android.gm.welcome.WelcomeTourActivity
		//com.google.android.gm/com.google.android.gm.ConversationListActivityGmail
		//com.google.android.gm/com.google.android.gm.welcome.SetupAddressesActivity
		//cap.setCapability("fullReset", "true");
		//cap.setCapability("fastReset", "true");		
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		Thread.sleep(2000);
    }
	
	@Test
	public void OpeningMail() throws InterruptedException
	{		
		List<AndroidElement> convList = driver.findElementsByXPath("//android.view.View//android.view.View[@index=0]");
		System.out.println("Total count of mails appearing:" + convList.size() );

		WebElement el = driver.findElementByXPath("//android.view.View[@index=0]//android.view.View[@index=0]");
		Dimension size = el.getSize(); 
				
		TouchAction t = new TouchAction(driver);
		
		
//		for(int i=0; i < convList.size() ; i++)
//		{
//			String xPathStr = String.format ("*//android.view.View[@index=%d]//android.view.View[@index=0]", i);
//			System.out.println(xPathStr);
//			
//			if(driver.findElementByXPath(xPathStr).getAttribute("contentDescription").toString().contains("Unread"))
//			{
//				driver.findElementByXPath(xPathStr).click();
//				Thread.sleep(2000);
//				int j = i+1;	
//				System.out.println("Mail-"+ j + " title: " + driver.findElement(By.id("com.google.android.gm:id/subject_and_folder_view")).getText());
//				driver.navigate().back();
//				Thread.sleep(2000);
//			}
//		}	
		
		
		
		
//		List<AndroidElement> convList = driver.findElementsByXPath("//android.view.View//android.view.View[@index=0]");
//		System.out.println("Total count of mails appearing:" + convList.size() );
//		
//		for(int i=0; i < convList.size() ; i++)
//		{
//				System.out.println(convList.get(i).getAttribute("content-desc"));
//				System.out.println(convList.get(i).getAttribute("content-desc").contains("Unread"));
//				convList.get(i).click();
//				Thread.sleep(2000);
//				int j = i+1;	
//				System.out.println("Mail-"+ j + " title: " + driver.findElement(By.id("com.google.android.gm:id/subject_and_folder_view")).getText());
//				driver.navigate().back();
//		}
//		System.out.println("Done");
//		Thread.sleep(3000);
	}
	
	@AfterClass
	public void Close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();	
	}
	
}
