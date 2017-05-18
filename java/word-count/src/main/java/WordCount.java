import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class WordCount {
    public Map<String, Integer> phrase(String phrase) {
        return stream(phrase
                .toLowerCase()
                .replaceAll("\\p{Punct}", "")
                .split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.reducing(0, i -> 1, Integer::sum)));
    }
}
