import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaindropConverter {
    public String convert(int number) {
        List<Integer> collect = IntStream.range(1, number+1)
                .filter(i -> number % i == 0)
                .boxed()
                .collect(Collectors.toList());
        String collect1 = collect.stream()
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) {
                        return integer == 3 ? "Pling" : integer == 5 ? "Plang" : integer == 7 ? "Plong" : "";
                    }
                }).collect(Collectors.joining());

        return collect1.isEmpty() ? String.valueOf(number) : collect1;
    }
}
