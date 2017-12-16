package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.Swapping;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * <p>Title: MIT Lab Project</p>
 * <p>Description: com.mit.lab.unit.SwappingTest</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Labs Co., Inc</p>
 *
 * @author <chao.deng@mit.lab>
 * @version 1.0
 * @since 4/26/2017
 */
public class SwappingTest {

    @Test(dataProvider = "solution-factory", dataProviderClass = DataProviderFactory.class, groups = {"swapping"})
    public void testSolution(int[] nums) throws Exception {
        Swapping target = new Swapping();
        System.out.println(String
            .format("%s can be a none-descending arrays by exchanging one time at most ? %s", Arrays.toString(nums),
                target.solution(nums)));
    }

}