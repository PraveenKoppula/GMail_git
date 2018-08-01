/**********************************************************************************************
Purpose of the class: Opening all mails in the conversation view (irrespective of read/unread)
***********************************************************************************************/

package NonRefined;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.internal.Coordinates;
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
import io.appium.java_client.touch.offset.PointOption;

public class JustSwipe {
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
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		Thread.sleep(2000);
    }
	
	@Test
	public void OpeningMail() throws InterruptedException
	{
		for(int i=0; i<4 ; i++)
		{
			TouchAction t = new TouchAction(driver);
	//		t.press(PointOption.point(0,0)).moveTo(PointOption.point(0,306)).release().perform();			
	//Unique path of last element
	//Dimension size = driver.findElementByXPath("//android.support.v7.widget.RecyclerView//android.view.View[@index=7]//android.view.View[@index=0]").getSize();
			Dimension size=driver.manage().window().getSize();
			int x=(int)(size.width/2);
			int startY=(int)(size.getHeight() * 0.9);
			int endY=(int)(size.getHeight() * 0.88);
			int duration=2000;
			t.press(PointOption.point(x, startY)).moveTo(PointOption.point((x - x), (endY-startY))).release().perform();
			
			driver.findElementByXPath("//android.support.v7.widget.RecyclerView//android.view.View[@index=7]//android.view.View[@index=0]").click();
			driver.navigate().back();
			Thread.sleep(2000);
		}
		System.out.println("Done");
		Thread.sleep(3000);
	}
	
//	@AfterClass
//	public void Close() throws InterruptedException
//	{
//		Thread.sleep(2000);
//		driver.quit();	
//	}
	
}
