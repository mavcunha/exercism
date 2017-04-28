import java.util.function.IntSupplier;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class LuhnValidator {

    public boolean isValid(String number) {
        return isInputValid(number) && checkSumIsValid(number);
    }

    private boolean checkSumIsValid(String number) {
        return stream(doubleEveryOtherDigit(number)).sum() % 10 == 0;
    }

    private int[] doubleEveryOtherDigit(String number) {
        final int[] digits = digitsFrom(number);
        IntStream.generate(reverseEveryOther(digits.length))
                .limit(digits.length/2)
                .forEach(i -> digits[i] = (digits[i] * 2) - (digits[i] / 5) * 9);
        return digits;
    }

    private IntSupplier reverseEveryOther(final int length) {
        return new IntSupplier() {
            int i = length;
            @Override
            public int getAsInt() {
                return i-=2;
            }
        };
    }

    private int[] digitsFrom(String s) {
        return s.replaceAll("\\D", "")
                .chars().boxed()
                .mapToInt(Character::getNumericValue).toArray();
    }

    private boolean isInputValid(String number) {
        return number.matches("^(?:\\s|\\d)+$") &&
               number.matches(".*(?:\\d.*){2,}");
    }
}
