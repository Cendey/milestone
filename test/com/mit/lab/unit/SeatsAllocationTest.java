package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.SeatsAllocation;
import org.testng.annotations.Test;

/**
 * <p>Title: MIT Lab Project</p>
 * <p>Description: com.mit.lab.unit.SeatsAllocationTest</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Labs Co., Inc</p>
 *
 * @author <chao.deng@mit.lab>
 * @version 1.0
 * @since 5/3/2017
 */
public class SeatsAllocationTest {

    @Test(dataProvider = "seat-factory", dataProviderClass = DataProviderFactory.class, groups = {"seats"})
    public void testSolution(int N, String S) throws Exception {
        SeatsAllocation target = new SeatsAllocation();
        System.out.println(String.format("There can allocate %d three-person families seats!", target.solution(N, S)));
    }

}