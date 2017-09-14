package com.dav_jur.instapoo;

import android.graphics.Bitmap;

public interface IFilterFactory {
    public IFiltroMap crearFiltro(String tipo, Bitmap mapa);
}