package com.qa.testpages;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.basetest.BaseTest;
import com.qa.pages.FlightItinerary;
import com.qa.pages.FlightResults;
import com.qa.pages.HomePage;

public class FlightsPageTest extends BaseTest {

	@Test
	public void testFlightSearch() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		FlightResults flightRslt = new FlightResults(driver);

		// Search for a one way flight in the clear trip flight search home page
		homePage.searchFlight("Bangalore", "kolkata");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Cleartrip"), "Flight search failed!");

		// Click on the first book button that is available in the Flight Results page
		flightRslt.bookFlight();
		flightRslt.selectFare();
	}

}