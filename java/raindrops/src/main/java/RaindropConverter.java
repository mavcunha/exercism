import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaindropConverter {
    public String convert(int number) {
        String collect = IntStream.range(1, number+1)
                .filter(i -> number % i == 0)
                .boxed()
                .map(this::soundOf)
                .collect(Collectors.joining());

        return collect.isEmpty() ? String.valueOf(number) : collect;
    }

    private String soundOf(Integer integer) {
        return integer == 3 ? "Pling" : integer == 5 ? "Plang" : integer == 7 ? "Plong" : "";
    }
}
