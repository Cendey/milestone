package com.mit.lab.unit;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.BizRule;

public class BizRuleTest {
	@Parameters({ "start-info" })
	@BeforeTest(groups = "biz-rule")
	public void startTest(String startInfo) {
		System.out.println(startInfo);
	}

	@Parameters({ "open-info" })
	@BeforeMethod(groups = { "biz-rule" })
	public void startSession(String openInfo, Method method) {
		System.out.println(String.format(openInfo, method.toGenericString()));
	}

	@Test(dataProvider = "bizrule-factory", dataProviderClass = DataProviderFactory.class, groups = { "biz-rule" })
	public void checkInsistence(Map<String, String> source) {
		Map<String, String> result = BizRule.checkInsistence(source);
		for (Map.Entry<String, String> item : result.entrySet()) {
			System.out.println("Controller: " + item.getKey() + " , Subview: " + item.getValue());
		}
	}

	@Parameters({ "close-info" })
	@AfterMethod(groups = { "biz-rule" })
	public void closeSession(String closeInfo, Method method) {
		System.out.println(String.format(closeInfo, method.toGenericString()));
	}

	@Parameters({ "finish-info" })
	@AfterTest(groups = { "biz-rule" })
	public void finishTest(String finishInfo) {
		System.out.println(finishInfo);
	}
}
