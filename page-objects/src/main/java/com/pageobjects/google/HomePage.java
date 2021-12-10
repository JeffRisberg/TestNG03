package com.pageobjects.google;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.framework.core.BasePage;
import org.openqa.selenium.*;

public class HomePage extends BasePage {

  private final WebElement aboutButton;
  private final WebElement storeButton;

  public HomePage(WebDriver driver) {
    super(driver);

    assertTrue(loadProperties("google/homePage"), "cannot load properties");

    String pageUrl = properties.getProperty("HOME_URL");

    driver.get(pageUrl);
    threadSleep(500);

    String aboutLinkLocator = properties.getProperty("HOME_ABOUT_LINK_XPATH");
    aboutButton = getElement(driver, By.xpath(aboutLinkLocator), 30);
    assertNotNull(aboutButton, "cannot find About link");

    String storeLinkLocator = properties.getProperty("HOME_STORE_LINK_XPATH");
    storeButton = getElement(driver, By.xpath(storeLinkLocator), 30);
    assertNotNull(storeButton, "cannot find Store link");
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
