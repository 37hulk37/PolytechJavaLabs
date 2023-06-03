package com.hulk.labsapp.labs.streamapi;

import com.hulk.labsapp.entity.LabsRunner;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hulk.labsapp.labs.streamapi.StreamAPI.*;

public class StreamAPIRunner implements LabsRunner {
    @Override
    public void start(ObservableList<String> input, ObservableList<String> output) {
        List<Integer> l = new ArrayList<>(Arrays.asList(2, 4, 6,  45, 8, 90));
        output.add(String.valueOf(average(l)));

        List<String> l2 = new ArrayList<>(Arrays.asList("98", "kookvpf", "kofkv0d", "v0k0dk"));
        output.add(addStr(l2).toString());

        List<Double> l3 = new ArrayList<>(Arrays.asList(2.0, 4.2, 6.4,  45.3, 8.9, 90.1, 4.6, 78.7, 6.6));
        output.add(listSquare(l3).toString());

        //Collection<Integer> c = new ArrayList<>();
        //System.out.println(getLastOrThrow(c));
        output.add(getLastOrThrow(Arrays.asList(2.0, 4.2, 6.4,  45.3, 8.9, 90.1, 4.6, 78.7, 6.6)).toString());

        List<String> l4 = new ArrayList<>(Arrays.asList("qwerty", "queen", "quick", "good", "cargo", "cool"));
        output.add(getSortedStringsFromChar(l4, "q").toString());
        output.add(getSortedStringsFromChar(l4, "c").toString());

        output.add(sumEven(l).toString());

        List<String> l5 = new ArrayList<>(Arrays.asList("qwerty", "kotlin", "furious", "good", "cargo", "imagine"));
        output.add(listToMap(l5).toString());
    }

    @Override
    public void stop() {
    }
}
