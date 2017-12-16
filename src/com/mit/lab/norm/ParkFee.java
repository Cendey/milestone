package com.mit.lab.norm;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>Title: MIT Lab Project</p>
 * <p>Description: com.mit.lab.norm.ParkFee</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Labs Co., Inc</p>
 *
 * @author <chao.deng@mit.lab>
 * @version 1.0
 * @since 4/26/2017
 */

/*
  The entrance fee of the car parking lot is 2;
  The first full or partial hour costs 3;
  Each successive full or partial hour (after the first) costs 4.
  Times are the same day and E < L
*/

public class ParkFee {

    public int solution(String enter, String leave) {
        Duration duration = duration(leave, enter);
        long hour = duration.toHours();
        long min = duration.toMinutes() % 60;
        hour += (min != 0 ? 1 : 0);
        return 2 + 3 + (Long.valueOf(hour).intValue() - 1) * 4;
    }

    private Duration duration(String enter, String leave) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime start = LocalTime.parse(enter, formatter);
        LocalTime over = LocalTime.parse(leave, formatter);
        return Duration.between(over, start);
    }
}
