import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {

    private List<List<Integer>> matrix = new ArrayList<>();

    public Matrix(String matrixAsString) {
        linesFrom(matrixAsString)
                .collect(Collectors.toList())
                .forEach(line -> matrix.add(columnsFrom(line)));
    }

    private Stream<String> linesFrom(String matrix) {
        return Arrays.stream(matrix.split("\n"));
    }

    private List<Integer> columnsFrom(String line) {
        return Arrays.stream(line.split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public int getRowsCount() {
        return matrix.size();
    }

    public int getColumnsCount() {
        return matrix.get(0).size();
    }

    public int[] getRow(int i) {
        return matrix.get(i)
                .stream()
                .mapToInt(Integer::intValue).toArray();
    }

    public int[] getColumn(int i) {
        return matrix.stream()
                .map(l -> l.get(i))
                .collect(Collectors.toList())
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
