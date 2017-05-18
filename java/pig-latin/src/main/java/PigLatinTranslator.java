import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class PigLatinTranslator {

    private static final String VOWELS_PATTERN = "(?i)^(?:[aeiou]|yt|xr).*$";
    private static final String CONSONANTS_PATTERN = "(?i)^(?:u.*q|h.*t)$";

    public String translate(String phrase) {
        return stream(phrase.split(" ")).map(this::translateWord).collect(Collectors.joining(" "));
    }

    private String translateWord(String word) {
        if (shouldShiftChars(word)) {
            return translateWord(word.substring(1, word.length()) + word.charAt(0));
        } else {
            return word + "ay";
        }
    }

    private boolean shouldShiftChars(String phrase) {
        return !phrase.matches(VOWELS_PATTERN) || phrase.matches(CONSONANTS_PATTERN);
    }
}
