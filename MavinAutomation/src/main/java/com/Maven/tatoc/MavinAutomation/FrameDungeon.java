package com.Maven.tatoc.MavinAutomation;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class FrameDungeon {

		public boolean colorMatching(WebDriver driver) {
			driver.switchTo().frame("main");
			String boxOneColor = driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().frame("child");
			String boxTwoColor = driver.findElement(By.id("answer")).getAttribute("class");
			while (!boxOneColor.equals(boxTwoColor)) {
				driver.switchTo().parentFrame();
				driver.findElement(By.linkText("Repaint Box 2")).click();
				driver.switchTo().frame("child");
				boxTwoColor = driver.findElement(By.id("answer")).getAttribute("class");
			}
			driver.switchTo().parentFrame();
			driver.findElement(By.linkText("Proceed")).click();
			String expectedUrl = "http://10.0.1.86/tatoc/basic/drag";
			String actualUrl = driver.getCurrentUrl();
			if (expectedUrl.equals(actualUrl)) {
				return true;
			}
			return false;
		}

	}

