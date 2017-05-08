import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sieve {

    private final List<Integer> notPrimes = new ArrayList<>();
    private final int number;

    public Sieve(int number) {
        this.number = number;

        int sqrt = (int) Math.sqrt((double) this.number);

        IntStream.rangeClosed(2, sqrt)
                .flatMap(n -> IntStream.rangeClosed(2, number).map(m -> n*m))
                .forEach(notPrimes::add);
    }

    public List<Integer> getPrimes() {
        return IntStream.rangeClosed(2, number).boxed().filter(n -> !notPrimes.contains(n)).collect(Collectors.toList());
    }
}
