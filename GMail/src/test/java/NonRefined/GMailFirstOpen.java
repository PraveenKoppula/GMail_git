package NonRefined;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GMailFirstOpen {

	AndroidDriver<AndroidElement> driver ;
	
	@BeforeClass
    public void OpenGmailApp() throws InterruptedException, IOException
    {		
 		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "My device");		
		cap.setCapability("appPackage", "com.google.android.gm");
		cap.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");		
		//cap.setCapability("noReset", "true");
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		//com.google.android.gm/com.google.android.gm.ConversationListActivityGmail
		//GMail activities: com.google.android.gm/com.google.android.gm.welcome.WelcomeTourActivity
		//com.google.android.gm/com.google.android.gm.ConversationListActivityGmail
		//com.google.android.gm/com.google.android.gm.welcome.SetupAddressesActivity
		//cap.setCapability("fullReset", "true");
		//cap.setCapability("fastReset", "true");		

    }
	
	@Test
	public void OpeningMail() throws InterruptedException
	{
		driver.findElementById("com.google.android.gm:id/welcome_tour_got_it").click();
		Thread.sleep(2000);
		driver.findElementById("com.google.android.gm:id/action_done").click();
		//driver.findElementById("com.google.android.gm:id/setup_addresses_add_another").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='Google']").click();
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void AfterTest() throws InterruptedException
	{
		driver.quit();
	}
	
}
