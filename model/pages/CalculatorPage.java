package com.planittesting.model.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage {
    WebDriver driver;

    public CalculatorPage(WebDriver driver) {
      this.driver = driver;
    }

    public CalculatorPage setPeople() {
        driver.findElement(By.id("numberOfApplicants-0")).click();
        //as there is no input colum, but drop down option list to click
        //so instead of using sendkeys, we use click
        return this;
    }

    public CalculatorPage setDependants(String DependantsNumber) {
        driver.findElement(By.name("numberOfDependants"))
              .sendKeys(DependantsNumber);
        return this;
    }
    public CalculatorPage setPersonalData() {
        this.setPeople()
        .setDependants("4");
        return this;
    }

    // Error message
    public String getPeopleError() {
        var element = driver
        .findElement(By.id("numberOfApplicants-error"));
        //.findElement(By.tagName(("p")));
        return element.getText();
        // driver.findElement(By.linkText("Next")).click();
        // return getErrorText(By.id("numberOfApplicants-error").findElement(context));  // Error message id1
     }

     public String getDependantsError() {
        return getErrorText(By.id("xxxxid2"));  // id2
     }

    public String getErrorText(By selector) {
        var elements = driver.findElements(By.id("selector"));
        if (elements.isEmpty())
          return "";
        return elements.get(0).getText();    // return "Selection is required"
    }

    // Buttons
    public CalculatorPage clickNextButton() {
        // Buttonstyle__StyledButton-sc-1vu4swu-3 lnzwHO SubmitButton-iNSvsi cagusE
        // driver.findElement(By.className("Buttonstyle__StyledButton")).click();
        driver.findElement(By.xpath("//button[@data-testid='btn-next']")).click();
        // var elements = driver.findElements(By.tagName("button"));
        // driver.findElements(By.tagName("button")).get(2).click();
        return this;
    }

    public String getPercentageComplete() {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
        .until(d -> d.findElement(By.className("fyCjnC"))).getText();
    }

}
