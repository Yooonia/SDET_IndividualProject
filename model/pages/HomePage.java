package com.planittesting.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
  WebDriver driver;
  
  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public CalculatorPage clickCalculButton() {
    driver.findElement(By.id("button_369")).findElement(By.tagName("a")).click();
   // driver.findElement(By.className("button-container")).findElement(By.tagName("a")).click();
    //button-container clear-div left 
    return new CalculatorPage(driver);
  }

public LoginPage clickLoginButton() {
    driver.findElement(By.id("quick-login")).click();
    return new LoginPage(driver);
}

public CalculatorPage setPersonalData2() {
    return null;
}
}
