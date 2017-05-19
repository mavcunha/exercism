import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsCalculator {
    public List<Long> calculatePrimeFactorsOf(long input) {
        List<Long> longs = new ArrayList<>();
        for (long factor = 2; factor <= input; factor++) {
            if (input % factor == 0) {
                input = input / factor;
                longs.add(factor);
                factor--;
            }
        }
        return longs;
    }
}
