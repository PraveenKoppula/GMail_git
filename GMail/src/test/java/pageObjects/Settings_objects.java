package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Settings_objects {
	
	public Settings_objects(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/* **********Common objects in all - START ************************ */
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Network & internet']")
	public WebElement NetworkInternet;
	
	//@AndroidFindBy(xpath="//*[@text='Wi-Fi']")
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[1]")
	public WebElement Wifi;

	@AndroidFindBy(xpath="//android.widget.Switch[@resource-id='com.android.settings:id/switch_widget']")
	public WebElement Wifi_Toggle;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add account']")
	public WebElement AddAccount;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Google']")
	public WebElement Google;
	
	// Defer daia - Google Services - Accept button - Settings
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.gms:id/next_button']")
	public WebElement DeferGaia_GoogleServices_Accept;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Advanced']")
	public WebElement Advanced;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Reset options']")
	public WebElement ResetOptions;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Erase all data (factory reset)']")
	public WebElement EraseAllData;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.settings:id/initiate_master_clear']")
	public WebElement FactoryReset;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.settings:id/execute_master_clear']")
	public WebElement EraseEveryThing;

	
	/* **********Common objects in all - END ************************ */	
	
	
	/* **********Welcome screen objects - START ************************ */
	//@AndroidFindBy(id="com.google.android.setupwizard:id/language_picker")
	//public WebElement LanguagePicker;
	
	//@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.android.settings:id/password']")
	//public WebElement WifiPassword;
	
	/* **********Wifi screen objects - END ************************ */
	
	
	/* *************************D2D screens-START ******************************* */
		
	
	/* ************************* Sign in screen - START ******************************* */	
	
	//@AndroidFindBy(xpath="//android.widget.EditText[@text='Email or phone' and @resource-id='identifierId']")
	//public WebElement UserID;	
	
	//@AndroidFindBy(xpath="//android.widget.Button[@text='Forgot email?']")
	//public WebElement ForgotEMail;
	
	//@AndroidFindBy(xpath="//android.widget.Button[@text='Create account']")
	//public WebElement CreateAccount;
	
	//@AndroidFindBy(xpath="//android.widget.Button[@resource-id='identifierNext']")
	//public WebElement SignIn_Next;
	
	//@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter your password']")
	//public WebElement Password;	
	
	//@AndroidFindBy(xpath="//android.widget.Button[@resource-id='passwordNext']")
	//public WebElement Password_Next;
	
	/* ************************* Sign in screen -END ******************************* */		

	/* ************************* Google Services - Start ******************************* */		
	// More or Accept button
	//@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.gms.policy_sidecar_aps:id/next_button']")
	//public WebElement GoogleServices_Next;
	
	/* ************************* Google Services - End ******************************* */		
	
	
}
