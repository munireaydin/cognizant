package com.cognizant.step_definitions;

import com.cognizant.pages.AutomotivePage;
import com.cognizant.pages.HomePage;
import com.cognizant.utilities.ConfigurationReader;
import com.cognizant.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CognizantStepDefs {

    @Given("User is on the Cognizant home page")
    public void user_is_on_the_cognizant_home_page() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    HomePage homePage = new HomePage();

    @Then("User should see the module names as listed")
    public void user_should_see_the_module_names_as_listed(List<String> expectedModuleNames) {


        List<String> actualModuleNames = new ArrayList<>();
        for (WebElement eachModule : homePage.moduleNames) {
            actualModuleNames.add(eachModule.getText());
        }

        Assert.assertEquals(expectedModuleNames, actualModuleNames);
    }

    @When("User clicks on {string} module")
    public void user_clicks_on_module(String moduleName) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.rejectCookies));
        homePage.rejectCookies.click();
        homePage.megaMenuTitle(moduleName).click();
    }

    @When("User clicks on {string} title")
    public void user_clicks_on_title(String titleOfIndustries) {
        homePage.subtitleUnderMegaMenu(titleOfIndustries).click();
    }

    AutomotivePage automotivePage = new AutomotivePage();

    @When("User clicks on Contact button")
    public void user_clicks_on_contact_button() {
        automotivePage.contactButton.click();
    }

    Faker faker = new Faker();
    @When("User should be able to write a valid email on Email box")
    public void user_should_be_able_to_write_a_valid_email_on_email_box() {
        Driver.getDriver().switchTo().frame(automotivePage.contactUsIframe);

        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(automotivePage.submitButton));

        automotivePage.eMailInputBox.sendKeys(faker.internet().emailAddress() + Keys.ENTER);

    }

    @When("User should be able to fill ContactUs form")
    public void user_should_be_able_to_fill_contact_us_form() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(automotivePage.firstNameInputBox));

        automotivePage.firstNameInputBox.sendKeys(faker.toString() + Keys.ENTER);
        Thread.sleep(300);

        automotivePage.lastNameInputBox.sendKeys(faker.toString() + Keys.ENTER);
        Thread.sleep(300);
        automotivePage.phoneInputBox.sendKeys(faker.numerify("###-########"));
        Thread.sleep(300);
        automotivePage.companyInputBox.sendKeys(faker.toString()+Keys.ENTER);
        Thread.sleep(300);
        automotivePage.jobTitleInputBox.sendKeys(faker.toString() + Keys.ENTER);
        Thread.sleep(300);

        Select select1 = new Select(automotivePage.countrySelectBox);
        select1.selectByVisibleText("Germany");

        Thread.sleep(300);
        Select select2= new Select(automotivePage.inquirySelectBox);
        select2.selectByVisibleText("Career Seekers");

        Thread.sleep(300);

        automotivePage.messageInputBox.sendKeys(faker.toString()+Keys.ENTER);
        Thread.sleep(300);

    }

    @When("User should  click on checkbox")
    public void user_should_click_on_checkbox() {
        automotivePage.privacyNoticeCheckBox.click();
    }

    @When("User should click on CAPTCHA box")
    public void user_should_click_on_captcha_box() {
        automotivePage.reCaptcha.click();
    }

    @Then("User should be able to click on {string} button")
    public void user_should_be_able_to_click_on_button(String string) {
        Assert.assertTrue(automotivePage.submitButton.isEnabled());
    }

}
