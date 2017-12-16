package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.DatePlain;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DatePlainTest {

	@Parameters({ "start-info" })
	@BeforeTest(groups = "date-plain")
	public void startTest(String startInfo) {
		System.out.println(startInfo);
	}

	@Parameters({ "open-info" })
	@BeforeMethod(groups = { "date-plain" })
	public void startSession(String openInfo, Method method) {
		System.out.println(String.format(openInfo, method.toGenericString()));
	}

	@Test(dataProvider = "date-factory", dataProviderClass = DataProviderFactory.class, groups = { "date-plain" })
	public void testPopUpDate(String plain, String value) throws Exception {
		DatePlain factory = DatePlain.getInstance();
		DatePlain instance = DatePlain.popInstance();
		System.out.println(String.format("%tD%n", factory.popUpDate(plain, value)));
		System.out.println(instance.popUpDate(plain, value));
	}

	@Parameters({ "close-info" })
	@AfterMethod(groups = { "date-plain" })
	public void closeSession(String closeInfo, Method method) {
		System.out.println(String.format(closeInfo, method.toGenericString()));
	}

	@Parameters({ "finish-info" })
	@AfterTest(groups = { "date-plain" })
	public void finishTest(String finishInfo) {
		System.out.println(finishInfo);
	}
}