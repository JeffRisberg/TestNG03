package com.pageobjects.aisera;

import static org.testng.Assert.assertNotNull;

import com.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class AdminUIDataSourcesPage extends BasePage {

  // Page URL
  private static String PAGE_URL = "https://login.demo9.aws-001-us-west-2.aisera.cloud/?system";

  @FindBy(how = How.XPATH, using = "//div[contains(text(),'Ticketing Systems')]")
  private WebElement ticketingSystems;

  public AdminUIDataSourcesPage(WebDriver driver) {
    super(driver);

    //assertCurrentUrl(PAGE_URL);

    threadSleep(500);

    PageFactory.initElements(driver, this);

    assertNotNull(ticketingSystems);

    highlightElement(getDriver(), ticketingSystems, HIGHLIGHT_DURATION);
  }
}
