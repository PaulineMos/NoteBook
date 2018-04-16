package javacourses;

import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    public static final String DATE_FORMAT = "dd.MM.uuuu";
    public static final DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public static final String TIME_FORMAT = "HH:mm";
    public static final DateTimeFormatter TIME_FORMATTER
            = DateTimeFormatter.ofPattern(TIME_FORMAT);

    static Scanner scanner = new Scanner(System.in);
    static TreeMap<Integer, Record> recordsMap = new TreeMap<>();

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
                case "birthdays":
                    findBirthdayInCurrentMonth();
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
        for (; ; ) {
            try {
                System.out.print("Show ID: ");
                int id = scanner.nextInt();
                Record r = recordsMap.get(id);
                System.out.println(r);
                return;

            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Enter number of ID!");
            }
        }
    }

    private static void findExpired() {

        for (Record r : recordsMap.values()) {
            if (r instanceof Expirable) {
                Expirable expirable = (Expirable) r;
                if (expirable.isExpired()) {
                    System.out.println(expirable);
                }
            }
        }
    }

    private static void findBirthdayInCurrentMonth() {
        String month = askString("Enter a month(MM)? ");
        boolean isBirthdays = false;
        for (Record r : recordsMap.values()) {
            if (r instanceof RecordWithBirthday) {
                RecordWithBirthday recordWithBirthday = (RecordWithBirthday) r;
                if (recordWithBirthday.isBirthdayInCurrentMonth(month)) {
                    System.out.println(recordWithBirthday);
                    isBirthdays = true;
                }
            }
        } if (!isBirthdays) {
            System.out.println("Not found such birthdays!");
        }
    }

    private static void help() {
        System.out.println("type - enter 'person', 'note', 'pet', 'alarm', 'reminder' ");
    }

    private static void list() {
        for (Record r : recordsMap.values()) {
            System.out.println(r);
        }
    }

    private static void find() {
        String part = askString("What to find? ");

        boolean isfound = false;
        for (Record r : recordsMap.values()) {
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
                case "pet":
                    addRecord(new Pet());
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
        int id = record.getId();
        recordsMap.put(id, record);
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

    public static LocalTime askTime(String message) {
        for (; ; ) {
            String strTime = askString(message + "(" + TIME_FORMAT + ") ");
            try {
                LocalTime time = LocalTime.parse(strTime, TIME_FORMATTER);
                return time;
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format!");
            }
        }
    }

    public static LocalDate askDate(String message) {
        for (; ; ) {
            String strDate = askString(message + "(" + DATE_FORMAT + ") ");
            try {
                LocalDate date = LocalDate.parse(strDate, DATE_FORMATTER);
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format!");
            }
        }
    }
}
