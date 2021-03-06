package javacourses;

import java.time.LocalDate;

public class Person extends RecordWithBirthday {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + super.getBirthday() + '\'' +
                '}';
    }


    @Override
    public void askUserData() {
        String firstName = Main.askString("First name: ");
        String lastName = Main.askString("Last name: ");
        String phone = Main.askString("Phone: ");
        String email = Main.askString("Email: ");
        LocalDate birthday = super.askBirthday();


        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setEmail(email);
        super.setBirthday(birthday);
    }

    @Override
    public boolean contains(String part) {
        String strDate = Main.DATE_FORMATTER.format(super.getBirthday());
        return strDate.contains(part)
                || firstName.contains(part)
                || lastName.contains(part)
                || phone.contains(part)
                || email.contains(part);
    }
}
