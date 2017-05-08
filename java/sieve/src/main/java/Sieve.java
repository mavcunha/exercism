import java.util.ArrayList;
import java.util.List;

public class Sieve {

    private final boolean[] primeIndex;

    public Sieve(int number) {
        primeIndex = new boolean[number + 1];

        int sqrt = (int) Math.sqrt((double) number);

        for (int i = 2; i <= sqrt; i++) {
            if (!primeIndex[i]) {
                for (int j = i*i, n = 0; j < primeIndex.length; j=i*i+n*i, n++) {
                    primeIndex[j] = true;
                }
            }
        }
    }

    public List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < primeIndex.length; i++) {
            if (!primeIndex[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
