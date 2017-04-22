import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    public static final long GIGA_SECOND = 1_000_000_000L;
    private LocalDateTime dateOfBirth;

    public Gigasecond(LocalDate birth) {
        this.dateOfBirth = birth.atStartOfDay();
    }

    public Gigasecond(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getDate() {
        return dateOfBirth.plusSeconds(GIGA_SECOND);
    }
}
