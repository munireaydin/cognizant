package com.cognizant.pages;

import com.cognizant.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".cog-header__main-menu-item")
    public List<WebElement> moduleNames;

    public WebElement megaMenuTitle(String str){
        String locator = "//*[contains(@class,'cog-header__main-menu-item') and contains(text(), '" + str + "')]";
        return Driver.getDriver().findElement(By.xpath(locator));
    }


    public WebElement subtitleUnderMegaMenu(String str) {
        String locator = "//*[contains(@class, 'cog-header__megamenu-panel')]//a[contains(text(),'" + str + "')]";
        return Driver.getDriver().findElement(By.xpath(locator));
    }

    @FindBy(id = "onetrust-reject-all-handler")
    public WebElement rejectCookies;
}


//[aria-label="Industries"] + .cog-header__megamenu-panel li a