import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

public class TwelveDays {

    private List<String> gifts = new ArrayList<String>() {{
        add("Partridge in a Pear Tree");
        add("Turtle Doves");
        add("French Hens");
        add("Calling Birds");
        add("Gold Rings");
        add("Geese-a-Laying");
        add("Swans-a-Swimming");
        add("Maids-a-Milking");
        add("Ladies Dancing");
        add("Lords-a-Leaping");
        add("Pipers Piping");
        add("Drummers Drumming");
    }};

    public String verse(int day) {
        return onDayMyLoveGave(day) + gifts(day) + lastGift(day);
    }

    public String verses(int from, int to) {
        return rangeClosed(from, to)
                .mapToObj(this::verse)
                .collect(Collectors.joining("\n"));
    }

    public String sing() {
        return verses(1, 12);
    }

    private String onDayMyLoveGave(int day) {
        return "On the " + Number.of(day).ordinal + " day of Christmas my true love gave to me, ";
    }

    private String gifts(int day) {
        return range(0, day - 1)
                .map(i -> day - i - 1)
                .mapToObj(i -> Number.of(i + 1).written + " " + gifts.get(i))
                .collect(Collectors.joining(", "));
    }

    private String lastGift(int day) {
        String particle = day == 1 ? "a " : ", and a ";
        return particle + gifts.get(0) + ".\n";
    }

    enum Number {
        _1("one", "first"),
        _2("two", "second"),
        _3("three", "third"),
        _4("four", "fourth"),
        _5("five", "fifth"),
        _6("six", "sixth"),
        _7("seven", "seventh"),
        _8("eight", "eighth"),
        _9("nine", "ninth"),
        _10("ten", "tenth"),
        _11("eleven", "eleventh"),
        _12("twelve", "twelfth");

        final String written;
        final String ordinal;

        Number(String written, String ordinal) {
            this.written = written;
            this.ordinal = ordinal;
        }

        static Number of(int i) {
            return Number.valueOf("_" + i);
        }
    }
}
