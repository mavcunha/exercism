import java.util.Arrays;

import static java.util.Arrays.stream;

public class LuhnValidator {
    public boolean isValid(String number) {
        if (!isInputValid(number)) {
            return false;
        }
        int[] digits = extractDigits(number);
        int[] doubledDigits = doubleEveryOtherDigit(digits);

        return stream(doubledDigits).sum() % 10 == 0;
    }

    private int[] doubleEveryOtherDigit(int[] chars) {
        int[] digits = Arrays.copyOf(chars, chars.length);
        int i = digits.length - 2;
        do {
            digits[i] = (digits[i] * 2) - (digits[i] / 5) * 9;
            i -= 2;
        } while (i >= 0);
        return digits;
    }

    private int[] extractDigits(String s) {
        return s.replaceAll("\\D", "")
                .chars().boxed()
                .mapToInt(Character::getNumericValue).toArray();
    }

    private boolean isInputValid(String number) {
        return number.matches("^(?:\\s|\\d)+$") &&
               number.matches(".*(?:\\d.*){2,}");
    }
}
