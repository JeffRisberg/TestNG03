package com.pageobjects.aisera;

import com.framework.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertNotNull;

public class AdminUIHomePage extends BasePage {

  // Page URL
  private static String PAGE_URL = "https://login.demo9.aws-001-us-west-2.aisera.cloud/?system";

  @FindBy(how = How.XPATH, using = "//div[contains(@class,'pull-right')]//span[contains(@class,'icon-setting')]")
  private WebElement configMenuButton;

  @FindBy(how = How.XPATH, using = "//div[contains(@class,'pull-right')]//span[contains(@class,'icon-profile')]")
  private WebElement userMenuButton;

  public AdminUIHomePage(WebDriver driver) {
    super(driver);

    //assertCurrentUrl(PAGE_URL);

    threadSleep(500);

    PageFactory.initElements(driver, this);

    assertNotNull(configMenuButton);
    assertNotNull(userMenuButton);
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

  public AdminUIDataSourcesPage navToDataSourcesPage() {
    highlightElement(getDriver(), configMenuButton, HIGHLIGHT_DURATION);
    configMenuButton.click();

    WebElement dataSourcesButton = getElement(getDriver(), By.xpath("//div[@class='popover-content']//div[contains(text(),'Data Sources')]"), 10);

    assertNotNull(dataSourcesButton);

    highlightElement(getDriver(), dataSourcesButton, HIGHLIGHT_DURATION);
    dataSourcesButton.click();

    int timeoutSec = 10;
    waitForLoad(driver, timeoutSec);

    return new AdminUIDataSourcesPage(getDriver());
  }
}
