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

                if (opcion == 1) {
                    System.out.println("-> [Espada de Hierro]: Ataque +15. Ideal para matar dragones.");
                } else if (opcion == 2) {
                    System.out.println("-> [Pocion Roja]: Recupera 50 puntos de salud.");
                } else if (opcion == 3) {
                    System.out.println("-> Cerrando mochila... ¡Buena suerte!");
                    botonSalir = 1;
                } else {
                    System.out.println("-> Opción invalida. Intenta con 1, 2 o 3.");
                }
            } catch (Exception e) {
                System.out.println("-> Error: ¡Debes ingresar un numero entero!");
                teclado.next();
            }
        }
    }
}
