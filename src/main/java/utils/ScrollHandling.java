package utils;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;

public class ScrollHandling {
	
	
	public static void scrollWindowIntoview(WebDriver driver, String sLocator, String locatorType)  {
		
		WebElement element;
		if (locatorType.equals("xpath")) {
			element = driver.findElement(By.xpath(sLocator));

		} else {
			element = driver.findElement(By.cssSelector(sLocator));
		}
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);	
			
	}
	public static void scrollWindowToElememtPoint(WebDriver driver, String sLocator, String locatorType) {
		
		WebElement element;
		if (locatorType.equals("xpath")) {
			element = driver.findElement(By.xpath(sLocator));

		} else {
			element = driver.findElement(By.cssSelector(sLocator));
		}
		Coordinates coordinate = ((Locatable)element).getCoordinates(); 
		coordinate.onPage(); 
		coordinate.inViewPort();
	}
	
		

	
	public static void scrollInElement(WebDriver driver, String sLocator) {
		
		((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('"+sLocator+"').scrollLeft += 250", "");
	}
	
	public static void scrollBottomOfWindow(WebDriver driver) {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
	}
	
	public static void scrollWindowSlowly(WebDriver driver,int x , int y) {
		
		for (int second = 0;; second++) {
		    if(second >=60){
		        break; 
		    }
		((JavascriptExecutor) driver).executeScript("window.scrollTo("+x+","+y+")"); 
		}
		//Horizontal: y=0, right: x, left: -x
		// vertical: x=0, right: y, left: -y
	}
	
	public static void scrollTopOfWindow(WebDriver driver) {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-document.body.scrollHeight || -document.documentElement.scrollHeight)", "");

	}
	

}

