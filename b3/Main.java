public class Main {
    public static void main(String[] args) {
        TextDocument model = new TextDocument();
        TextView view = new TextView(model);
        view.run();
    }
}
