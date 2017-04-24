import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Acronym {
    private final String phrase;

    public Acronym(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        String[] words = phrase.split("(?:\\s|-)");

        return Stream.of(words)
                .map(w -> w.replaceAll("^([A-Z])[A-Z].*(?!:)", "$1"))
                .map(w -> Character.toUpperCase(w.charAt(0)) + w.substring(1))
                .collect(Collectors.joining()).chars()
                .filter(Character::isUpperCase)
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.joining());
    }
}
