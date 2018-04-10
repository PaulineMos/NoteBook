package javacourses;

import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Record> records = new ArrayList<>();

    public static void main(String[] args) {
        commandLoop();
    }

    private static void commandLoop() {
        for (; ; ) {
            System.out.print("Choose the command (create, list, help, find, expired, show or exit): ");
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
                case "expired":
                    findExpired();
                    break;
                case "show":
                    showID();
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

    private static void showID() {

        try {
            System.out.print("Show ID: ");
            int num = scanner.nextInt();

            for (Record r : records) {
                if (r.getId() == num) {
                    System.out.println(r);
                }
            }
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("Enter number of ID!");
        }
    }

    private static void findExpired() {
        LocalTime now = LocalTime.now();
        LocalDateTime nowDT = LocalDateTime.now();
        for (Record r : records) {
            if (r instanceof Alarm && !(r instanceof Reminder)) {
                Alarm a = (Alarm) r;
                if (a.getTime().isBefore(now)) {
                    System.out.println(a);
                }
            }
            if (r instanceof Reminder) {
                Reminder rem = (Reminder) r;
                LocalDateTime dt = rem.getDate().atTime(rem.getTime());
                if (dt.isBefore(nowDT)) {
                    System.out.println(rem);
                }
            }
        }
    }

    private static void help() {
        System.out.println("type - enter 'person'");
    }

    private static void list() {
        for (Record r : records) {
            System.out.println(r);
        }
    }

    private static void find() {
        String part = askString("What to find? ");

        boolean isfound = false;
        for (Record r : records) {
            if (r.contains(part)) {
                System.out.println(r);
                isfound = true;
            }
        }
        if (!isfound) {
            System.out.println("Not found!");
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
                case "reminder":
                    addRecord(new Reminder());
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
