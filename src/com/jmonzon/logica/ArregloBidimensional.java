package com.jmonzon.logica;

/**
 * @author Jorge Monzón Morales
 * @project Arreglos
 */
public class ArregloBidimensional {

    public static void main(String[] args) {

        int arreglob[][] = { {5,6,7},{8,9,7}};

        for (int filas= 0; filas< arreglob.length; filas++){
            for (int columnas = 0; columnas< arreglob[filas].length; columnas++){
                System.out.print(arreglob[filas][columnas] + " ");
            }

            System.out.println("");
        }


    }
}
