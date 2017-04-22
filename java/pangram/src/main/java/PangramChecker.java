import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class PangramChecker {

    private List<Character> atLeastOnceChars;

    public PangramChecker() {
        atLeastOnceChars = "abcdefghijklmnopqrstuvxywz".chars()
                .mapToObj(c -> ((char) c))
                .collect(Collectors.toList());
    }

    public boolean isPangram(String input) {
        final char[] inputChars = input.toLowerCase(Locale.ENGLISH).toCharArray();

        return remainingMandatoryChars(inputChars) == 0;
    }

    private int remainingMandatoryChars(char[] inputChars) {
        List<Character> atLeastOnce = newListCopy(this.atLeastOnceChars);
        for (int i = 0; i < inputChars.length && atLeastOnce.size() != 0; i++) {
            atLeastOnce.remove(Character.valueOf(inputChars[i]));
        }
        return atLeastOnce.size();
    }

    private List<Character> newListCopy(List<Character> orig) {
        return new ArrayList<>(orig);
    }
}
