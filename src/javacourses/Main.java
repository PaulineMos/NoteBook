package javacourses;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Person> records = new ArrayList<>();

    public static void main(String[] args) {
        commandLoop();
    }

    private static void commandLoop() {
        for (; ; ) {
            System.out.print("Choose the command (create, list, help or exit): ");
            String cmd = scanner.next();

            switch (cmd.toLowerCase()) {
                case "exit":
                    return;
                case "create":
                    create();
                    break;
                case "list":
                    list();
                    break;
                case "help":
                    help();
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

    private static void help() {
        System.out.println("type - enter 'person'");
        System.out.println("first name - enter your first name");
        System.out.println("last name - enter your last name");
        System.out.println("phone - enter your phone");
        System.out.println("email - enter your email");
    }

    private static void list() {
       for (Person p : records) {
           System.out.println(p);
       }
    }

    private static void create() {
        for (; ; ) {
            System.out.print("type> ");
            String type = scanner.next();

            switch (type.toLowerCase()) {
                case "exit":
                return;
                case "help":
                    help();
                    break;
                case "person":
                    createPerson();
                    return;
                default:
                    System.out.println("Wrong");
            }
        }
    }

    private static void createPerson() {

        String firstName = askString("First name: ");
        String lastName = askString("Last name: ");
        String phone = askString("Phone: ");
        String email = askString("Email: ");

        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhone(phone);
        person.setEmail(email);

        records.add(person);
    }
    private static String askString(String message){
        System.out.print(message);

        return scanner.next();
    }
}
