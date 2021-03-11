package com.pageobjects.google;

import com.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AboutPage extends BasePage {

  // Page URL
  private static String PAGE_URL = "https://about.google";

  public AboutPage(WebDriver driver) {
    super(driver);

    assertCurrentUrl(PAGE_URL);

    PageFactory.initElements(driver, this);
  }
}
