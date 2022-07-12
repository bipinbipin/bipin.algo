package bipin.advent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwentyTwentyOne_Day6_pt2 {

    static long totalFish = 0;
    static Map<String, Long> fullMap = new HashMap<>();

    public static void main(String[] args) {
        buildFishMap(256);
        String[] inputArray = input.split(",");
        for (String f : inputArray) {
            totalFish += fullMap.get(f);
        }
        System.out.println("Total Fish:\t" + totalFish);
    }

    static void buildFishMap(int days) {

        Map<String, StringBuilder> halfwayMap = new HashMap<>();

        for (int j = 0; j <= 8; j++) {
            StringBuilder fishMap = new StringBuilder().append(j);
            int day = 1;

            while (day <= days/2) {
                for (int i = 0; i < fishMap.length(); i++) {
                    if (fishMap.charAt(i) == '0') {
                        fishMap.setCharAt(i, '6');
                        fishMap.append('9');
                    } else {
                        fishMap.setCharAt(i, (char) (fishMap.charAt(i)-1));
                    }
                }
                day++;
            }

            halfwayMap.put(String.valueOf(j), fishMap);

            System.out.println("Starting Age:\t" + j + "\t Fish Spawn:\t" + fishMap.length() + "\t Map After Half of Days:\t" + fishMap.toString());
        }

        for(String s : halfwayMap.keySet()) {
            fullMap.put(s, crunchString(halfwayMap.get(s), halfwayMap));
            System.out.println("Char:\t" + s + "\tValue:\t" + fullMap.get(s));
        }
    }

    static long crunchString(StringBuilder sb, Map<String, StringBuilder> valueMap) {
        long total = 0;
        for (int i = 0; i < sb.length(); i++) {
            total += valueMap.get(String.valueOf(sb.charAt(i))).length();
        }
        return total;
    }

    static String testInput = "3,4,3,1,2";

    static String input = "3,5,2,5,4,3,2,2,3,5,2,3,2,2,2,2,3,5,3,5,5,2,2,3,4,2,3,5,5,3,3,5,2,4,5,4,3,5,3,2,5,4,1,1,1,5,1,4,1,4,3,5,2,3,2,2,2,5,2,1,2,2,2,2,3,4,5,2,5,4,1,3,1,5,5,5,3,5,3,1,5,4,2,5,3,3,5,5,5,3,2,2,1,1,3,2,1,2,2,4,3,4,1,3,4,1,2,2,4,1,3,1,4,3,3,1,2,3,1,3,4,1,1,2,5,1,2,1,2,4,1,3,2,1,1,2,4,3,5,1,3,2,1,3,2,3,4,5,5,4,1,3,4,1,2,3,5,2,3,5,2,1,1,5,5,4,4,4,5,3,3,2,5,4,4,1,5,1,5,5,5,2,2,1,2,4,5,1,2,1,4,5,4,2,4,3,2,5,2,2,1,4,3,5,4,2,1,1,5,1,4,5,1,2,5,5,1,4,1,1,4,5,2,5,3,1,4,5,2,1,3,1,3,3,5,5,1,4,1,3,2,2,3,5,4,3,2,5,1,1,1,2,2,5,3,4,2,1,3,2,5,3,2,2,3,5,2,1,4,5,4,4,5,5,3,3,5,4,5,5,4,3,5,3,5,3,1,3,2,2,1,4,4,5,2,2,4,2,1,4";
}
