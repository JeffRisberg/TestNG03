package com.pageobjects.aisera;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.framework.core.BasePage;
import org.openqa.selenium.*;

public class AdminUIDataSourcesPage extends BasePage {

  private WebElement ticketingSystems;

  public AdminUIDataSourcesPage(WebDriver driver) {
    super(driver);

    assertTrue(loadProperties("aisera/uiDataSourcesPage"), "cannot load properties");

    String pageUrl = properties.getProperty("UIDATASOURCES_URL");

    //assertCurrentUrl(pageUrl);

    threadSleep(500);

    String emailTextLocator = properties.getProperty("UIDATASOURCES_TICKET_SYSTEMS_XPATH");
    ticketingSystems = getElement(driver, By.xpath(emailTextLocator), 30);
    assertNotNull(ticketingSystems, "cannot find Ticketing Systems text");

    highlightElement(getDriver(), ticketingSystems, HIGHLIGHT_DURATION);
  }
}
