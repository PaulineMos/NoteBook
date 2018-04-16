package javacourses;


import java.time.LocalDate;


public abstract class RecordWithBirthday extends Record {
    private LocalDate birthday;

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate askBirthday() {
        LocalDate birthday = Main.askDate("Birthday: ");
        return birthday;
    }
public boolean isBirthdayInCurrentMonth(String month) {
    String strDate = Main.DATE_FORMATTER.format(birthday);
        return strDate.contains("."+month+".");

}
}
