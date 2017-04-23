import java.util.stream.Collectors;

public class Acronym {
    private final String phrase;

    public Acronym(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        if (phrase.matches(".*:.*")) {
            return phrase.split(":")[0];
        }
        String[] words = phrase.split("(?:\\s|-)");
        StringBuilder acronym = new StringBuilder();
        for (String word : words) {
            if (word.toUpperCase().equals(word)) {
                acronym.append(word.charAt(0));
            } else if (word.matches("(?:[A-Z].*){2,}")){
                String s = caseMixedWord(word);
                acronym.append(s);
            } else {
                acronym.append(String.valueOf(word.charAt(0)).toUpperCase());
            }
        }
        return acronym.toString();
    }

    private String caseMixedWord(String word) {
        String collect = word.chars()
                .filter(Character::isUpperCase)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        return collect;
    }
}
