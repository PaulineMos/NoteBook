package javacourses;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.SplittableRandom;

public class Alarm extends Note implements Expirable {


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
        LocalTime time = Main.askTime("Enter time: ");
        setTime(time);
    }


    @Override
    public boolean contains(String part) {
        String strTime = Main.TIME_FORMATTER.format(time);
        return strTime.contains(part)
                || super.contains(part);
    }

    @Override
    public boolean isExpired() {
        LocalTime now = LocalTime.now();
        return time.isBefore(now);
    }
}
