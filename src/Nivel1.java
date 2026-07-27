import java.util.Scanner;
public class Nivel1 {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.print("Ingrese el nombre del guerrero");
        String name = sc.nextLine();
        System.out.print("Ingrese la edad del guerrero");
        int edad = sc.nextInt();
        System.out.print("Ingrese la vida base del guerrero");
        int vidaBase = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el ataque base del guerrero");
        int atqb = sc.nextInt();
        System.out.print("Ingrese la defensa base del guerrero");
        int defb = sc.nextInt();
        System.out.print("Ingrese el oro inicial requerido");
        int oroi = sc.nextInt();
        System.out.print("Ingrese la clase del guerrero deseada");
        String claseg = sc.next();
        System.out.println("Poder de combate total: " + atqb*3 + defb*2);
        System.out.println("Nivel estimado: "+ vidaBase/10);
        if (oroi < 50){
            System.out.println("No se puede pagar la inscripción, oro insuficiente");
        }else {
            System.out.println("Oro tras pagar la inscripción" + (oroi - 50));
        }
        sc.close();
    }
}
