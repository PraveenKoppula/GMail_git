/* ************************************************/
/* ************* GENERIC FUNCTION WRAPPER *********/
/* ************************************************/

package Functions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Device {
	
	//For now it is incomplete
	public static String ScreenTitle(AndroidDriver<AndroidElement> driver)
	{
		return driver.findElementById("com.google.android.setupwizard:id/suw_layout_title").getText().toString();
	}
	
	public static void ScrollTo(AndroidDriver<AndroidElement> driver, String selector) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+selector+"\").instance(0))").click();
		}
	
	public static boolean isElementPresent(AndroidDriver<AndroidElement> driver, String selector) {
		if(driver.findElementsByXPath("//android.widget.TextView[@text=\""+selector+"\"]").size() != 0)
		{
			return true;
		}else{
			return false;			
		}
	}
	
	public static void WaitTillTextAppears(AndroidDriver<AndroidElement> driver, String selector) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\""+selector+"\"]")));
	}
	
	public static void WaitTillButtonAppears(AndroidDriver<AndroidElement> driver, String selector) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text=\""+selector+"\"]")));
	}
	
	public static void WaitTillViewAppears(AndroidDriver<AndroidElement> driver, String selector) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text=\""+selector+"\"]")));
	}
	
	public static void WaitTillTextDisappears(AndroidDriver<AndroidElement> driver, String selector) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Boolean element = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.view.View[@text=\""+selector+"\"]")));
	}
	
	public static void GetFromXML(String tagname) throws ParserConfigurationException, SAXException, IOException {
        File inputFile = new File("GoogleServices.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        System.out.println(tagname + ": " + doc.getElementsByTagName(tagname).item(0).getTextContent());
	}
	
//	public void waitForElementVIsibilityIOS(By element) {
//        FluentWait<AndroidDriver> wait = new FluentWait<AndroidDriver>(AndroidDriver driver).withTimeout(20, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
//    }
	
}
