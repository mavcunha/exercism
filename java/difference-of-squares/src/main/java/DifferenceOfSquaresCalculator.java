import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.summingInt;

public final class DifferenceOfSquaresCalculator {

    public int computeSquareOfSumTo(int number) {
        return until(number).boxed()
                .collect(collectingAndThen(summingInt(a -> a), i -> i * i));
    }

    public int computeSumOfSquaresTo(int number) {
        return until(number).map(a -> a * a).sum();
    }

    public int computeDifferenceOfSquares(int number) {
        return computeSquareOfSumTo(number) - computeSumOfSquaresTo(number);
    }

    private IntStream until(int number) {
        return IntStream.rangeClosed(1, number);
    }
}
