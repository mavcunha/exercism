import static java.lang.Math.sqrt;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.rangeClosed;

public class PrimeCalculator {

    public int nth(int i) {
        if(!(i > 0)) throw new IllegalArgumentException();

        return iterate(2, n -> n + 1).filter(this::isPrime)
                .limit(i).reduce((f, s) -> s).getAsInt();
    }

    private boolean isPrime(int n) {
        return rangeClosed(2, (int) sqrt(n)).noneMatch(i -> n % i == 0);
    }

}
