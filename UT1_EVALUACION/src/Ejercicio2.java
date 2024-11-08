// Ejercicio 2: Simulación de un Juego de Dados con Executors
// Enunciado: Implementa un programa que simule el lanzamiento de un dado utilizando tres hilos gestionados por un ScheduledExecutorService.
// Cada hilo debe generar un número aleatorio entre 1 y 6 cada segundo y almacenarlo en una lista.
// Después de 5 lanzamientos, el programa debe imprimir el valor acumulado por cada hilo y cerrar el ExecutorService.


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio2 {

    public static void main(String[] args) {

        // Creación de tres hilos, cada uno representando un jugador lanzando el dado
        Thread jugador1 = new Thread(new SimulacionDado("Jugador 1"));
        Thread jugador2 = new Thread(new SimulacionDado("Jugador 2"));
        Thread jugador3 = new Thread(new SimulacionDado("Jugador 3"));

        // Iniciar los hilos
        jugador1.start();
        jugador2.start();
        jugador3.start();
    }

    static class SimulacionDado implements Runnable {
        private String nombreJugador;
        private List<Integer> lanzamientos;
        private Random random;

        public SimulacionDado(String nombreJugador) {
            this.nombreJugador = nombreJugador;
            this.lanzamientos = new ArrayList<>();
            this.random = new Random();
        }

        @Override
        public void run() {
            int totalAcumulado = 0;

            for (int i = 1; i <= 5; i++) {
                // Generar un número aleatorio entre 1 y 6
                int lanzamiento = random.nextInt(6) + 1;
                lanzamientos.add(lanzamiento);
                totalAcumulado += lanzamiento;

                // Imprimir el resultado del lanzamiento
                System.out.println(nombreJugador + " lanzó un " + lanzamiento);

                try {
                    // Pausar el hilo por 1 segundo
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("Hilo interrumpido: " + nombreJugador);
                }
            }

            // Imprimir el total acumulado después de 5 lanzamientos
            System.out.println(nombreJugador + " acumuló un total de: " + totalAcumulado);
        }
    }

}
