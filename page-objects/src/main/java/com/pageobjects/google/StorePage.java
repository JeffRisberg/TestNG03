package com.pageobjects.google;

import static org.testng.Assert.assertTrue;

import com.framework.core.BasePage;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

  public StorePage(WebDriver driver) {
    super(driver);

    assertTrue(loadProperties("google/storePage"));

    String pageUrl = properties.getProperty("STORE_URL");

    assertCurrentUrl(pageUrl);
  }
}
