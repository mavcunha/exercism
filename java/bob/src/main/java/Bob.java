import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class Bob {

    public String hey(String msg) {
        return Stream.of(
                silence("Fine. Be that way!"),
                yell("Whoa, chill out!"),
                question("Sure."))
                .map(f -> f.apply(msg))
                .filter(Objects::nonNull)
                .findFirst().orElse("Whatever.");
    }

    private Function<String, String> yell(String response) {
        return msg -> msg.equals(msg.toUpperCase()) && !msg.equals(msg.toLowerCase()) ?
                response : null;
    }

    private Function<String, String> silence(String response) {
        return msg -> msg.trim().isEmpty() ? response : null;
    }

    private Function<String, String> question(String response) {
        return msg -> msg.endsWith("?") ? response : null;
    }
}
