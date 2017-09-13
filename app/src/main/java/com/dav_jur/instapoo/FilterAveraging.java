package com.dav_jur.instapoo;

import android.graphics.Color;
import android.graphics.Bitmap;

public class FilterAveraging implements FiltroMap{
    int[] Kernel = new int[9];
    int altura;
    int ancho;
    Bitmap Map;

    public FilterAveraging(Bitmap mapaBits){
        this.Map = mapaBits;
    }

    public void getAltura(Bitmap mapaBits){
        this.altura = mapaBits.getHeight();
    }

    public void getAncho(Bitmap mapaBits){
        this.ancho = mapaBits.getWidth();
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
                Grey = (R + G + B)/3;
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