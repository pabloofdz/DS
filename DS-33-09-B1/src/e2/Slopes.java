package e2;

public class Slopes {
    public static int downTheSlope ( char [][] slopeMap , int right , int down ) {
        int i, j, k, x, y, y2, x2, cont = 0, filas = slopeMap.length, columnas;
        boolean columnasIguales = true, caracteresValidos = true;
        if (filas == 0){
            throw new IllegalArgumentException("La matriz está vacía");
        }else{
            for (i = 1; i < filas; i++){
                if (slopeMap[i].length != slopeMap[i - 1].length)
                columnasIguales = false;
            }
            if (!columnasIguales){
                throw new IllegalArgumentException("La matriz no es cuadrada");
            }else{
                columnas = slopeMap[0].length;
                if (columnas != filas){
                    throw new IllegalArgumentException("La matriz no es cuadrada");
                }else if (right >= columnas || right < 1){
                    throw new IllegalArgumentException("El desplazamiento hacia la derecha no es válido " +
                            "(debe ser positivo y menor que el número de columnas)");
                }else if (down >= filas || down < 1){
                    throw new IllegalArgumentException("El desplazamiento hacia abajo no es válido " +
                            "(debe ser positivo y menor que el número de filas)");
                }else {
                    for (j = 0; j < filas; j++) {
                        for (k = 0; k < columnas; k++) {
                            if (slopeMap[j][k] != '.' && slopeMap[j][k] != '#')
                                caracteresValidos = false;
                        }
                    }
                    if (!caracteresValidos) {
                        throw new IllegalArgumentException("La matriz incluye caracteres distintos de '.' y '#'");
                    }else {
                        x = 0;
                        y = 0;
                        while(x < filas){
                            y2 = y;
                            while(y < y2 + right && y < columnas){
                                if (slopeMap[x][y] == '#')
                                    cont++;
                                y++;
                            }
                            if(y == columnas)
                                y--;
                            if (y < y2 + right) {
                                y = 0;
                                y2 = y2 - columnas;
                                while (y < y2 + right && y < columnas) {
                                    if (slopeMap[x][y] == '#')
                                        cont++;
                                    y++;
                                }
                            }
                            x2 = x;
                            while(x < x2 + down && x < filas){
                                if (slopeMap[x][y] == '#')
                                    cont++;
                                x++;
                            }
                        }

                    }
                }
            }
        }
        return cont;
    }
    public static int jumpTheSlope ( char [][] slopeMap , int right , int down )  {
        int i, j, k, x, y, cont = 0, filas = slopeMap.length, columnas;
        boolean columnasIguales = true, caracteresValidos = true;
        if (filas == 0){
            throw new IllegalArgumentException("La matriz está vacía");
        }else{
            for (i = 1; i < filas; i++){
                if (slopeMap[i].length != slopeMap[i - 1].length)
                    columnasIguales = false;
            }
            if (!columnasIguales){
                throw new IllegalArgumentException("La matriz no es cuadrada");
            }else{
                columnas = slopeMap[0].length;
                if (columnas != filas){
                    throw new IllegalArgumentException("La matriz no es cuadrada");
                }else if (right >= columnas || right < 1){
                    throw new IllegalArgumentException("El desplazamiento hacia la derecha no es válido " +
                            "(debe ser positivo y menor que el número de columnas)");
                }else if (down >= filas || down < 1){
                    throw new IllegalArgumentException("El desplazamiento hacia abajo no es válido " +
                            "(debe ser positivo y menor que el número de filas)");
                }else {
                    for (j = 0; j < filas; j++) {
                        for (k = 0; k < columnas; k++) {
                            if (slopeMap[j][k] != '.' && slopeMap[j][k] != '#')
                                caracteresValidos = false;
                        }
                    }
                    if (!caracteresValidos) {
                        throw new IllegalArgumentException("La matriz incluye caracteres distintos de '.' y '#'");
                    }else {
                        x = 0;
                        y = 0;
                        while(x < filas){
                            if (slopeMap[x][y] == '#')
                                cont++;
                            y = y + right;
                            if (y >= columnas)
                                y = y - columnas;
                            x = x + down;
                        }

                    }
                }
            }
        }
        return cont;
    }
}

