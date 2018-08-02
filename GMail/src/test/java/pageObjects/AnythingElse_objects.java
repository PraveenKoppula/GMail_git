package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AnythingElse_objects {
	
	public AnythingElse_objects(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/* ************************* Review additional apps - Start ******************************* */	

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add another email account']")
	public WebElement AddAnotherEmail;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Google']")
	public WebElement Google;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Other']")
	public WebElement Other;
			
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.google.android.gm:id/view_email_addresses']")
	public WebElement ViewEmailAddresses;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Outlook, Hotmail, and Live']")
	public WebElement OutlookHotMailAndLive;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Yahoo']")
	public WebElement Yahoo;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Exchange and Office 365']")
	public WebElement ExchangeAndOffice;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Not now']")
	public WebElement NotNow;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add another fingerprint']")
	public WebElement AddAnotherFingerprint;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Change font size']")
	public WebElement ChangeFontSize;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Change wallpaper']")
	public WebElement ChangeWallpaper;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Discover songs with Now Playing']")
	public WebElement DiscoverSongs;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.intelligence.sense:id/ambient_music_setup_enable_button']")
	public WebElement DiscoverSongs_TurnON;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.intelligence.sense:id/ambient_music_setup_disable_button']")
	public WebElement DiscoverSongs_NoThanks;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Review additional apps']")
	public WebElement ReviewAdditionalApps;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.android.vending:id/setup_wizard_preloads_select_all_checkable']")
	public WebElement ReviewAdditionalApps_SelectAllCheckBox;
	
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.setupwizard:id/skip_button']")
	public WebElement NoThanks;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.setupwizard:id/next_button']")
	public WebElement DoneForNow;
	
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.google.android.gm:id/account_email']")
	public WebElement OtherEMail_ID;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.google.android.gm:id/regular_password']")
	public WebElement OtherEMail_Password;
	
	@AndroidFindBy(xpath="//android.widget.Button")
	public WebElement Next;
	/* ************************* Review additional apps - End ******************************* */
	
	
}
