import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Acronym {

    public static final Pattern WORD_SPLIT = Pattern.compile("\\W");
    public static final Pattern CAMEL_CASE_SPLIT = Pattern.compile("(?=[A-Z][a-z]+)");

    private final String phrase;

    public Acronym(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return WORD_SPLIT.splitAsStream(phrase)
                .flatMap(CAMEL_CASE_SPLIT::splitAsStream)
                .map(w -> w.substring(0, 1).toUpperCase())
                .collect(Collectors.joining());
    }
}
