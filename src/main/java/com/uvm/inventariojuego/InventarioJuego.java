package com.uvm.inventariojuego;

import java.util.Scanner;
import com.uvm.inventariojuego.model.Item;
import com.uvm.inventariojuego.services.InventarioService;
import com.uvm.inventariojuego.services.LoggerService;
import com.uvm.inventariojuego.services.impl.InventarioImpl;
import com.uvm.inventariojuego.services.impl.LogImpl;

public class InventarioJuego {

    public static void main(String args[]) {

        Scanner teclado = new Scanner(System.in);
//        Inventario inventario = new Inventario();
        InventarioService inventario = new InventarioImpl();
        LoggerService logger = new LogImpl();

//        for(Item item : inventario.getItems())
//        {
//            System.out.println("Nombre: " + item.getNombre());
//            System.out.println("Descripcion: " + item.getDesc());
//            System.out.println("Tipo: " + item.getTipo());
//            System.out.println("Cantidad: " + item.getCantidad());
//        }
        int botonSalir = 0;
        int opcion = 0;

        while (botonSalir == 0) {

            try {

                System.out.println("\n=== INVENTARIO DE TU PERSONAJE ===");
                System.out.println("1. Gestionar Inventario");
                System.out.println("2. Buscar");
                System.out.println("3. Ver historial");
                System.out.println("4. Salir");
                System.out.println("Elige una opcion: ");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1 -> {
                        int menu_inv = 0;
                        boolean enSubMenu = true;

                        while (enSubMenu) {
                            try {
                                System.out.println("\n=== GESTION DE INVENTARIO ===");
                                System.out.println("1. Agregar objeto");
                                System.out.println("2. Modificar");
                                System.out.println("3. Eliminar");
                                System.out.println("4. Salir");
                                System.out.println("Elige una opcion: ");
                                menu_inv = teclado.nextInt();

                                switch (menu_inv) {
                                    case 1 -> {
                                        System.out.println("\n=== REGISTAR OBJETO ===\n");
                                        teclado.nextLine();
                                        Item item = new Item();
                                        System.out.print("Nombre: ");
                                        item.setNombre(teclado.nextLine());
                                        System.out.print("Descripcion: ");
                                        item.setDesc(teclado.nextLine());
                                        System.out.print("Tipo (Arma, Armadura, Pocion): ");
                                        item.setTipo(teclado.nextLine());
                                        System.out.print("Cantidad: ");
                                        item.setCantidad(teclado.nextInt());
                                        inventario.agregarItem(item);
                                        System.out.println("Objeto registrado correctamente.");
                                    }
                                    case 2 -> {
                                        inventario.modificarItem();
                                        break;
                                    }
                                    case 3 -> {
                                        inventario.eliminarItem();

                                    }
                                    case 4 ->
                                        enSubMenu = false;
                                    default ->
                                        System.out.println("-> Opción invalida.");
                                }
                            } catch (Exception e) {
                                System.out.println("-> Error: ¡Debes ingresar un numero entero!");
                                teclado.next();
                            }
                        }  // ← Fin while
                    }  // ← Fin case 1
                    case 2 -> {
                        System.out.println("\n=== INVENTARIO ===\n");
                        teclado.nextLine();
                        System.out.print("Nombre: ");

                        String nombre = teclado.nextLine();
                        inventario.buscarItem(nombre);
                    }
                    case 3 -> {
                        System.out.println("\n=== HISTORIAL ===\n");
                        logger.getLog();
                    }
                    case 4 -> {
                        System.out.println("-> Cerrando mochila... ¡Buena suerte!");
                        botonSalir = 1;
                    }
                    default ->
                        System.out.println("-> Opción invalida. Intenta con 1, 2 o 3.");
                }
            } catch (Exception e) {
                System.out.println("-> Error: ¡Debes ingresar un numero entero!");
                teclado.next();
            }
        }
    }
}
