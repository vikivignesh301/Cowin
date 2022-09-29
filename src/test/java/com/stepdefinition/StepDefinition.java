package com.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.POM.Page.Vaccine_Search;
import com.Property_File.ConfigurationHelper;
import com.mav.practice.Advance_code.XLSX_Reader;
import com.runner.RunnerClassCowin;

import baseClassCowin.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {

	public static WebDriver driver = RunnerClassCowin.driver;
	public static Vaccine_Search v = new Vaccine_Search(driver);

	@Given("user Launch The Url")
	public void user_launch_the_url() throws IOException {
		launchUrl(ConfigurationHelper.getInstance().getUrl());
		screenMaximize();
	}

	@When("enter The State and District")
	public void enter_the_state_and_district() throws InterruptedException, IOException {

		jsScrollInToView(v.getHeading());
		sleep();
		clickonElement(v.getStatedropdown());
		sleep();
		List<WebElement> allstates = v.getAllstates();
		for (WebElement state : allstates) {
			String text = state.getText();

			if (text.trim().equals(XLSX_Reader.particlarData("cowin", 1, 0))) {
				jsClick(state);
				break;
			}
		}
		Thread.sleep(1000);

		clickonElement(v.getDistrictdropdown());
		sleep();
		List<WebElement> alldistrict = v.getAlldistrict();
		for (WebElement district : alldistrict) {
			String text = district.getText();
			if (text.trim().equals(XLSX_Reader.particlarData("cowin", 1, 1))) {
				jsClick(district);
				break;
			}
		}
	}

	@Then("click the Search button")
	public void click_the_search_button() throws InterruptedException {
		sleep();
		jsClick(v.getSearch());
		jsScrollBy(0, 500);
	}

	@When("click On Details Of Vaccine")
	public void click_on_details_of_vaccine() throws InterruptedException {
		sleep();
		clickonElement(v.getFilter_age18());
		sleep();
		clickonElement(v.getFilter_dose2());
		sleep();
		clickonElement(v.getFilter_paid());
		sleep();
		clickonElement(v.getFilter_covidshield());
	}

	@When("validate The Details Of Vaccine")
	public void validate_the_details_of_vaccine() throws IOException, InterruptedException {
		List<WebElement> validate = v.getValidate();
		sleep();
		for (WebElement crosscheck : validate) {
			String text = crosscheck.getText();

			if (text.equalsIgnoreCase(XLSX_Reader.particlarData("cowin", 2, 2))) {
				System.out.println("18+ is Clicked");
			}

			if (text.equalsIgnoreCase(XLSX_Reader.particlarData("cowin", 1, 3))) {
				System.out.println("Paid is Clicked");
			}

			if (text.equals(XLSX_Reader.particlarData("cowin", 2, 4))) {
				System.out.println("Dose 2 is Clicked");
			}

			if (text.equalsIgnoreCase(XLSX_Reader.particlarData("cowin", 1, 5))) {
				System.out.println("CoviShield is clicked");
			}
		}
	}

	@When("print The Total No Of Center Displayed")
	public void print_the_total_no_of_center_displayed() throws InterruptedException {
		jsScrollBy(0, 500);
		List<WebElement> all_centres = v.getAll_centres();
		for (WebElement centre : all_centres) {
			System.out.println("The centre is : " + centre.getText());
		}
		sleep();
	}

	@Then("validate With Screenshot")
	public void validate_with_screenshot() throws IOException {
		screenShot("cowin");
	}

}
