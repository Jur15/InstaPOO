package com.dav_jur.instapoo;

import android.graphics.Color;
import android.graphics.Bitmap;

public class FilterAveraging implements IFiltroMap {
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
        int colorInteger,nuevoColorInt;
        for(int i = 0; i < altura; i++ ){
            for(int a = 0; a < ancho; a++){
                colorInteger = Map.getPixel(i,a);
                R = (colorInteger >> 16) & 0xff;
                G = (colorInteger >> 8) & 0xff;
                B = (colorInteger) & 0xff;
                Grey = (R + G + B)/3;
                nuevoColorInt = Color.rgb(Grey,Grey,Grey);
                Map.setPixel(i,a,nuevoColorInt);
            }
        }
    }

    public Bitmap getMap(){
        procesarMap();
        return Map;
    }
}