import static java.util.stream.IntStream.iterate;

public class PrimeCalculator {

    public int nth(int i) {
        if(!(i > 0)) throw new IllegalArgumentException();

        return iterate(1, n -> n + 1).filter(RosettaModifiedPrimeTest::isPrime)
                .limit(i).reduce((f, s) -> s).getAsInt();
    }

}
