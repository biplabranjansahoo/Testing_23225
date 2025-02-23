package com.qa.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlighter {

	WebDriver driver;

	public Highlighter(WebDriver driver) {
		this.driver = driver;
	}

	public void highlightElement(WebElement element) {
		// Store the original background color of the element
		String originalStyle = element.getAttribute("style");

		// Use JavaScript to highlight the element by changing its style
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
				"border: 2px solid red; background-color: yellow;");

		// Optional: Wait for 1 second to visually highlight the element
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Restore the original style of the element
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
	}
}
