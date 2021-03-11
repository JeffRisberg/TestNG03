package com.pageobjects.aisera;

import com.framework.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class WebchatPage extends BasePage {

  // Page URL
  private static String PAGE_URL = "https://static.aisera.com/demo9/acme-itsm/index.html";

  @FindBy(how = How.XPATH, using = "//div[@class='commands-container']//span[contains(@class,'chat-close')]")
  private WebElement closeButton;

  @FindBy(how = How.XPATH, using = "//div[@class='commands-container']//span[contains(@class,'flaticon-menu-dots')]")
  private WebElement menuButton;

  public WebchatPage(WebDriver driver) {
    super(driver);

    driver.get(PAGE_URL);
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }

    PageFactory.initElements(driver, this);

    assertNotNull(closeButton);
    assertNotNull(menuButton);
  }

  public void clickCloseButton() {
    closeButton.click();
  }

  public void clickMenuButton() {
    menuButton.click();
  }

  public void clickRefreshButton() {
    clickMenuButton();

    WebElement refreshButton = getDriver().findElement(By.xpath("//div[@class='commands-container']//span[@data-tooltip='Refresh']"));
    assertNotNull(refreshButton);

    refreshButton.click();
  }

  public void clickProfileButton() {
    clickMenuButton();

    WebElement refreshButton = getDriver().findElement(By.xpath("//div[@class='commands-container']//span[@data-tooltip='Refresh']"));
    assertNotNull(refreshButton);

    refreshButton.click();
  }

  public void changeUserName(String userName) {
    clickProfileButton();

    WebElement userNameText = getDriver().findElement(By.xpath("//div[@class='field-editor']//input"));
    assertNotNull(userNameText);

    userNameText.sendKeys(userName);

    WebElement continueButton = getDriver().findElement(By.xpath("//button[contains(@class,'continue-btn')]"));
    assertNotNull(continueButton);

    continueButton.click();
  }
}

