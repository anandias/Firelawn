package com.Ecommerce.Firelawn.genericLib;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public void getPhoto(WebDriver driver, String name) throws IOException {
		/**
		 * Date d = new Date
		 * d.toString().ReplaceAll()(":","-");
		 */
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String timestamp = LocalDateTime.now().toString().replaceAll(":", "-");
		File dest = new File(Autoconatant.photoPath+timestamp+name+".pgn");
		FileUtils.copyFile(src, dest);
		
	}

}
