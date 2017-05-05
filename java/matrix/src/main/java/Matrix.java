import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {

    private List<List<Integer>> matrix = new ArrayList<>();

    public Matrix(String matrixAsString) {
        streamOf(matrixAsString, "\n")
                .collect(Collectors.toList())
                .forEach(line -> matrix.add(columnsFrom(line)));
    }

    private List<Integer> columnsFrom(String line) {
        return streamOf(line, "\\s+")
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private Stream<String> streamOf(String str, String regex) {
        return Arrays.stream(str.split(regex));
    }

    public int getRowsCount() {
        return matrix.size();
    }

    public int getColumnsCount() {
        return matrix.get(0).size();
    }

    public int[] getRow(int i) {
        return matrix.get(i).stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] getColumn(int i) {
        return matrix.stream().mapToInt(l -> l.get(i)).toArray();
    }
}
