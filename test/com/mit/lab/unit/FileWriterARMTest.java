package com.mit.lab.unit;

import com.mit.lab.impl.FileWriterARM;
import com.mit.lab.init.DataProviderFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FileWriterARMTest {

    @Parameters({"start-info"})
    @BeforeTest(groups = {"file-writer"})
    public void startTest(String startInfo) {
        System.out.println(startInfo);
    }

    @Parameters({"open-info"})
    @BeforeMethod(groups = {"file-writer"})
    public void startSession(String openInfo, Method method) {
        System.out.println(String.format(openInfo, method.toGenericString()));
    }

    @Test(groups = {"file-writer"}, dataProvider = "file-writer-arm-factory",
        dataProviderClass = DataProviderFactory.class)
    public void testWriteStuff(String message) throws Exception {
        try (final FileWriterARM writerARM = new FileWriterARM("peekaboo.txt")) {
            writerARM.writeStuff(message);
            System.out.println("done with the resource...");
        }
    }

    @Parameters({"close-info"})
    @AfterMethod(groups = {"file-writer"})
    public void closeSession(String closeInfo, Method method) {
        System.out.println(String.format(closeInfo, method.toGenericString()));
    }

    @Parameters({"finish-info"})
    @AfterTest(groups = {"file-writer"})
    public void finishTest(String finishInfo) {
        System.out.println(finishInfo);
    }
}