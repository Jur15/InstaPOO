package com.dav_jur.instapoo;

import android.graphics.Bitmap;
import android.graphics.Color;

public class Gaussiano implements FiltroMap{
  float[][] Kernel = {{0.0113437f,0.083819f,0.011343f},{0.0838195f,0.619347f,0.083819f},{0.0113437f,0.083819f,0.011343f}};
  int altura;
  int ancho;
  Bitmap Map;

  public Gaussiano(Bitmap mapaBits){
    this.Map = mapaBits;
  }

  public void getAltura(Bitmap mapaBits){
    this.altura = mapaBits.getHeight();
  }

  public void getAncho(Bitmap mapaBits){
    this.ancho = mapaBits.getWidth();
  }

  public float procesarMatricesR (int[] matrisColores){
    float sumatoria = 0.0f;
    int indice = 0;
    int valorRojo;
    for ( int i = 0; i < 3; i++){
      for ( int a = 0; a < 3; a++){
        if (matrisColores[indice] == 0){
          valorRojo = 0;
        }
        else{
          valorRojo = (matrisColores[indice] >> 16) & 0xff;
        }
        sumatoria = sumatoria + Kernel[i][a] * valorRojo;
        indice = indice + 1;
      }
    }
    sumatoria = sumatoria / 9;
    return sumatoria;
  }

  public float procesarMatricesG (int[] matrisColores){
    float sumatoria = 0.0f;
    int indice = 0;
    int valorVerde;
    for ( int i = 0; i < 3; i++){
      for ( int a = 0; a < 3; a++){
        if (matrisColores[indice] == 0){
          valorVerde = 0;
        }
        else{
          valorVerde = (matrisColores[indice] >> 8) & 0xff;
        }
        sumatoria = sumatoria + Kernel[i][a] * valorVerde;
        indice = indice + 1;
      }
    }
    sumatoria = sumatoria / 9;
    return sumatoria;
  }

  public float procesarMatricesB (int[] matrisColores){
    float sumatoria = 0.0f;
    int indice = 0;
    int valorAzul;
    for ( int i = 0; i < 3; i++){
      for ( int a = 0; a < 3; a++){
        if (matrisColores[indice] == 0){
          valorAzul = 0;
        }
        else{
          valorAzul = (matrisColores[indice]) & 0xff;
        }
        sumatoria = sumatoria + Kernel[i][a] * valorAzul;
        indice = indice + 1;
      }
    }
    sumatoria = sumatoria / 9;
    return sumatoria;
  }

  public void procesarMap (){
    getAltura(Map);
    getAncho(Map);
    int[] bits = new int[9];
    float R,G,B;
    int x,y,w;
    int nuevoColor;
    for(int i = 0; i < altura; i++ ){
      for(int a = 0; a < ancho; a++){
        x = i - 1;
        for(int p = 0; p < 3; p++){
          y = a - 1;
          for (int q = 0; q < 3; q++){
            w = x * 3 + y;
            if (x < 0 || x > ancho-1){
              bits[w] = 0;
            }
            else if (y < 0 || y > altura-1){
              bits[w] = 0;
            }
            else{
              bits[w] = Map.getPixel(x,y);
            }
            y = y + 1;
          }
          x = x + 1;
        }
        R = procesarMatricesR(bits);
        G = procesarMatricesG(bits);
        B = procesarMatricesB(bits);
        nuevoColor = Color.rgb(Math.round(R),Math.round(G),Math.round(B));
        Map.setPixel(i,a,nuevoColor);
      }
    }
  }

  public Bitmap getMap(){
    procesarMap();
    return Map;
  }
}
