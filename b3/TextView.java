import java.util.Scanner;

public class TextView {
    private TextDocument model;

    public TextView(TextDocument model) {
        this.model = model;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Text Document Application");
            System.out.println("Enter " + Menu.ENTER_TEXT.getValue() + ": Set Text");
            System.out.println("Enter " + Menu.WORD_COUNT.getValue() + ": Count Words");
            System.out.println("Enter " + Menu.COUNT_A.getValue() + ": Count 'A' Characters");
            System.out.println("Enter " + Menu.STANDARDIZE_TEXT.getValue() + ": Standardize Text");
            System.out.println("Enter " + Menu.DISPLAY_TEXT.getValue() + ": Display Text");
            System.out.println("Enter " + Menu.EXIT.getValue() + ": Exit");
            System.out.print("Enter your choice: ");
            String line = scanner.nextLine();

            switch (Menu.fromValue(line)) {
                case ENTER_TEXT:
                    System.out.print("Enter text: ");
                    String newText = scanner.nextLine();
                    model.setTextDocument(newText);
                    break;
                case WORD_COUNT:
                    int wordCount = model.countWords();
                    System.out.println("Word count: " + wordCount);
                    break;
                case COUNT_A:
                    int charCount = model.countCharacterA();
                    System.out.println("Count of 'A' characters: " + charCount);
                    break;
                case STANDARDIZE_TEXT:
                    model.standardizeText();
                    System.out.println("Text standardized.");
                    break;
                case DISPLAY_TEXT:
                    System.out.println("Text: " + model.getTextDocument());
                    break;
                case EXIT:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

enum Menu {
    ENTER_TEXT("1"),
    WORD_COUNT("2"),
    COUNT_A("3"),
    STANDARDIZE_TEXT("4"),
    DISPLAY_TEXT("5"),
    EXIT("6");

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