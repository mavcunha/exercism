import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class HandshakeCalculator {

    private static final int REVERSE_POSITION = 4;
    private Signal[] signals = Signal.values();

    public List<Signal> calculateHandshake(int number) {
        return signals(number)
                .filter(idx -> isBitSetOn(number, idx))
                .mapToObj(idx -> signals[idx])
                .collect(Collectors.toList());
    }

    private IntStream signals(int number) {
        IntStream range = IntStream.range(0, signals.length);
        return isBitSetOn(number, REVERSE_POSITION) ? range.map(i -> signals.length - i - 1) : range;
    }

    private boolean isBitSetOn(int number, int pos) {
        return ((number >> pos) & 1) == 1;
    }
}
