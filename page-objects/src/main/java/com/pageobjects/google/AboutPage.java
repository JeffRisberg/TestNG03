package com.pageobjects.google;

import static org.testng.Assert.assertTrue;

import com.framework.core.BasePage;
import org.openqa.selenium.WebDriver;

public class AboutPage extends BasePage {

  public AboutPage(WebDriver driver) {
    super(driver);

    assertTrue(loadProperties("google/aboutPage"));

    String pageUrl = properties.getProperty("ABOUT_URL");

    assertCurrentUrl(pageUrl);
  }
}
