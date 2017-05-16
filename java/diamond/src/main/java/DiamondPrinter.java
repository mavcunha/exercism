import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.join;
import static java.util.stream.IntStream.concat;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

final class DiamondPrinter {


    public List<String> printToList(char c) {
        IntStream ay = range('A', c);
        IntStream za = rangeClosed('A', c).map(z -> c - z + 'A');

        return concat(ay, za).mapToObj(z -> diamondLine(c, z)).collect(Collectors.toList());
    }

    private String diamondLine(char c, int z) {
        Character ch = (char) z;

        int os = c - z;
        int is = 2 * (z - 'A') - 1;

        if(z == 'A') {
            return spaces(os) + ch + spaces(os);
        } else {
            return spaces(os) + ch + spaces(is) + ch + spaces(os);
        }
    }

    private String spaces(int i) {
        return join("", Collections.nCopies(i, " "));
    }
}
