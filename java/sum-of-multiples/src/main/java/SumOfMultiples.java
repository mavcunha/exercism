import java.util.Arrays;

public class SumOfMultiples {

    private final int number;
    private final int[] multiples;

    public SumOfMultiples(int number, int[] multiples) {
        this.number = --number; // open interval
        this.multiples = multiples;
    }

    public int getSum() {
        if (multiples.length == 0) {
            return 0;
        }

        int lcm = lcm(multiples);
        int sub = sumMultiplesOf(number, lcm);

        if(lcm == 1) {
            sub = 0;
        }

        int sum = Arrays.stream(multiples)
                .map(n -> sumMultiplesOf(number, n))
                .sum();

        return sum - sub;
    }

    private int lcm(int[] numbers) {
        return Arrays.stream(numbers).reduce(1, (k, j) -> (k * j) / gcd(k, j));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int sumMultiplesOf(int number, int multiple) {
        int n = Math.floorDiv(number, multiple);
        return multiple * (n * (n + 1)) / 2;
    }
}
