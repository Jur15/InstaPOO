package com.dav_jur.instapoo;

import android.graphics.Bitmap;

public class FactoryIMP implements FactoryFilters{
    public final static String AVERAGING = "Averaging";
    public final static String DESATURATION = "Desaturation";
    public final static String DECOMPOSITIONMAX = "DecompositionMax";
    public final static String DECOMPOSITIONMIN = "DecompositionMin";

    public FiltroMap crearFiltro(String tipo, Bitmap mapa){
        switch(tipo){
            case AVERAGING: return new FilterAveraging(mapa);
            case DESATURATION: return new Desaturation(mapa);
            case DECOMPOSITIONMAX: return new DecompositionMax(mapa);
            case DECOMPOSITIONMIN: return new DecompositionMin(mapa);
            default: return null;
        }
    }
}