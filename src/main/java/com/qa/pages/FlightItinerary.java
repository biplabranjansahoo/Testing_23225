package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.basepage.BasePage;
import com.qa.utils.ExplicitWaitUtils;
import com.qa.utils.Utils;

public class FlightItinerary extends BasePage{

	private ExplicitWaitUtils waitUtils;
	private Utils utils;
	
	@FindBy(xpath = "//h3[text()='Standard fare']")
	private WebElement standardFare;
	
	@FindBy(xpath = "//h4[text()='Continue']")
	private WebElement itrContinue;
	
	@FindBy(xpath="//div[contains(@style,'rgb(71, 29, 54); c') or contains(@style,'rgb(92, 133, 214); c')]")
	private List<WebElement> selectSeat;
	
	public FlightItinerary(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.waitUtils = new ExplicitWaitUtils(driver, 10);
		this.utils = new Utils(driver);
	}

	public void itineraryContinue() {
		// Wait for new window to appear
		utils.waitForNewWindowAndSwitch();
		//Click on Continue button of flight itinerary
		waitUtils.waitForClickability(itrContinue).click();
	}
	
	public void selectAvailableSeat() {
		
		if(selectSeat.size()>2) {
			selectSeat.get(0).click();
			selectSeat.get(1).click();
		}

	}


}
