import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.IntStream.range;

/**
 * Modified version of http://rosettacode.org/wiki/Miller%E2%80%93Rabin_primality_test#Java
 */
class RosettaModifiedPrimeTest {

    static boolean isPrime(int p) {
        BigInteger n = BigInteger.valueOf(p);

        int intN = n.intValue();
        if (intN == 1 || intN == 4 || intN == 6 || intN == 8) return false;
        if (intN == 2 || intN == 3 || intN == 5 || intN == 7) return true;

        ModReduce r = new ModReduce().reduce(n);

        return getPrimesToTest(n).stream().noneMatch(k -> tryComposite(k, r.d, n, r.s));
    }

    private static List<BigInteger> getPrimesToTest(final BigInteger n) {
        long count = Stream.of(
                "1373653",
                "25326001",
                "118670087467",
                "2152302898747",
                "3474749660383").map(BigInteger::new)
                .filter(p -> n.compareTo(p) >= 0)
                .count();

        return asList(2, 3, 5, 7, 11, 13, 17).subList(0, (int) count + 2)
                .stream().map(BigInteger::valueOf).collect(Collectors.toList());
    }

    private static boolean tryComposite(final BigInteger a, final BigInteger d, final BigInteger n, final BigInteger s) {
        return !a.modPow(d, n).equals(BigInteger.ONE) &&
                range(0, s.intValue())
                        .noneMatch(k ->
                                a.modPow(BigInteger.valueOf(2).pow(k).multiply(d), n).equals(n.subtract(BigInteger.ONE)));
    }

    private static class ModReduce {
        private BigInteger d;
        private BigInteger s;

        ModReduce reduce(BigInteger n) {
            d = n.subtract(BigInteger.ONE);
            s = BigInteger.ZERO;

            while (d.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                d = d.shiftRight(1);
                s = s.add(BigInteger.ONE);
            }
            return this;
        }
    }
}
