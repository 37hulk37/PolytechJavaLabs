package com.hulk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();

        Move a = new RideHorse();

        Scanner in = new Scanner(System.in);
        System.out.println("Ways to move: ");
        System.out.println("ride, fly, walk");
        System.out.println("To exit type 'exit'");

        String st = in.next().toLowerCase();
        while ( !st.equals("exit") ) {
            switch(st) {
                case "ride" -> {
                    hero.setMove(new RideHorse());
                    hero.executeMove();
                }
                case "fly" -> {
                    hero.setMove(new Fly());
                    hero.executeMove();
                }
                case "walk" -> {
                    hero.setMove(new Walk());
                    hero.executeMove();
                }
            }
            st = in.next();
        }

        in.close();
    }
}
