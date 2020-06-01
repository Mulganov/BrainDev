package com.mulganov.app.brain_dev.ui.math.fast.fragments.game.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Lesson {
    static final int level_default_pm = 10;
    static final int level_default_md = 3;

    static final int next_level_pm = 5;
    static final int next_level_md = 5;

    static int level_plus_minus;
    static int level_mul_div;
    int a;
    int b;
    public float otvet;
    char znak;
    public Otvets otvets;

    Lesson(int level){
        reloadLevel(level);

        Random random = new Random();

        otvets = new Otvets();

        int r = random.nextInt(4) + 1;
        System.out.println(r);

        switch (r){
            case 1:
                znak = '+';
                a = random.nextInt(level_plus_minus) + 1;
                b = random.nextInt(level_plus_minus) + 1;
                otvet = a + b;
                break;

            case 2:
                znak = '-';
                a = random.nextInt(level_plus_minus) + 1;
                b = random.nextInt(level_plus_minus) + 1;
                otvet = a - b;
                break;

            case 3:
                znak = '*';
                a = random.nextInt(level_mul_div) + 1;
                b = random.nextInt(level_mul_div) + 1;
                otvet = a * b;
                break;

            case 4:
                znak = '/';
                a = random.nextInt(level_mul_div) + 1;
                b = random.nextInt(level_mul_div) + 1;
                otvet = (float) a / b;
                break;
        }


        otvets.a = (int) round (otvet + (otvet / 10f) + 1, 2);
        otvets.b = (int) round (otvet - (otvet / 10f) - 1, 2);
        otvets.c = (int) round (otvet - (otvet / 20f) - 1, 2);
        otvets.d = (int) round (otvet + (otvet / 20f) + 1, 2);

        int rr = random.nextInt(3)+1;

        switch (rr){
            case 1: otvets.a = otvet;
                break;
            case 2: otvets.b = otvet;
                break;
            case 3: otvets.c = otvet;
                break;
            case 4: otvets.d = otvet;
                break;
        }

    }

    private void reloadLevel(int level) {
        int pm = level / next_level_pm;
        int md = level / next_level_md;

        Lesson.level_plus_minus = level_default_pm + pm;
        Lesson.level_mul_div = level_default_md + md;
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public class Otvets{
        public float a;
        public float b;
        public float c;
        public float d;

    }
}
