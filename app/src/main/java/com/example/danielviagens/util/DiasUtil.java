package com.example.danielviagens.util;

public class DiasUtil {

    public static String diasEmTexto(int quantidadeDeDias) {
        if (quantidadeDeDias > 1) {
            return  quantidadeDeDias+ " dias";
        }else {
            return quantidadeDeDias + " dia";
        }
    }
}
