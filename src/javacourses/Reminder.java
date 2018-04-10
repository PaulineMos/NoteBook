package javacourses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Reminder extends Alarm{
    public static final String DATE_FORMAT = "dd.MM.uuuu";
    public static final DateTimeFormatter DATE_FORMATTER
            =DateTimeFormatter.ofPattern(DATE_FORMAT);

    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void askUserData() {
            super.askUserData();
            for (; ; ) {
                try {
                    String strDate = Main.askString("Date (" + DATE_FORMAT + "): ");
                    LocalDate date = LocalDate.parse(strDate, DATE_FORMATTER);
                    setDate(date);
                    return;
                } catch (DateTimeParseException e) {
                    System.out.println("Incorrect format!");
                }
            }
    }

    @Override
    public String toString() {
        String strDate = DATE_FORMATTER.format(date);
        return "Reminder{" +
                "id=" + getId() + '\'' +
                ", time='" + getTime() + '\'' +
                ", date='" + strDate + '\'' +
                ", text='" + getText() + '\'' +
                '}';
    }

    @Override
    public boolean contains(String part) {
        String strDate = DATE_FORMATTER.format(date);
        return strDate.contains(part)
              ||  super.contains(part);
    }
}
