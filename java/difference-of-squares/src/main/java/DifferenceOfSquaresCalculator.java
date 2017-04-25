import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.summingInt;

public final class DifferenceOfSquaresCalculator {

    public int computeSquareOfSumTo(int number) {
        return until(number).boxed()
                .collect(collectingAndThen(summingInt(a -> a), this::square));
    }

    public int computeSumOfSquaresTo(int number) {
        return until(number).map(this::square).sum();
    }

    public int computeDifferenceOfSquares(int number) {
        return computeSquareOfSumTo(number) - computeSumOfSquaresTo(number);
    }

    private int square(Integer i) {
        return i * i;
    }

    private IntStream until(int number) {
        return IntStream.rangeClosed(1, number);
    }
}
