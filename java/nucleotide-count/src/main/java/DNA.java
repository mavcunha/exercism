import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DNA {

    private final Map<Character, Integer> counting;

    public DNA(String dna) {
        counting = dna.chars().mapToObj(c -> ((char) c))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.reducing(0, i -> 1, Integer::sum)));

        Stream.of('A','C','G','T')
                .filter(e -> !counting.containsKey(e))
                .forEach(e -> counting.put(e, 0));
    }

    public int count(char n) {
        return Optional.ofNullable(counting.get(n))
                .orElseThrow((Supplier<RuntimeException>) IllegalArgumentException::new);
    }

    public Map<Character, Integer> nucleotideCounts() {
        return counting;
    }

}
