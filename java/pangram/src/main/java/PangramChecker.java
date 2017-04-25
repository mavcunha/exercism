import java.util.*;
import java.util.stream.Collectors;

public class PangramChecker {

    private List<String> atLeastOnceChars =
            Arrays.stream("abcdefghijklmnopqrstuvxywz".split("")).collect(Collectors.toList());

    public boolean isPangram(String input) {
        return atLeastOnceChars.stream()
                .allMatch(Arrays.stream(input.toLowerCase().split(""))
                        .collect(Collectors.toSet())::contains);

    }
}
