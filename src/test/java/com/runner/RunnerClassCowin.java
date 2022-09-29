package com.runner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Property_File.ConfigurationHelper;

import baseClassCowin.BaseClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\VIGNESH S\\eclipse-workspace\\COWIN_PROJECT\\src\\test\\java\\com\\feature\\Cowin.feature", glue = "com.stepdefinition", monochrome = true, plugin = {
		"pretty", "html:Reports/HtmlReport.html", "junit:Reports/XmlReport.xml", "json:Reports/JasonReport.json" })
public class RunnerClassCowin {
	
	public static WebDriver driver;
	@BeforeClass
	public static void setUp() throws IOException {
		String browser = ConfigurationHelper.getInstance().getBrowser();
		driver = BaseClass.browserLaunch(browser);
		BaseClass.implicitWait();
	}
	@AfterClass
	public static void tearDown() {
		BaseClass.windowClose();
	}
}
