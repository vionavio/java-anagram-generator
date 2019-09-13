public class Similiar {
    private Character letterKey;
    private Character letterMask;

    public Similiar(Character letterKey, Character letterMask) {
        this.letterKey = letterKey;
        this.letterMask = letterMask;
    }

    public Character getLetterKey() {
        return letterKey;
    }

    public void setLetterKey(Character letterKey) {
        this.letterKey = letterKey;
    }

    public Character getLetterMask() {
        return letterMask;
    }

    public void setLetterMask(Character letterMask) {
        this.letterMask = letterMask;
    }
}
