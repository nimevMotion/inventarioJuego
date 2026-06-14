package com.uvm.inventariojuego;

import com.uvm.inventariojuego.services.LoggerService;
import com.uvm.inventariojuego.services.impl.LogImpl;
import java.util.Scanner;
import com.uvm.inventariojuego.model.Inventario;
import com.uvm.inventariojuego.model.Item;
import com.uvm.inventariojuego.services.InventarioService;
import com.uvm.inventariojuego.services.impl.InventarioImpl;
public class InventarioJuego {

    public static void main(String args[]) {

        Scanner teclado = new Scanner(System.in);
        LoggerService logger = new LogImpl();
//        Inventario inventario = new Inventario();
        InventarioService inventario = new InventarioImpl();
        
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

                        System.out.println("\n=== INVENTARIO ===");

//                        for(Item item : inventario.getItems())
//                        {
//                            System.out.println("----------------");
//                            System.out.println("Nombre: " + item.getNombre());
//                            System.out.println("Descripcion: " + item.getDesc());
//                            System.out.println("Tipo: " + item.getTipo());
//                            System.out.println("Cantidad: " + item.getCantidad());
//                        }
                    }
                    case 3 -> {
                        
                    }
                    case 4 -> {
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
