package com.jmonzon.Ejercicio1;

import java.util.Scanner;

/**
 * @author Jorge Luis Monzón Morales
 * @project Arreglos
 */
public class TestLibroCalificaciones {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String nombreCurso;
        int cantidadAlumnos, cantidadNotas, nota;
        int matrizNotas[][] = new int[100][100];

        do {
            System.out.println("Ingresar nombre del curso");
            nombreCurso = entrada.nextLine();


            System.out.println("Ingresar la cantidad de Alumnos");
            cantidadAlumnos = entrada.nextInt();

            System.out.println("Ingresar la cantidad de Notas");
            cantidadNotas = entrada.nextInt();


        } while (cantidadAlumnos < 1 || cantidadNotas < 1);

        matrizNotas = new int[cantidadAlumnos][cantidadNotas];

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Ingrese las notas del alumno " + (i + 1));
            for (int j = 0; j < cantidadNotas; j++) {

                do {
                    System.out.print("ingresar la nota " + (j + 1) + ": ");
                    nota = entrada.nextInt();

                    if (nota >= 1) {
                        matrizNotas[i][j] = nota;
                    } else {
                        System.out.println("Vuelve a ingresar la nota");
                    }

                } while (nota < 0);
            }
        }

        LibroCalificaciones curso1 = new LibroCalificaciones(nombreCurso, matrizNotas);
        curso1.procesaCalificaciones();


    }

}
