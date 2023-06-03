package com.hulk.labsapp.labs.translator;

import com.hulk.labsapp.entity.LabsRunner;
import javafx.collections.ObservableList;

import java.util.List;

public class TranslatorRunner implements LabsRunner {
    @Override
    public void start(ObservableList<String> input, ObservableList<String> output) {
        Translator translator = new Translator(
                "translate.txt",
                "dictionary.txt",
                output
        );

        translator.translate(input);
    }

    @Override
    public void stop() {
    }
}
