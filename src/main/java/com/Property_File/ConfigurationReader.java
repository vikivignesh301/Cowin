package com.Property_File;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	private Properties p;

	public  ConfigurationReader() throws IOException {
		File f = new File(
				"C:\\Users\\VIGNESH S\\eclipse-workspace\\COWIN_PROJECT\\src\\main\\java\\com\\Property_File\\Cowin.Properties");
		FileInputStream fi = new FileInputStream(f);
		p = new Properties();
		p.load(fi);
	}

	public String getBrowser() {
		String browser = p.getProperty("browser");
		return browser;
	}

	public String getUrl() {
		String url = p.getProperty("url");
		return url;
	}

}
