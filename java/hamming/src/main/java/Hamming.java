import java.util.stream.IntStream;

public class Hamming {
    private final char[] firstStrand;
    private final char[] secondStrand;

    public Hamming(String firstStrand, String secondStrand) {
        checkStrandsSameSize(firstStrand, secondStrand);
        this.firstStrand  = firstStrand.toCharArray();
        this.secondStrand = secondStrand.toCharArray();
    }

    public int getHammingDistance() {
        return Math.toIntExact(IntStream.range(0, firstStrand.length)
                        .filter(i -> firstStrand[i] != secondStrand[i])
                        .count());
    }

    private void checkStrandsSameSize(final String first, final String second) {
        if (first.length() != second.length()) {
            throw new IllegalArgumentException("Both strands must be equal size");
        }
    }
}
