package bipin.advent;

import java.util.ArrayList;
import java.util.List;

public class TwentyTwentyOne_Day6 {

    static int days = 128;

    public static void main(String[] args) {
        String[] inputArray = testInput.split(",");
        List<Integer> fishList = new ArrayList<>(10000000);
        for (String f : inputArray) {
            fishList.add(Integer.parseInt(f));
        }
        int day = 1;

        while (day <= days) {

            List<Integer> tempList = new ArrayList<>(10000000);

            for (int i = 0; i < fishList.size(); i++) {
                Integer value = fishList.get(i);
                if( value == 0) {
                    tempList.add(6);
                    tempList.add(8);
                } else {
                    tempList.add(--value);
                }
            }

            fishList = new ArrayList<>(tempList);
//            System.out.println("After \t " + day + ":\t " + printNumbers(fishList));
            day++;
        }

        System.out.println("Total Number of Fishes: " + fishList.size());

    }

    static String printNumbers(List<Integer> fishList) {
        String output = "";
        for(Integer fish : fishList) {
            output = output + fish + ",";
        }
        return output;
    }

    static String single = "3";

    static String testInput = "3,4,3,1,2";

    static String input = "3,5,2,5,4,3,2,2,3,5,2,3,2,2,2,2,3,5,3,5,5,2,2,3,4,2,3,5,5,3,3,5,2,4,5,4,3,5,3,2,5,4,1,1,1,5,1,4,1,4,3,5,2,3,2,2,2,5,2,1,2,2,2,2,3,4,5,2,5,4,1,3,1,5,5,5,3,5,3,1,5,4,2,5,3,3,5,5,5,3,2,2,1,1,3,2,1,2,2,4,3,4,1,3,4,1,2,2,4,1,3,1,4,3,3,1,2,3,1,3,4,1,1,2,5,1,2,1,2,4,1,3,2,1,1,2,4,3,5,1,3,2,1,3,2,3,4,5,5,4,1,3,4,1,2,3,5,2,3,5,2,1,1,5,5,4,4,4,5,3,3,2,5,4,4,1,5,1,5,5,5,2,2,1,2,4,5,1,2,1,4,5,4,2,4,3,2,5,2,2,1,4,3,5,4,2,1,1,5,1,4,5,1,2,5,5,1,4,1,1,4,5,2,5,3,1,4,5,2,1,3,1,3,3,5,5,1,4,1,3,2,2,3,5,4,3,2,5,1,1,1,2,2,5,3,4,2,1,3,2,5,3,2,2,3,5,2,1,4,5,4,4,5,5,3,3,5,4,5,5,4,3,5,3,5,3,1,3,2,2,1,4,4,5,2,2,4,2,1,4";
}
