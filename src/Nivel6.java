

//Parte A
//Enemigo Java
public class Enemigo {
    String nombre;
    int vida;
    int ataque;
    double recompensaOro;
    boolean esJefe;
}



//mazmorra.java

public class Mazmorra {
    public static void main(String[] args) {
        Enemigo goblin = new Enemigo();
        goblin.nombre = "Goblin";
        goblin.vida = 50;
        goblin.ataque = 12;
        goblin.recompensaOro = 15.5;
        goblin.esJefe = false;

        Enemigo dragon = new Enemigo();
        dragon.nombre = "Dragón";
        dragon.vida = 300;
        dragon.ataque = 40;
        dragon.esJefe = true;
        dragon.recompensaOro = 500.0;

        System.out.println("Enemigos en la mazmorra:");
        System.out.println("- " + goblin.nombre + " (vida " + goblin.vida + ")");
        System.out.println("- " + dragon.nombre + " (vida " + dragon.vida + ")");
        
        if (dragon.esJefe) {
            System.out.println(dragon.nombre + " es un JEFE. ¡Cuidado!");
        }
    }
}

//Parte B

//Misión 6.1 + Bonus Creativo
public class Personaje {
    String nombre;
    String clase;
    int nivel;
    int vida;
    int vidaMaxima;
    int ataque;
    int defensa;
    double oro;
    boolean estaVivo;
    
    // Bonus creativo
    String arma;
    boolean esVenenoso;
}

//aventura.java
import java.util.Scanner;

public class Aventura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Personaje 1 (Datos fijos)
        Personaje p1 = new Personaje();
        p1.nombre = "Aria";
        p1.clase = "Arquero";
        p1.nivel = 12;
        p1.vidaMaxima = 120;
        p1.vida = 120;
        p1.ataque = 30;
        p1.defensa = 15;
        p1.oro = 150.0;
        p1.estaVivo = true;
        p1.arma = "Arco Largo";
        p1.esVenenoso = true; // Bonus: Tiene veneno

        // 2. Personaje 2 (Datos fijos)
        Personaje p2 = new Personaje();
        p2.nombre = "Braum";
        p2.clase = "Guerrero";
        p2.nivel = 15;
        p2.vidaMaxima = 200;
        p2.vida = 200;
        p2.ataque = 20;
        p2.defensa = 40;
        p2.oro = 300.0;
        p2.estaVivo = true;
        p2.arma = "Escudo Pesado";
        p2.esVenenoso = false;

        // 3. Personaje 3 (Datos por Scanner)
        Personaje p3 = new Personaje();
        System.out.println("=== CREA A TU HÉROE ===");
        System.out.print("Nombre: ");
        p3.nombre = sc.nextLine();
        System.out.print("Clase: ");
        p3.clase = sc.nextLine();
        System.out.print("Nivel: ");
        p3.nivel = sc.nextInt();
        System.out.print("Vida Máxima (y actual): ");
        p3.vidaMaxima = sc.nextInt();
        p3.vida = p3.vidaMaxima;
        System.out.print("Ataque: ");
        p3.ataque = sc.nextInt();
        System.out.print("Defensa: ");
        p3.defensa = sc.nextInt();
        System.out.print("Oro: ");
        p3.oro = sc.nextDouble();
        sc.nextLine(); // Limpieza del buffer
        p3.estaVivo = true;
        System.out.print("Nombre del Arma: ");
        p3.arma = sc.nextLine();
        p3.esVenenoso = false;

        System.out.println("\n=== FICHAS DE PERSONAJES ===");
        System.out.println("1: " + p1.nombre + " | Vida: " + p1.vida + "/" + p1.vidaMaxima + " | Arma: " + p1.arma);
        System.out.println("2: " + p2.nombre + " | Vida: " + p2.vida + "/" + p2.vidaMaxima + " | Arma: " + p2.arma);
        System.out.println("3: " + p3.nombre + " | Vida: " + p3.vida + "/" + p3.vidaMaxima + " | Arma: " + p3.arma);

        // Cálculo de Poder
        int poder1 = (p1.ataque * 3) + (p1.defensa * 2) + (p1.nivel * 10);
        int poder2 = (p2.ataque * 3) + (p2.defensa * 2) + (p2.nivel * 10);
        int poder3 = (p3.ataque * 3) + (p3.defensa * 2) + (p3.nivel * 10);

        System.out.println("\n=== EL MÁS PODEROSO ===");
        if (poder1 > poder2 && poder1 > poder3) {
            System.out.println(p1.nombre + " tiene el mayor poder (" + poder1 + ")");
        } else if (poder2 > poder1 && poder2 > poder3) {
            System.out.println(p2.nombre + " tiene el mayor poder (" + poder2 + ")");
        } else if (poder3 > poder1 && poder3 > poder2) {
            System.out.println(p3.nombre + " tiene el mayor poder (" + poder3 + ")");
        } else {
            System.out.println("Hay un empate en el poder máximo.");
        }

        // Simulación de Ataque: Personaje 1 ataca a Personaje 3
        System.out.println("\n=== SIMULACIÓN DE COMBATE ===");
        System.out.println(p1.nombre + " ataca a " + p3.nombre + " con " + p1.arma);
        
        int danio = p1.ataque - p3.defensa;
        if (danio < 0) {
            danio = 0;
        }
        
        // Bonus creativo: daño por veneno
        if (p1.esVenenoso) {
            System.out.println("¡Ataque venenoso! Daño extra aplicado.");
            danio += 5;
        }

        p3.vida -= danio;
        if (p3.vida <= 0) {
            p3.vida = 0;
            p3.estaVivo = false;
        }

        System.out.println(p3.nombre + " recibe " + danio + " puntos de daño.");

        // Curación a Personaje 3
        System.out.println("\n=== CURACIÓN ===");
        if (p3.estaVivo) {
            p3.vida += 30;
            if (p3.vida > p3.vidaMaxima) {
                p3.vida = p3.vidaMaxima;
            }
            System.out.println(p3.nombre + " se cura 30 puntos. Vida actual: " + p3.vida + "/" + p3.vidaMaxima);
        } else {
            System.out.println(p3.nombre + " no puede curarse porque ha caído en combate.");
        }

        // Estado Final
        System.out.println("\n=== ESTADO FINAL ===");
        System.out.println("1: " + p1.nombre + " | Vida: " + p1.vida);
        System.out.println("2: " + p2.nombre + " | Vida: " + p2.vida + " (Intacto)");
        System.out.println("3: " + p3.nombre + " | Vida: " + p3.vida + " | Vivo: " + p3.estaVivo);

        sc.close();
    }
}

//Parte C- Caza de Bugs

public class BugObjetos {
    public static void main(String[] args) {
        Heroe h1 = new Heroe();
        h1.nombre = "Aria";
        h1.vida = 100;

        // Bug 2 Corregido: Inicialización de un nuevo objeto en lugar de copiar la referencia
        Heroe h2 = new Heroe();
        h2.nombre = "Kael";
        h2.vida = 150;

        // Bug 1 Corregido: Se añade la instanciación de h3 para evitar el NullPointerException / variable no inicializada
        Heroe h3 = new Heroe();
        h3.nombre = "Nyx";

        System.out.println("h1: " + h1.nombre + " - " + h1.vida);
        System.out.println("h2: " + h2.nombre + " - " + h2.vida);
    }
}
