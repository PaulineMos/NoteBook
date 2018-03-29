package javacourses;

import java.util.SplittableRandom;

public class Alarm extends Record {

    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + getId() + '\'' +
                "time='" + time + '\'' +
                '}';
    }

    @Override
    public void askUserData() {
        String time = Main.askString("Time: ");
        setTime(time);

    }

    @Override
    public boolean contains(String part) {
        return time.contains(part);
    }
}
