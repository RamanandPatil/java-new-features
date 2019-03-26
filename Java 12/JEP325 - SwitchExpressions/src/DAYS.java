import java.util.Random;

public enum DAYS {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static DAYS getRandomDay() {
        return DAYS.values()[new Random().nextInt(6) + 1];
    }
}
