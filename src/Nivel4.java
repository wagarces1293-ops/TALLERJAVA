import java.util.Scanner;
public class Nivel4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("===Nivel 3 - El inventario del heroe===");
        System.out.println("=======================================");
        int[] pociones = new int[5];
        String[] nombres = {"Poción menor", "Poción media", "Poción mayor", "Elixir", "Antídoto"};
// 1. LLENAR el array pidiendo datos
        System.out.println("=== CARGA DE INVENTARIO ===");
        for (int i = 0; i < pociones.length; i++) {
            System.out.print("¿Cuántas unidades de " + nombres[i] + "? ");
            pociones[i] = sc.nextInt();
        }
        // 2. RECORRER para mostrar
        System.out.println();
        System.out.println("=== TU MOCHILA ===");
        for (int i = 0; i < pociones.length; i++) {
            System.out.println("[" + i + "] " + nombres[i] + " x" + pociones[i]);
        }
// 3. RECORRER para calcular
        int totalObjetos = 0;
        for (int i = 0; i < pociones.length; i++) {
            totalObjetos += pociones[i];
        }
        System.out.println();
        System.out.println("Tipos distintos : " + pociones.length);
        System.out.println("Objetos totales : " + totalObjetos);
// 4. Modificar una posición concreta
        System.out.print("¿Qué posición quieres vaciar (0 a 4)? ");
        int pos = sc.nextInt();
        if (pos >= 0 && pos < pociones.length) {
            pociones[pos] = 0;
            System.out.println(nombres[pos] + " descartada.");
        } else {
            System.out.println("Esa posición no existe en la mochila.");
        }
        System.out.println("=====================================");
        System.out.println("========Los daños del combate========");
        System.out.println("=====================================");

        int[] danios = {12, 25, 8, 30, 15, 22};
        System.out.println("El array tiene " + danios.length+ " golpes registrados");
        System.out.println("El primer golpe fue de " + danios[0]);
        System.out.println("El último golpe fue de " + danios[danios.length - 1]);
        int suma = 0;
        for (int i = 0; i < danios.length; i++) {
            suma += danios[i];
            System.out.println("Golpe " + (i + 1) + ": " + danios[i]);
        }
        System.out.println("Daño total: " + suma);

        System.out.println("==============================================");
        System.out.println("===MISION 4.1 - La bitácora de la mazmorra ===");
        System.out.println("==============================================");

        int[] oro = new int[7];
        int oroTotal = 0;
        int salasVacias = 0;

        System.out.println("=================================");
        System.out.println("===EXPLORACIÓN DE LA MAZMORRA ===");
        System.out.println("=================================");

        //1. Pida el oro encontrado en cada una de las 7 salas y lo guarde en un array.
        for (int i = 0; i < oro.length ; i++){
            System.out.println("Cuanto oro encontraste en la sala " + (i + 1) + ": ");
            oro[i] = sc.nextInt();
        }
        System.out.println(" \n --- Bitacora --- \n");
        for (int i = 0; i < oro.length; i++) {
            System.out.println("Sala " + (i + 1) + ": " + oro[i] + " de oro");
            oroTotal += oro[i];
            if (oro[i] == 0) {
                salasVacias++;
            }
        }
        System.out.println("\n ---------------------------------------------");
        System.out.println("Oro total encontrado : " + oroTotal);
        System.out.println("Salas vacías (0 oro) : " + salasVacias);
        System.out.println("\n ---------------------------------------------");

        System.out.print("\n¿Qué número de sala deseas consultar? (1 a 7): ");
        int salaConsulta = sc.nextInt();

        if (salaConsulta >= 1 && salaConsulta <= 7) {
            int indice = salaConsulta - 1;
            System.out.print("\n En la sala " + salaConsulta + " habia " + oro[indice] + " de oro.");
        } else {
            System.out.print("\n Error: La sala " + salaConsulta + " No existe, Ingrese numero del 1 al 7");
        }

        System.out.println("======================");
        System.out.println("===CAZA DE BUGS #4 ===");
        System.out.println("======================");

        int[] vidas = {100, 85, 60, 40};
        // Se debe usar < en lugar de <=
        for (int i = 0; i < vidas.length; i++) {
            System.out.println("Héroe " + i + ": " + vidas[i]);
        }
        // El length va sin parentesis
        System.out.println("Total de héroes: " + vidas.length);



    }
}
