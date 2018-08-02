package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Deferred_objects {

	public Deferred_objects(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/* **********Common objects in all - START ************************ */
	@AndroidFindBy(id="com.google.android.setupwizard:id/skip_button")
	public WebElement Skip;

	@AndroidFindBy(id="com.google.android.setupwizard:id/next_button")
	public WebElement Next;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='App updates are ready']")
	public WebElement AppUpdatesAreReady;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Restore over mobile data']")
	public WebElement RestoreOverMobileData;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.setupwizard:id/next_button']")
	public WebElement WiFiSettings;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Finish setting up your Pixel']")
	public WebElement FinishSettingUpPixel;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Finish setup']")
	public WebElement FinishSetup;
	
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.setupwizard:id/welcome_next_button']")
	public WebElement Deferred_Start;

	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.setupwizard:id/welcome_cancel_button']")
	public WebElement RemindMeLater;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.vending:id/positive_button']")
	public WebElement PlayProtectAccept;
	
}
