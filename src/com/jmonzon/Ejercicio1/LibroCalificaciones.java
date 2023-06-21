package com.jmonzon.Ejercicio1;

/**
 * @author Jorge Luis Monzón Morales
 * @project Arreglos
 */
public class LibroCalificaciones {

    private String nombreDelCurso;
    private int[][] calificaciones;

    public LibroCalificaciones(String nombreDelCurso, int[][] calificaciones) {
        this.nombreDelCurso = nombreDelCurso;
        this.calificaciones = calificaciones;
    }

    public String getNombreDelCurso() {
        return nombreDelCurso;
    }

    public void setNombreDelCurso(String nombreDelCurso) {
        this.nombreDelCurso = nombreDelCurso;
    }

    public void procesaCalificaciones() {
        imprimirCalificaciones();

        System.out.printf("%n%s %d%n%s %d",
                "La calificación más baja en el libro de calificaciones es:",
                obtenerMinima(),
                "La calificación más alta en el libro de calificaciones es:",
                obtenerMaxima());


//        imprime la grafica
        imprimirGraficoBarras();

    }//fin de procesoCalificaciones


    public int obtenerMinima() {

//        Asumimos la calificación baja en la posición 1 de la matriz
        int calificacionBaja = calificaciones[0][0];

//        itera filas
        for (int[] notasFilas : calificaciones) {
//          iterar Columnas
            for (int notaColumna : notasFilas) {
                if (notaColumna < calificacionBaja) {
                    calificacionBaja = notaColumna;
                }
            }
        }

        return calificacionBaja;
    }

    public int obtenerMaxima() {

//        Asumimos la calificación baja en la posición 1 de la matriz
        int calificacionAlta = calificaciones[0][0];

//        itera filas
        for (int[] notasFilas : calificaciones) {
//          iterar Columnas
            for (int notaColumna : notasFilas) {
                if (notaColumna > calificacionAlta) {
                    calificacionAlta = notaColumna;
                }
            }
        }

        return calificacionAlta;
    }

    public void imprimirGraficoBarras() {

        System.out.println("Distribución de calificación en general");

//        almacena la frecuencia de las calificaciones en cada rango de 10 calificaciones
        int[] frecuencia = new int[11];


        for (int[] caliEstudiantes : calificaciones) {

            for (int calificacion : caliEstudiantes) {

//                incrementa el valor en la posicion indicada de calificación
                ++frecuencia[calificacion / 10];
            }
        }

//        para cada frecuencia de calificaciones, imprime una barra en el gráfico
        for (int cuenta = 0; cuenta < frecuencia.length; cuenta++) {
            if (cuenta == 10) {
                System.out.printf("%5d: ", 100);
            } else {
//                impresión con formato de dos digitos
                System.out.printf("%02d-%02d: ",
                        cuenta * 10, cuenta * 10 + 9);

            }

//            imprimimos la barra de asteriscos de acuerdo a cantidad en la posición cuenta de frecuencia
            for(int estrellas = 0; estrellas<frecuencia[cuenta]; estrellas++){
                System.out.print("*");
            }

//            salto de linea
            System.out.println("");
        }
    }

    public void imprimirCalificaciones() {

        System.out.println("");
        System.out.println("======Reporte======");

        System.out.print("              ");


//        Crea un encabezado de columna para cada una de la pruebas
        for (int j = 0; j < calificaciones[0].length; j++) {

            System.out.printf("Prueba %d ", j + 1);
        }

        System.out.println("Promedio");

//        Crea filas/columnas de texto que representan el arreglo calificaciones
        for (int i = 0; i < calificaciones.length; i++) {

//            muestra la fila de de Estudiantes
            System.out.printf("Estudiantes %2d", i + 1);

//            iteramos las columnas de la fila 1
            for (int prueba : calificaciones[i]) {
                System.out.printf("%8d", prueba);
            }

//            Llama al método obtenerPromedio para calcular la calificación promedio del estudiante
//            pasamos fila de calificaciones como argumento para obtenerPromedio
            double promedio = obtenerPromedio(calificaciones[i]);
            System.out.printf("%9.2f%n", promedio);
        }
    }

    public double obtenerPromedio(int[] calificaciones) {
        int total = 0;

//        obtenemos las calificación de la iteración de la fila
        for (int calificacion : calificaciones) {
            total += calificacion;
        }

//      devuelve el promedio de calificación
        return (double) total / calificaciones.length;
    }
}
