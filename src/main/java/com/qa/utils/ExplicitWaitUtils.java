package com.qa.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitUtils {

	private WebDriver driver;
	private WebDriverWait wait;

	// Constructor that initializes WebDriver and WebDriverWait
	public ExplicitWaitUtils(WebDriver driver, int timeoutInSeconds) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)); // Timeout for 10 seconds
	}

	// Method to wait for an element to be visible
	public WebElement waitForVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Method to wait for an element to be clickable
	public WebElement waitForClickability(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	// Method to wait for presence of an element in the DOM
	public WebElement waitForPresence(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// Method to wait for text to be present in an element
	public boolean waitForTextToBePresent(WebElement element, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	// Method to wait for an alert to be present
	public boolean waitForAlert() {
		return wait.until(ExpectedConditions.alertIsPresent()) != null;
	}

	// Method to wait for the element to be invisible
	public boolean waitForInvisibility(WebElement element) {
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}
    public void waitForWindow() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }
}
