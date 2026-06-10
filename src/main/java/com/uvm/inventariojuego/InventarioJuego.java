package com.uvm.inventariojuego;

import java.util.Scanner;

public class InventarioJuego {

    public static void main(String args[]) {

        Scanner teclado = new Scanner(System.in);

        int botonSalir = 0;
        int opcion = 0;

        while (botonSalir == 0) {

            try {
                System.out.println("\n=== INVENTARIO DE TU PERSONAJE ===");
                System.out.println("2. Ver Pocion de vida");
                System.out.println("3. Salir del juego");
                System.out.println("Elige una opcion: ");

                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1 -> System.out.println("-> [Espada de Hierro]: Ataque +15. Ideal para matar dragones.");
                    case 2 -> System.out.println("-> [Pocion Roja]: Recupera 50 puntos de salud.");
                    case 3 -> {
                        System.out.println("-> Cerrando mochila... ¡Buena suerte!");
                        botonSalir = 1;
                    }
                    default -> System.out.println("-> Opción invalida. Intenta con 1, 2 o 3.");
                }
            } catch (Exception e) {
                System.out.println("-> Error: ¡Debes ingresar un numero entero!");
                teclado.next();
            }
        }
    }
}
