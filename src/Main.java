import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Main {
    private static String mainWord = "mahru";
    private static ArrayList<Similiar> similarList = new ArrayList<>();
    private static ArrayList<Character> similarKeys = new ArrayList<>();
    private static ArrayList<ShuffleWord> shuffleWordArrayList = new ArrayList<>();
    private static ArrayList<String> shuffledWords = new ArrayList<>();
    private static ArrayList<ArrayList<Boolean>> possibilities = new ArrayList<ArrayList<Boolean>>();

    public static void main(String[] args) {
        prepare();
        for (int i = 0; i < mainWord.length(); i++) {
            if (similarKeys.contains(mainWord.charAt(i))) {
                shuffleWordArrayList.add(new ShuffleWord(
                        i,
                        mainWord.charAt(i),
                        getMaskCharacterFromSimilar(mainWord.charAt(i))
                ));
            }
        }
        generatePossibilities();
//        System.out.println(shuffleWordArrayList);
        generateShuffleWords();
//        System.out.println(shuffleWordArrayList.size());
//        System.out.println(possibilities);
        removeDuplicates();
    }

    private static void prepare() {
        similarList.add(new Similiar('a', 'e'));
        similarList.add(new Similiar('u', 'n'));
        similarList.add(new Similiar('m', 'w'));
        similarList.add(new Similiar('n', 'u'));

        for (Similiar similiar : similarList) {
            similarKeys.add(similiar.getLetterKey());
        }
    }

    private static Character getMaskCharacterFromSimilar(Character character) {
        Character foundCharacter = ' ';
        for (Similiar similiar : similarList) {
            if (similiar.getLetterKey().equals(character)) {
                foundCharacter = similiar.getLetterMask();
            }
        }
        return foundCharacter;
    }

    private static void generatePossibilities() {
        final int n = shuffleWordArrayList.size();
        for (int i = 0; i < Math.pow(2, n); i++) {
            StringBuilder bin = new StringBuilder(Integer.toBinaryString(i));
            while (bin.length() < n)
                bin.insert(0, "0");
            char[] chars = bin.toString().toCharArray();

            boolean[] boolArray = new boolean[n];
            for (int j = 0; j < chars.length; j++) {
                boolArray[j] = chars[j] == '1';
            }
            ArrayList<Boolean> boolArray2 = new ArrayList<>();
            for (Boolean value : boolArray) {
                boolArray2.add(value);
            }
            possibilities.add(boolArray2);
        }
    }

    private static void generateShuffleWords() {
        for (ArrayList<Boolean> possibilityList: possibilities) {
            StringBuilder newWord = new StringBuilder(mainWord);
            Iterator<Boolean> possibilityIterator = possibilityList.iterator();
            Iterator<ShuffleWord> shuffleWordIterator = shuffleWordArrayList.iterator();

            while (possibilityIterator.hasNext() && shuffleWordIterator.hasNext()) {
                Boolean isMask = possibilityIterator.next();
                ShuffleWord shuffleWord = shuffleWordIterator.next();

                if (isMask) {
                    newWord.setCharAt(shuffleWord.getIndex(), shuffleWord.getLetter_mask());
//                    newWord.indexOf(shuffleWord.getIndex()) = shuffleWord.getLetter_mask();
                    shuffledWords.add(String.valueOf(newWord));
                }
            }
        }
    }

    private static void removeDuplicates() {
        LinkedHashSet<String> uniqueShuffledWords = new LinkedHashSet<>(shuffledWords);
        System.out.println(shuffledWords);
        System.out.println(shuffledWords.size());
        System.out.println(uniqueShuffledWords);
        System.out.println(uniqueShuffledWords.size());
    }
}
