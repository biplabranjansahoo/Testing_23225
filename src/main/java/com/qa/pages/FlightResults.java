package com.qa.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.basepage.BasePage;
import com.qa.utils.ExplicitWaitUtils;
import com.qa.utils.Highlighter;
import com.qa.utils.Utils;

public class FlightResults extends BasePage {

	private ExplicitWaitUtils waitUtils;
	private Highlighter highlighter;
	private Utils utils;

	@FindBy(xpath = "//button[text()='Book']")
	private List<WebElement> bookButton;

	@FindBy(xpath = "//h2[text()='Review your itinerary']")
	private WebElement reviewitinery;

	@FindBy(xpath = "//h3[text()='Standard fare")
	private WebElement selectFare;

	@FindBy(xpath = "//h3[text()='Continue']")
	private WebElement FareContinue;

	public FlightResults(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.waitUtils = new ExplicitWaitUtils(driver, 10);
		highlighter = new Highlighter(driver);
		this.utils = new Utils(driver);
	}

	public void bookFlight() throws InterruptedException {
		highlighter.highlightElement(bookButton.get(0));
		waitUtils.waitForClickability(bookButton.get(0)).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		utils.waitForNewWindowAndSwitch();
	}

	public void selectFare() {
		try {
			waitUtils.waitForClickability(selectFare).click();
			waitUtils.waitForClickability(FareContinue).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}