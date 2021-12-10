package com.pageobjects.aisera;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.framework.core.BasePage;
import org.openqa.selenium.*;

public class AdminUIAiseraAppsPage extends BasePage {

  private final WebElement itsmForSNOWApp;

  public AdminUIAiseraAppsPage(WebDriver driver) {
    super(driver);

    assertTrue(loadProperties("aisera/uiAiseraAppsPage"), "cannot load properties");

    String pageUrl = properties.getProperty("UIAISERAPPS_URL");

    //assertCurrentUrl(pageUrl);

    threadSleep(500);

    String ticketSystemsLocatorLocator = properties.getProperty("UIAISERAAPPS_ITSM_FOR_SNOW_XPATH");
    itsmForSNOWApp = getElement(driver, By.xpath(ticketSystemsLocatorLocator), 30);
    assertNotNull(ticketSystemsLocatorLocator, "cannot find ITSM for SNOW app");

    highlightElement(getDriver(), itsmForSNOWApp, HIGHLIGHT_DURATION);
  }
}
