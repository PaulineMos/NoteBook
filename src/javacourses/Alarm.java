package javacourses;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.SplittableRandom;

public class Alarm extends Note {
    public static final String TIME_FORMAT = "HH:mm";
    public static final DateTimeFormatter TIME_FORMATTER
            =DateTimeFormatter.ofPattern(TIME_FORMAT);

    private LocalTime time;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + getId() + '\'' +
                ", time='" + time + '\'' +
                ", text='" + getText() + '\'' +
                '}';
    }

    @Override
    public void askUserData() {
        super.askUserData();
        String strTime = Main.askString("Time (" + TIME_FORMAT + "): ");
        LocalTime time = LocalTime.parse(strTime, TIME_FORMATTER);
        setTime(time);
    }

    @Override
    public boolean contains(String part) {
        String strTime = TIME_FORMATTER.format(time);
        return strTime.contains(part)
                || super.contains(part);
    }
}
