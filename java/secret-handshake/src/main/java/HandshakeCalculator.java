import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class HandshakeCalculator {

    public static final int REVERSE_POSITION = 4;
    private Signal[] signals = {
            Signal.WINK,
            Signal.DOUBLE_BLINK,
            Signal.CLOSE_YOUR_EYES,
            Signal.JUMP};

    public List<Signal> calculateHandshake(int number) {
        return signalsRange(byteDefinedIn(number, REVERSE_POSITION))
                .filter(idx -> byteDefinedIn(number, idx))
                .mapToObj(idx -> signals[idx])
                .collect(Collectors.toList());
    }

    private IntStream signalsRange(boolean reverse) {
        IntStream range = IntStream.range(0, signals.length);
        return reverse ? range.map(i -> signals.length - i - 1) : range;
    }

    private boolean byteDefinedIn(int number, int pos) {
        return ((number >> pos) & 1) == 1;
    }
}
