package com.qa.testpages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.pages.HomePage;

public class HotelPageTest extends BaseTest {

    @Test
    public void testHotelSearch() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.searchHotel("Goa");

        String title = driver.getTitle();
        System.out.println(title);
       // Assert.assertTrue(title.contains("Hotels"), "Hotel search failed!");
    }
}