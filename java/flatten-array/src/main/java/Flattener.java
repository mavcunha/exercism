import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class Flattener {

    public List<Object> flatten(List<Object> list) {
        return flatList(list).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private Stream<Object> flatList(Object f) {
        return f instanceof List ? List.class.cast(f).stream().flatMap(this::flatList) : Stream.of(f);
    }
}
