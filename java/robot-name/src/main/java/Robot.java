import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Stream.generate;

public class Robot {

    private static Set<String> names = new HashSet<>();
    private String name;

    public Robot() {
        this.name = generateNewName();
    }

    public String getName() {
        return this.name;
    }

    public void reset() {
        this.name = generateNewName();
    }

    private String generateNewName() {
        return generate(this::randomName)
                .filter(names::add)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private String randomName() {
        return randomChar() + randomChar() + randomInt(0, 9) + randomInt(0, 9) + randomInt(0, 9);
    }

    private String randomChar() {
        return String.valueOf((char) randomInt('A', 'Z'));
    }

    private int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
