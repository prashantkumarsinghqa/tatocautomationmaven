package com.Maven.tatoc.MavinAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAround {

	public boolean drag(WebDriver driver) {
		Actions actions = new Actions(driver);
		WebElement drop = driver.findElement(By.id("dropbox"));
		WebElement drag = driver.findElement(By.id("dragbox"));
		actions.dragAndDrop(drag, drop).build().perform();
		driver.findElement(By.linkText("Proceed")).click();
		String expectedUrl = "http://10.0.1.86/tatoc/basic/windows";
		String actualUrl = driver.getCurrentUrl();
		if (expectedUrl.equals(actualUrl)) {
			return true;
		}
		return false;
	}

}