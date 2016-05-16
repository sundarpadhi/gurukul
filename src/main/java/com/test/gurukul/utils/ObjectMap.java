package com.test.gurukul.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {

	//property file and provide the locator information to the test.

	Properties properties;

	public ObjectMap(String mapFile){

		properties = new Properties();
		try {
			FileInputStream Master = new FileInputStream(mapFile);
			properties.load(Master);
			Master.close();
		}catch (IOException e) {
			e.getMessage();
		}
	}

	public By getLocator(String ElementName) throws Exception {
		//Read value using the logical name as Key
		String locator = properties.getProperty(ElementName);

		String locatorType = locator.split(":",2)[0];
		String locatorValue = locator.split(":",2)[1];

		//Return a instance of By class based on type of locator
		if(locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		else if(locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		else if((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return By.className(locatorValue);
		else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return By.tagName(locatorValue);
		else if((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return By.linkText(locatorValue);
		else if(locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return By.cssSelector(locatorValue);
		else if(locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		else
			throw new Exception("Locator type '" + locatorType + "' not defined!!");
	}
}
