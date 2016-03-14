//Project_3_StringsWords.

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        HashMap<String, Byte> wordsMap = new HashMap<>(10); // Map<String, its Value (type Byte)>
        wordsMap.put("one",   (byte)1);
        wordsMap.put("two",   (byte)2);
        wordsMap.put("three", (byte)3);
        wordsMap.put("four",  (byte)4);
        wordsMap.put("five",  (byte)5);
        wordsMap.put("six",   (byte)6);
        wordsMap.put("seven", (byte)7);
        wordsMap.put("eight", (byte)8);
        wordsMap.put("nine",  (byte)9);
        wordsMap.put("zero",  (byte)0);

        String[] wordsArray = {"onezero", "eightt", "three", "four", "fiveone", "sixsevenseven ", "seven!",
                               "zerozeroeightninesixoneonetwo", "nine", "zerozerooneonezeroonezero", "zerozeroonetwo",
                               "twofive", "threefiveone", "fourfivesix", "sevensevennineninenineoneone", "nineeightone", "eighttwoone"};

        Object[] intArray = new Object[wordsArray.length]; // Creation of the array of objects

        String maxNumber = getNumbers(wordsArray, wordsMap);
        System.out.println("The greatest length of a compound word is '" + maxNumber + "'.");
        System.out.println();
        System.out.println("The program was carried out " + (System.currentTimeMillis() - startTime) + " milliseconds.");
    }

//    In this method it is passed an array of strings and Map <String, value>.
//    By Character constructed string that is compared to the Map <String, value> takes her numerical value of
//    Map <String, value> and then selected the largest number, which corresponds to a string from an array of strings.

    private static String getNumbers(String[] stringArray, HashMap<String, Byte> wordsMap) {
        String maxStringNumber = stringArray[0];
        int maxNumber = 0;
        String string = "";
        for (byte i = 0; i < stringArray.length; i++) {
            char[] chr = stringArray[i].toCharArray();
            String stringNum = "";
            for (short j = 0; j < chr.length; j++) {
                if (chr[j] >= 'a' && chr[j] <= 'z') {
                    string += chr[j];
                }
                if (string != "" && string.length() >= 3) {
                    for (Map.Entry entry : wordsMap.entrySet()) {
                        if (string.equals(entry.getKey())) {
                            stringNum += entry.getValue().toString();
                            string = "";
                            break;
                        }
                    }
                }
            }
            if (Integer.valueOf(stringNum) >= maxNumber) {
                maxNumber = Integer.valueOf(stringNum);
                maxStringNumber = stringArray[i];
            }
            string = "";
        }
        return maxStringNumber;
    }

}