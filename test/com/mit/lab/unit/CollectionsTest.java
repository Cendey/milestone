package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.Collections;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: MIT Lab Project</p>
 * <p>Description: com.mit.lab.unit.CollectionsTest</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Labs Co., Inc</p>
 *
 * @author <chao.deng@mit.lab>
 * @version 1.0
 * @since 5/2/2017
 */
public class CollectionsTest {

    @Test(dataProvider = "collections-factory", dataProviderClass = DataProviderFactory.class, groups = {"collections"})
    public void testExtractPK(List<Map<String, Object>> source, String name) throws Exception {
        Collections target = new Collections();
        StackTraceElement[] stackTraces = new Throwable().getStackTrace();
        StringBuilder trace = new StringBuilder();
        trace.append(String.format("%s#%s@%d", stackTraces[0].getClassName(), stackTraces[0].getMethodName(),
            stackTraces[0].getLineNumber()));
        System.out.println(trace);
        System.out.println(String.format("Those primary keys are: [%s]",target.extractPK(source, name)));
    }

}