package com.example.shayriapp;

import android.os.Environment;

import com.example.shayriapp.R;

import java.io.File;

public class Color_Array {
    public static int[] colors = {R.color.c1, R.color.c2, R.color.c3,
            R.color.c4, R.color.c5, R.color.c6,
            R.color.c7, R.color.c8, R.color.c9,
            R.color.c10, R.color.c11, R.color.c12,
            R.color.c13, R.color.c14, R.color.c15,
            R.color.c16, R.color.c17, R.color.c18,
            R.color.c19, R.color.c20, R.color.c21,
            R.color.c22, R.color.c23, R.color.c24};

    public static int[] gradients = {R.drawable.grad_1, R.drawable.grad_2,
            R.drawable.grad_3, R.drawable.grad_4,
            R.drawable.grad_5, R.drawable.grad_6};

    public static String[] fonts={"BOD_PSTC.TTF","BRADHITC.TTF","BRITANIC.TTF","BRUSHSCI.TTF","FREESCPT.TTF",
                "ITCEDSCR.TTF","LHANDW.TTF","MATURASC.TTF","segoesc.ttf"};
    public static String[] emog= {"\uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B \uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B",
            "\uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B \uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B",
            "\uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B \uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B",
            "\uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B \uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B",
            "\uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B \uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B",
            "\uD83E\uDD10 \uD83D\uDE2F \uD83E\uDD1A \uD83D\uDC4B",
            "\uD83E\uDDD3 \uD83E\uDDD1 \uD83D\uDC69 \uD83D\uDC67",
            "\uD83E\uDD26 \uD83D\uDE47 \uD83D\uDE46 \uD83E\uDD37",
            "\uD83D\uDC91  \uD83D\uDC6B \uD83D\uDC6D \uD83D\uDC6C"};

    public static File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

}