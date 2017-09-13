package com.dav_jur.instapoo;

import android.graphics.Color;
import android.graphics.Bitmap;

public class DecompositionMax implements FiltroMap{
    int altura;
    int ancho;
    Bitmap Map;

    public DecompositionMax(Bitmap mapaBits){
        this.Map = mapaBits;
    }

    public void getAltura(Bitmap mapaBits){
        this.altura = mapaBits.getHeight();
    }

    public void getAncho(Bitmap mapaBits){
        this.ancho = mapaBits.getWidth();
    }

    public int Max(int A, int B, int C){
        if(A > B){
            if(A > C) return A;
            else return C;
        }
        else{
            if (B > C) return B;
            else return C;
        }
    }

    public void procesarMap (){
        getAltura(Map);
        getAncho(Map);
        int R,G,B,Grey;
        Color colorEvaluado, nuevoColor;
        for(int i = 0; i < altura; i++ ){
            for(int a = 0; a < ancho; a++){
                colorEvaluado = Map.getPixel(i,a);
                R = colorEvaluado.red(colorEvaluado);
                G = colorEvaluado.green(colorEvaluado);
                B = colorEvaluado.blue(colorEvaluado);
                Grey = Max(R,G,B);
                nuevoColor = nuevoColor.valueOf(Grey,Grey,Grey);
                Map.setPixel(i,a,nuevoColor);
            }
        }
    }

    public Bitmap getMap(){
        procesarMap();
        return Map;
    }
}