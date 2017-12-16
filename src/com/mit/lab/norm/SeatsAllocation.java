package com.mit.lab.norm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: MIT Lab Project</p>
 * <p>Description: com.mit.lab.norm.SeatsAllocation</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Labs Co., Inc</p>
 *
 * @author <chao.deng@mit.lab>
 * @version 1.0
 * @since 5/3/2017
 */
public class SeatsAllocation {
    private static final List<String> COLUMNS = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "J", "K");

    public int solution(int N, String S) {
        // write your code in Java SE 8
        if (S == null || "".equals(S.trim())) {
            return 3 * N;
        } else {
            int counter = 0;
            Map<String, Boolean> exclusives = new HashMap<>();
            Arrays.stream(S.split(" ")).forEach(item -> exclusives.put(item, true));
            for (int row = 1; row <= N; row++) {
                int contiguousSeatNumber = 0;
                for (int col = 0; col < 10; col++) {
                    String item = COLUMNS.get(col);
                    if (exclusives.get(row + item) == null) {
                        if (contiguousSeatNumber >= 3 && nextToAisle(item)) {
                            counter++;
                            contiguousSeatNumber = 0;
                        }
                        contiguousSeatNumber++;
                    } else {
                        contiguousSeatNumber = 0;
                    }
                }
                if (contiguousSeatNumber > 2) {
                    counter++;
                }
            }
            return counter;
        }
    }

    private boolean nextToAisle(String item) {
        boolean isToAlias;
        switch (item) {
            case "D":
            case "H":
                isToAlias = true;
                break;
            default:
                isToAlias = false;
        }
        return isToAlias;
    }
}
