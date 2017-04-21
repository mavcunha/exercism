import java.util.Locale;

public class PangramChecker {

    private final String atLeastOnceChars = "abcdefghijklmnopqrstuvxywz";

    public boolean isPangram(String input) {
        final String lowerCaseInput = input.toLowerCase(Locale.ENGLISH);

        return atLeastOnceChars.chars().noneMatch(c -> isCharMissing((char) c, lowerCaseInput));
    }

    private boolean isCharMissing(char c, String input) {
        return input.indexOf(c) == -1;
    }
}
