import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.valueOf;
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
        char[] line = emptyLine(last - 'A' + 1);

        line[line.length - 1 - (curr - 'A')] = curr;

        return valueOf(line) + reverse(valueOf(line)).substring(1, line.length);
    }

    private String reverse(String line) {
        return new StringBuilder(line).reverse().toString();
    }

    private char[] emptyLine(int size) {
        return String.join("", Collections.nCopies(size, " ")).toCharArray();
    }
}
