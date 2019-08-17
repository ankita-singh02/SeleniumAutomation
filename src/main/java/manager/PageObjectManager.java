package manager;

import org.openqa.selenium.WebDriver;

import pageobjects.ApprovalQueuesPage;
import pageobjects.BrowsePage;
import pageobjects.BulkEmailPage;
import pageobjects.ClusterNavBar;
import pageobjects.DiscussionPage;
import pageobjects.EventsPage;
import pageobjects.HomePage;
import pageobjects.HubNavBar;
import pageobjects.InboxPage;
import pageobjects.JoinAdditionalHubPage;
import pageobjects.LandingPage;
import pageobjects.ProfilePage;
import pageobjects.SiteAdminPage;
import pageobjects_signup.ALUMNI_ADVICE;
import pageobjects_signup.BASIC_INFO;
import pageobjects_signup.BASIC_INFO_ALT;
import pageobjects_signup.CALENDAR_SYNC;
import pageobjects_signup.CUSTOM_FIELDS;
import pageobjects_signup.HOW_CAN_I_HELP;
import pageobjects_signup.HUB_SELECT;
import pageobjects_signup.IS_ANONYMOUS;
import pageobjects_signup.SELECT_SCHOOL;
import pageobjects_signup.SELECT_TYPE;
import pageobjects_signup.SIGN_AGREEMENT;
import pageobjects_signup.SMS_NOTIFICATIONS;
import pageobjects_signup.USER_GROUPS;
import pageobjects_signup.USER_PROGRAMS;
import pageobjects_signup.WORK_HISTORY;
import utils.GenericPage;

public class PageObjectManager {
	
	private WebDriver driver;
	

	public PageObjectManager(WebDriver driver) {
		 
		this.driver = driver;
 
	}
	
	private LandingPage landingPage;
	public LandingPage getLandingPage() {
		return (landingPage == null) ? landingPage = new LandingPage(driver) : landingPage;
	}
	
	private ClusterNavBar clusterNavBar;
	public ClusterNavBar getClusterNavBar() {
		return (clusterNavBar == null) ? clusterNavBar = new ClusterNavBar(driver) : clusterNavBar;
	}
	
	private BulkEmailPage bulkEmailPage;
	public BulkEmailPage getBulkEmailPage() {
		return (bulkEmailPage == null) ? bulkEmailPage = new BulkEmailPage(driver) : bulkEmailPage;
	}
	
	private SiteAdminPage siteAdminPage;
	public SiteAdminPage getSiteAdminPage() {
		return (siteAdminPage == null) ? siteAdminPage = new SiteAdminPage(driver) : siteAdminPage;
	}
	private GenericPage gsm;
	public GenericPage getGenericPage() {

		return (gsm == null) ? gsm = new GenericPage(driver) : gsm;

	}
	private HubNavBar hubnavbar;
	public HubNavBar getHubNavBar() {
		return (hubnavbar == null) ? hubnavbar = new HubNavBar(driver) : hubnavbar;
	}
	
	private EventsPage eventpage;
	public EventsPage getEventPage() {
	return (eventpage == null) ? eventpage = new EventsPage(driver) : eventpage;
	
	}
	private HUB_SELECT hubSelectPage;
	public HUB_SELECT getHUB_SELECT() {
		return (hubSelectPage == null) ? hubSelectPage = new HUB_SELECT(driver) : hubSelectPage;
	}
	
	private SELECT_TYPE selectTypePage;
	public SELECT_TYPE getSELECT_TYPE() {
		return (selectTypePage == null) ? selectTypePage = new SELECT_TYPE(driver) : selectTypePage;

	}
	
	private BASIC_INFO basicInfoPage;
	public BASIC_INFO getBASIC_INFO() {
		return (basicInfoPage == null) ? basicInfoPage = new BASIC_INFO(driver) : basicInfoPage;

	}
	
	private BASIC_INFO_ALT basicInfoAltPage;
	public BASIC_INFO_ALT getBASIC_INFO_ALT() {
		return (basicInfoAltPage == null) ? basicInfoAltPage = new BASIC_INFO_ALT(driver) : basicInfoAltPage;

	}
	private SELECT_SCHOOL selectSchoolPage;
	public SELECT_SCHOOL getSELECT_SCHOOL() {
		return (selectSchoolPage == null) ? selectSchoolPage = new SELECT_SCHOOL(driver) : selectSchoolPage;

	}
	
	private CALENDAR_SYNC calendarSyncPage;
	public CALENDAR_SYNC getCALENDAR_SYNC() {
		return (calendarSyncPage == null) ? calendarSyncPage = new CALENDAR_SYNC(driver) : calendarSyncPage;

	}
	private HOW_CAN_I_HELP howCanIHelpPage;
	public HOW_CAN_I_HELP getHOW_CAN_I_HELP() {
		return (howCanIHelpPage == null) ? howCanIHelpPage = new HOW_CAN_I_HELP(driver) : howCanIHelpPage;

	}
	private USER_PROGRAMS userProgramsPage;
	public USER_PROGRAMS getUSER_PROGRAMS() {
		return (userProgramsPage == null) ? userProgramsPage = new USER_PROGRAMS(driver) : userProgramsPage;

	}
	private SMS_NOTIFICATIONS smsNotifPage;
	public SMS_NOTIFICATIONS getSMS_NOTIFICATIONS() {
		return (smsNotifPage == null) ? smsNotifPage = new SMS_NOTIFICATIONS(driver) : smsNotifPage;

	}
	private USER_GROUPS getUserGroupsPage;
	public USER_GROUPS getUSER_GROUPS() {
		return (getUserGroupsPage == null) ? getUserGroupsPage = new USER_GROUPS(driver) : getUserGroupsPage;

	}
	private ALUMNI_ADVICE getAlumniAdvicePage;
	public ALUMNI_ADVICE getALUMNI_ADVICE() {
		return (getAlumniAdvicePage == null) ? getAlumniAdvicePage = new ALUMNI_ADVICE(driver) : getAlumniAdvicePage;

	}
	private CUSTOM_FIELDS getCustomFieldsPage;
	public CUSTOM_FIELDS getCUSTOM_FIELDS() {
		return (getCustomFieldsPage == null) ? getCustomFieldsPage = new CUSTOM_FIELDS(driver) : getCustomFieldsPage;

	}
	private IS_ANONYMOUS isAnonPage;
	public IS_ANONYMOUS getIS_ANONYMOUS() {
		return (isAnonPage == null) ? isAnonPage = new IS_ANONYMOUS(driver) : isAnonPage;

	}
	private SIGN_AGREEMENT signAgreementPage;
	public SIGN_AGREEMENT getSIGN_AGREEMENT() {
		return (signAgreementPage == null) ? signAgreementPage = new SIGN_AGREEMENT(driver) : signAgreementPage;

	}
	private ApprovalQueuesPage approvalPage;
	public ApprovalQueuesPage getApprovalPage() {
		return (approvalPage == null) ? approvalPage = new ApprovalQueuesPage(driver) : approvalPage;

	}
	
	private BrowsePage browsePage;
	public BrowsePage getBrowsePage() {
		return (browsePage == null) ? browsePage = new BrowsePage(driver) : browsePage;

	}
	private HomePage homePage;
	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;

	}
	
	private ProfilePage profilePage;
	public ProfilePage getProfilePage() {
		return (profilePage == null) ? profilePage = new ProfilePage(driver) : profilePage;

	}
	
	private InboxPage inboxPage;
	public InboxPage getInboxPage() {
		return (inboxPage == null) ? inboxPage = new InboxPage(driver) : inboxPage;

	}
	private DiscussionPage discussionPage;
	public DiscussionPage getDiscussionPage() {
		return (discussionPage == null) ? discussionPage = new DiscussionPage(driver) : discussionPage;

	}
	
	private WORK_HISTORY workHistoryPage;
	public WORK_HISTORY getWORK_HISTORY() {
		return (workHistoryPage == null) ? workHistoryPage = new WORK_HISTORY(driver) : workHistoryPage;
	}
	
	private JoinAdditionalHubPage joinAdditionalHubPage;
	public JoinAdditionalHubPage getJoinAdditionalHubPage() {
		return (joinAdditionalHubPage == null) ? joinAdditionalHubPage = new JoinAdditionalHubPage(driver) : joinAdditionalHubPage;

	} 
	
	
	
	
	
}
