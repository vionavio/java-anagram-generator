package combination;

import java.util.ArrayList;

public class StringCombination {
    static String[] elements = {"a", "b"};
    static int maxLength = 2;
    static ArrayList<String> combinedLetter = new ArrayList<>();

    public static void main(String[] args) {
        combineStringFromElements(elements, "", maxLength);
        System.out.println(combinedLetter);
    }

    private static void combineStringFromElements(String[] elements, String currentString, int maxLength) {
        if (currentString.length() == maxLength) {
            combinedLetter.add(currentString);
            System.out.println(currentString);
            return;
        }
        for (String element : elements) {
            combineStringFromElements(elements, currentString + element, maxLength);
        }
    }
}
