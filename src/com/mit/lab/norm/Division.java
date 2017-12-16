package com.mit.lab.norm;

/**
 * <p>Title: MIT Lab Project</p>
 * <p>Description: com.mit.lab.norm.Division</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Labs Co., Inc</p>
 *
 * @author <chao.deng@mit.lab>
 * @version 1.0
 * @since 5/3/2017
 */
public class Division {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 5) return -1;
        long sum = sum(A, 0, A.length);

        long preSum, midSum, postSum;
        for (int preIndex = 1; preIndex < A.length - 1; preIndex++) {
            for (int postIndex = preIndex + 1; postIndex < A.length; postIndex++) {
                if ((sum - A[preIndex] - A[postIndex]) % 3 == 0) {
                    preSum = sum(A, 0, preIndex);
                    midSum = sum(A, preIndex + 1, postIndex);
                    postSum = sum(A, postIndex + 1, A.length);
                    if (preSum == midSum && midSum == postSum) {
                        System.out.println(String.format("Division index pair (%d,%d)", preIndex, postIndex));
                        return 0;
                    }
                }
            }
        }

        return -1;
    }

    /**
     * <em>Summary:</em><p>Sum all elements provided, include begin, but end is exclusive</p>
     *
     * @param A     <p>Given arrays, which scope range from 1..N</p>
     * @param begin <p><code>begin</code> included</p>
     * @param end   <p><code>end</code> exclusive</p>
     * @return <p>All elements sum</p>
     */
    private long sum(int[] A, int begin, int end) {
        long sum = 0;
        if (A != null && A.length > 0) {
            while (begin < end) {
                sum += A[begin++];
            }
        }
        return sum;
    }

}
