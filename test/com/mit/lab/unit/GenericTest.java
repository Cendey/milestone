package com.mit.lab.unit;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.Generic;

public class GenericTest {
	@Parameters({ "start-info" })
	@BeforeTest(groups = "string-operation")
	public void startTest(String startInfo) {
		System.out.println(startInfo);
	}

	@Parameters({ "open-info" })
	@BeforeMethod(groups = { "string-operation" })
	public void startSession(String openInfo, Method method) {
		System.out.println(String.format(openInfo, method.toGenericString()));
	}

	@Test(dataProvider = "string-factory", dataProviderClass = DataProviderFactory.class, groups = { "string-operation" })
	public void toSplit(String source, String regex) {
		Arrays.asList(Generic.toSplit(source, regex)).stream().forEach(System.out::println);
	}

	@Test(dataProvider = "string-factory", dataProviderClass = DataProviderFactory.class, groups = { "string-operation" })
	public void toTrim(String source, String regex) {
		Arrays.asList(Generic.toSplit(source, regex)).stream()
				.filter(item -> (item.length() != item.trim().length() && item.indexOf("-") == -1))
				.forEach(System.out::println);
	}

	@Test(dataProvider = "string-factory", dataProviderClass = DataProviderFactory.class, groups = { "string-operation" })
	public void testReplaceNoneCharater(String source, String regex) {
		if (source.indexOf("-") != -1) {
			System.out.println(Generic.replaceNoneCharacter(source, regex));
		}
	}

	@Parameters({ "close-info" })
	@AfterMethod(groups = { "string-operation" })
	public void closeSession(String closeInfo, Method method) {
		System.out.println(String.format(closeInfo, method.toGenericString()));
	}

	@Parameters({ "finish-info" })
	@AfterTest(groups = { "string-operation" })
	public void finishTest(String finishInfo) {
		System.out.println(finishInfo);
	}
}
