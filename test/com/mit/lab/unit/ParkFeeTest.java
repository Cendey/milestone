package com.mit.lab.unit;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.ParkFee;
import org.testng.annotations.Test;

/**
 * <p>Title: MIT Lab Project</p>
 * <p>Description: com.mit.lab.unit.ParkFeeTest</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Labs Co., Inc</p>
 *
 * @author <chao.deng@mit.lab>
 * @version 1.0
 * @since 4/27/2017
 */
public class ParkFeeTest {

    @Test(dataProvider = "parking-time-factory", dataProviderClass = DataProviderFactory.class, groups = { "parking-fee" })
    public void testSolution(String enter, String leave) throws Exception {
        ParkFee fee = ParkFee.class.newInstance();
        System.out.println(String.format("The fee need to pay from %s to %s is: %d", enter,leave,fee.solution(enter,leave)));
    }

}