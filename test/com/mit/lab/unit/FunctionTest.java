package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.intf.Function;
import com.mit.lab.norm.Generic;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * <p>Title: MIT Lib Project</p>
 * <p>Description: com.mit.lab.unit.FunctionTest</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Lab Co., LTD.</p>
 *
 * @author <chao.deng@mit.edu>
 * @version 1.0
 * @since 12/08/2017
 */
public class FunctionTest<T, U> {

    @Parameters({"start-info"})
    @BeforeTest(groups = "function")
    public void startTest(String startInfo) {
        System.out.println(startInfo);
    }

    @Parameters({"open-info"})
    @BeforeMethod(groups = {"function"})
    public void startSession(String openInfo, Method method) {
        System.out.println(String.format(openInfo, method.toGenericString()));
    }

    @Test(dataProvider = "function-factory-main", dataProviderClass = DataProviderFactory.class, groups = {"function"})
    public <R> void testHigherCompose(Function<U, R> f, Function<T, U> g, T arg, Method method) {
        Function<Function<U, R>, Function<Function<T, U>, Function<T, R>>> higherCompose =
            outer -> intermediate -> inner -> outer.apply(intermediate.apply(inner));
        System.out.println(
            Generic.format("%s(%s) = %s").apply(method.getName()).apply(arg)
                .apply(higherCompose.apply(f).apply(g).apply(arg)).apply(""));
    }

    @Test(dataProvider = "function-factory-main", dataProviderClass = DataProviderFactory.class, groups = {"function"})
    public <R> void testCompose(Function<T, U> outer, Function<R, T> inner, R arg, Method method) {
        Function<R, U> compose = param -> outer.apply(inner.apply(param));
        System.out.println(
            Generic.format("%s(%s) = %s").apply(method.getName()).apply(arg).apply(compose.apply(arg)).apply(""));
    }

    @Test(dataProvider = "function-factory-swap", dataProviderClass = DataProviderFactory.class, groups = {"function"})
    public <R> void testSwap(Function<T, Function<U, R>> inner, T rate, U price, Method method) {
        System.out.println(
            Generic.format("Normal#: %s(%s, %s) = %s").apply(method.getName()).apply(rate).apply(price)
                .apply(inner.apply(rate).apply(price)));

        Function<U, Function<T, R>> swap = Function.swap(inner);
        System.out.println(
            Generic.format("Swap#: %s(%s, %s) = %s").apply(method.getName()).apply(rate).apply(price)
                .apply(swap.apply(price).apply(rate)));
    }

    @Parameters({"close-info"})
    @AfterMethod(groups = {"function"})
    public void closeSession(String closeInfo, Method method) {
        System.out.println(String.format(closeInfo, method.toGenericString()));
    }

    @Parameters({"finish-info"})
    @AfterTest(groups = {"function"})
    public void finishTest(String finishInfo) {
        System.out.println(finishInfo);
    }
}