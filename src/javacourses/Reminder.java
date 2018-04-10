package javacourses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Reminder extends Alarm implements Expirable{
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean isExpired() {
        LocalDateTime nowDT = LocalDateTime.now();
        LocalDateTime dt = getDate().atTime(getTime());
        return dt.isBefore(nowDT);
    }

    @Override
    public void askUserData() {
            super.askUserData();
            LocalDate date = Main.askDate("Enter date: ");
            setDate(date);
    }

    @Override
    public String toString() {
        String strDate = Main.DATE_FORMATTER.format(date);
        return "Reminder{" +
                "id=" + getId() + '\'' +
                ", time='" + getTime() + '\'' +
                ", date='" + strDate + '\'' +
                ", text='" + getText() + '\'' +
                '}';
    }

    @Override
    public boolean contains(String part) {
        String strDate = Main.DATE_FORMATTER.format(date);
        return strDate.contains(part)
              ||  super.contains(part);
    }
}
