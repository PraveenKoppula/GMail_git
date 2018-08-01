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

public class GetMailBoxWidth {
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
		System.out.println(driver.getContext());
		List<AndroidElement> convList = driver.findElementsByXPath("//android.support.v7.widget.RecyclerView//android.view.View//android.view.View[@index=0]");
		System.out.println("Total count of mails appearing:" + convList.size() );

		TouchAction t = new TouchAction(driver);
		Dimension elementSize = null;
		
		for(int i=6; i < convList.size() ; i++)
		{
			//System.out.println(" rect "+convList.get(i).getRect());

			elementSize = convList.get(i).getSize();
			System.out.println("cccc"+ elementSize);
			System.out.println(" height " + elementSize.height);
			System.out.println(" width " + elementSize.width);
			
			t.tap(PointOption.point(elementSize.height, elementSize.width)).release();

			convList.get(i).click();
			
			Thread.sleep(2000);
			int j = i+1;
			System.out.println("Mail-"+ j + " title: " + driver.findElement(By.id("com.google.android.gm:id/subject_and_folder_view")).getText());
			driver.navigate().back();
			Thread.sleep(2000);
		}
		
		
		t.press(PointOption.point(0,0)).moveTo(PointOption.point(0,elementSize.height)).release().perform();
		driver.findElementByXPath("//android.support.v7.widget.RecyclerView//android.view.View[@index=0]//android.view.View[@index=0]").click();
		
		System.out.println("Done");
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void Close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();	
	}
	
}
