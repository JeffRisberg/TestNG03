package com.pageobjects.aisera;

import com.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AdminUIDataSourcesPage extends BasePage {

  // Page URL
  private static String PAGE_URL = "https://store.google.com/US";

  public AdminUIDataSourcesPage(WebDriver driver) {
    super(driver);

    assertCurrentUrl(PAGE_URL);

    PageFactory.initElements(driver, this);
  }
}
