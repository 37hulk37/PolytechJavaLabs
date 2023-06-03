package com.hulk.labsapp.labs.pattern_strategy;

import com.hulk.labsapp.entity.LabsRunner;
import com.hulk.labsapp.labs.pattern_strategy.impl.*;
import javafx.collections.ObservableList;

public class PatternStrategyRunner implements LabsRunner {
    @Override
    public void start(ObservableList<String> input, ObservableList<String> output) {
        Hero hero = new Hero();

        input.stream().forEach(st -> {
            switch (st) {
                case "ride" -> {
                    hero.setMove(new RideHorse());
                    hero.executeMove(output);
                }
                case "fly" -> {
                    hero.setMove(new Fly());
                    hero.executeMove(output);
                }
                case "walk" -> {
                    hero.setMove(new Walk());
                    hero.executeMove(output);
                }
            }
        });
    }

    @Override
    public void stop() {
    }
}
