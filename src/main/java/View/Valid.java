package View;

public class Valid {

    public static boolean isEmpty(String input) {
        return input.equals("");
    }

    public static boolean isLetter(String input) {
        return !input.replaceAll("[0-9]", "").equals("");
    }

    public static boolean isNumberNotInRange(String input) {
        int size = Integer.parseInt(input);
        return !(size >= 3 && size <= 20);
    }

    public static boolean isNumber(String input) {
        return !input.replaceAll("[a-zA-Z]", "").equals("");
    }

    public static boolean isNotMoveLetter(String input) {
        return !(input.equals("U") || input.equals("D"));
    }

    public static boolean isNotCommandLetter(String input) {
        return !(input.equals("R") || input.equals("Q"));
    }
}
