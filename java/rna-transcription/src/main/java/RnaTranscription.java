import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RnaTranscription {

    private Map<Character, String> transcriptionMap = new HashMap<>();

    public RnaTranscription() {
        this.transcriptionMap.put('C', "G");
        this.transcriptionMap.put('G', "C");
        this.transcriptionMap.put('T', "A");
        this.transcriptionMap.put('A', "U");
    }

    public String ofDna(String dna) {
        return dna.isEmpty() ? "" : transcribe(dna);
    }

    private String transcribe(String dna) {
        return dna.chars()
                .mapToObj(a -> this.transcriptionMap.get((char) a))
                .collect(Collectors.joining());
    }
}