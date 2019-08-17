package pageobjects;

import java.util.HashMap;

public class Map_Elements {
	
	public static String elementMap(String xpath_name, String page_key ) {
		HashMap<String, HashMap<String, String >> outerMap= new HashMap<String, HashMap<String, String >>();
		HashMap<String, String> bulkEmailPageElements =new HashMap<String, String>() ;
		HashMap<String, String> eventPageElements =new HashMap<String, String>() ;
		outerMap.put("BulkEmailPage", bulkEmailPageElements);

		bulkEmailPageElements.put("buttonNEWMESSAGE","//button[@data-qa='createNewMessage-button']");
		bulkEmailPageElements.put("buttonUSECLASSICEMAILEDITOR", "//button[@data-qa='classicEditor-button']");
		bulkEmailPageElements.put("buttonSELECTRECIPIENTS", ".//button[@data-qa='selectRecipients-button']/span");
		bulkEmailPageElements.put("buttonCONFIRM", "//button/span[contains(text(),'Confirm')]");
		bulkEmailPageElements.put("radioSPECIFICINDIVIDUALS", "//md-radio-button[@data-qa='individuals-radio-button']");
		bulkEmailPageElements.put("checkboxFIRSTUSER", "//td/md-checkbox");
		bulkEmailPageElements.put("buttonSELECTUSERS", "//button[@data-qa='selectUsers-button']");
		bulkEmailPageElements.put("buttonSENDNOW", "//button[@data-qa='sendNow-button']/span");
		
		bulkEmailPageElements.put("overlayCHOOSEEDITOR", "//div[@data-qa='chooseEditor-overlay']/p");
		bulkEmailPageElements.put("overlaySELECTRECIPIENTS", "//div[@class='new-content-container']");
		bulkEmailPageElements.put("modalEMAILCONFIRMATION", "//h4[text()='Email Confirmation']");
		bulkEmailPageElements.put("tableEXPLOREUSERS", "//div[@id='user-data-table']");
		bulkEmailPageElements.put("linkCLICKTOUPDATE", "//a[contains(text(),'(click to update)')]");
		
		outerMap.put("EventPage", eventPageElements);
		eventPageElements.put("buttonCREATEEVENT", "//button[@data-qa='createEvent-button']/span");
		eventPageElements.put("buttonCREATEEVENTONMODAL", "//button[@data-qa='createEventModal-button']");
		eventPageElements.put("toggleDONOTSENDREMINDER", "//md-switch[@data-qa='reminderEmail-switch']");
		eventPageElements.put("buttonSUBMIT", "//button[@data-qa='submitEvent-button']");
		eventPageElements.put("buttonOK", "//button[@aria-label='OK']/span");
		eventPageElements.put("modalEVENTTYPE", "//h3[text()='Select Event Type']");
		eventPageElements.put("formCREATEEVENT", "//div[@class='create-event-container']");
		eventPageElements.put("modalEVENTCREATED", "//h4[text()='Event Created']");
		
		eventPageElements.put("inputHEADLINE","//input[@data-qa='eventHeadline-input']");
		eventPageElements.put("inputEVENTDESCRIPTION","//span[text()='Describe the question in more detail']");
		eventPageElements.put("LOCATIONTEXT","//input[@data-qa='locationHeader-input']");

		
		return outerMap.get(page_key).get(xpath_name);
		
	}

}
