package com.pageobjects.aisera;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.framework.core.BasePage;
import org.openqa.selenium.*;

public class AdminUIHomePage extends BasePage {

  // @FindBy(how = How.XPATH, using =
  // "//div[contains(@class,'pull-right')]//span[contains(@class,'icon-setting')]")
  private final WebElement configMenuButton;

  // @FindBy(how = How.XPATH, using =
  // "//div[contains(@class,'pull-right')]//span[contains(@class,'icon-profile')]")
  private final WebElement userMenuButton;

  public AdminUIHomePage(WebDriver driver) {
    super(driver);

    assertTrue(loadProperties("aisera/uiHomePage"), "cannot load properties");

    String pageUrl = properties.getProperty("UIHOME_URL");

    //assertCurrentUrl(pageUrl);

    threadSleep(500);

    String configMenuLocator = properties.getProperty("UIHOME_CONFIG_MENU_XPATH");
    configMenuButton = getElement(driver, By.xpath(configMenuLocator), 30);
    assertNotNull(configMenuButton, "cannot find config menu");

    String userMenuLocator = properties.getProperty("UIHOME_USER_MENU_XPATH");
    userMenuButton = getElement(driver, By.xpath(userMenuLocator), 30);
    assertNotNull(userMenuButton, "cannot find user menu");
  }

  public void toggleConfigMenu() {
    highlightElement(getDriver(), configMenuButton, HIGHLIGHT_DURATION);
    configMenuButton.click();

    threadSleep(500);

    configMenuButton.click();
  }

  public void toggleUserMenu() {
    highlightElement(getDriver(), userMenuButton, HIGHLIGHT_DURATION);
    userMenuButton.click();

    threadSleep(500);

    userMenuButton.click();
  }

  public AdminUIAiseraAppsPage navToAiseraAppsPage() {
    highlightElement(getDriver(), configMenuButton, HIGHLIGHT_DURATION);
    configMenuButton.click();

    String aiseraAppsButtonLocator = properties.getProperty("UIHOME_CONFIG_AISERA_APPS_XPATH");
    WebElement aiseraAppsButton = getElement(getDriver(), By.xpath(aiseraAppsButtonLocator),10);

    assertNotNull(aiseraAppsButton);

    highlightElement(getDriver(), aiseraAppsButton, HIGHLIGHT_DURATION);
    aiseraAppsButton.click();

    int timeoutSec = 10;
    waitForLoad(driver, timeoutSec);

    return new AdminUIAiseraAppsPage(getDriver());
  }

  public AdminUIDataSourcesPage navToDataSourcesPage() {
    highlightElement(getDriver(), configMenuButton, HIGHLIGHT_DURATION);
    configMenuButton.click();

    String dataSourcesButtonLocator = properties.getProperty("UIHOME_CONFIG_DATA_SOURCES_XPATH");
    WebElement dataSourcesButton = getElement(getDriver(), By.xpath(dataSourcesButtonLocator),10);

    assertNotNull(dataSourcesButton);

    highlightElement(getDriver(), dataSourcesButton, HIGHLIGHT_DURATION);
    dataSourcesButton.click();

    int timeoutSec = 10;
    waitForLoad(driver, timeoutSec);

    return new AdminUIDataSourcesPage(getDriver());
  }
}
