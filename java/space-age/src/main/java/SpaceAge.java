import java.time.Duration;

public class SpaceAge {
    
    private static final double EARTH_YEAR_DAYS = 365.25;

    private final long ageInSeconds;
    private final long ageInDays;

    enum OrbitalYear {
        MERCURY(0.2408467),
        VENUS(0.61519726),
        EARTH(1),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132);

        private final double earthYearRatio;

        OrbitalYear(double earthYearRatio) {
            this.earthYearRatio = earthYearRatio;
        }
    }

    public SpaceAge(long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
        this.ageInDays = Duration.ofSeconds(this.ageInSeconds).toDays();
    }

    public double getSeconds() {
        return this.ageInSeconds;
    }

    public double onEarth() {
        return ageOnPlanet(OrbitalYear.EARTH);
    }

    public double onMercury() {
        return ageOnPlanet(OrbitalYear.MERCURY);
    }

    public double onVenus() {
        return ageOnPlanet(OrbitalYear.VENUS);
    }

    public double onMars() {
        return ageOnPlanet(OrbitalYear.MARS);
    }

    public double onJupiter() {
        return ageOnPlanet(OrbitalYear.JUPITER);
    }

    public double onSaturn() {
        return ageOnPlanet(OrbitalYear.SATURN);
    }

    public double onUranus() {
        return ageOnPlanet(OrbitalYear.URANUS);
    }

    public double onNeptune() {
        return ageOnPlanet(OrbitalYear.NEPTUNE);
    }

    private double ageOnPlanet(OrbitalYear planet) {
        return this.ageInDays / (EARTH_YEAR_DAYS * planet.earthYearRatio);
    }
}
