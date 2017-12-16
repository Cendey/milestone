package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.Holder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class HolderTest {

    @Parameters({"start-info"})
    @BeforeTest(groups = "holder")
    public void startTest(String startInfo) {
        System.out.println(startInfo);
    }

    @Parameters({"open-info"})
    @BeforeMethod(groups = "holder")
    public void startSession(String openInfo, Method method) {
        System.out.println(String.format(openInfo, method.toGenericString()));
    }

    @Test(dataProvider = "holder-factory", dataProviderClass = DataProviderFactory.class, groups = {"holder"})
    public void testGetHeavy(Holder holder) throws Exception {
        System.out.println(ThreadLocal.withInitial(holder::getHeavy).get());
        Runnable[] tasks = {holder::getHeavy, holder::getHeavy};
        for (Runnable item : tasks) {
            new Thread(item).start();
        }
    }

    @Parameters({"close-info"})
    @AfterMethod(groups = "holder")
    public void closeSession(String closeInfo, Method method) {
        System.out.println(String.format(closeInfo, method.toGenericString()));
    }

    @Parameters({"finish-info"})
    @AfterTest(groups = "holder")
    public void finishTest(String finishInfo) {
        System.out.println(finishInfo);
    }
}