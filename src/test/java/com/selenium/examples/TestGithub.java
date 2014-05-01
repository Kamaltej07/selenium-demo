package com.selenium.examples;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.examples.page.GithubLandingPage;
import com.selenium.examples.page.HomePage;
import com.selenium.examples.page.LoginPage;
import com.selenium.examples.page.Page;



public class TestGithub {

  private WebDriver webDriver;

  @BeforeMethod
  public void setup() {
    // webDriver = new FirefoxDriver();
    webDriver = new HtmlUnitDriver();
  }

  // @AfterMethod
  public void afterMethod() {
    if (null != webDriver)
      webDriver.close();
  }

  @AfterMethod
  // @AfterClass
  public void afterClass() {
    if (null != webDriver)
      webDriver.quit();
  }


  @Test
  public void landOnGithubHomePage() {

    Page homePage = new GithubLandingPage(webDriver);
    String title = homePage.getTitle();
    assertEquals(title, "GitHub · Build software better, together.");

  }

  @Test
  public void signInButtonTakesYouToLoginPage() {
    GithubLandingPage homePage = new GithubLandingPage(webDriver);
    LoginPage loginPage = homePage.goToLognInPage();
    assertEquals(loginPage.getTitile(), "Sign in · GitHub");
  }
  
  @Test
  public void loginToGitHub() {
    GithubLandingPage githubLandingPage = new GithubLandingPage(webDriver);
    LoginPage loginPage = githubLandingPage.goToLognInPage();
    HomePage homePage = loginPage.login("ssmita", "Qwerty!123");
  }

}
