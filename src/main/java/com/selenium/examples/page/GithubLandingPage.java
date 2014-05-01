package com.selenium.examples.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GithubLandingPage extends Page {

  private static final String url = "https://github.com/";

  @FindBy(how = How.LINK_TEXT, using = "Sign in")
  private WebElement signInButton;

  public GithubLandingPage(WebDriver webDriver) {
    super(webDriver, url);
  }

  public LoginPage goToLognInPage() {
    signInButton.click();
    return new LoginPage(webDriver);
  }



}
