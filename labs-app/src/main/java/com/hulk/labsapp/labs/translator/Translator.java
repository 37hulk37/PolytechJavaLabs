package com.hulk.labsapp.labs.translator;

import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {
    private final String translateFile;
    private final String dictionaryFile;
    private final HashMap<String, TreeSet<String>> dictionary;
    private final ObservableList<String> output;

    public Translator(String translateFile, String dictionaryFile, ObservableList<String> output) {
        this.translateFile = translateFile;
        this.dictionaryFile = dictionaryFile;
        this.dictionary = new HashMap<>();
        this.output = output;
    }

    private boolean checkForSample(String str, Pattern p) {
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private void readDictionary() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile))) {

            Pattern pStr = Pattern.compile("(([a-z]+)[ ])+[|][ ]([а-я]+[ ]?)+");
            String str;

            while ((str = reader.readLine()) != null) {
                str = str.toLowerCase();
                if (checkForSample(str, pStr)) {
                    String[] words = str.split(" \\| ");

                    if (!dictionary.containsKey(words[0])) {
                        Pattern pWord = Pattern.compile("[a-z]");

                        if ( !checkForSample(words[1], pWord) ) {
                            dictionary.put(words[0], new TreeSet<>(Arrays.asList(words[1])));
                        } else {

                            StringBuilder sbKey = new StringBuilder();
                            StringBuilder sbValue = new StringBuilder();

                            for (String word : words) {
                                if (checkForSample(word, pWord)) {
                                    sbKey.append(word);
                                } else {
                                    sbValue.append(word);
                                }
                            }

                            dictionary.put(sbKey.toString(), new TreeSet<>(Arrays.asList(sbValue.toString())));
                        }
                    } else {
                        dictionary.compute(words[0], (k, v) -> {
                            v.add(words[1]);
                            return v;
                        });
                    }
                } else {
                    throw new InvalidFileFormatException();
                }
            }
        } catch (IOException | InvalidFileFormatException ex) {
            ex.printStackTrace();
        }
    }

    private void makeDictionary() {
        try {
            File file = new File(dictionaryFile);

            if (file.exists() && file.isFile() && file.canRead()) {
                readDictionary();
            } else {
                throw new FileReadException();
            }
        } catch (FileReadException ex) {
            ex.printStackTrace();
        }
    }

    private void makeTranslation(ObservableList<String> input) {
        for (String state : input) {
            state = state.toLowerCase();

            if (dictionary.containsKey(state)) {
                output.add(dictionary.get(state).last());
            } else {
                String[] words = state.split(" ");

                StringBuilder out = new StringBuilder();
                for (String word : words) {
                    if (dictionary.containsKey(word)) {
                        out.append(dictionary.get(word).last()).append(" ");
                    } else {
                        out.append(word).append(" ");
                    }
                }
                output.add(out.toString());
                out.setLength(0);
            }
        }
    }

    public void translate(ObservableList<String> input) {
        makeDictionary();

        try {
            File file = new File(translateFile);

            if (file.exists() && file.isFile() && file.canWrite()) {
                makeTranslation(input);
            } else {
                throw new FileReadException();
            }
        } catch (FileReadException ex) {
            ex.printStackTrace();
        }
    }
}
