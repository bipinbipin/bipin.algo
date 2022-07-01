package bipin.advent;

import java.util.ArrayList;
import java.util.List;

/*
gamma binary: 101110100101 gamma decimal: 2981
epsilon binary: 010001011010 epsilon decimal: 1114
Power consumption: 3320834
 */
public class TwentyTwentyOne_Day3 {

    public static void main(String[] args) {
        String[] inputArray = input.split(System.lineSeparator());
        int[] tally = new int[inputArray[0].length()];
        List<String> oxygenList = new ArrayList<>();
        List<String> co2List = new ArrayList<>();
        for(String line : inputArray) {
            char[] charArray = line.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                switch (charArray[i]) {
                    case '0':
                        tally[i]--;
                        break;
                    case '1':
                        tally[i]++;
                        break;
                }
            }
        }

        // get initial list
        for (int j = 0; j < inputArray.length; j++) {

            // create new list with only the values that are max.
            if (tally[0] > 0) {  // 1 is most prevalent
                if (inputArray[j].charAt(0) == '1') {
                    oxygenList.add(inputArray[j]);
                } else {
                    co2List.add(inputArray[j]);
                }
            } else if (tally[0] <= 0) {  // 0 is most prevalent
                if (inputArray[j].charAt(0) == '0') {
                    oxygenList.add(inputArray[j]);
                } else {
                    co2List.add(inputArray[j]);
                }
            }
        }

        while (oxygenList.size() > 1) {
            for (int k = 1; k < tally.length; k++) {
                int mostPrev = mostPrev(oxygenList, k);
                List<String> oxyTemp = new ArrayList<>();
                for (int l = 0; l < oxygenList.size(); l++) {
                    if (mostPrev >= 0) {  // 1 most prevalent  or equal
                        if (oxygenList.get(l).charAt(k) == '1') {
                            oxyTemp.add(oxygenList.get(l));
                        }
                    } else if (mostPrev < 0) {// 0 most prevalent
                        if (oxygenList.get(l).charAt(k)== '0') {
                            oxyTemp.add((oxygenList.get(l)));
                        }
                    }
                }
                oxygenList = oxyTemp;
            }
        }

        while(co2List.size() > 1) {
            for (int m = 1; m < tally.length; m++) {
                int mostPrev = mostPrev(co2List, m);
                List<String> co2Temp =  new ArrayList<>();
                for (int n = 0; n < co2List.size(); n++) {
                    if(mostPrev < 0) {
                        if(co2List.get(n).charAt(m) == '1') {
                            co2Temp.add(co2List.get(n));
                        }
                    } else if (mostPrev >= 0) {
                        if(co2List.get(n).charAt(m)== '0') {
                            co2Temp.add(co2List.get(n));
                        }
                    }
                }
                co2List = co2Temp;
                if (co2List.size() == 1) {
                    break;
                }
            }
        }

        String oxygenRating = oxygenList.get(0);
        String co2Rating = co2List.get(0);

        System.out.println(Integer.parseInt(oxygenRating,2));
        System.out.println(Integer.parseInt(co2Rating,2));
        System.out.println(Integer.parseInt(oxygenRating,2) * Integer.parseInt(co2Rating,2));

//        String gamma = "";
//        String epsilon = "";
//
//        for(int v : tally) {
//            if (v > 0) {
//                gamma += "1";
//                epsilon += "0";
//            } else {
//                gamma += "0";
//                epsilon += "1";
//            }
//        }
//
//        System.out.println("gamma binary: " + gamma + " gamma decimal: " + Integer.parseInt(gamma, 2));
//        System.out.println("epsilon binary: " + epsilon + " epsilon decimal: " + Integer.parseInt(epsilon, 2));
//        System.out.println("Power consumption: " + (Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)));

    }

    static public int mostPrev(List<String> stringList, int index) {
        int tally = 0;
        for(String single : stringList) {
            if(single.charAt(index) == '1') {
                tally++;
            } else {
                tally--;
            }
        }
        return tally;
    }
    static String testInput = "00100\n" +
            "11110\n" +
            "10110\n" +
            "10111\n" +
            "10101\n" +
            "01111\n" +
            "00111\n" +
            "11100\n" +
            "10000\n" +
            "11001\n" +
            "00010\n" +
            "01010\n";

    static String input = "101011111001\n" +
            "100100110111\n" +
            "101010101011\n" +
            "010100010000\n" +
            "001101101101\n" +
            "110001101010\n" +
            "001001011001\n" +
            "101111101111\n" +
            "110001001000\n" +
            "111111000000\n" +
            "111100110001\n" +
            "101100010100\n" +
            "000010000011\n" +
            "000110000011\n" +
            "101010100101\n" +
            "000111001010\n" +
            "100101101110\n" +
            "111111010101\n" +
            "110010001100\n" +
            "000011001101\n" +
            "001001111110\n" +
            "100101001100\n" +
            "000011100100\n" +
            "000100110011\n" +
            "000101101000\n" +
            "101010011011\n" +
            "101011110000\n" +
            "010010110011\n" +
            "110110101110\n" +
            "001110000110\n" +
            "001110111101\n" +
            "110111100101\n" +
            "000010101010\n" +
            "101010101010\n" +
            "011011001101\n" +
            "110110000111\n" +
            "011010011000\n" +
            "000111000101\n" +
            "100000101011\n" +
            "010010101100\n" +
            "110000101110\n" +
            "000010001001\n" +
            "101010001100\n" +
            "101111110101\n" +
            "101111011110\n" +
            "110011100001\n" +
            "011011100100\n" +
            "111100011010\n" +
            "110110101001\n" +
            "101011100010\n" +
            "111000110110\n" +
            "111011100101\n" +
            "111000001111\n" +
            "101110110011\n" +
            "111101000000\n" +
            "101111100110\n" +
            "011111101101\n" +
            "100111110111\n" +
            "000111011011\n" +
            "001001001111\n" +
            "100010110000\n" +
            "001101010000\n" +
            "100101101001\n" +
            "100001010000\n" +
            "110101110001\n" +
            "100111111111\n" +
            "101101000101\n" +
            "001110100110\n" +
            "101010110000\n" +
            "101111010010\n" +
            "101011100101\n" +
            "001110010100\n" +
            "011110110100\n" +
            "100011000000\n" +
            "001000000100\n" +
            "010000010001\n" +
            "101101111011\n" +
            "111010001011\n" +
            "101010100000\n" +
            "101001000000\n" +
            "001000010101\n" +
            "010011000111\n" +
            "101010111100\n" +
            "111101000101\n" +
            "111111100010\n" +
            "100010011101\n" +
            "101001111101\n" +
            "010111001111\n" +
            "111111110110\n" +
            "100111101010\n" +
            "010101000101\n" +
            "100101010010\n" +
            "010110010001\n" +
            "011101000111\n" +
            "011110011010\n" +
            "100000111100\n" +
            "011111111000\n" +
            "001111010001\n" +
            "110110100111\n" +
            "111000001011\n" +
            "110010010011\n" +
            "101010110010\n" +
            "110000110111\n" +
            "101111010000\n" +
            "110111010000\n" +
            "110011100011\n" +
            "010000100111\n" +
            "001010110001\n" +
            "011101011010\n" +
            "110111010010\n" +
            "011001001101\n" +
            "101101001111\n" +
            "011101110100\n" +
            "001101101110\n" +
            "011011101101\n" +
            "111001010001\n" +
            "001100101000\n" +
            "010011100000\n" +
            "011000010100\n" +
            "111000111111\n" +
            "001001100001\n" +
            "010011001010\n" +
            "001110101100\n" +
            "010010111010\n" +
            "000111111011\n" +
            "010010000110\n" +
            "110001100100\n" +
            "001110110111\n" +
            "000010001111\n" +
            "100011100001\n" +
            "100001101110\n" +
            "100001110111\n" +
            "010110100000\n" +
            "100101101111\n" +
            "001100000111\n" +
            "101100111001\n" +
            "100100001100\n" +
            "100000101100\n" +
            "010101000110\n" +
            "101110001000\n" +
            "101110000110\n" +
            "101110011100\n" +
            "001001010001\n" +
            "110111101011\n" +
            "101001000001\n" +
            "111100111110\n" +
            "001100010100\n" +
            "010001111111\n" +
            "110011000011\n" +
            "100110011101\n" +
            "011010100100\n" +
            "011111000011\n" +
            "000110001000\n" +
            "010010111111\n" +
            "010011111011\n" +
            "001000111110\n" +
            "000111101011\n" +
            "100010111100\n" +
            "010110001111\n" +
            "011011000000\n" +
            "010111000011\n" +
            "010001011111\n" +
            "111000101100\n" +
            "010110110000\n" +
            "001100111011\n" +
            "011110100101\n" +
            "100011100011\n" +
            "001000101000\n" +
            "101011001011\n" +
            "101111001111\n" +
            "111000100101\n" +
            "111101100111\n" +
            "111010101000\n" +
            "001110000111\n" +
            "010101011110\n" +
            "001111010100\n" +
            "101011011101\n" +
            "000111101010\n" +
            "000011001011\n" +
            "111000010001\n" +
            "011001011011\n" +
            "011011011001\n" +
            "011110111000\n" +
            "000010001100\n" +
            "011110010000\n" +
            "010000101001\n" +
            "101011011111\n" +
            "100111001100\n" +
            "101000011100\n" +
            "111000000100\n" +
            "011100110000\n" +
            "011100101010\n" +
            "010001110011\n" +
            "100100100010\n" +
            "011110010010\n" +
            "011000100111\n" +
            "110101000101\n" +
            "111011000001\n" +
            "011000010111\n" +
            "010011110011\n" +
            "011001000001\n" +
            "000100101110\n" +
            "100111110001\n" +
            "010010011010\n" +
            "111101011001\n" +
            "100110101111\n" +
            "100010001100\n" +
            "010010000111\n" +
            "100011100100\n" +
            "111001111011\n" +
            "110000010111\n" +
            "101001010001\n" +
            "011111001010\n" +
            "110111111100\n" +
            "000101111101\n" +
            "101011000111\n" +
            "000100010000\n" +
            "111100001111\n" +
            "100000110010\n" +
            "110001110100\n" +
            "000001001100\n" +
            "000101000001\n" +
            "100111101011\n" +
            "011000110110\n" +
            "101111000000\n" +
            "010100101100\n" +
            "101111100011\n" +
            "100111001101\n" +
            "100000010010\n" +
            "100101001111\n" +
            "011110100010\n" +
            "110110100110\n" +
            "100000100001\n" +
            "110100001110\n" +
            "010011001111\n" +
            "011010010000\n" +
            "000000010101\n" +
            "111111011100\n" +
            "000011100000\n" +
            "011110111101\n" +
            "110000011100\n" +
            "011011011000\n" +
            "010100111010\n" +
            "010010100101\n" +
            "001110100011\n" +
            "000110000100\n" +
            "100111000101\n" +
            "000010001000\n" +
            "110110110000\n" +
            "010011000100\n" +
            "011001100010\n" +
            "110000011110\n" +
            "000110100111\n" +
            "010111111011\n" +
            "011100000011\n" +
            "100011101110\n" +
            "001100011010\n" +
            "000010100100\n" +
            "000011110000\n" +
            "000000101000\n" +
            "101001101001\n" +
            "101111010101\n" +
            "101100101101\n" +
            "110000000000\n" +
            "111011001110\n" +
            "001100101110\n" +
            "100101111000\n" +
            "010001000111\n" +
            "111100111010\n" +
            "000100011101\n" +
            "010001000011\n" +
            "100000101001\n" +
            "111111101101\n" +
            "000000011101\n" +
            "001101110110\n" +
            "001100000101\n" +
            "010110011110\n" +
            "001011100100\n" +
            "110001100101\n" +
            "001011110011\n" +
            "011101111000\n" +
            "001001100110\n" +
            "000001011000\n" +
            "001011010000\n" +
            "110001010100\n" +
            "000100011011\n" +
            "010101101010\n" +
            "101000101010\n" +
            "101111011000\n" +
            "110001010111\n" +
            "111100110011\n" +
            "101011101000\n" +
            "000100010110\n" +
            "111010000110\n" +
            "000100000001\n" +
            "101011110101\n" +
            "010010010011\n" +
            "100101011001\n" +
            "100101001010\n" +
            "110100110101\n" +
            "010011100111\n" +
            "100110010101\n" +
            "111010000011\n" +
            "011011110110\n" +
            "111000101110\n" +
            "001011101100\n" +
            "010110100010\n" +
            "011001101011\n" +
            "011000101101\n" +
            "011011111110\n" +
            "011011111001\n" +
            "100001001101\n" +
            "101110011011\n" +
            "001111011100\n" +
            "111110010011\n" +
            "000010101011\n" +
            "001111101010\n" +
            "100001101000\n" +
            "111100100000\n" +
            "010011100100\n" +
            "011101101100\n" +
            "000001101011\n" +
            "001100001110\n" +
            "000011000111\n" +
            "100110001000\n" +
            "101101101011\n" +
            "001011011110\n" +
            "101010111101\n" +
            "101110100110\n" +
            "011111000100\n" +
            "111101111000\n" +
            "001011110111\n" +
            "010010011001\n" +
            "111110110001\n" +
            "100101000100\n" +
            "011011010101\n" +
            "100010010000\n" +
            "100010101000\n" +
            "110010000100\n" +
            "000001001111\n" +
            "101110011010\n" +
            "010000111111\n" +
            "111101010001\n" +
            "100000000000\n" +
            "011101100110\n" +
            "001110101101\n" +
            "001001110010\n" +
            "110011101001\n" +
            "101101011001\n" +
            "000000110101\n" +
            "011101100011\n" +
            "010100000011\n" +
            "101011110010\n" +
            "100101000010\n" +
            "100110001100\n" +
            "000111111010\n" +
            "111100011001\n" +
            "111110101001\n" +
            "010000111000\n" +
            "100110000011\n" +
            "100011001110\n" +
            "000100010010\n" +
            "001101100100\n" +
            "000000001100\n" +
            "011101001001\n" +
            "100001001000\n" +
            "101100111000\n" +
            "110011011111\n" +
            "111110101110\n" +
            "101101001010\n" +
            "111000011001\n" +
            "111110011001\n" +
            "110111010100\n" +
            "011001111011\n" +
            "101101111000\n" +
            "010010010100\n" +
            "100000110110\n" +
            "011110010100\n" +
            "010010101010\n" +
            "001111100100\n" +
            "100000011101\n" +
            "110100010010\n" +
            "101101100000\n" +
            "111001111010\n" +
            "010001100110\n" +
            "011000110101\n" +
            "011110010011\n" +
            "011111100000\n" +
            "001000101100\n" +
            "000100010111\n" +
            "011000101010\n" +
            "011000010110\n" +
            "010001101011\n" +
            "110101010000\n" +
            "000100100100\n" +
            "011011001100\n" +
            "010100011101\n" +
            "100111110110\n" +
            "111010000001\n" +
            "001001111111\n" +
            "010100001111\n" +
            "011111101011\n" +
            "011000011011\n" +
            "111010000100\n" +
            "110001001111\n" +
            "111011011010\n" +
            "001110001110\n" +
            "100100101001\n" +
            "101101101001\n" +
            "001100001001\n" +
            "001000001110\n" +
            "101111000010\n" +
            "000110001110\n" +
            "101111110010\n" +
            "110011001011\n" +
            "000000010100\n" +
            "110100110001\n" +
            "111000011111\n" +
            "100000001110\n" +
            "100100011011\n" +
            "101100100011\n" +
            "011101000010\n" +
            "001100100101\n" +
            "111110101101\n" +
            "011100001001\n" +
            "101100000110\n" +
            "101011010011\n" +
            "000101101100\n" +
            "001011101001\n" +
            "110000000101\n" +
            "011111011110\n" +
            "000001100110\n" +
            "100110011011\n" +
            "111010100100\n" +
            "011001101001\n" +
            "010111110011\n" +
            "110111000000\n" +
            "011100101011\n" +
            "010110100111\n" +
            "110011001001\n" +
            "000010111011\n" +
            "101110010110\n" +
            "000001011001\n" +
            "100101000111\n" +
            "110110111011\n" +
            "000101110001\n" +
            "100000111101\n" +
            "011110001011\n" +
            "000101010101\n" +
            "101011110011\n" +
            "000110011001\n" +
            "101010000001\n" +
            "100001011110\n" +
            "010000000111\n" +
            "000011100110\n" +
            "100111100010\n" +
            "110101000111\n" +
            "001010101110\n" +
            "111000100000\n" +
            "001100101101\n" +
            "000111010111\n" +
            "101110000000\n" +
            "011111000010\n" +
            "111000001110\n" +
            "001100110101\n" +
            "101001000100\n" +
            "010111011101\n" +
            "000100000100\n" +
            "111111000111\n" +
            "111011001111\n" +
            "101000011110\n" +
            "110011101101\n" +
            "111101000011\n" +
            "101101111001\n" +
            "010010010101\n" +
            "110000100010\n" +
            "000100100111\n" +
            "000110111111\n" +
            "000011001000\n" +
            "011011100001\n" +
            "101100111101\n" +
            "011111000001\n" +
            "000110101100\n" +
            "010010111001\n" +
            "111100101110\n" +
            "100111010100\n" +
            "011111000000\n" +
            "001011001000\n" +
            "101111000011\n" +
            "000100001010\n" +
            "110100010000\n" +
            "110001000011\n" +
            "010010101111\n" +
            "001010001010\n" +
            "010001110001\n" +
            "011000001101\n" +
            "101001010111\n" +
            "000000011100\n" +
            "010011111000\n" +
            "110010011011\n" +
            "001110100111\n" +
            "011101000011\n" +
            "111110011101\n" +
            "100111000000\n" +
            "101011101110\n" +
            "111000010111\n" +
            "101001000011\n" +
            "011110011001\n" +
            "000100010001\n" +
            "101110000100\n" +
            "111101101101\n" +
            "000100100110\n" +
            "010011010001\n" +
            "000101100110\n" +
            "010111110001\n" +
            "001110111100\n" +
            "100000111111\n" +
            "101100000011\n" +
            "110011000100\n" +
            "100000001011\n" +
            "010101100000\n" +
            "101010000101\n" +
            "010110101101\n" +
            "010011100001\n" +
            "001101001111\n" +
            "101100100111\n" +
            "100000001101\n" +
            "100100101100\n" +
            "101111010111\n" +
            "010101001100\n" +
            "011001111111\n" +
            "010111110000\n" +
            "010100110101\n" +
            "101111010001\n" +
            "111101111100\n" +
            "011010011011\n" +
            "111100110100\n" +
            "111110001010\n" +
            "011110011111\n" +
            "000110001100\n" +
            "011001010111\n" +
            "000010010111\n" +
            "011100101111\n" +
            "111110111000\n" +
            "110010110010\n" +
            "000101111010\n" +
            "001010010100\n" +
            "100110110001\n" +
            "101101010001\n" +
            "100001111011\n" +
            "010101001001\n" +
            "000001000010\n" +
            "100101100011\n" +
            "010100101010\n" +
            "001001001100\n" +
            "101000110110\n" +
            "111110001000\n" +
            "100101110010\n" +
            "001000111011\n" +
            "100111010111\n" +
            "000000110000\n" +
            "110101111000\n" +
            "011000101110\n" +
            "110101001111\n" +
            "101000010010\n" +
            "101011000010\n" +
            "100110000111\n" +
            "110101011001\n" +
            "110010010100\n" +
            "010000001111\n" +
            "110011011001\n" +
            "111010110100\n" +
            "010000101010\n" +
            "101100111011\n" +
            "000000011010\n" +
            "110110001000\n" +
            "001011011011\n" +
            "101110100001\n" +
            "010100011011\n" +
            "111101001101\n" +
            "010000011001\n" +
            "110010100100\n" +
            "101101011010\n" +
            "110000100001\n" +
            "010101111000\n" +
            "101000111010\n" +
            "011011010100\n" +
            "011110011101\n" +
            "010000100100\n" +
            "001111101001\n" +
            "010011110000\n" +
            "111000100111\n" +
            "010101010101\n" +
            "000001001010\n" +
            "010001001100\n" +
            "111011111100\n" +
            "001110000011\n" +
            "110101101000\n" +
            "111010011110\n" +
            "110011010011\n" +
            "001010101101\n" +
            "001111110001\n" +
            "110001011110\n" +
            "011110010001\n" +
            "010010000100\n" +
            "111010111001\n" +
            "000100111111\n" +
            "000001010101\n" +
            "001010110111\n" +
            "000110010011\n" +
            "000010011111\n" +
            "011110100001\n" +
            "011111010110\n" +
            "001110010110\n" +
            "001001000011\n" +
            "101111011101\n" +
            "011100110111\n" +
            "010000001101\n" +
            "010010100111\n" +
            "010000110011\n" +
            "011110110111\n" +
            "010000110110\n" +
            "011101011011\n" +
            "000010100001\n" +
            "001100011111\n" +
            "011110110000\n" +
            "111011011011\n" +
            "101011101111\n" +
            "010001000101\n" +
            "010100001000\n" +
            "010100101110\n" +
            "001000000101\n" +
            "001001011011\n" +
            "111001000101\n" +
            "110101110100\n" +
            "111111010111\n" +
            "101010100111\n" +
            "110000011010\n" +
            "000100100000\n" +
            "011101000001\n" +
            "000011000001\n" +
            "010101010001\n" +
            "010010011100\n" +
            "010001110101\n" +
            "010110110111\n" +
            "010011110010\n" +
            "011011100110\n" +
            "000110100011\n" +
            "100010100011\n" +
            "101111110011\n" +
            "001011100101\n" +
            "011101110000\n" +
            "110001110000\n" +
            "111010010000\n" +
            "111111000011\n" +
            "010010001100\n" +
            "010111101010\n" +
            "010010101000\n" +
            "111001010111\n" +
            "010110110011\n" +
            "001101110010\n" +
            "011111001111\n" +
            "010100110100\n" +
            "010010100100\n" +
            "101011101100\n" +
            "000111101001\n" +
            "000001011010\n" +
            "101010111000\n" +
            "100011111111\n" +
            "100100011111\n" +
            "111000010010\n" +
            "011011100010\n" +
            "000111010010\n" +
            "101010101111\n" +
            "010000100101\n" +
            "100110110101\n" +
            "011011100011\n" +
            "011011110011\n" +
            "111011000100\n" +
            "100010001010\n" +
            "110000010000\n" +
            "100101011111\n" +
            "101100001100\n" +
            "111110101111\n" +
            "100111000100\n" +
            "011101001110\n" +
            "100011011101\n" +
            "111101011010\n" +
            "110101111001\n" +
            "001000110101\n" +
            "111110101100\n" +
            "001010010111\n" +
            "100110000000\n" +
            "110101010100\n" +
            "110110001101\n" +
            "011110101101\n" +
            "100110101110\n" +
            "000000000010\n" +
            "011010111001\n" +
            "000001101111\n" +
            "000100000101\n" +
            "110000100011\n" +
            "001010000101\n" +
            "100111011010\n" +
            "000001101001\n" +
            "001011000001\n" +
            "000111100110\n" +
            "111111110011\n" +
            "000101000000\n" +
            "111000110000\n" +
            "000010000111\n" +
            "000101010001\n" +
            "000011110001\n" +
            "101100110100\n" +
            "100001111110\n" +
            "001111111111\n" +
            "100011000110\n" +
            "011100011001\n" +
            "101011110100\n" +
            "001010001111\n" +
            "100010100001\n" +
            "001111100110\n" +
            "010110110010\n" +
            "110010110101\n" +
            "011000110011\n" +
            "000101011110\n" +
            "101000100100\n" +
            "010110010110\n" +
            "001000000110\n" +
            "110000100100\n" +
            "011101101011\n" +
            "100100000111\n" +
            "000111010101\n" +
            "110111000100\n" +
            "001010110000\n" +
            "101001110001\n" +
            "001001101011\n" +
            "101000100101\n" +
            "111111000010\n" +
            "000010110101\n" +
            "110000000110\n" +
            "000100110000\n" +
            "111111011011\n" +
            "101101100101\n" +
            "011001010010\n" +
            "111111101111\n" +
            "000111101101\n" +
            "100110110011\n" +
            "110000001000\n" +
            "111000001101\n" +
            "110011010010\n" +
            "110110111110\n" +
            "000001011111\n" +
            "001100001010\n" +
            "111101011100\n" +
            "010010100010\n" +
            "110100011011\n" +
            "110001101011\n" +
            "010111111010\n" +
            "011111100100\n" +
            "001010010110\n" +
            "001010111111\n" +
            "111110111110\n" +
            "011010000110\n" +
            "111111111001\n" +
            "011011011110\n" +
            "001010011101\n" +
            "001110010111\n" +
            "001001111100\n" +
            "110010111000\n" +
            "000111000100\n" +
            "001100001000\n" +
            "110110110100\n" +
            "101001010000\n" +
            "000101000101\n" +
            "010101101100\n" +
            "101010110110\n" +
            "111101011000\n" +
            "101010011100\n" +
            "110010110011\n" +
            "111110001110\n" +
            "100100101110\n" +
            "001010000000\n" +
            "001000110010\n" +
            "101000111111\n" +
            "111110111101\n" +
            "000110010110\n" +
            "101100100110\n" +
            "100010011001\n" +
            "100110100010\n" +
            "111101100110\n" +
            "111100111111\n" +
            "010111011011\n" +
            "111100011111\n" +
            "001010010011\n" +
            "111101010010\n" +
            "110111001010\n" +
            "010110000000\n" +
            "011111011001\n" +
            "101011100011\n" +
            "011100110011\n" +
            "111100011110\n" +
            "101001001001\n" +
            "100101100110\n" +
            "000100110010\n" +
            "010011101110\n" +
            "000011110111\n" +
            "000000011111\n" +
            "110011011100\n" +
            "111110100100\n" +
            "101110101111\n" +
            "001101011000\n" +
            "101101110001\n" +
            "101011000100\n" +
            "111001101100\n" +
            "110111111001\n" +
            "011010101001\n" +
            "000000000000\n" +
            "111100000101\n" +
            "110010111001\n" +
            "000100001110\n" +
            "110101111100\n" +
            "110010011111\n" +
            "001001110111\n" +
            "111111111111\n" +
            "000110011100\n" +
            "110101111010\n" +
            "011010111011\n" +
            "111000000101\n" +
            "011110100111\n" +
            "001010101111\n" +
            "001011011001\n" +
            "101010001011\n" +
            "100001000000\n" +
            "111110111010\n" +
            "001110111110\n" +
            "000000110100\n" +
            "111110111001\n" +
            "111000010101\n" +
            "110011110111\n" +
            "110111001101\n" +
            "111011010010\n" +
            "110100000110\n" +
            "100111111100\n" +
            "010001100010\n" +
            "111100010000\n" +
            "100111011101\n" +
            "101001000111\n" +
            "111110110011\n" +
            "010101010100\n" +
            "101000110111\n" +
            "000111101100\n" +
            "100001011001\n" +
            "010000011111\n" +
            "000100101011\n" +
            "011011011010\n" +
            "001111000010\n" +
            "111001101011\n" +
            "100011010111\n" +
            "110111100111\n" +
            "100001010110\n" +
            "100001110101\n" +
            "100110110111\n" +
            "011111111011\n" +
            "111111101110\n" +
            "111111001000\n" +
            "101010000110\n" +
            "110010010110\n" +
            "100110100111\n" +
            "011101011100\n" +
            "011010011101\n" +
            "101111101101\n" +
            "110111010110\n" +
            "110000000100\n" +
            "110000110100\n" +
            "001100000110\n" +
            "001011001101\n" +
            "001010011111\n" +
            "011001110000\n" +
            "100111100100\n" +
            "001111000000\n" +
            "110100011001\n" +
            "110000110011\n" +
            "000000101101\n" +
            "111101111111\n" +
            "111111010010\n" +
            "011101101110\n" +
            "111101101100\n" +
            "100000110000\n" +
            "110101010001\n" +
            "101001110100\n" +
            "010010110110\n" +
            "111011000111\n" +
            "101100000100\n" +
            "010011010101\n" +
            "111101000001\n" +
            "101001111000\n" +
            "101110000011\n" +
            "001011011101\n" +
            "111010000010\n" +
            "001001110100\n" +
            "111111001001\n" +
            "001001010000\n" +
            "001110000001\n" +
            "111100000000\n" +
            "010101110100\n" +
            "000101011011\n" +
            "001100011001\n" +
            "001110001100\n" +
            "001110100010\n" +
            "000000100111\n" +
            "000100111000\n" +
            "110100101100\n" +
            "110100111010\n" +
            "111001101101\n" +
            "111100101011\n" +
            "011101100000\n" +
            "100000100011\n" +
            "010111110010\n" +
            "010011001000\n" +
            "101001100110\n" +
            "100110001111\n" +
            "000110110101\n" +
            "111001110110\n" +
            "000101010110\n" +
            "011000011010\n" +
            "010100110110\n" +
            "110100111111\n" +
            "111000110011\n" +
            "001011111000\n" +
            "001000000000\n" +
            "111111010100\n" +
            "111111100110\n" +
            "000000001111\n" +
            "110001000001\n" +
            "010000101000\n" +
            "101111111010\n" +
            "100100001101\n" +
            "111011110100\n" +
            "110101110011\n" +
            "010111111110\n" +
            "001000101111\n" +
            "100110101100\n" +
            "110010010010\n" +
            "010010001000\n" +
            "011111101100\n" +
            "111100100011\n" +
            "110111101000\n" +
            "100000111001\n" +
            "001011100011\n" +
            "001010111100\n" +
            "000100001100\n" +
            "010111000110\n" +
            "001111000101\n" +
            "001110000010\n" +
            "110100101000\n" +
            "001110000101\n" +
            "101000110000\n" +
            "001001011101\n" +
            "101001011001\n" +
            "011110100011\n" +
            "101010010110\n" +
            "101000001101\n" +
            "110111111111\n" +
            "010010001101\n" +
            "011100010110\n" +
            "000100100001\n" +
            "001111111101\n" +
            "001001111000\n" +
            "001100101111\n" +
            "111010111100\n" +
            "110100010111\n" +
            "000000010011\n" +
            "100110110000\n" +
            "101100101111\n" +
            "100011010100\n" +
            "001001101110\n" +
            "110001101000\n" +
            "110101101110\n" +
            "010011110101\n" +
            "010000110001\n" +
            "100011111000\n" +
            "111110000010\n" +
            "100111100000\n" +
            "100001100110\n" +
            "110111000110\n" +
            "000101100011\n" +
            "010110001100\n" +
            "100000100010\n" +
            "001011000000\n" +
            "110101000010\n" +
            "101110101001\n" +
            "011010100110\n" +
            "111111110000\n" +
            "001010110010\n" +
            "010000001011\n" +
            "100000010011\n" +
            "010111010111\n" +
            "101111100010\n" +
            "010100010011\n";
}