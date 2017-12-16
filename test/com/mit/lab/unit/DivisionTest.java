package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.Division;
import org.testng.annotations.Test;

/**
 * <p>Title: MIT Lab Project</p>
 * <p>Description: com.mit.lab.unit.DivisionTest</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Labs Co., Inc</p>
 *
 * @author <chao.deng@mit.lab>
 * @version 1.0
 * @since 5/3/2017
 */
public class DivisionTest {

    @Test(dataProvider = "division-factory", dataProviderClass = DataProviderFactory.class, groups = {"division"})
    public void testSolution(int[] A) throws Exception {
        Division target = new Division();
        System.out.println(String.format("Dose array can divide to three equivalent parts? %b", target.solution(A) == 0));
    }

}