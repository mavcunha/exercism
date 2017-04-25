import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scrabble {

    private final Map<Character, Integer> points = Stream.of(
            lettersPoints("AEIOULNRST", 1),
            lettersPoints("DG", 2),
            lettersPoints("BCMP", 3),
            lettersPoints("FHVWY", 4),
            lettersPoints("K", 5),
            lettersPoints("JX", 8),
            lettersPoints("QZ", 10)
    ).collect(HashMap::new, Map::putAll, Map::putAll);

    private String input;

    public Scrabble(String input) {
        this.input = Optional.ofNullable(input).orElse("");
    }

    public int getScore() {
        return input.trim().chars()
                .reduce(0, (l, r) -> l + points.get(Character.toUpperCase((char) r)));
    }

    private Map<Character, Integer> lettersPoints(String letters, int points) {
        return letters.chars()
                .mapToObj(c1 -> ((char) c1))
                .collect(Collectors.toMap(Function.identity(), s -> points));
    }
}
