import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Triangle {

    private final TriangleKind kind;

    private Map<Integer, TriangleKind> kindBySideDiff = new HashMap<Integer, TriangleKind>(){{
        put(1, TriangleKind.EQUILATERAL);
        put(2, TriangleKind.ISOSCELES);
        put(3, TriangleKind.SCALENE);
    }};

    public Triangle(double a, double b, double c) throws TriangleException {
        this.kind = kindBySideDiff.get(givenAValidTriangle(a, b, c).collect(Collectors.toSet()).size());
    }

    public TriangleKind getKind() {
        return this.kind;
    }

    private Stream<Double> givenAValidTriangle(double a, double b, double c) throws TriangleException {
        List<Double> collect = Stream.of(a, b, c).sorted()
                .filter(l -> l > 0d)
                .collect(Collectors.toList());

        if (collect.size() != 3 || collect.get(0) + collect.get(1) <= collect.get(2)) {
            throw new TriangleException();
        }

        return collect.stream();
    }
}
