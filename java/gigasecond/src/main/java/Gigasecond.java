import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Gigasecond {

    public static final long GIGA_SECOND = 1_000_000_000L;
    private LocalDateTime dateOfBirth;

    public Gigasecond(LocalDate birth) {
        this.dateOfBirth = LocalDateTime.of(birth, LocalTime.MIDNIGHT);
    }

    public Gigasecond(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getDate() {
        return dateOfBirth.plus(GIGA_SECOND, ChronoUnit.SECONDS);
    }
}
