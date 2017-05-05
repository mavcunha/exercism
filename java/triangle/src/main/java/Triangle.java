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
        checkNonZeroOrNegativeSides(a, b, c);
        checkTriangleInequality(a, b, c);

        this.kind = kindBySideDiff.get(notEqualSides(a, b, c));
    }

    public TriangleKind getKind() {
        return this.kind;
    }

    private void checkTriangleInequality(double a, double b, double c) throws TriangleException {
        List<Double> collect = Stream.of(a, b, c).sorted().collect(Collectors.toList());
        if(collect.get(0) + collect.get(1) <= collect.get(2)) {
            throw new TriangleException();
        }
    }

    private void checkNonZeroOrNegativeSides(double a, double b, double c) throws TriangleException {
        if (Stream.of(a, b, c).anyMatch(l -> l <= 0d)) {
            throw new TriangleException();
        }
    }

    private int notEqualSides(double a, double b, double c) {
        return Stream.of(a, b, c).collect(Collectors.toSet()).size();
    }
}
