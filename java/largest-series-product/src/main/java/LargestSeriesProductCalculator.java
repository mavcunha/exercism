import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.rangeClosed;

public class LargestSeriesProductCalculator {

    private final long[] digits;

    public LargestSeriesProductCalculator(String digits) {
        ensure(digits != null, "String to search must be non-null.");
        ensure(digits.matches("^\\d*$"), "String to search may only contains digits.");

        this.digits = digits.chars().boxed()
                .mapToLong(Character::getNumericValue)
                .toArray();
    }

    public long calculateLargestProductForSeriesLength(int w) {
        ensure(w <= digits.length, "Series length must be less than or equal to the length of the string to search.");
        ensure(!(w < 0), "Series length must be non-negative.");

        return rangeClosed(0, digits.length - w)
                .mapToLong(i ->
                        stream(copyOfRange(digits, i, i + w))
                        .reduce((a, b) -> a * b).orElse(1))
                .sorted().max().orElse(0);
    }

    private void ensure(boolean test, final String message) {
        if(!test) {
            throw new IllegalArgumentException(message);
        }
    }
}
