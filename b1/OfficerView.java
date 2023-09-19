import java.util.Scanner;

public class OfficerView {

    private ManagerOfficer managerOfficer;
    private Scanner scanner;

    enum MenuOption {
        INSERT_OFFICER,
        SEARCH_OFFICER,
        SHOW_INFORMATION,
        EXIT
    }

    enum OfficerType {
        ENGINEER,
        WORKER,
        STAFF
    }

    public OfficerView() {
        managerOfficer = new ManagerOfficer();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Application Manager Officer");
            System.out.println("Enter " + MenuOption.INSERT_OFFICER.ordinal() + ": To insert officer");
            System.out.println("Enter " + MenuOption.SEARCH_OFFICER.ordinal() + ": To search officer by name: ");
            System.out.println("Enter " + MenuOption.SHOW_INFORMATION.ordinal() + ": To show information officers");
            System.out.println("Enter " + MenuOption.EXIT.ordinal() + ": To exit:");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (MenuOption.values()[choice]) {
                case INSERT_OFFICER:
                    insertOfficer();
                    break;
                case SEARCH_OFFICER:
                    searchOfficer();
                    break;
                case SHOW_INFORMATION:
                    showInformation();
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

    private void insertOfficer() {
        System.out.println("Enter " + OfficerType.ENGINEER.ordinal() + ": to insert Engineer");
        System.out.println("Enter " + OfficerType.WORKER.ordinal() + ": to insert Worker");
        System.out.println("Enter " + OfficerType.STAFF.ordinal() + ": to insert Staff");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            choice = -1;
        }

        switch (OfficerType.values()[choice]) {
            case ENGINEER:
                insertEngineer();
                break;
            case WORKER:
                insertWorker();
                break;
            case STAFF:
                insertStaff();
                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }

    private void insertEngineer() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age:");
        int age = scanner.nextInt();
        System.out.print("Enter gender: ");
        scanner.nextLine();
        String gender = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter branch: ");
        String branch = scanner.nextLine();
        Officer engineer = new Engineer(name, age, gender, address, branch);
        managerOfficer.addOfficer(engineer);
        System.out.println(engineer.toString());
    }

    private void insertWorker() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age:");
        int age = scanner.nextInt();
        System.out.print("Enter gender: ");
        scanner.nextLine();
        String gender = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter level: ");
        int level = scanner.nextInt();
        Officer worker = new Worker(name, age, gender, address, level);
        managerOfficer.addOfficer(worker);
        System.out.println(worker.toString());
    }

    private void insertStaff() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter gender: ");
        scanner.nextLine();
        String gender = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter task: ");
        String task = scanner.nextLine();
        Officer staff = new Staff(name, age, gender, address, task);
        managerOfficer.addOfficer(staff);
        System.out.println(staff.toString());
    }

    private void searchOfficer() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        managerOfficer.searchOfficerByName(name).forEach(officer -> {
            System.out.println(officer.toString());
        });
    }

    private void showInformation() {
        managerOfficer.showListInforOfficer();
    }
}
