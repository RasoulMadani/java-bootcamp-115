package q01.commonClassess;

public class CheckIsDigit {
    public static boolean checkForDigit(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkForAtSign(String input) {
        for (char c : input.toCharArray()) {
            if (c=='@') {
                return true;
            }
        }
        return false;
    }
}
