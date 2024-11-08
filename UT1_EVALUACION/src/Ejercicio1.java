// Ejercicio 1: Hilos con Nombres Personalizados (Sencillo)
// Enunciado: Crea tres clases (o una y crear 3 instancias) que extiendan Thread, cada una de las cuales imprimirá
// su nombre en cada iteración de un bucle de 1 a 5.
// Asigna nombres personalizados a los hilos (por ejemplo, "Hilo A", "Hilo B", "Hilo C") en el constructor de cada clase
// y lanza estos hilos desde el main.
// Verifica que los nombres de los hilos se impriman de forma intercalada en la consola.

public class Ejercicio1 extends Thread {

    public static void main(String[] args) {

        Thread HiloA = new Thread(new NombreHilo("Hilo A"));
        Thread HiloB = new Thread(new NombreHilo("Hilo B"));
        Thread HiloC = new Thread(new NombreHilo("Hilo C"));

        HiloA.start();
        HiloB.start();
        HiloC.start();

    }

    static class NombreHilo implements Runnable {
        private String nombre;

        public NombreHilo(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Nombre del hilo: " + nombre);
            }
        }
    }
}