package bipin.advent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwentyTwentyOne_Day6_group {
    static String testInput = "3,4,3,1,2";
    static String input = "3,5,2,5,4,3,2,2,3,5,2,3,2,2,2,2,3,5,3,5,5,2,2,3,4,2,3,5,5,3,3,5,2,4,5,4,3,5,3,2,5,4,1,1,1,5,1,4,1,4,3,5,2,3,2,2,2,5,2,1,2,2,2,2,3,4,5,2,5,4,1,3,1,5,5,5,3,5,3,1,5,4,2,5,3,3,5,5,5,3,2,2,1,1,3,2,1,2,2,4,3,4,1,3,4,1,2,2,4,1,3,1,4,3,3,1,2,3,1,3,4,1,1,2,5,1,2,1,2,4,1,3,2,1,1,2,4,3,5,1,3,2,1,3,2,3,4,5,5,4,1,3,4,1,2,3,5,2,3,5,2,1,1,5,5,4,4,4,5,3,3,2,5,4,4,1,5,1,5,5,5,2,2,1,2,4,5,1,2,1,4,5,4,2,4,3,2,5,2,2,1,4,3,5,4,2,1,1,5,1,4,5,1,2,5,5,1,4,1,1,4,5,2,5,3,1,4,5,2,1,3,1,3,3,5,5,1,4,1,3,2,2,3,5,4,3,2,5,1,1,1,2,2,5,3,4,2,1,3,2,5,3,2,2,3,5,2,1,4,5,4,4,5,5,3,3,5,4,5,5,4,3,5,3,5,3,1,3,2,2,1,4,4,5,2,2,4,2,1,4";
    static int days = 256;

    public static void main(String[] args) {
        String[] inputArray = input.split(",");
        Map<Integer, Long> runningCount = new HashMap<>();
        for (int j = 0; j <= 8; j++) {
            runningCount.put(j, 0l);
        }

        for (int i = 0; i < inputArray.length; i++) {
            Integer fish = Integer.parseInt(inputArray[i]);
            Long curval = runningCount.get(fish);
            runningCount.put(fish, ++curval);
        }

        int day = 1;
        while(day <= days) {
            long newfisheez = 0;
            for(Integer idx : runningCount.keySet()) {
                if (idx == 0) {
                    newfisheez = runningCount.get(idx);
                } else {
                    Long tmp = runningCount.get(idx);
                    Integer prevIdx = --idx;
                    runningCount.put(prevIdx, tmp);
                }
            }
            runningCount.put(6, runningCount.get(6) + newfisheez);
            runningCount.put(8, newfisheez);
            day++;
        }

        long totalFish = 0;
        for (int j = 0; j <= 8; j++) {
            totalFish += runningCount.get(j);
        }
        System.out.println("Total Fishes: " + totalFish);
    }

}
