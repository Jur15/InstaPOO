public class Convoluciones implements FiltroMap{
  int[] Kernel = {{0,1,0},{1,4,1},{0,1,0}};
  int altura;
  int ancho;
  Bitmap Map;

  public class Convoluciones(Bitmap mapaBits){
    this.Map = mapaBits;
  }

  public void getAltura(Bitmap mapaBits){
    this.altura = mapaBits.getHeight();
  }

  public void getAncho(Bitmap mapaBits){
    this.ancho = mapaBits.getWidth();
  }

  public int procesarMatricesR (Color[] matrisColores){
    int sumatoria = 0;
    int indice = 0;
    int valorRojo;
    for ( int i = 0; i < 3; i++){
      for ( int a = 0; a < 3; a++){
        if (matrisColores[indice] == NULL){
          valorRojo = 0;
        }
        else{
          valorRojo = matrisColores[indice].red(colorEvaluado);
        }
        sumatoria = sumatoria + Kernel[i][a] * valorRojo;
        indice = indice + 1;
      }
    }
    sumatoria = sumatoria / 9;
    return sumatoria;
  }

  public int procesarMatricesG (Color[] matrisColores){
    int sumatoria = 0;
    int indice = 0;
    int valorVerde;
    for ( int i = 0; i < 3; i++){
      for ( int a = 0; a < 3; a++){
        if (matrisColores[indice] == NULL){
          valorVerde = 0;
        }
        else{
          valorVerde = matrisColores[indice].green(colorEvaluado);
        }
        sumatoria = sumatoria + Kernel[i][a] * valorVerde;
        indice = indice + 1;
      }
    }
    sumatoria = sumatoria / 9;
    return sumatoria;
  }

  public int procesarMatricesB (Color[] matrisColores){
    int sumatoria = 0;
    int indice = 0;
    int valorAzul;
    for ( int i = 0; i < 3; i++){
      for ( int a = 0; a < 3; a++){
        if (matrisColores[indice] == NULL){
          valorAzul = 0;
        }
        else{
          valorAzul = matrisColores[indice].blue(colorEvaluado);
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
    Color[] bits = new Color[9];
    int R,G,B,Grey,x,y,w;
    Color colorEvaluado, nuevoColor;
    for(int i = 0; i < altura; i++ ){
      for(int a = 0; a < ancho; a++){
        x = i - 1;
        for(int p = 0; p < 3; p++){
          y = a - 1;
          for (int q = 0; q < 3; q++){
            if (x < 0 || x > ancho-1){
              bit[p][q] = NULL;
            }
            else if (y < 0 || y > altura-1){
              bit[p][q] = NULL;
            }
            else{
              w = x * 3 + y;
              bits[w] = Map.getPixel(x,y);
            }
            y = y + 1;
          }
          x = x + 1;
        }
        R = procesarMatricesR(bits);
        G = procesarMatricesG(bits);
        B = procesarMatricesB(bits);
        nuevoColor = nuevoColor.valueOf(R,G,B);
        Map.setPixel(i,a,nuevoColor);
      }
    }
  }

  public Bitmap getMap(){
    procesarMap();
    return Map;
  }
}
