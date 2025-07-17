public class Main {

    public static void main(String[] args) {
        // Matriz con 5 estudiantes y 6 columnas:
        // Curso1, Curso2, Curso3, Promedio, Nota más alta, Nota más baja
        double[][] notasEstudiantes = {
            {85, 70, 92, 0, 0, 0},
            {60, 75, 88, 0, 0, 0},
            {90, 95, 93, 0, 0, 0},
            {72, 68, 65, 0, 0, 0},
            {100, 85, 80, 0, 0, 0}
        };

        // Calcular promedio, nota alta y baja por estudiante
        for (int i = 0; i < notasEstudiantes.length; i++) {
            double suma = 0;
            double notaAlta = notasEstudiantes[i][0];
            double notaBaja = notasEstudiantes[i][0];

            // Solo recorremos las 3 primeras columnas (cursos)
            for (int j = 0; j < 3; j++) {
                double nota = notasEstudiantes[i][j];
                suma += nota;

                if (nota > notaAlta) notaAlta = nota;
                if (nota < notaBaja) notaBaja = nota;
            }

            notasEstudiantes[i][3] = suma / 3;   // Promedio
            notasEstudiantes[i][4] = notaAlta;   // Nota más alta
            notasEstudiantes[i][5] = notaBaja;   // Nota más baja
        }

        // Mostrar la matriz completa
        System.out.println("Notas de los estudiantes:");
        for (int i = 0; i < notasEstudiantes.length; i++) {
            System.out.print("Estudiante " + (i + 1) + ": [");
            for (int j = 0; j < 6; j++) {
                System.out.print(notasEstudiantes[i][j]);
                if (j < 5) System.out.print(", ");
            }
            System.out.println("]");
        }

        // Promedio por curso
        System.out.println("\nPromedio por curso:");
        for (int j = 0; j < 3; j++) {
            double sumaCurso = 0;
            for (int i = 0; i < notasEstudiantes.length; i++) {
                sumaCurso += notasEstudiantes[i][j];
            }
            double promedioCurso = sumaCurso / notasEstudiantes.length;
            System.out.println("Curso " + (j + 1) + ": " + promedioCurso);
        }

        // Promedio general
        double sumaGeneral = 0;
        int totalNotas = 0;
        for (int i = 0; i < notasEstudiantes.length; i++) {
            for (int j = 0; j < 3; j++) {
                sumaGeneral += notasEstudiantes[i][j];
                totalNotas++;
            }
        }
        double promedioGeneral = sumaGeneral / totalNotas;
        System.out.println("\nPromedio general de todos los estudiantes: " + promedioGeneral);

        // Buscar nota más alta
        double notaMax = -1;
        int estMax = -1, cursoMax = -1;
        for (int i = 0; i < notasEstudiantes.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (notasEstudiantes[i][j] > notaMax) {
                    notaMax = notasEstudiantes[i][j];
                    estMax = i;
                    cursoMax = j;
                }
            }
        }
        System.out.println("\nNota más alta: " + notaMax + " (Estudiante " + (estMax + 1) + ", Curso " + (cursoMax + 1) + ")");

        // Buscar nota más baja
        double notaMin = 101;
        int estMin = -1, cursoMin = -1;
        for (int i = 0; i < notasEstudiantes.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (notasEstudiantes[i][j] < notaMin) {
                    notaMin = notasEstudiantes[i][j];
                    estMin = i;
                    cursoMin = j;
                }
            }
        }
        System.out.println("Nota más baja: " + notaMin + " (Estudiante " + (estMin + 1) + ", Curso " + (cursoMin + 1) + ")");
    }
}
