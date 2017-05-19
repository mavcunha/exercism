import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Allergies {

    private final List<Allergen> allergies;

    public Allergies(int score) {
        allergies = Stream.of(Allergen.values())
                .filter(i -> (score & i.getScore()) == i.getScore())
                .collect(Collectors.toList());
    }

    public boolean isAllergicTo(Allergen allergen) {
        return allergies.contains(allergen);
    }

    public List<Allergen> getList() {
        return allergies;
    }
}
