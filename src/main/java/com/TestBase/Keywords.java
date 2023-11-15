package com.TestBase;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Keywords {
	Hooks1 base = new Hooks1();
    
	public WebElement getWebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return Hooks1.driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return Hooks1.driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return Hooks1.driver.findElement(By.cssSelector(locatorValue));
		} else
			return null;
	}

	public List<WebElement> getWebElements(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return Hooks1.driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return Hooks1.driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return Hooks1.driver.findElements(By.cssSelector(locatorValue));
		} else
			return null;
	}

	public void enterText(WebElement e, String textToEnter) {
		e.sendKeys(textToEnter);
	}

	public void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public void enterButton() {
		
	}

	public String getText(String locatorType, String locatorValue) {
		return getWebElement(locatorType, locatorValue).getText();
	}

	public void launchUrl(String url) {
		Hooks1.driver.get(url);
	}
	
	public void maximize(RemoteWebDriver driver) {
		Hooks1.driver.manage().window().maximize();

	}
}
