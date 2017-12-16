package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.intf.UseInstance;
import com.mit.lab.norm.FileWriterEAM;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class FileWriterEAMTest {

    @Parameters({"start-info"})
    @BeforeTest(groups = {"file-writer-eam"})
    public void startTest(String startInfo) {
        System.out.println(startInfo);
    }

    @Parameters({"open-info"})
    @BeforeMethod(groups = {"file-writer-eam"})
    public void startSession(String openInfo, Method method) {
        System.out.println(String.format(openInfo, method.toGenericString()));
    }

    @Test(dataProvider = "file-writer-eam-factory", dataProviderClass = DataProviderFactory.class,
        groups = {"file-writer-eam"})
    public void testUse(String fileName,UseInstance<FileWriterEAM, IOException> instance) throws Exception {
        FileWriterEAM.use(fileName, instance);
    }

    @Parameters({"close-info"})
    @AfterMethod(groups = {"file-writer-eam"})
    public void closeSession(String closeInfo, Method method) {
        System.out.println(String.format(closeInfo, method.toGenericString()));
    }

    @Parameters({"finish-info"})
    @AfterTest(groups = {"file-writer-eam"})
    public void finishTest(String finishInfo) {
        System.out.println(finishInfo);
    }
}