package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.GenRegister;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class GenRegisterTest {

    @Parameters({"start-info"})
    @BeforeTest(groups = "register")
    public void startTest(String startInfo) {
        System.out.println(startInfo);
    }

    @Parameters({"open-info"})
    @BeforeMethod(groups = "register")
    public void startSession(String openInfo, Method method) {
        System.out.println(String.format(openInfo, method.toGenericString()));
    }

    @Test(dataProvider = "register-factory", dataProviderClass = DataProviderFactory.class, groups = {"register"})
    public void testGenInfo(String registerName) throws Exception {
        GenRegister.genInfo(registerName);
    }

    @Parameters({"close-info"})
    @AfterMethod(groups = "register")
    public void closeSession(String closeInfo, Method method) {
        System.out.println(String.format(closeInfo, method.toGenericString()));
    }

    @Parameters({"finish-info"})
    @AfterTest(groups = "register")
    public void finishTest(String finishInfo) {
        System.out.println(finishInfo);
    }
}