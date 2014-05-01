package com.selenium.examples.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Page {
  
  @FindBy(how = How.ID, id = "login_field")
  private WebElement usernameField;

  @FindBy(how = How.ID, id = "password")
  private WebElement passwordField;

  @FindBy(how = How.NAME, name = "commit")
  private WebElement signInButton;

  public LoginPage(WebDriver webDriver) {
    super(webDriver);
  }

  public String getTitile() {
    return webDriver.getTitle();
  }

  public HomePage login(String userName, String password) {
    usernameField.sendKeys(userName);
    passwordField.sendKeys(password);
    signInButton.click();
    return new HomePage(webDriver);
  }


}
