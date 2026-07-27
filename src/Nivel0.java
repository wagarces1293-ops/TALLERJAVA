public class Nivel0 {
        public static void main(String[] args) {
            String nombreObjeto = "Poción de vida";
            double precioUnitario = 12.5;
            int cantidad = 4;
            double totalGastado = precioUnitario * cantidad;
            System.out.println("Objeto: " + nombreObjeto);
            System.out.println("Compraste " + cantidad + " unidades");
            System.out.println("Gastaste: " + totalGastado + " monedas de oro");

        }

}
/*
* 1.  ¿Por qué precioUnitario no puede ser int? Porque es un decimal.
2.  ¿Qué pasa si escribo 12,5 en vez de 12.5? Da error
3.  ¿Qué imprime "Total: " + 4 + 2? ¿Y "Total: " + (4 + 2)? Lo mismo 6
* */
