package com.pageobjects.google;

import com.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

  // Page URL
  private static String PAGE_URL = "https://www.google.com";

  @FindBy(how = How.LINK_TEXT, using = "About")
  private WebElement aboutButton;

  @FindBy(how = How.LINK_TEXT, using = "Store")
  private WebElement storeButton;

  public HomePage(WebDriver driver) {
    super(driver);

    driver.get(PAGE_URL);
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }

    PageFactory.initElements(driver, this);
  }

  public AboutPage clickAboutButton() {
    aboutButton.click();
    return new AboutPage(getDriver());
  }

  public StorePage clickStoreButton() {
    storeButton.click();
    return new StorePage(getDriver());
  }
}
