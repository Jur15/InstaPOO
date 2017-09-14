package com.dav_jur.instapoo;

import android.graphics.Color;
import android.graphics.Bitmap;

public class FilterDesaturation implements IFiltroMap {
    int altura;
    int ancho;
    Bitmap Map;

    public FilterDesaturation(Bitmap mapaBits){
        this.Map = mapaBits;
    }

    public void getAltura(Bitmap mapaBits){
        this.altura = mapaBits.getHeight();
    }

    public void getAncho(Bitmap mapaBits){
        this.ancho = mapaBits.getWidth();
    }

    public int max(int A, int B, int C){
        if(A > B){
            if(A > C) return A;
            else return C;
        }
        else{
            if (B > C) return B;
            else return C;
        }
    }

    public int min(int A, int B, int C){
        if(A < B){
            if(A < C) return A;
            else return C;
        }
        else{
            if (B < C) return B;
            else return C;
        }
    }

    public void procesarMap (){
        getAltura(Map);
        getAncho(Map);
        int R,G,B,Grey,min,max;
        int colorInteger,nuevoColorInt;
        for(int i = 0; i < altura; i++ ){
            for(int a = 0; a < ancho; a++){
                colorInteger = Map.getPixel(i,a);
                R = (colorInteger >> 16) & 0xff;
                G = (colorInteger >> 8) & 0xff;
                B = (colorInteger) & 0xff;
                min = min(R,G,B);
                max = max(R,G,B);
                Grey = (min + max)/2;
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
