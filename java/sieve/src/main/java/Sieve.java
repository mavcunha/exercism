import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.rangeClosed;

public class Sieve {

    private List<Integer> primes = new ArrayList<>();

    public Sieve(int number) {
        int sqrt = (int) Math.sqrt((double) number);

        primes = upTo(number)
                .filter(k -> upTo(sqrt)
                        .flatMap(n -> upTo(number)
                                .map(m -> n * m)
                                .filter(j -> j <= number))
                        .noneMatch(l -> k == l))
                .boxed().collect(Collectors.toList());
    }

    private IntStream upTo(int number) {
        return rangeClosed(2, number);
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
