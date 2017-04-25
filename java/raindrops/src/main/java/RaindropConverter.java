import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;

public class RaindropConverter {

    private final Map<Integer,String> sounds = new HashMap<Integer, String>(){{
        put(3, "Pling");
        put(5, "Plang");
        put(7, "Plong");
    }};

    public String convert(int number) {
        return IntStream.rangeClosed(1, number)
                .filter(i -> number % i == 0).boxed()
                .map(i -> sounds.getOrDefault(i, ""))
                .collect(collectingAndThen(
                        Collectors.joining(),
                        s -> s.isEmpty() ? String.valueOf(number) : s));
    }

}
