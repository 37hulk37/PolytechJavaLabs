import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Translator {
    private final String fileForTranslate;
    private final Dictionary dictionary;

    public Translator(String fileForTranslate, String dictionaryFile) {
        this.fileForTranslate = fileForTranslate;
        this.dictionary = new Dictionary(dictionaryFile);
        dictionary.initDictionary();
    }


    public void translate() {
        try {
            if ( !isFileExists(fileForTranslate)) {
                throw new FileReadException();
            }

            outputTranslation();
        } catch (FileReadException ex) {
            ex.getCause();
        }
    }

    private void outputTranslation() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileForTranslate))) {
            String state;

            while ((state = reader.readLine()) != null) {
                makeTranslation(state.toLowerCase());
            }

        } catch (IOException ex) {
            ex.getCause();
        }
    }

    private void makeTranslation(String state) {
        if (dictionary.containsKey(state)) {
            System.out.println(dictionary.getLongestTranslation(state));
        } else {
            outputPhrase(state);
        }
    }

    private void outputPhrase(String state) {
        String[] words = state.split(" ");

        for (String word : words) {
            if (dictionary.containsKey(word)) {
                System.out.print(dictionary.getLongestTranslation(word) + " ");
            } else {
                System.out.print(word + " ");
            }
        }
        System.out.println();
    }

    private boolean isFileExists(String fileName) {
        File file = new File(fileName);
        return file.exists() && file.isFile() && file.canWrite();
    }
}
