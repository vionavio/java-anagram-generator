public class StringIndex {
    public static void main(String[] args) {
        String apa = "apa";
        StringBuilder newApa = new StringBuilder(apa);
        newApa.setCharAt(0, 'p');
        System.out.println(apa);
        System.out.println(newApa);
    }
}
