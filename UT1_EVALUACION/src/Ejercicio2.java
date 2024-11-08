// Ejercicio 2: Simulación de un Juego de Dados con Executors
// Enunciado: Implementa un programa que simule el lanzamiento de un dado utilizando tres hilos gestionados por un ScheduledExecutorService.
// Cada hilo debe generar un número aleatorio entre 1 y 6 cada segundo y almacenarlo en una lista.
// Después de 5 lanzamientos, el programa debe imprimir el valor acumulado por cada hilo y cerrar el ExecutorService.


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ejercicio2 {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        SimulacionDado jugador1 = new SimulacionDado("Jugador 1");
        SimulacionDado jugador2 = new SimulacionDado("Jugador 2");
        SimulacionDado jugador3 = new SimulacionDado("Jugador 3");

        executorService.scheduleAtFixedRate(jugador1, 0, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(jugador2, 0, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(jugador3, 0, 1, TimeUnit.SECONDS);

        executorService.schedule(() -> {
            executorService.shutdown();
        }, 5, TimeUnit.SECONDS);
    }

    static class SimulacionDado implements Runnable {
        private String nombreJugador;
        private List<Integer> lanzamientos;
        private Random random;
        private int lanzamientosRestantes;

        public SimulacionDado(String nombreJugador) {
            this.nombreJugador = nombreJugador;
            this.lanzamientos = new ArrayList<>();
            this.random = new Random();
            this.lanzamientosRestantes = 5; // Limitar a 5 lanzamientos
        }

        @Override
        public void run() {
            if (lanzamientosRestantes > 0) {
                int lanzamiento = random.nextInt(6) + 1;
                lanzamientos.add(lanzamiento);
                System.out.println(nombreJugador + " lanzó un " + lanzamiento);
                lanzamientosRestantes--;

                if (lanzamientosRestantes == 0) {
                    int totalAcumulado = lanzamientos.stream().mapToInt(Integer::intValue).sum();
                    System.out.println(nombreJugador + " acumuló un total de: " + totalAcumulado);
                }
            }
        }
    }
}

