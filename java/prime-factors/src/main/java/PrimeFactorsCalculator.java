import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsCalculator {
    public List<Long> calculatePrimeFactorsOf(long number) {
        List<Long> factors = new ArrayList<>();
        for (long factor = 2; factor <= (long) Math.sqrt(number); factor++) {
            while (number % factor == 0) {
                number /= factor;
                factors.add(factor);
            }
        }
        if (number > 1) {
            factors.add(number);
        }
        return factors;
    }
}
