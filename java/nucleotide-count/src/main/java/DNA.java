import java.util.Map;
import java.util.function.Function;
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
        if(!Character.toString(n).matches("(?i)[acgt]"))
            throw new IllegalArgumentException();
        return counting.get(n);
    }

    public Map<Character, Integer> nucleotideCounts() {
        return counting;
    }
}
