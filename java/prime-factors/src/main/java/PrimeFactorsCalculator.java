import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsCalculator {
    public List<Long> calculatePrimeFactorsOf(long input) {
        List<Long> longs = new ArrayList<>();
        for (long i = 2; i <= input; i++) {
            if (input % i == 0) {
                input = input / i;
                longs.add(i);
                i--;
            }
        }
        return longs;
    }
}
