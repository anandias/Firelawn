package com.Ecommerce.Firelawn.genericLib;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilities {
	public void dropDown(WebElement ele,String text) {
		Select s = new Select(ele);
		s.deselectByVisibleText(text);
	}
	public void mouseHover(WebDriver driver, WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).perform();
		
	}
	public void rightClick(WebDriver driver, WebElement ele) {
		Actions actions = new Actions(driver);
		actions.contextClick().perform();
		
	}
	public void dragAndDrop(WebDriver driver, WebElement src,WebElement dest) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(src, dest).perform();
		
	}
	public void doubleClick(WebDriver driver, WebElement ele) {
		Actions actions = new Actions(driver);
		actions.doubleClick(ele).perform();
		
	}
	public void switchFrames(WebDriver driver) {
		driver.switchTo().frame(0);
		
	}
	public void switchBackFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
		
	}
	public void alertPopupWithAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
	public void alertPopupWithDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
	}
	public void switchTabs(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		for(String b: child) {
			driver.switchTo().window(b);
		}
		
	}
	public void scrollBar(WebDriver driver, String x, String y) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.ScrollBy("+x+","+y+")" );
		
	}
	public void jsClick(WebDriver driver, WebElement ele) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("Arguments[0].Click();",ele);
		
	}
	
	
	
	

}
