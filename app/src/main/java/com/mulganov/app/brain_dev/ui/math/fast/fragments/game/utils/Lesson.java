package com.mulganov.app.brain_dev.ui.math.fast.fragments.game.utils;

import android.icu.text.DecimalFormat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ChoiceFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Random;

public class Lesson {
    static int level_plus_minus = 10;
    static int level_mul_div = 3;
    int a;
    int b;
    public float otvet;
    char znak;
    public Otvets otvets;

    Lesson(){
        Random random = new Random();

        otvets = new Otvets();

        int r = random.nextInt(3) + 1;

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


        otvets.a = (float) round (otvet + (otvet / 10f) + 1, 2);
        otvets.b = (float) round (otvet - (otvet / 10f) - 1, 2);
        otvets.c = (float) round (otvet - (otvet / 20f) - 1, 2);
        otvets.d = (float) round (otvet + (otvet / 20f) + 1, 2);

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
