import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.rangeClosed;

public class LargestSeriesProductCalculator {

    private static final String NON_NULL = "String to search must be non-null.";
    private static final String ONLY_DIGITS = "String to search may only contains digits.";
    private static final String SERIES_LESS_EQ_SEARCH = "Series length must be less than or equal to the length of the string to search.";
    private static final String SERIES_NON_NEGATIVE = "Series length must be non-negative.";

    private final long[] digits;

    public LargestSeriesProductCalculator(String digits) {
        ensure(digits != null, NON_NULL);
        ensure(digits.matches("^\\d*$"), ONLY_DIGITS);

        this.digits = digits.chars().boxed()
                .mapToLong(Character::getNumericValue)
                .toArray();
    }

    public long calculateLargestProductForSeriesLength(int w) {
        ensure(w <= digits.length, SERIES_LESS_EQ_SEARCH);
        ensure(!(w < 0), SERIES_NON_NEGATIVE);

        return rangeClosed(0, digits.length - w)
                .mapToLong(i ->
                        stream(copyOfRange(digits, i, i + w))
                        .reduce((a, b) -> a * b).orElse(1))
                .max().orElse(0);
    }

    private void ensure(boolean expected, final String message) {
        if(!expected) {
            throw new IllegalArgumentException(message);
        }
    }
}
