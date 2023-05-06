package com.hulk;

import com.hulk.Insectivores.*;
import com.hulk.Predators.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<Mammals> SrcCollection = Arrays.asList(
                new Manul("m1"), new Manul("m2"), new Lynx("l3"),
                new Lynx("l1"), new Lynx("l2"), new HedgehogDefault("h1")
        );

        Collection<Hedgehogs> Collection1 = new ArrayList<>();
        Collection<Feline> Collection2 = new ArrayList<>();
        Collection<Predators> Collection3 = new ArrayList<>();

        segregate(SrcCollection, Collection1, Collection2, Collection3);

        System.out.println("#1");
        System.out.println(Collection1);
        System.out.println(Collection2);
        System.out.println(Collection3);

        Collection<Predators> SrcCollection2 = Arrays.asList(
                new Manul("m3"), new Manul("m4"), new Lynx("l4"),
                new Lynx("l5"), new Lynx("l6")
        );

        Collection<Chordates> Collection4 = new ArrayList<>();
        Collection<Manul> Collection5 = new ArrayList<>();
        Collection<Feline> Collection6 = new ArrayList<>();

        segregate(SrcCollection2, Collection4, Collection5, Collection6);

        System.out.println("#2");
        System.out.println(Collection4);
        System.out.println(Collection5);
        System.out.println(Collection6);

        Collection<Hedgehogs> SrcCollection3 = Arrays.asList(
                new HedgehogDefault("h3"),
                new HedgehogDefault("h4")
        );

        Collection<Insectivores> Collection7 = new ArrayList<>();
        Collection<Predators> Collection8 = new ArrayList<>();
        Collection<Predators> Collection9 = new ArrayList<>();

        segregate(SrcCollection3, Collection7, Collection8, Collection9);

        System.out.println("#3");
        System.out.println(Collection7);
        System.out.println(Collection8);
        System.out.println(Collection9);
    }

    public static void segregate(Collection<? extends Chordates> src,
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
