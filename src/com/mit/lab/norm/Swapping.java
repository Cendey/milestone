package com.mit.lab.norm;

import java.util.Arrays;

/**
 * <p>Title: MIT Lab Project</p>
 * <p>Description: com.mit.lab.norm.Swapping</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Labs Co., Inc</p>
 *
 * @author <chao.deng@mit.lab>
 * @version 1.0
 * @since 4/26/2017
 */
public class Swapping {

    public boolean solution(int[] nums) {
        return nums.length <= 2 || orderByOneSwap(nums);
    }

    private boolean orderByOneSwap(int[] nums) {
        int size = nums.length;
        int[] dump = Arrays.copyOf(nums, size);
        Arrays.sort(dump);

        int counter = 0;
        for (int pos = 0; pos < size; pos++) {
            if (nums[pos] != dump[pos]) ++counter;
        }
        return counter <= 2;
    }
}
