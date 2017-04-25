import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class DifferenceOfSquaresCalculator {

    public int computeSquareOfSumTo(int number) {
        return IntStream.rangeClosed(1, number).boxed().collect(
                Collectors.collectingAndThen(Collectors.summingInt(a -> a),i -> i * i));
    }

    public int computeSumOfSquaresTo(int number) {
        return IntStream.rangeClosed(1, number).map(a -> a * a).sum();
    }

    public int computeDifferenceOfSquares(int number) {
        return computeSquareOfSumTo(number) - computeSumOfSquaresTo(number);
    }
}
