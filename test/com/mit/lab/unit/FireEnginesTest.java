package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.FireEngines;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FireEnginesTest {

	@Parameters({ "start-info" })
	@BeforeTest(groups = "fire-engine")
	public void startTest(String startInfo) {
		System.out.println(startInfo);
	}

	@Parameters({ "open-info" })
	@BeforeMethod(groups = "fire-engine")
	public void startSession(String openInfo, Method method) {
		System.out.println(String.format(openInfo, method.toGenericString()));
	}

	@Test(dataProvider = "fire-engine-factory", dataProviderClass = DataProviderFactory.class, groups = { "fire-engine" })
	public void testStart(FireEngines<?> fireEngines) throws Exception {
		fireEngines.start();
	}

	@Test(dataProvider = "fire-engine-factory", dataProviderClass = DataProviderFactory.class, groups = { "fire-engine" })
	public void testSpeed(FireEngines<?> fireEngines) throws Exception {
		fireEngines.speed(fireEngines.getSpeed());
	}

	@Parameters({ "close-info" })
	@AfterMethod(groups = { "fire-engine" })
	public void closeSession(String closeInfo, Method method) {
		System.out.println(String.format(closeInfo, method.toGenericString()));
	}

	@Parameters({ "finish-info" })
	@AfterTest(groups = "fire-engine")
	public void finishTest(String finishInfo) {
		System.out.println(finishInfo);
	}
}