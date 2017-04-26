import java.util.Arrays;
import java.util.stream.IntStream;

public class SumOfMultiples {

    private final int number;
    private final int[] multiples;

    public SumOfMultiples(int number, int[] multiples) {
        this.number = number;
        this.multiples = multiples;
    }

    public int getSum() {
        return IntStream.range(1, number)
                .filter(this::multipleOfAny).sum();
    }

    private boolean multipleOfAny(int i) {
        return Arrays.stream(multiples).anyMatch(m -> i % m == 0);
    }
}
