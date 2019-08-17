package pageobjects;

public class ClusterNavBar_Elements {
	public static final String XPATH="xpath";
	
	public static final String dropdownPROFILE="//li[contains(@class,'dropdown profile')]/a/i";
	public static final String optionMYPROFILE="//a[@class='profile-pic-dropdown dropdown-toggle']/i[@class='caret']";
	public static final String optionMYDOCS="//li[contains(@class,'dropdown profile')]/ul/li/a[contains(text(),'My Documents')]";
	public static final String optionMYJOBPOSTS="//li[contains(@class,'dropdown profile')]/ul/li/a[contains(text(),'My Job Posts')]";
	public static final String optionMYEVENTS="//li[contains(@class,'dropdown profile')]/ul/li/a[contains(text(),'My Events')]";
	public static final String optionMYLISTS="//li[contains(@class,'dropdown profile')]/ul/li/a[contains(text(),'My Lists')]";
	public static final String optionMYPREFERENCES="//li[contains(@class,'dropdown profile')]/ul/li/a[contains(text(),'My Preferences')]";
	public static final String optionSIGNOUT="//li[contains(@class,'dropdown profile')]/ul/li/a[contains(text(),'Sign Out')]";

	public static final String dropdownADMIN = "//a[@title='Admin']";
	public static final String optionHUBADMIN ="//a[contains(text(),'Hub Admin') and @class='large-pad']";

	public static final String optionAPPROVALQUEUES = "//a[contains(text(),'Approval Queues')]";
	

}
