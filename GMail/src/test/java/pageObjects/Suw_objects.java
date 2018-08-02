package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Suw_objects {
	
	public Suw_objects(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/* **********Common objects in all - START ************************ */
	@AndroidFindBy(id="com.google.android.setupwizard:id/skip_button")
	public WebElement Skip;

	@AndroidFindBy(id="com.google.android.setupwizard:id/next_button")
	public WebElement Next;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='OK']")
	public WebElement Ok;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Cancel']")
	public WebElement Cancel;		
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.android.settings:id/suw_layout_title']")
	//@AndroidFindBy(id="com.android.settings:id/suw_layout_title")
	public WebElement ScreenTitle;	
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Continue']")
	public WebElement Continue;	
	
	
	/* **********Common objects in all - END ************************ */	
	
	
	/* **********Welcome screen objects - START ************************ */
	@AndroidFindBy(id="com.android.yadayada:id/ok_button")
	public WebElement BetaProgram_OK;
	
	@AndroidFindBy(id="com.google.android.setupwizard:id/language_picker")
	public WebElement LanguagePicker;
	
	@AndroidFindBy(id="com.google.android.setupwizard:id/welcome_accessibility")
	public WebElement VisionSettings;
	
	@AndroidFindBy(id="com.google.android.setupwizard:id/welcome_emergency_dial")
	public WebElement Emergency;
	
	//working
	@AndroidFindBy(id="com.google.android.setupwizard:id/start")
	public WebElement Start; 	
	/* **********Welcome screen objects - END ************************ */

	/* **********Wifi screen objects -START ************************ */
	//working
	@AndroidFindBy(id="com.google.android.setupwizard:id/network_see_all_wifi")
	public WebElement SeeAllWifiNetworks; 	
	
	//working
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3idiots-2.4']")
	public WebElement HomeWifi;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Manusaran']")
	public WebElement ManuWifi;
	
	//working
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.android.settings:id/password']")
	public WebElement WifiPassword;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Connect']")
	public WebElement Connect;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add new network']")
	public WebElement AddNetwork;
	/* **********Wifi screen objects - END ************************ */
	
	
	/* *************************D2D screens-START ******************************* */
	
	@AndroidFindBy(id="com.google.android.apps.pixelmigrate:id/animated_title")
	public WebElement D2D_screen1Title; 
	
	@AndroidFindBy(id="com.google.android.apps.pixelmigrate:id/fragment_usb_next_button")
	public WebElement D2DNext; // need to check 
	
	//@AndroidFindBy(xpath="//android.widget.Button[@text='Don't copy']")
	@AndroidFindBy(id="android:id/button1")	
	public WebElement DontCopy_Confirm;
	
	// for all: Can't use old phone, No cable, Cable doesn’t fit? and No adapter? buttons 
	@AndroidFindBy(id="com.google.android.apps.pixelmigrate:id/fragment_usb_other_ways_button")
	public WebElement CopyOtherWays; // need to check 
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Don't copy data']")	
	public WebElement DontCopy;

	@AndroidFindBy(xpath="//android.widget.Button[@text='No cable?']")
	public WebElement NoCable;
	
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Cable doesn't fit']")
	public WebElement CableDoesNotFit;

	@AndroidFindBy(xpath="//android.widget.Button[@text='No adapter?']")
	public WebElement NoAdapter;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[2]//android.widget.TextView[@text='A backup from an Android phone']")
	public WebElement SmartSetup;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[3]//android.widget.TextView[@text='A backup from the cloud']")
	public WebElement BackupFromCloud;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[4]//android.widget.TextView[@text='An iPhone® device']")
	public WebElement BackupFromiPhone;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.apps.pixelmigrate:id/next_button']")
	public WebElement PixelMigrate_Next;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.apps.pixelmigrate:id/primary_button']")
	public WebElement PixelMigrate_SecurityConfirm;	
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.apps.pixelmigrate:id/start_transfer']")
	public WebElement Restore;	
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.apps.pixelmigrate:id/dont_restore_button']")
	public WebElement DontRestore;	
	
	/* *************************D2D screens-END ******************************* */	
	
	/* ************************* Sign in screen - START ******************************* */	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='learnMore']")
	public WebElement LearnMore;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='identifierId']")
	public WebElement UserID;	
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Forgot email?']")
	public WebElement ForgotEMail;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Create account']")
	public WebElement CreateAccount;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='identifierNext']")
	public WebElement SignIn_Next;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Show password']")
	public WebElement ShowPassword;
	
	//@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter your password']")
	@AndroidFindBy(xpath="//android.widget.EditText")
	public WebElement Password;	
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='passwordNext']")
	public WebElement Password_Next;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='forgotPassword']")
	public WebElement ForgotPassword;
	
	@AndroidFindBy(xpath="//android.view.View[@resource-id='tosLink']")
	public WebElement TosLink;	
	
	@AndroidFindBy(xpath="//android.view.View[@resource-id='privacyLink']")
	public WebElement PrivacyLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Don't add this account now']")
	public WebElement DontAddThisAccountNow;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='signinconsentNext']")
	public WebElement AddAccount_IAgree;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Verify it's you']")
	public WebElement Account_Verification;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Confirm your recovery email']")
	public WebElement ConfirmRecoveryEmail;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='knowledge-preregistered-email-response']")
	public WebElement RecoveryEmail_EditBox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='NEXT']")
	public WebElement NEXT;
	
	public String DecryptBackup = "To decrypt your backup, enter your old phone’s screen lock on the next screen";
	
	/* ************************* Sign in screen -END ******************************* */		

	/* ************************* Google Services - Start ******************************* */		
	// More or Accept button - SUW
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.gms.policy_sidecar_aps:id/next_button']")
	public WebElement GoogleServices_Next;	
	
	/* ************************* Google Services - End ******************************* */		

	/* ************************* Fingerprint and Security - Start ******************************* */		
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.settings:id/fingerprint_cancel_button']")
	public WebElement SkipFingerPrint;

	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.settings:id/fingerprint_next_button']")
	public WebElement FingerPrint_Next;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.android.settings:id/password_entry']")
	public WebElement PIN_Password;	
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.settings:id/screen_lock_options']")
	public WebElement ScreenLockOptions;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Password']")
	public WebElement ScreenLock_Password;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Pattern']")
	public WebElement ScreenLock_Pattern;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='PIN']")
	public WebElement ScreenLock_PIN;
	
	//Next or Confirm buttons
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.settings:id/next_button']")
	public WebElement Security_Next;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.settings:id/skip_button']")
	public WebElement Security_Skip;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.settings:id/clear_button']")
	public WebElement Security_Clear;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Skip anyway']")
	public WebElement FingerPrint_SkipAnyway;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Go back']")
	public WebElement GoBack;
	
	/* ************************* Fingerprint and Security - End ******************************* */

	/* ************************* Continue setup screen - Start ******************************* */
	// Continue button = SUW Next button
	// Leave & Get reminder = SUW Skip button	
	/* ************************* Continue setup screen - End ******************************* */
	
	/* ************************* Google Assistant screens - Start ******************************* */
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.googlequicksearchbox:id/opa_error_cancel_button']")
	public WebElement GoogleAssistant_Skip;

	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.googlequicksearchbox:id/opa_error_cancel_button']")
	public WebElement VoiceMatch_NoThanks;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.googlequicksearchbox:id/opa_error_action_button']")
	public WebElement GoogleAssistant_Next;

	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.googlequicksearchbox:id/opa_error_action_button']")
	public WebElement VoiceMatch_IAgree;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.gms:id/action_button_positive']")
	public WebElement GoogleAssistant_Permissions_TurnON;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.gms:id/action_button_negative']")
	public WebElement GoogleAssistant_Permissions_NoThanks;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.googlequicksearchbox:id/decline_button']")
	public WebElement VoiceTraning_Cancel;

	@AndroidFindBy(xpath="//android.widget.Switch[@resource-id='com.google.android.googlequicksearchbox:id/opa_error_switch']")
	public WebElement LetTheAssistantUseWhatsOnYourScreen_ToggleSwitch;
	
	/* ************************* Google Assistant screens - End ******************************* */
	
	/* ************************* Squeeze for Assistant screens - Start ******************************* */
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button2']")
	public WebElement Squeeze_Next;	
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.settings:id/cancel_button']")
	public WebElement Squeeze_DoItLater;
	
	@AndroidFindBy(xpath="//android.widget.SeekBar[@resource-id='com.android.settings:id/assist_gesture_sensitivity_seekbar']")
	public WebElement Squeeze_SeekBar;
	
	/* ************************* Squeeze for Assistant screens - End ******************************* */
	
	/* ************************* Google Pay screens - Start ******************************* */
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.gms:id/submit_button']")
	public WebElement GooglePay_AddACard;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.gms:id/skip_button']")
	public WebElement GooglePay_Skip;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Enter details manually']")
	public WebElement GooglePay_EnterDetailsManually;
	
	/* ************************* Google Pay screens - End ******************************* */
	
	/* ************************* Review additional apps - Start ******************************* */	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.vending:id/suw_pai_button' and @text='OK']")
	public WebElement ReviewAdditionalApps_OK;
	
	/* ************************* Review additional apps - End ******************************* */
	
	/* ************************* One last tip - Start ******************************* */
	
	@AndroidFindBy(xpath="//android.widget.Switch[@resource-id='com.google.android.setupwizard:id/pixel_email_switch']")
	public WebElement OneLastTip_Toggle;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.setupwizard:id/closing_next_button']")
	public WebElement OneLastTip_AllSet;
	
	/* ************************* One last tip - End ******************************* */
	
	
}
