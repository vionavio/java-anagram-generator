import java.util.ArrayList;

public class Main {
    private static String mainWord = "mahru";
    private static ArrayList<Similiar> similiars = new ArrayList<>();
    private static ArrayList<Character> similiarKeys = new ArrayList<>();
    private static ArrayList<ShuffleWord> shuffleWordArrayList = new ArrayList<>();
    private static ArrayList<ShuffleWord> shuffledWords = new ArrayList<>();
    private static ArrayList<Boolean> possibility = new ArrayList<>();
    private static ArrayList<ArrayList<Boolean>> possibilities = new ArrayList<ArrayList<Boolean>>();

    public static void main(String[] args) {
        prepare();
        for (int i = 0; i < mainWord.length(); i++) {
            if (similiarKeys.contains(mainWord.charAt(i))) {
//                System.out.println(mainWord.charAt(i));
                shuffleWordArrayList.add(new ShuffleWord(
                        i,
                        mainWord.charAt(i),
                        getMaskCharacterFromSimilar(mainWord.charAt(i))
                ));
            }
        }
        generatePossibilities();
        System.out.println(shuffleWordArrayList);
//        System.out.println(shuffleWordArrayList.size());
//        System.out.println(possibilities);
    }

    private static void prepare() {
        similiars.add(new Similiar('a', 'e'));
        similiars.add(new Similiar('u', 'n'));
        similiars.add(new Similiar('m', 'w'));
        similiars.add(new Similiar('n', 'u'));

        for (Similiar similiar : similiars) {
            similiarKeys.add(similiar.getLetterKey());
        }

        possibility.add(true);
        possibility.add(false);
    }

    private static Character getMaskCharacterFromSimilar(Character character) {
        Character foundCharacter = ' ';
        for (Similiar similiar : similiars) {
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
//            System.out.println(Arrays.toString(chars));

            boolean[] boolArray = new boolean[n];
            for (int j = 0; j < chars.length; j++) {
                boolArray[j] = chars[j] == '1';
            }
            ArrayList<Boolean> boolArray2 = new ArrayList<>();
            for (Boolean value : boolArray) {
                boolArray2.add(value);
            }
//            System.out.println(Arrays.toString(boolArray));
            possibilities.add(boolArray2);
//            System.out.println(boolArray2);
        }
//        System.out.println(possibilities);
    }


}
