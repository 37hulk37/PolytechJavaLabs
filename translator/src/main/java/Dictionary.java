import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dictionary {
    private final String dictionaryFile;
    private final HashMap<String, TreeSet<String>> dictionary;
    private final Pattern strPattern = Pattern.compile("(([a-z]+) )+[|] ([а-я]+ ?)+");
    private final Pattern wPattern = Pattern.compile("a-z");

    public Dictionary(String dictionaryFile) {
        this.dictionaryFile = dictionaryFile;
        this.dictionary = new HashMap<>();
    }

    public void initDictionary() {
        try {
            if ( !isFileExists(dictionaryFile)) {
                throw new FileReadException();
            }

            readFile();
        } catch (FileReadException ex) {
            ex.getCause();
        }
    }

    private void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile))) {
            String str;

            while ((str = reader.readLine()) != null) {
                makeDictionary(str.toLowerCase());
            }

        } catch (IOException ex) {
            ex.getCause();
        }
    }

    public boolean containsKey(String key) {
        return dictionary.containsKey(key);
    }

    public String getLongestTranslation(String key) {
        return dictionary.get(key).last();
    }

    private void makeDictionary(String str) throws InvalidFileFormatException {
        if ( !isStrValidFileFormat(str) ) {
            throw new InvalidFileFormatException();
        }

        var words = str.split(" \\| ");

        if ( !dictionary.containsKey(words[0]) ) {
            addTranslationToDictionary(words);
        } else {
            dictionary.computeIfPresent(words[0], (k, v) -> {
                v.add(words[1]);
                return v;
            });
        }
    }

    private void addTranslationToDictionary(String[] words) {
        if ( !isWordIsTranslation(words[1]) ) {
            dictionary.put(words[0], new TreeSet<>(Collections.singletonList(words[1])));
        } else {
            addPhraseToDictionary(words);
        }
    }

    private void addPhraseToDictionary(String[] words) {
        StringBuilder sbKey = new StringBuilder();
        StringBuilder sbValue = new StringBuilder();

        for (String word : words) {
            if (isWordIsTranslation(word)) {
                sbKey.append(word);
            } else {
                sbValue.append(word);
            }
        }

        dictionary.put(sbKey.toString(), new TreeSet<>(List.of(sbValue.toString())));
    }

    private boolean isStrValidFileFormat(String str) {
        return checkForSample(str, strPattern);
    }

    private boolean isWordIsTranslation(String str) {
        return checkForSample(str, wPattern);
    }

    private boolean checkForSample(String str, Pattern pattern) {
        Matcher m = pattern.matcher(str);
        return m.matches();
    }

    private boolean isFileExists(String fileName) {
        File file = new File(fileName);
        return file.exists() && file.isFile() && file.canWrite();
    }
}
