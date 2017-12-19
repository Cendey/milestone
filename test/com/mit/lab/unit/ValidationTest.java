package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.Validation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: com.mit.lab.unit.ValidationTest</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Kewill Co., Ltd</p>
 *
 * @author <chao.deng@kewill.com>
 * @version 1.0
 * @date 12/19/2017
 */
public class ValidationTest {

    @Parameters({"start-info"})
    @BeforeTest(groups = "validation")
    public void startTest(String startInfo) {
        System.out.println(startInfo);
    }

    @Parameters({"open-info"})
    @BeforeMethod(groups = {"validation"})
    public void startSession(String openInfo, Method method) {
        System.out.println(String.format(openInfo, method.toGenericString()));
    }

    @Test(dataProvider = "validation-factory", dataProviderClass = DataProviderFactory.class, groups = {"validation"})
    public void testValidate(String emailAddress) {
        Validation.validate(emailAddress).exec();
    }

    @Parameters({"close-info"})
    @AfterMethod(groups = {"validation"})
    public void closeSession(String closeInfo, Method method) {
        System.out.println(String.format(closeInfo, method.toGenericString()));
    }

    @Parameters({"finish-info"})
    @AfterTest(groups = {"validation"})
    public void finishTest(String finishInfo) {
        System.out.println(finishInfo);
    }
}