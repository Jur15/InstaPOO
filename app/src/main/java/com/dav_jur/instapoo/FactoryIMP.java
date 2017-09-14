package com.dav_jur.instapoo;

import android.graphics.Bitmap;

public class FactoryIMP implements IFilterFactory,IConstants {

    public IFiltroMap crearFiltro(String tipo, Bitmap mapa){
        switch(tipo){
            case AVERAGING: return new FilterAveraging(mapa);
            case DESATURATION: return new FilterDesaturation(mapa);
            case DECOMPOSITIONMAX: return new FilterDecompositionMax(mapa);
            case DECOMPOSITIONMIN: return new FilterDecompositionMin(mapa);
            case GAUSSIANO: return new FilterGaussiano(mapa);
            case CONVOLUCIONES: return new FilterConvoluciones(mapa);
            default: return null;
        }
    }
}
