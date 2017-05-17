import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.*;

final class DiamondPrinter {

    public List<String> printToList(char c) {
        IntStream ay = range('A', c);
        IntStream za = rangeClosed('A', c).map(z -> c - z + 'A');

        return concat(ay, za)
                .mapToObj(z -> diamondLine(c, (char) z))
                .collect(Collectors.toList());
    }

    private String diamondLine(char last, char curr) {
        List<String> line = emptyLine(last - 'A' + 1);

        int lastIdx = line.size() - 1;

        line.set(lastIdx - (curr - 'A'), String.valueOf(curr));

        return Stream.of(line, reverse(line.subList(0, lastIdx)))
                .flatMap(List::stream)
                .collect(Collectors.joining());
    }

    private List<String> reverse(List<String> line) {
        List<String> reversed = new ArrayList<>(line);
        Collections.reverse(reversed);
        return reversed;
    }

    private List<String> emptyLine(int size) {
        return new ArrayList<>(Collections.nCopies(size, " "));
    }
}
