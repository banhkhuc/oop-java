public class TextDocument {
    private String text;

    public TextDocument() {
        this.text = "";
    }

    public TextDocument(String str) {
        this.text = str;
    }

    public int countWords() {
        if (text.isEmpty()) {
            return 0;
        }

        int count = 0;
        String[] words = text.trim().split("\\s+");
        for (String word : words) {
            if (!word.trim().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public int countCharacterA() {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == 'A' || c == 'a') {
                count++;
            }
        }
        return count;
    }

    public void standardizeText() {
        text = text.trim();
        text = text.replaceAll("\\s+", " ");
    }

    public String getTextDocument() {
        return text;
    }

    public void setTextDocument(String str) {
        this.text = str;
    }
}