package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.meta.Items;
import com.mit.lab.norm.Script;
import org.testng.annotations.Test;

public class ScriptTest {
    @Test(dataProvider = "script-factory", dataProviderClass = DataProviderFactory.class, groups = {"script"})
    public void testEvaluate(Items params, String expression) throws Exception {
        Script.getInstance().evaluate(params, expression);
        System.out.println(String.format(params + " --> " + expression + "? %s", params.isResult() ? "√" : "×"));
    }
}