import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;
import static java.util.stream.Stream.of;

public class DNA {

    private final Map<Character, Integer> counting;

    public DNA(String dna) {
        counting = dna.chars().mapToObj(c -> ((char) c))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.reducing(0, i -> 1, Integer::sum)));

        of('A','C','G','T').forEach(n -> counting.computeIfAbsent(n, i -> 0));
    }

    public int count(char n) {
        return ofNullable(counting.get(n)).orElseThrow(IllegalArgumentException::new);
    }

    public Map<Character, Integer> nucleotideCounts() {
        return counting;
    }
}
