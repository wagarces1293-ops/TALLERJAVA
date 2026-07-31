import java.util.Scanner;

public class Nivel5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("=== NIVEL 5 - EL SALÓN DE LA FAMA ===");
        System.out.println("=======================================");

        // =========================================================
        // 1. TE LO MUESTRO — El salón de la fama del gremio
        // =========================================================
        System.out.println("\n--- 1. TE LO MUESTRO: Salón de la Fama ---");
        String[] nombres = {"Aria", "Kael", "Nyx", "Doran", "Selene"};
        int[] puntajesEjemplo = {120, 340, 90, 200, 500};

        int sumaPuntajes = 0;
        for (int i = 0; i < puntajesEjemplo.length; i++) {
            sumaPuntajes += puntajesEjemplo[i];

        }
        double promedioEjemplo = (double) sumaPuntajes / puntajesEjemplo.length;

        int maxPuntaje = puntajesEjemplo[0];
        int minPuntaje = puntajesEjemplo[0];
        int posMax = 0;
        int posMin = 0;

        for (int i = 1; i < puntajesEjemplo.length; i++) {
            if (puntajesEjemplo[i] > maxPuntaje) {
                maxPuntaje = puntajesEjemplo[i];
                posMax = i;
            }
            if (puntajesEjemplo[i] < minPuntaje) {
                minPuntaje = puntajesEjemplo[i];
                posMin = i;
            }
        }

        int sobrePromedioCount = 0;
        for (int i = 0; i < puntajesEjemplo.length; i++) {
            if (puntajesEjemplo[i] > promedioEjemplo) {
                sobrePromedioCount++;
            }
        }

        System.out.println("===== SALÓN DE LA FAMA =====");
        System.out.println("Promedio del gremio : " + promedioEjemplo);
        System.out.println("Campeón             : " + nombres[posMax] + " con " + maxPuntaje + " puntos");
        System.out.println("Último              : " + nombres[posMin] + " con " + minPuntaje + " puntos");
        System.out.println("Sobre el promedio   : " + sobrePromedioCount + " miembros");

        // =========================================================
        // 2. LO HACEMOS JUNTOS — El daño máximo (10 XP)
        // =========================================================
        System.out.println("\n--- 2. LO HACEMOS JUNTOS: El daño máximo ---");
        int[] golpes = {12, 45, 8, 45, 30, 22};
        int maximoGolpe = golpes[0]; // Inicializamos con el primer elemento
        int posMaxGolpe = 0;

        for (int i = 1; i < golpes.length; i++) {
            if (golpes[i] > maximoGolpe) {
                maximoGolpe = golpes[i];
                posMaxGolpe = i;
            }
        }
        System.out.println("El golpe más fuerte fue de " + maximoGolpe);
        System.out.println("Ocurrió en el turno " + (posMaxGolpe + 1));

        // =========================================================
        // 3. AHORA TÚ — MISIÓN 5.1: El análisis de la temporada
        // =========================================================
        System.out.println("\n=================================================");
        System.out.println("=== MISIÓN 5.1 - EL ANÁLISIS DE LA TEMPORADA ===");
        System.out.println("=================================================");

        double[] oroMeses = new double[12];
        System.out.println("Ingrese el oro ganado en los 12 meses del año:");
        for (int i = 0; i < oroMeses.length; i++) {
            System.out.print("Mes " + (i + 1) + ": ");
            oroMeses[i] = sc.nextDouble();
        }

        // 3.1 Total y Promedio
        double oroTotalAnual = 0;
        for (int i = 0; i < oroMeses.length; i++) {
            oroTotalAnual += oroMeses[i];
        }
        double promedioMensual = oroTotalAnual / oroMeses.length;

        // 3.2 Mejor y peor mes
        double mejorOro = oroMeses[0];
        double peorOro = oroMeses[0];
        int mejorMesIndice = 0;
        int peorMesIndice = 0;

        for (int i = 1; i < oroMeses.length; i++) {
            if (oroMeses[i] > mejorOro) {
                mejorOro = oroMeses[i];
                mejorMesIndice = i;
            }
            if (oroMeses[i] < peorOro) {
                peorOro = oroMeses[i];
                peorMesIndice = i;
            }
        }

        // 3.3 Cuántos meses superaron el promedio
        int mesesSobrePromedio = 0;
        for (int i = 0; i < oroMeses.length; i++) {
            if (oroMeses[i] > promedioMensual) {
                mesesSobrePromedio++;
            }
        }

        // Mostrar resultados generales
        System.out.println("\n--- RESUMEN DE LA TEMPORADA ---");
        System.out.println("Oro total anual    : " + oroTotalAnual);
        System.out.printf("Promedio mensual   : %.2f\n", promedioMensual);
        System.out.println("Mejor mes          : Mes " + (mejorMesIndice + 1) + " (" + mejorOro + " de oro)");
        System.out.println("Peor mes           : Mes " + (peorMesIndice + 1) + " (" + peorOro + " de oro)");
        System.out.println("Diferencia         : " + (mejorOro - peorOro) + " de oro");
        System.out.println("Meses sobre promedio: " + mesesSobrePromedio);

        // Bonus creativo: Marcado de meses con símbolo [+] o [-]
        System.out.println("\n--- DETALLE DE MESES ([+] superó promedio | [-] no superó) ---");
        for (int i = 0; i < oroMeses.length; i++) {
            String simbolo = (oroMeses[i] > promedioMensual) ? "[+]" : "[-]";
            System.out.println("Mes " + (i + 1) + ": " + oroMeses[i] + " de oro " + simbolo);
        }

        // 3.4 Búsqueda de valor específico
        System.out.print("\nIngrese una cantidad de oro a buscar: ");
        double oroBuscado = sc.nextDouble();
        int mesEncontrado = -1; // Bandera de no encontrado

        for (int i = 0; i < oroMeses.length; i++) {
            if (oroMeses[i] == oroBuscado) {
                mesEncontrado = i;
                break;
            }
        }

        if (mesEncontrado != -1) {
            System.out.println("¡Encontrado! El valor " + oroBuscado + " se registró en el Mes " + (mesEncontrado + 1));
        } else {
            System.out.println("La cantidad " + oroBuscado + " no ocurrió en ningún mes.");
        }

        // =========================================================
        // 4. CAZA DE BUGS #5 (25 XP)
        // =========================================================
        System.out.println("\n=================================");
        System.out.println("=== CAZA DE BUGS #5 (CORREGIDO) ===");
        System.out.println("=================================");

        int[] temperaturas = {-5, -12, -3, -7};
        
        // Bug 1 corregido: inicializar con el primer elemento de la colección
        int maximoTemp = temperaturas[0];
        int sumaTemp = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > maximoTemp) {
                maximoTemp = temperaturas[i];
            }
            sumaTemp += temperaturas[i];
        }

        // Bug 2 corregido: casting (double) para evitar división entera
        double promedioTemp = (double) sumaTemp / temperaturas.length;

        System.out.println("Máximo  : " + maximoTemp);
        System.out.println("Promedio: " + promedioTemp);

        sc.close();
    }
}
