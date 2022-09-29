package com.mav.practice.cowin_project;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.mav.practice.Advance_code.XLSX_Reader;

public class Cowin {

	public static WebDriver driver;
	public static String statevalue;
	public static String districtvalue;
	public static String Age;
	public static String Payment;
	public static String Dose;
	public static String VaccineName;

	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\VIGNESH S\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.cowin.gov.in/");
		driver.manage().window().maximize();
	}

	public static void stateSelect() throws Exception {
		statevalue = XLSX_Reader.particlarData("cowin", 1, 0);
		districtvalue = XLSX_Reader.particlarData("cowin", 1, 1);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement heading = driver.findElement(By.xpath("(//img[@class='img-fluid'])[2]"));
		js.executeScript("arguments[0].scrollIntoView()", heading);
		Thread.sleep(1000);
		WebElement statedropdown = driver
				.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c69-352']"));
		statedropdown.click();
		Thread.sleep(1000);
		List<WebElement> allstates = driver.findElements(By.xpath("//div[@role='listbox']/mat-option"));
		for (WebElement state : allstates) {
			String text = state.getText();

			if (text.trim().equals(statevalue)) {
				js.executeScript("arguments[0].click();", state);
				break;
			}
		}
		Thread.sleep(1000);
		WebElement districtdropdown = driver
				.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c69-354']"));
		districtdropdown.click();
		Thread.sleep(1000);
		List<WebElement> alldistrict = driver.findElements(By.xpath("//div[@role='listbox']/mat-option"));
		for (WebElement district : alldistrict) {
			String text = district.getText();
			if (text.trim().equals(districtvalue)) {
				js.executeScript("arguments[0].click();", district);
				break;
			}
		}
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.xpath("//button[@tabindex='0']"));
		js.executeScript("arguments[0].click();", search);
		js.executeScript("window.scrollBy(0,500)");
	}

	public static void vaccineDetails() throws InterruptedException {
		Thread.sleep(2000);
		WebElement filter_age18 = driver.findElement(By.xpath("//label[@for='c1']"));
		filter_age18.click();
		Thread.sleep(2000);
		WebElement filter_dose2 = driver.findElement(By.xpath("//label[@for='cdoes2']"));
		filter_dose2.click();
		Thread.sleep(2000);
		WebElement filter_paid = driver.findElement(By.xpath("//label[@for='c6']"));
		filter_paid.click();
		Thread.sleep(2000);
		WebElement filter_covidshield = driver.findElement(By.xpath("//label[@for='c3']"));
		filter_covidshield.click();
	}

	public static void validation() throws InterruptedException, IOException {
		Age = XLSX_Reader.particlarData("cowin", 2, 2);
		Payment = XLSX_Reader.particlarData("cowin", 1, 3);
		Dose = XLSX_Reader.particlarData("cowin", 2, 4);
		VaccineName = XLSX_Reader.particlarData("cowin", 1, 5);

		List<WebElement> validate = driver.findElements(
				By.xpath("//div[@class='show-result']/descendant::li[@class='ng-star-inserted']/span[2]"));
		Thread.sleep(2000);
		for (WebElement crosscheck : validate) {
			String text = crosscheck.getText();
			if (text.equalsIgnoreCase(Age)) {
				System.out.println("18+ is Clicked");
			}
			if (text.equalsIgnoreCase(Payment)) {
				System.out.println("Paid is Clicked");
			}
			if (text.equals(Dose)) {
				System.out.println("Dose 2 is Clicked");
			}
			if (text.equalsIgnoreCase(VaccineName)) {
				System.out.println("CoviShield is clicked");
			}
		}
	}

	public static void centrePrint() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		List<WebElement> all_centres = driver.findElements(By.xpath("//div[@class='row-disp']"));
		for (WebElement centre : all_centres) {
			System.out.println("The centre is : " + centre.getText());
		}
		Thread.sleep(3000);
	}
	public static void screenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\VIGNESH S\\eclipse-workspace\\COWIN_PROJECT\\Screenshot\\cowin.png");
		FileUtils.copyFile(source, destination);
	}

	public static void main(String[] args) throws Exception {
		browserLaunch();
		stateSelect();
		vaccineDetails();
		validation();
		centrePrint();
		screenShot();
	}

}
