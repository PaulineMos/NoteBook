package javacourses;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Record> records = new ArrayList<>();

    public static void main(String[] args) {
        commandLoop();
    }

    private static void commandLoop() {
        for (; ; ) {
            System.out.print("Choose the command (create, list, help, find or exit): ");
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
                case "find":
                    find();
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
        for (Record r : records) {
            System.out.println(r);
        }
    }

    private static void find() {
        String part = askString("What to find? ");

        for (Record r : records) {
            if (r.contains(part)) {
                System.out.println(r);
            } else {
                System.out.println("Nothing found!");
            }
        }
    }

    private static void create() {
        for (; ; ) {
            System.out.print("type: ");
            String type = scanner.next();

            switch (type.toLowerCase()) {
                case "exit":
                    return;
                case "help":
                    help();
                    break;
                case "person":
                    addRecord(new Person());
                    return;
                case "note":
                    addRecord(new Note());
                    return;
                case "alarm":
                    addRecord(new Alarm());
                    return;
                default:
                    System.out.println("Wrong");
            }
        }
    }

    private static void addRecord(Record record) {
        record.askUserData();
        records.add(record);
        System.out.println("Created!");
    }

    public static String askString(String message) {
        System.out.print(message);
        String str = scanner.next();
        if (str.startsWith("\"")) {
            ArrayList<String> list = new ArrayList<>();
            list.add(str);
            while (!str.endsWith("\"")) {
                str = scanner.next();
                list.add(str);
            }
            str = String.join(" ", list);
        }
        return str;
    }
}
