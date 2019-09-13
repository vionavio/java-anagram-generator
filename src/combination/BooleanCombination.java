package combination;

import java.util.ArrayList;
import java.util.Arrays;

public class BooleanCombination {
    private static ArrayList<ArrayList<Boolean>> possibilities = new ArrayList<ArrayList<Boolean>>();
//    ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        final int n = 3;
        for (int i = 0; i < Math.pow(2, n); i++) {
            StringBuilder bin = new StringBuilder(Integer.toBinaryString(i));
            while (bin.length() < n)
                bin.insert(0, "0");
            char[] chars = bin.toString().toCharArray();
            System.out.println(Arrays.toString(chars));

            boolean[] boolArray = new boolean[n];
            for (int j = 0; j < chars.length; j++) {
                boolArray[j] = chars[j] == '1';
            }
            ArrayList<Boolean> boolArray2 = new ArrayList<>();
            for (Boolean value: boolArray) {
                boolArray2.add(value);
            }
//            System.out.println(Arrays.toString(boolArray));
            possibilities.add(boolArray2);
//            System.out.println(boolArray2);
        }
        System.out.println(possibilities);
    }
}
