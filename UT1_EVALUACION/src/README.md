# UT1 EVALUACION
#### Hecho por Alejandro López Santos

## Ejercicio 1

En este ejercicio creamos tres hilos con diferentes nombres y hacemos que ejecuten un bucle que muestra el nombre de estos hilos 5 veces, podemos ver que al ejecutarlo, los hilos muestran sus nombres de forma intercalada entre ellos.

Salida por pantalla:
```
Nombre del hilo: Hilo A
Nombre del hilo: Hilo A
Nombre del hilo: Hilo A
Nombre del hilo: Hilo A
Nombre del hilo: Hilo C
Nombre del hilo: Hilo B
Nombre del hilo: Hilo A
Nombre del hilo: Hilo C
Nombre del hilo: Hilo C
Nombre del hilo: Hilo C
Nombre del hilo: Hilo C
Nombre del hilo: Hilo B
Nombre del hilo: Hilo B
Nombre del hilo: Hilo B
Nombre del hilo: Hilo B
```


## Ejercicio 2

En este ejercicio utilizamos ScheduledExecutorService para crear tres hilos directamente, cada uno de esos hilos será un jugador el cuál tendrá 5 lanzamientos, cada uno de esos lanzamientos puede sacar un número del 1 al 6, mostramos por pantalla cada lanzamiento de cada jugador y cuando ya han hecho 5 lanzamientos mostramos el total de puntos que ha obtenido cada uno  de los jugadores.

Salida por pantalla:
```
Jugador 3 lanzó un 2
Jugador 2 lanzó un 2
Jugador 1 lanzó un 1
Jugador 1 lanzó un 6
Jugador 2 lanzó un 3
Jugador 3 lanzó un 4
Jugador 1 lanzó un 4
Jugador 3 lanzó un 1
Jugador 2 lanzó un 5
Jugador 2 lanzó un 6
Jugador 3 lanzó un 6
Jugador 1 lanzó un 1
Jugador 1 lanzó un 4
Jugador 2 lanzó un 3
Jugador 3 lanzó un 5
Jugador 1 acumuló un total de: 16
Jugador 3 acumuló un total de: 18
Jugador 2 acumuló un total de: 19

Process finished with exit code 0
```