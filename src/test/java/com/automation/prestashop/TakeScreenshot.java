package com.automation.prestashop;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {

	public static String takescreenshot(WebDriver driver, String Screenshotname, String urlReport) throws IOException {

		try {
			TakesScreenshot takescreenshot=(TakesScreenshot)driver;
			File source=takescreenshot.getScreenshotAs(OutputType.FILE);
			String screenshotURL = Screenshotname + ".png";
			String dest = "C:\\projects\\prestashop\\Reports\\" + urlReport + "/" + screenshotURL;
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			return screenshotURL;
			
		} catch (Exception e) {
			
			System.out.println("Exception while taking screenshot" + e.getMessage());
			
			return e.getMessage();
		}
	}

}

