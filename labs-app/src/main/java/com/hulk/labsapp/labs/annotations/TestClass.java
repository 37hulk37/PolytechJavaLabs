package com.hulk.labsapp.labs.annotations;

import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.List;

public class TestClass {
    private final ObservableList<String> output;

    public TestClass(ObservableList<String> output) {
        this.output = output;
    }

    @MyAnnotation(value = 2)
    public void method1(String str) {
        output.add(str + " first");
    }

    @MyAnnotation(4)
    public void method2(Collection<Integer> l) {
        output.add(String.valueOf(l.contains(2)));
    }

    @MyAnnotation(5)
    protected void method3(String str) {
        output.add(str);
    }

    @MyAnnotation(value = 1)
    protected void method4(int a, double b) {
        output.add(String.valueOf(a + b));
    }

    @MyAnnotation(value = 2)
    private void method5(String str, List<String> l) {
        output.add(String.valueOf(l.contains(str)));
    }

    @MyAnnotation(value = 3)
    private void method6(int y) {
        output.add(String.valueOf(y));
    }
}
