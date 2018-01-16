package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.intf.Function;
import com.mit.lab.util.Utils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: com.mit.lab.unit.UtilsTest</p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MIT Edu</p>
 *
 * @author <chao.deng@kewill.com>
 * @version 1.0
 * @date 01/16/2018
 */
public class UtilsTest {

    @Parameters({"start-info"})
    @BeforeTest(groups = {"utils"})
    public void startTest(String startInfo) {
        System.out.println(startInfo);
    }

    @Parameters({"open-info"})
    @BeforeMethod(groups = {"utils"})
    public void startSession(String openInfo, Method method) {
        System.out.println(String.format(openInfo, method.toGenericString()));
    }

    @Test(dataProvider = "utils-factory", dataProviderClass = DataProviderFactory.class, groups = {"utils"})
    public void testFold(
        List<Integer> elements, Integer identity, Function<Integer, Function<Integer, Integer>> function) {
        System.out.println(String.format("########### Original elements sequence: %s ##########", elements.toString()));
        Integer result = Utils.foldLeft(elements, identity, function);
        System.out.println(String.format("########## Fold elements is: %s #########", result));
    }

    @Parameters({"close-info"})
    @AfterMethod(groups = {"utils"})
    public void closeSession(String closeInfo, Method method) {
        System.out.println(String.format(closeInfo, method.toGenericString()));
    }

    @Parameters({"finish-info"})
    @AfterTest(groups = {"utils"})
    public void finishTest(String finishInfo) {
        System.out.println(finishInfo);
    }
}