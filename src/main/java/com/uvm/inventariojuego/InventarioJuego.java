package com.uvm.inventariojuego;

import com.uvm.inventariojuego.services.LoggerService;
import com.uvm.inventariojuego.services.impl.LogImpl;
import java.util.Scanner;
import com.uvm.inventariojuego.model.Inventario;
import com.uvm.inventariojuego.model.Item;
import com.uvm.inventariojuego.services.InventarioService;
import com.uvm.inventariojuego.services.impl.InventarioImpl;
import java.util.List;

public class InventarioJuego {   

    public static void main(String args[]) {

        Scanner teclado = new Scanner(System.in);
        LoggerService logger = new LogImpl();
        Inventario inventario = new Inventario();
//        InventarioService inventario = new InventarioImpl();
        
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
                                        List<Item> items = inventario.getItems();

                                        if (items.isEmpty()) {
                                            System.out.println("-> No hay objetos en el inventario.");
                                        } else {
                                            // Mostrar todos los objetos guardados
                                            System.out.println("\n=== MODIFICAR OBJETO ===\n");
                                            for (int i = 0; i < items.size(); i++) {
                                                System.out.println(i + ". " + items.get(i).getNombre() 
                                                                 + " || " + items.get(i).getTipo()
                                                                 + " || Cantidad: " + items.get(i).getCantidad());
                                            }
                                            
                                            System.out.print("Numero de objeto a modificar: ");
                                            int indice = teclado.nextInt();

                                            if (indice >= 0 && indice < items.size()) {
                                                Item item = items.get(indice);
                                                teclado.nextLine();

                                                System.out.print("Nuevo nombre (" + item.getNombre() + "): ");
                                                item.setNombre(teclado.nextLine());

                                                System.out.print("Nueva descripcion (" + item.getDesc() + "): ");
                                                item.setDesc(teclado.nextLine());

                                                System.out.print("Nuevo tipo (" + item.getTipo() + "): ");
                                                item.setTipo(teclado.nextLine());

                                                System.out.print("Nueva cantidad (" + item.getCantidad() + "): ");
                                                item.setCantidad(teclado.nextInt());

                                                System.out.println("-> Objeto modificado correctamente.");
                                            } else {
                                                System.out.println("-> Numero invalido.");
                                            }
                                        }
                                    }
                                    case 3 -> {
                                        List<Item> items = inventario.getItems();
                                        if (items.isEmpty()) {
                                            System.out.println("-> No hay objetos en el inventario.");
                                        } else {                                            
                                            System.out.println("\n=== ELIMINAR OBJETO ===\n");
                                            for (int i = 0; i < items.size(); i++) {
                                                System.out.println(i + ". " + items.get(i).getNombre()
                                                                 + " || " + items.get(i).getTipo()
                                                                 + " || Cantidad: " + items.get(i).getCantidad());
                                            }                                            
                                            System.out.print("Numero de objeto a eliminar: ");
                                            int indice = teclado.nextInt();

                                            if (indice >= 0 && indice < items.size()) {
                                                String nombre = items.get(indice).getNombre(); 
                                                items.remove(indice);
                                                System.out.println("-> " + nombre + " eliminado correctamente.");
                                            } else {
                                                System.out.println("-> Numero invalido.");
                                            }
                                        }
                                    }
                                    case 4 -> enSubMenu = false;
                                    default -> System.out.println("-> Opción invalida.");
                                }
                            } catch (Exception e) {
                                System.out.println("-> Error: ¡Debes ingresar un numero entero!");
                                teclado.next();
                            }
                        }  // ← Fin while
                    }  // ← Fin case 1
                    case 2 -> {
                        System.out.println("\n=== INVENTARIO ===\n");
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
