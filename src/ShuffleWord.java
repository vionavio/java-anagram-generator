public class ShuffleWord {
    private int index;
    private Character letter_key;
    private Character letter_mask;

    public ShuffleWord(int index, Character letter_key, Character letter_mask) {
        this.index = index;
        this.letter_key = letter_key;
        this.letter_mask = letter_mask;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Character getLetter_key() {
        return letter_key;
    }

    public void setLetter_key(Character letter_key) {
        this.letter_key = letter_key;
    }

    public Character getLetter_mask() {
        return letter_mask;
    }

    public void setLetter_mask(Character letter_mask) {
        this.letter_mask = letter_mask;
    }

    @Override
    public String toString() {
        return "ShuffleWord{" +
                "index=" + index +
                ", letter_key=" + letter_key +
                ", letter_mask=" + letter_mask +
                '}';
    }
}
