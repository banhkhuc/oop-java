import java.util.Scanner;

public class HotelView {
    private Hotel hotel;
    private Scanner scanner;

    public HotelView() {
        hotel = new Hotel();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Application Manager Candidate");
            System.out.println("Enter " + Menu.INSERT_PERSON.getValue() + ": To insert person for rent");
            System.out.println("Enter " + Menu.REMOVE_PERSON.getValue() + ": To remove person by passport");
            System.out.println("Enter " + Menu.CALCULATE_PRICE.getValue() + ": To calculate price by passport");
            System.out.println("Enter " + Menu.SHOW_INFO.getValue() + ": To show info");
            System.out.println("Enter " + Menu.EXIT.getValue() + ": To exit:");
            String line = scanner.nextLine();
            switch (Menu.fromValue(line)) {
                case INSERT_PERSON:
                    insertPersonForRent();
                    break;
                case REMOVE_PERSON:
                    removePersonByPassport();
                    break;
                case CALCULATE_PRICE:
                    calculatePriceByPassport();
                    break;
                case SHOW_INFO:
                    showInfo();
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

    private void insertPersonForRent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter passport: ");
        scanner.nextLine();
        String passport = scanner.nextLine();
        System.out.println("Choose " + RoomType.ROOM_A.getValue() + " to rent room type A");
        System.out.println("Choose " + RoomType.ROOM_B.getValue() + " to rent room type B");
        System.out.println("Choose " + RoomType.ROOM_C.getValue() + " to rent room type C");
        String choice = scanner.nextLine();
        Room room;
        switch (RoomType.fromValue(choice)) {
            case ROOM_A:
                room = new RoomA();
                break;
            case ROOM_B:
                room = new RoomB();
                break;
            case ROOM_C:
                room = new RoomC();
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        System.out.print("Enter number of days for rent: ");
        int numberOfDays = scanner.nextInt();
        Person person = new Person(name, age, passport, room, numberOfDays);
        hotel.add(person);
        scanner.nextLine();
    }

    private void removePersonByPassport() {
        System.out.print("Enter passport: ");
        String passport = scanner.nextLine();
        hotel.delete(passport);
    }

    private void calculatePriceByPassport() {
        System.out.print("Enter passport: ");
        String passport = scanner.nextLine();
        System.out.println("Price: " + hotel.calculator(passport));
    }

    private void showInfo() {
        hotel.show();
    }
}

enum Menu {
    INSERT_PERSON("1"),
    REMOVE_PERSON("2"),
    CALCULATE_PRICE("3"),
    SHOW_INFO("4"),
    EXIT("5");

    private final String value;

    Menu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Menu fromValue(String value) {
        for (Menu menu : Menu.values()) {
            if (menu.getValue().equals(value)) {
                return menu;
            }
        }
        return null;
    }
}

enum RoomType {
    ROOM_A("a"),
    ROOM_B("b"),
    ROOM_C("c");

    private final String value;

    RoomType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RoomType fromValue(String value) {
        for (RoomType type : RoomType.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return null;
    }
}
