/*****************************************************************************
        Purpose of the class: Changing few General settings 
*****************************************************************************/

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

public class ChangeSettings {

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
	
	@Test 
	public void ChangeGeneralSettings() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		Device.ScrollTo(driver, "Settings");
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"General settings\")").click();
		driver.findElementByXPath("//android.widget.LinearLayout[@index=2]//android.widget.CheckBox[@resource-id='android:id/checkbox']").click();		

		Device.ScrollTo(driver, "Confirm before deleting");
		Device.ScrollTo(driver, "Confirm before archiving");
		Device.ScrollTo(driver, "Confirm before sending");
	}
	
	@AfterClass
	public void Close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();	
	}
	
}
