package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.FluentMailer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Consumer;

public class FluentMailerTest {

    @Parameters({"start-info"})
    @BeforeTest(groups = "fluent-mailer")
    public void startTest(String startInfo) {
        System.out.println(startInfo);
    }

    @Parameters({"open-info"})
    @BeforeMethod(groups = "fluent-mailer")
    public void startSession(String openInfo, Method method) {
        System.out.println(String.format(openInfo, method.toGenericString()));
    }

    @Test(dataProvider = "mailer-factory", dataProviderClass = DataProviderFactory.class, groups = "fluent-mailer")
    public void send(Consumer<FluentMailer> block) {
        FluentMailer.send(block);
        Arrays.asList("/usr,/tmp").stream().map(
            path -> {
                try {
                    return new File(path).getCanonicalPath();
                } catch (IOException ex) {
                    return ex.getMessage();
                }
            }
        ).forEach(System.out::println);
    }

    @Parameters({"close-info"})
    @AfterMethod(groups = "fluent-mailer")
    public void closeSession(String closeInfo, Method method) {
        System.out.println(String.format(closeInfo, method.toGenericString()));
    }

    @Parameters({"finish-info"})
    @AfterTest(groups = "fluent-mailer")
    public void finishTest(String finishInfo) {
        System.out.println(finishInfo);
    }
}