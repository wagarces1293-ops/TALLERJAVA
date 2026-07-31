import java.util.Scanner;

public class Nivel7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(java.util.Locale.US);

        System.out.println("=================================================");
        System.out.println("=== NIVEL 7 — EL EJÉRCITO (Arrays de Objetos) ===");
        System.out.println("=================================================");

        // =========================================================
        // 1. TE LO MUESTRO Y LO HACEMOS JUNTOS — La Patrulla (10 XP)
        // =========================================================
        System.out.println("\n--- 1. LO HACEMOS JUNTOS: La Patrulla ---");
        
        // Se declara un array de objetos Personaje para 4 guardias
        Personaje[] patrulla = new Personaje[4]; // 1er 'new' (el array)

        for (int i = 0; i < patrulla.length; i++) {
            patrulla[i] = new Personaje(); // ¡LÍNEA IMPRESCINDIBLE! (2do al 5to 'new')
            patrulla[i].nombre = "Guardia " + (i + 1);
            patrulla[i].clase = "Guardia";
            patrulla[i].nivel = 1;
            patrulla[i].vida = 50 + (i * 10);
            patrulla[i].vidaMaxima = 100;
            patrulla[i].ataque = 15;
            patrulla[i].defensa = 10;
            patrulla[i].oro = 20.0;
            patrulla[i].estaVivo = true;
            patrulla[i].arma = "Lanza";
            patrulla[i].esVenenoso = false;
        }

        System.out.println("Estado de la patrulla generada:");
        for (int i = 0; i < patrulla.length; i++) {
            System.out.println("-> " + patrulla[i].nombre + " -> Vida: " + patrulla[i].vida + " | Vivo: " + patrulla[i].estaVivo);
        }

        /*
         * Respuestas a las preguntas de control de La Patrulla:
         * 1. ¿Cuántas veces aparece la palabra new? 5 veces (1 para el array y 4 para las instancias de Personaje).
         * 2. ¿Qué error ocurre si se borra patrulla[i] = new Personaje();? NullPointerException en tiempo de ejecución.
         * 3. ¿Qué vida tiene patrulla[3]? 50 + (3 * 10) = 80.
         */

        // =========================================================
        // 2. AHORA TÚ — MISIÓN 7.1: El Registro del Gremio Completo
        // =========================================================
        System.out.println("\n=========================================================");
        System.out.println("=== MISIÓN 7.1 - EL REGISTRO DEL GREMIO COMPLETO ===");
        System.out.println("=========================================================");

        System.out.print("¿Cuántos miembros tiene el gremio? ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // Limpieza del Enter del teclado

        if (cantidad <= 0) {
            System.out.println("El gremio debe tener al menos 1 miembro.");
        } else {
            Personaje[] gremio = new Personaje[cantidad];

            // 2.1 Petición de datos con ciclo for
            System.out.println("\n=== REGISTRO DE MIEMBROS ===");
            for (int i = 0; i < gremio.length; i++) {
                gremio[i] = new Personaje(); // ¡Instanciación obligatoria!
                
                System.out.println("\n--- Miembro #" + (i + 1) + " ---");
                System.out.print("Nombre completo: ");
                gremio[i].nombre = sc.nextLine();

                System.out.print("Clase (Guerrero/Mago/Arquero/etc.): ");
                gremio[i].clase = sc.nextLine();

                System.out.print("Nivel: ");
                gremio[i].nivel = sc.nextInt();

                System.out.print("Vida actual: ");
                gremio[i].vida = sc.nextInt();

                System.out.print("Vida máxima: ");
                gremio[i].vidaMaxima = sc.nextInt();

                System.out.print("Ataque base: ");
                gremio[i].ataque = sc.nextInt();

                System.out.print("Defensa base: ");
                gremio[i].defensa = sc.nextInt();

                System.out.print("Oro inicial: ");
                gremio[i].oro = sc.nextDouble();
                sc.nextLine(); // Limpieza tras el número

                System.out.print("Arma principal: ");
                gremio[i].arma = sc.nextLine();

                System.out.print("¿Tiene ataque venenoso? (true/false): ");
                gremio[i].esVenenoso = sc.nextBoolean();
                sc.nextLine(); // Limpieza del Enter tras nextBoolean() para que el próximo nextLine() funcione correctamente

                gremio[i].estaVivo = (gremio[i].vida > 0);
            }

            // 2.2 Mostrar la tabla completa del gremio
            System.out.println("\n=========================================================================================================");
            System.out.println("                                      TABLA GENERAL DEL GREMIO                                           ");
            System.out.println("=========================================================================================================");
            System.out.printf("%-4s %-20s %-12s %-6s %-10s %-8s %-9s %-10s %-8s %-12s %-8s\n",
                    "ID", "Nombre", "Clase", "Nivel", "Vida/Max", "Ataque", "Defensa", "Oro", "Estado", "Arma", "Veneno");
            System.out.println("---------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < gremio.length; i++) {
                String estadoStr = gremio[i].estaVivo ? "VIVO" : "CAÍDO";
                String venenoStr = gremio[i].esVenenoso ? "SÍ" : "NO";
                String vidaStr = gremio[i].vida + "/" + gremio[i].vidaMaxima;
                System.out.printf("[%d]  %-20s %-12s %-6d %-10s %-8d %-9d %-10.2f %-8s %-12s %-8s\n",
                        (i + 1), gremio[i].nombre, gremio[i].clase, gremio[i].nivel, vidaStr,
                        gremio[i].ataque, gremio[i].defensa, gremio[i].oro, estadoStr, gremio[i].arma, venenoStr);
            }
            System.out.println("---------------------------------------------------------------------------------------------------------");

            // 2.3 Estadísticas: Oro total, promedio, mejor y peor vida, niveles sobre promedio
            double oroTotalGremio = 0;
            int sumaNiveles = 0;

            for (int i = 0; i < gremio.length; i++) {
                oroTotalGremio += gremio[i].oro;
                sumaNiveles += gremio[i].nivel;
            }

            double oroPromedio = oroTotalGremio / gremio.length;
            double nivelPromedio = (double) sumaNiveles / gremio.length;

            int posMasVida = 0;
            int posMenosVida = 0;

            for (int i = 1; i < gremio.length; i++) {
                if (gremio[i].vida > gremio[posMasVida].vida) {
                    posMasVida = i;
                }
                if (gremio[i].vida < gremio[posMenosVida].vida) {
                    posMenosVida = i;
                }
            }

            int miembrosSobrePromedioNivel = 0;
            for (int i = 0; i < gremio.length; i++) {
                if (gremio[i].nivel > nivelPromedio) {
                    miembrosSobrePromedioNivel++;
                }
            }

            System.out.println("\n--- ESTADÍSTICAS DEL GREMIO ---");
            System.out.printf("Oro total acumulado : %.2f monedas\n", oroTotalGremio);
            System.out.printf("Promedio de oro     : %.2f monedas por miembro\n", oroPromedio);
            System.out.printf("Promedio de nivel   : %.2f\n", nivelPromedio);
            System.out.println("Miembro con MÁS vida: " + gremio[posMasVida].nombre + " (" + gremio[posMasVida].vida + " HP)");
            System.out.println("Miembro con MENOS vida: " + gremio[posMenosVida].nombre + " (" + gremio[posMenosVida].vida + " HP)");
            System.out.println("Miembros por encima del nivel promedio: " + miembrosSobrePromedioNivel);

            // 2.4 Búsqueda de miembro por nombre (usando equalsIgnoreCase y bandera -1)
            System.out.print("\nIngrese el nombre del miembro que desea buscar: ");
            String nombreBuscado = sc.nextLine();
            int posBuscado = -1; // Bandera de no encontrado

            for (int i = 0; i < gremio.length; i++) {
                if (gremio[i].nombre.equalsIgnoreCase(nombreBuscado)) {
                    posBuscado = i;
                    break;
                }
            }

            if (posBuscado != -1) {
                Personaje p = gremio[posBuscado];
                System.out.println("\n=== FICHA DE MIEMBRO ENCONTRADO ===");
                System.out.println("Nombre       : " + p.nombre);
                System.out.println("Clase        : " + p.clase);
                System.out.println("Nivel        : " + p.nivel);
                System.out.println("Vida         : " + p.vida + " / " + p.vidaMaxima);
                System.out.println("Ataque       : " + p.ataque);
                System.out.println("Defensa      : " + p.defensa);
                System.out.println("Oro          : " + p.oro);
                System.out.println("Estado       : " + (p.estaVivo ? "Vivo" : "Derrotado"));
                System.out.println("Arma         : " + p.arma);
                System.out.println("Ataque Veneno: " + (p.esVenenoso ? "Sí" : "No"));
            } else {
                System.out.println("El héroe \"" + nombreBuscado + "\" no pertenece al gremio.");
            }

            // 2.5 Aplicar Evento de Subsidio (Nivel < 5 recibe 50 de oro)
            System.out.println("\n--- EVENTO DE SUBSIDIO DEL GREMIO ---");
            int beneficiados = 0;
            for (int i = 0; i < gremio.length; i++) {
                if (gremio[i].nivel < 5) {
                    gremio[i].oro += 50.0;
                    beneficiados++;
                    System.out.println("[SUBSIDIO] " + gremio[i].nombre + " (Nivel " + gremio[i].nivel + ") recibió 50 de oro. Nuevo saldo: " + gremio[i].oro);
                }
            }
            System.out.println("Total de miembros beneficiados con subsidio: " + beneficiados);

            // 2.6 BONUS CREATIVO: Combate en cadena (Miembro 0 ataca a 1, 1 a 2, ..., último al 0)
            System.out.println("\n=================================================");
            System.out.println("=== BONUS CREATIVO: COMBATE EN CADENA ===========");
            System.out.println("=================================================");

            if (gremio.length > 1) {
                for (int i = 0; i < gremio.length; i++) {
                    int objetivo = (i + 1) % gremio.length;

                    if (gremio[i].estaVivo && gremio[objetivo].estaVivo) {
                        int danioBase = gremio[i].ataque - gremio[objetivo].defensa;
                        if (danioBase < 0) {
                            danioBase = 0;
                        }
                        
                        int danioExtra = gremio[i].esVenenoso ? 5 : 0;
                        int danioTotal = danioBase + danioExtra;

                        gremio[objetivo].vida -= danioTotal;
                        System.out.print(gremio[i].nombre + " ataca a " + gremio[objetivo].nombre + " infligiendo " + danioTotal + " de daño");
                        if (danioExtra > 0) {
                            System.out.print(" (¡+5 por veneno!)");
                        }
                        System.out.println(".");

                        if (gremio[objetivo].vida <= 0) {
                            gremio[objetivo].vida = 0;
                            gremio[objetivo].estaVivo = false;
                            System.out.println("-> ¡" + gremio[objetivo].nombre + " ha sido derrotado en el combate!");
                        } else {
                            System.out.println("-> " + gremio[objetivo].nombre + " sobrevive con " + gremio[objetivo].vida + " HP.");
                        }
                    } else if (!gremio[i].estaVivo) {
                        System.out.println(gremio[i].nombre + " está caído y no puede atacar.");
                    } else {
                        System.out.println(gremio[i].nombre + " no puede atacar a " + gremio[objetivo].nombre + " porque ya está caído.");
                    }
                }

                System.out.println("\n--- ESTADO FINAL TRAS COMBATE EN CADENA ---");
                for (int i = 0; i < gremio.length; i++) {
                    System.out.println("[" + (i + 1) + "] " + gremio[i].nombre + " -> Vida: " + gremio[i].vida + " | Estado: " + (gremio[i].estaVivo ? "VIVO" : "CAÍDO"));
                }
            } else {
                System.out.println("Se requieren al menos 2 miembros para realizar el combate en cadena.");
            }
        }

        // =========================================================
        // 3. CAZA DE BUGS #7 (25 XP)
        // =========================================================
        System.out.println("\n==============================================");
        System.out.println("=== CAZA DE BUGS #7 (CORREGIDO Y AUDITADO) ===");
        System.out.println("==============================================");

        Personaje[] equipoBug = new Personaje[3];
        
        // Bug 1 corregido: agregar la instanciación de cada objeto dentro del ciclo
        for (int i = 0; i < equipoBug.length; i++) {
            equipoBug[i] = new Personaje(); // Solución al Bug 1 (NullPointerException)
            equipoBug[i].nombre = "Héroe " + (i + 1);
            equipoBug[i].vida = 100;
        }

        // Bug 2 corregido: usar i < equipoBug.length en lugar de i <= equipoBug.length
        System.out.println("Lista de héroes corregida:");
        for (int i = 0; i < equipoBug.length; i++) { // Solución al Bug 2 (ArrayIndexOutOfBoundsException)
            System.out.println("- " + equipoBug[i].nombre + " (Vida: " + equipoBug[i].vida + ")");
        }

        /*
         * Informe Caza de Bugs #7:
         * 1. Bug 1: El programa original fallaba en la primera vuelta del primer ciclo con java.lang.NullPointerException
         *    porque new Personaje[3] solo crea el contenedor de 3 casillas vacías (todas en null). Faltaba la línea
         *    equipo[i] = new Personaje(); como primera instrucción dentro del primer ciclo.
         * 
         * 2. Bug 2: Al corregir el Bug 1, el programa se caía al final del segundo ciclo con java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3.
         *    Ocurre porque la condición i <= equipo.length intentaba acceder al índice 3 en un array de tamaño 3.
         * 
         * 3. Índice máximo válido: El índice máximo válido para este array de tamaño 3 es 2 (equipo.length - 1).
         * 
         * 4. Ambos bugs fueron solucionados exitosamente y el programa ejecuta sin errores.
         */

        sc.close();
    }
}
