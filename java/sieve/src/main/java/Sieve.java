import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.rangeClosed;

public class Sieve {

    private List<Integer> primes = new ArrayList<>();

    public Sieve(int number) {
        int sqrt = (int) Math.sqrt((double) number);

        Set<Integer> composites = rangeClosed(2, sqrt).boxed()
                .flatMap(n -> rangeClosed(n, number).boxed().map(m -> n * m).filter(j -> j <= number))
                .collect(Collectors.toSet());

        primes = rangeClosed(2, number).boxed()
                .filter(n -> !composites.contains(n)).collect(Collectors.toList());
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
