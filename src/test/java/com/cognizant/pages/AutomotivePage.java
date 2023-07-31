package com.cognizant.pages;

import com.cognizant.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutomotivePage {

    public AutomotivePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//a[@aria-label='Contact']")
    public WebElement contactButton;

    @FindBy(xpath="//input[@placeholder='Email *']")
    public WebElement eMailInputBox;

    @FindBy(xpath="//input[@aria-label='First Name *']")
    public WebElement firstNameInputBox;

    @FindBy(xpath="//input[@aria-label='Last Name *']")
    public WebElement lastNameInputBox;

    @FindBy(xpath="//input[@aria-label='Phone *']")
    public WebElement phoneInputBox;

    @FindBy(xpath="//input[@aria-label='Job Title *']")
    public WebElement jobTitleInputBox;

    @FindBy(xpath="//input[@aria-label='Company *']")
    public WebElement companyInputBox;

    @FindBy(xpath="//select[@aria-label='Country *']")
    public WebElement countrySelectBox;

    @FindBy(id="297592_81472pi_297592_81472")
    public WebElement inquirySelectBox;

    @FindBy(id="contact-us-iframe")
    public WebElement contactUsIframe;

    @FindBy(id="297592_63571pi_297592_63571")
    public WebElement messageInputBox;

    @FindBy(id="297592_63573pi_297592_63573_835319")
    public WebElement privacyNoticeCheckBox;

    @FindBy(css=".recaptcha-checkbox-checkmark")
    public WebElement reCaptcha;

    @FindBy(xpath="//input[@type='submit']")
    public WebElement submitButton;






}
