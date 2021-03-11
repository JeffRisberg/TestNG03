package com.pageobjects.google;

import static org.testng.Assert.assertNotNull;

import com.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

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
    threadSleep(500);

    PageFactory.initElements(driver, this);

    assertNotNull(aboutButton);
    assertNotNull(storeButton);
  }

  public AboutPage clickAboutButton() throws Exception {
    highlightElement(getDriver(), aboutButton, HIGHLIGHT_DURATION);

    aboutButton.click();
    return new AboutPage(getDriver());
  }

  public StorePage clickStoreButton() {
    highlightElement(getDriver(), storeButton, HIGHLIGHT_DURATION);

    storeButton.click();
    return new StorePage(getDriver());
  }
}
