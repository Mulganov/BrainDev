package com.mulganov.app.brain_dev.ui.math.fast.fragments.game.utils;

import android.icu.text.DecimalFormat;

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

    HashMap<Integer, Float> otvetMap = new HashMap<>();

    Lesson(){
        Random random = new Random();

        int r = random.nextInt(3) + 1;

        r = 4;

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

                DecimalFormat format = null;

                System.out.println(otvet);

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    format = new DecimalFormat("#.##");
                    otvet = Float.parseFloat(format.format(otvet).replaceAll(",", "."));
                }

                System.out.println(otvet);
                break;
        }

        for (int i = 1; i < 5; i++){
            otvetMap.put(i,  random.nextInt((int) Math.abs(otvet+1))+otvet/2);
        }

        otvetMap.put(  random.nextInt(3)+1, otvet  );
    }

}
