package com.qa.utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.basepage.BasePage;

public class Utils extends BasePage {

	public Utils(WebDriver driver) {
		super(driver);
	}

	public void waitForNewWindowAndSwitch( ) {
		
		String parentWin = driver.getWindowHandle();
		Set<String> winHandles = driver.getWindowHandles();
		
		Iterator<String> itr = winHandles.iterator();
		while(itr.hasNext()){
			String childWin = itr.next();
			if(!parentWin.equals(childWin)) {
				driver.switchTo().window(childWin);
			}
		}
	}

	public void closeNewWindowAndSwitchBack() {
		driver.close(); // Close the new window
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			break; // Switch back to the main window
		}
	}
	
	public String validateText(WebElement wel) {
		String text = wel.getText();
		return text;
	}

}
