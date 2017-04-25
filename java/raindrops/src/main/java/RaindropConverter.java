import java.util.Map;
import java.util.TreeMap;

public class RaindropConverter {

    private final Map<Integer,String> sounds = new TreeMap<Integer, String>(){{
        put(3, "Pling");
        put(5, "Plang");
        put(7, "Plong");
    }};

    public String convert(int number) {
        return sounds.keySet().stream()
                .filter(i -> number % i == 0)
                .map(sounds::get)
                .reduce(String::concat)
                .orElse(String.valueOf(number));
    }

}
