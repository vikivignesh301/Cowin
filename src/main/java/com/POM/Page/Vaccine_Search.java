package com.POM.Page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vaccine_Search {

	public static WebDriver driver;

	@FindBy(xpath = "(//img[@class='img-fluid'])[2]")
	private WebElement heading;
	@FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c69-352']")
	private WebElement statedropdown;
	@FindBy(xpath = "//div[@role='listbox']/mat-option")
	private List<WebElement> allstates;
	@FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c69-354']")
	private WebElement districtdropdown;
	@FindBy(xpath = "//div[@role='listbox']/mat-option")
	private List<WebElement> alldistrict;
	@FindBy(xpath = "//button[@tabindex='0']")
	private WebElement search;
	@FindBy(xpath = "//label[@for='c1']")
	private WebElement filter_age18;
	@FindBy(xpath = "//label[@for='cdoes2']")
	private WebElement filter_dose2;
	@FindBy(xpath = "//label[@for='c6']")
	private WebElement filter_paid;
	@FindBy(xpath = "//label[@for='c3']")
	private WebElement filter_covidshield;
	@FindBy(xpath = "//div[@class='show-result']/descendant::li[@class='ng-star-inserted']/span[2]")
	private List<WebElement> validate;
	@FindBy(xpath = "//div[@class='row-disp']")
	private List<WebElement> all_centres;

	public Vaccine_Search(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeading() {
		return heading;
	}

	public WebElement getStatedropdown() {
		return statedropdown;
	}

	public List<WebElement> getAllstates() {
		return allstates;
	}

	public WebElement getDistrictdropdown() {
		return districtdropdown;
	}

	public List<WebElement> getAlldistrict() {
		return alldistrict;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getFilter_age18() {
		return filter_age18;
	}

	public WebElement getFilter_dose2() {
		return filter_dose2;
	}

	public WebElement getFilter_paid() {
		return filter_paid;
	}

	public WebElement getFilter_covidshield() {
		return filter_covidshield;
	}

	public List<WebElement> getValidate() {
		return validate;
	}

	public List<WebElement> getAll_centres() {
		return all_centres;
	}

}
