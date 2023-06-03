package com.hulk.labsapp.labs.thirdlab;

import com.hulk.labsapp.entity.LabsRunner;
import com.hulk.labsapp.labs.thirdlab.Insectivores.*;
import com.hulk.labsapp.labs.thirdlab.Predators.*;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ThirdLabRunner implements LabsRunner {
    @Override
    public void start(ObservableList<String> input, ObservableList<String> output) {
        Collection<Mammals> SrcCollection = Arrays.asList(
                new Manul("m1"), new Manul("m2"), new Lynx("l3"),
                new Lynx("l1"), new Lynx("l2"), new HedgehogDefault("h1")
        );

        Collection<Hedgehogs> Collection1 = new ArrayList<>();
        Collection<Feline> Collection2 = new ArrayList<>();
        Collection<Predators> Collection3 = new ArrayList<>();

        segregate(SrcCollection, Collection1, Collection2, Collection3);

        output.add("#1");
        output.add(Collection1.toString());
        output.add(Collection2.toString());
        output.add(Collection3.toString());

        Collection<Predators> SrcCollection2 = Arrays.asList(
                new Manul("m3"), new Manul("m4"), new Lynx("l4"),
                new Lynx("l5"), new Lynx("l6")
        );

        Collection<Chordates> Collection4 = new ArrayList<>();
        Collection<Manul> Collection5 = new ArrayList<>();
        Collection<Feline> Collection6 = new ArrayList<>();

        segregate(SrcCollection2, Collection4, Collection5, Collection6);

        output.add("#2");
        output.add(Collection4.toString());
        output.add(Collection5.toString());
        output.add(Collection6.toString());

        Collection<Hedgehogs> SrcCollection3 = Arrays.asList(
                new HedgehogDefault("h3"),
                new HedgehogDefault("h4")
        );

        Collection<Insectivores> Collection7 = new ArrayList<>();
        Collection<Predators> Collection8 = new ArrayList<>();
        Collection<Predators> Collection9 = new ArrayList<>();

        segregate(SrcCollection3, Collection7, Collection8, Collection9);

        output.add("#3");
        output.add(Collection7.toString());
        output.add(Collection8.toString());
        output.add(Collection9.toString());
    }

    @Override
    public void stop() {
    }

    public void segregate(Collection<? extends Chordates> src,
                            Collection<? super HedgehogDefault> c1,
                            Collection<? super Manul> c2,
                            Collection<? super Lynx> c3) {

        for (var chord : src) {
            if (chord instanceof HedgehogDefault) {
                c1.add(((HedgehogDefault) chord));
            } else if (chord instanceof Manul) {
                c2.add((Manul) chord);
            } else if (chord instanceof Lynx) {
                c3.add((Lynx) chord);
            }
        }
    }
}
