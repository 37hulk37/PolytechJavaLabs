public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator(
                "translate.txt", "dictionary.txt"
        );

        translator.translate();
    }
}
