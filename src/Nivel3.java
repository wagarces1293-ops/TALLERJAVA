import java.util.Scanner;
public class Nivel3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- 1.COMBATE DRAGÓN ---

        int vidaHeroe = 100;
        int vidaDragon = 120;
        int ataqueHeroe = 25;
        int ataqueDragon = 18;
        int turno = 1;
        int danioTotalHecho = 0;
        System.out.println("=== ¡COMIENZA EL COMBATE! ===");
        while (vidaHeroe > 0 && vidaDragon > 0) {
            System.out.println();
            System.out.println("--- TURNO " + turno + " ---");
            // El héroe ataca
            vidaDragon -= ataqueHeroe;
            danioTotalHecho += ataqueHeroe;
            System.out.println("Golpeas al dragón por " + ataqueHeroe + ". Le quedan " +
                    vidaDragon);
            // Si el dragón sigue vivo, contraataca
            if (vidaDragon > 0) {
                vidaHeroe -= ataqueDragon;
                System.out.println("El dragón te quema por " + ataqueDragon + ". Te quedan " +
                        vidaHeroe);
            }
            turno++;
        }
        System.out.println();
        System.out.println("=== FIN DEL COMBATE ===");
        if (vidaHeroe > 0) {
            System.out.println("¡VICTORIA! Vida restante: " + vidaHeroe);
        } else {
            System.out.println("DERROTA. El dragón te venció.");
        }
        System.out.println("Turnos jugados: " + (turno - 1));
        System.out.println("Daño total infligido: " + danioTotalHecho);

        // --- 2. ENTRENAMIENTO CON WHILE ---

        int experiencia = 0; // inicialización
        int sesiones = 0;
        while (experiencia < 100) { // condición
            experiencia += 5; // actualización del acumulador
            sesiones++; // contador
            System.out.println("Sesión " + sesiones + " → XP: " + experiencia);
        }
        System.out.println("Entrenamiento completo en " + sesiones + " sesiones");

        // --- 2. ENTRENAMIENTO CON FOR ---

        int experienciaFor = 0; // inicialización
        int sesionesFor = 0;
        for (int i = 5; i <= 100; i += 5) { // condición
            experienciaFor = i; // actualización del acumulador
            sesionesFor++; // contador
            System.out.println("Sesión " + sesionesFor + " → XP: " + experienciaFor);
        }
        System.out.println("Entrenamiento completo en " + sesionesFor + " sesiones");

        System.out.println("--- MISION 3.0: TORNEO ---");

        int goldHero = 0;
        int vidaHero3 = 100;
        int vidaResta = 0;
        int rondasGanadas = 0;
        int opcion = 0;
        System.out.println("==================================================");
        System.out.println("==============¡BIENVENIDO AL TORNEO!==============");
        System.out.println("==================================================");
        do {
            System.out.println("1.Pelear");
            System.out.println("2.Descansar");
            System.out.println("3.Ver estado");
            System.out.println("4.Retirarse");
            opcion = sc.nextInt();

            if (opcion == 1) {
                rondasGanadas++;
                if (rondasGanadas % 3 == 0) {
                    vidaHero3 -= 40;
                    goldHero += 150;
                } else {
                    vidaHero3 -= 15;
                    goldHero += 40;
                }
            } else if (opcion == 2) {

                if (vidaHero3 <= 80 && goldHero > 10) {
                    vidaHero3 += 20;
                    goldHero -= 10;
                } else if (vidaHero3 > 80 && goldHero > 10) {
                    vidaResta = 100 - vidaHero3;
                    vidaHero3 += vidaResta;
                    goldHero -= 10;
                } else {
                    System.out.println("Pobre XD");
                }

            } else if (opcion == 3) {
                System.out.println("\n --- ESTADO DEL HEROE --- \n");
                System.out.println("Vida:" + vidaHero3 + " / 100");
                System.out.println("Oro :" + goldHero);
                System.out.println("Peleas Ganadas: " + rondasGanadas);
            } else if (opcion == 4) {
                System.out.println("Huyes como un cobarde");
            } else {
                System.out.println("Opcion no valida, intenta de nuevo");
            }
        } while (opcion != 4 && vidaHero3 > 0);
        if (vidaHero3 <= 0) {
            System.out.println("Te moriste");
        }
        System.out.println("===============================");
        System.out.println("============RESUMEN============");
        System.out.println("===============================");
        System.out.println("Peleas Ganadas: " + rondasGanadas);
        System.out.println("Oro acumulado: " + goldHero);
        System.out.println("Vida final: " + vidaHero3);
        System.out.println("===============================");

        System.out.println("============================");
        System.out.println("========Casa de Bugs========");
        System.out.println("============================");


        int i2 = 1;
        int suma = 0;
        while (i2 <= 10) {
            i2++;
            suma += i2;

        }
        System.out.println("La suma es: " + suma);
        int suma2 = 0;
        for (int j = 0; j <= 10; j++) {
            suma2 += j;
        }
        System.out.println("La suma es: " + suma2);

    }
}

