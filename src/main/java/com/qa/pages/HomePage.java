package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.basepage.BasePage;
import com.qa.utils.ExplicitWaitUtils;
import com.qa.utils.Highlighter;

public class HomePage extends BasePage {

	private ExplicitWaitUtils waitUtils;
	private Highlighter highlighter;

	@FindBy(xpath = "//input[@placeholder ='Where from?']")
	private WebElement fromCity;

	@FindBy(xpath = "//div[input[@placeholder ='Where from?']]//following-sibling::div/ul[1]")
	private WebElement selectFromCity;

	@FindBy(xpath = "//input[@placeholder ='Where to?']")
	private WebElement toCity;

	@FindBy(xpath = "//div[input[@placeholder ='Where to?']]//following-sibling::div/ul[4]")
	private WebElement selectToCity;

	@FindBy(xpath = "//span[text()='1 Adult, Economy']")
	private WebElement passengerSelection;

	@FindBy(xpath = "//div[1]/div/div/div/div[2]/button[2]")
	private WebElement clickAdults;

	@FindBy(xpath = "//span[text()='2 Adults, Economy']")
	private WebElement economy;

	@FindBy(xpath = "//div[div[div[input[@placeholder='Where from?']]]]/following-sibling::div[2]/div[1]/div/div/div[1]")
	private WebElement departDate;

	@FindBy(xpath = "//div[2]/div[3]/div[3]/div[4]/div/div[text()='13']")
	private WebElement selectDeparturedate;

	@FindBy(xpath = "//h4[text()='Search flights']")
	private WebElement searchButton;

	@FindBy(xpath = "//div/main/div/div/div[2]/div[2]/div[8]/div/div[1]/div[1]/div/div[2]/div[1]/div/span/div/span[text()='Flight details']")
	private WebElement flightdetails;

	@FindBy(xpath = "//p[text()='Hotels']")
	private WebElement hotel;

	@FindBy(xpath = "//label[p[contains(text(),'Enter locality')]]/following-sibling::input")
	private WebElement hotelCity;

	@FindBy(xpath = "//div[@id='modify_search_list_container_id']/li[1]/div[2]")
	private WebElement enterHotelCity;

	@FindBy(xpath = "//div[@id='modify_search_list_container_id']/li[1]/div[2]/div[1]/p")
	private WebElement selectHotelCity;

	@FindBy(xpath = "//h4[text()='Search hotels']")
	private WebElement searchHotleButton;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.waitUtils = new ExplicitWaitUtils(driver, 10);
		 highlighter = new Highlighter(driver);
	}

	public void searchFlight(String from, String to) throws InterruptedException {
		driver.navigate().refresh();
		highlighter.highlightElement(fromCity);
		waitUtils.waitForVisibility(fromCity).sendKeys(from);
		waitUtils.waitForClickability(selectFromCity).click();
		waitUtils.waitForVisibility(toCity).click();
		waitUtils.waitForVisibility(toCity).sendKeys(to);
		waitUtils.waitForClickability(selectToCity).click();
		waitUtils.waitForClickability(passengerSelection).click();
		waitUtils.waitForClickability(clickAdults).click();
		waitUtils.waitForClickability(economy).click();
		waitUtils.waitForClickability(departDate).click();
		waitUtils.waitForClickability(selectDeparturedate).click();
		waitUtils.waitForClickability(searchButton).click();
		
	}

	public void searchHotel(String city) throws InterruptedException {

		driver.navigate().refresh();
		waitUtils.waitForClickability(hotel).click();
		waitUtils.waitForVisibility(hotelCity).sendKeys(city);
		waitUtils.waitForClickability(selectHotelCity).click();
		waitUtils.waitForClickability(searchHotleButton).click();
		
	}

}
