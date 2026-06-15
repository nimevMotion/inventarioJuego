package com.uvm.inventariojuego.services.impl;

import com.uvm.inventariojuego.model.Inventario;
import com.uvm.inventariojuego.model.Item;
import com.uvm.inventariojuego.services.FileService;
import com.uvm.inventariojuego.services.InventarioService;
import com.uvm.inventariojuego.services.LoggerService;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class InventarioImpl implements InventarioService {

    private final FileService fileService;
    private final LoggerService log;

    public InventarioImpl() {
        this.fileService = new FileImpl();
        this.log = new LogImpl();
    }

    // La función agrega un item a inventario, permite ingresar nombre, descripción, tipo, cantidad.
    public boolean agregarItem() {
        Inventario inventario = fileService.getInventario();
        if (inventario == null) {
            return false;
        } else {             
            System.out.println("\n=== REGISTAR OBJETO ===\n");            
            Item item = new Item();                                   
            Scanner teclado = new Scanner(System.in);
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
            inventario.agregarItem(item);
            log.salvarEvento("Se ha agregago el item " + item.getNombre());
            return fileService.salvarIventario(inventario);
        }
    }

    // La función modifica un item ya creado sumando un registro al item.
    public void modificarItem() {
        Inventario inventario = getItems();

        if (inventario.getItems().isEmpty()) {
            System.out.println("-> No hay objetos en el inventario.");
        } else {
            List<Item> items = inventario.getItems();
            // Mostrar todos los objetos guardados
            System.out.println("\n=== MODIFICAR OBJETO ===\n");
            for (int i = 0; i < items.size(); i++) {
                System.out.println(i + ". " + items.get(i).getNombre()
                        + " || " + items.get(i).getTipo()
                        + " || Cantidad: " + items.get(i).getCantidad());
            }

            Scanner teclado = new Scanner(System.in);
            System.out.print("Numero de objeto a modificar: ");
            int indice = teclado.nextInt();

            if (indice >= 0 && indice < items.size()) {
                Item item = items.get(indice);
                teclado.nextLine();
//                System.out.print("Nuevo nombre (" + item.getNombre() + "): ");
//                item.setNombre(teclado.nextLine());
//
//                System.out.print("Nueva descripcion (" + item.getDesc() + "): ");
//                item.setDesc(teclado.nextLine());
//
//                System.out.print("Nuevo tipo (" + item.getTipo() + "): ");
//                item.setTipo(teclado.nextLine());
                System.out.println("Que cantidad quieres agregar del objeto " + item.getNombre() + ":");
                item.setCantidad(teclado.nextInt());

                inventario.agregarItem(item);
                fileService.salvarIventario(inventario);
                System.out.println("-> Objeto modificado correctamente.");
//                teclado.close();
                return;
            } else {
                System.out.println("-> Numero invalido.");
                return;
            }
        }
    }

    // La función elimina un registro de un item ya creado.
    public void eliminarItem() {
        Inventario inventario = getItems();
        if (inventario.getItems().isEmpty()) {
            System.out.println("-> No hay objetos en el inventario.");
        } else {
            System.out.println("\n=== ELIMINAR OBJETO ===\n");
            List<Item> items = inventario.getItems();
            for (int i = 0; i < items.size(); i++) {
                System.out.println(i + ". " + items.get(i).getNombre()
                        + " || " + items.get(i).getTipo()
                        + " || Cantidad: " + items.get(i).getCantidad());
            }
            Scanner teclado = new Scanner(System.in);
            System.out.print("Numero de objeto a eliminar: ");
            int indice = teclado.nextInt();

            if (indice >= 0 && indice < items.size()) {
//                String nombre = items.get(indice).getNombre();
//                items.remove(indice);
                inventario.eliminarItem(inventario.getItems().get(indice));
                System.out.println("-> " + inventario.getItems().get(indice) + " eliminado correctamente.");
                fileService.salvarIventario(inventario);
            } else {
                System.out.println("-> Numero invalido.");
            }
        }
    }

    @Override
    public Inventario getItems() {
        Inventario inventario = fileService.getInventario();
        if (inventario == null) {
            return null;
        }
        return inventario;
    }
    
    @Override
    public void buscarItem(String nombre)
    {
        Inventario inventario = fileService.getInventario();
        Iterator<Item> it = inventario.getItems().iterator();
        
        while(it.hasNext())
        {
            Item item = it.next();
            System.out.println(item.getNombre());
            if(item.getNombre().equalsIgnoreCase(nombre.trim()))
            {
                System.out.println("Se ha encontrado el Item: " + item.getNombre());
                System.out.println("Descripcion: " + item.getDesc());
                System.out.println("Tipo: " + item.getTipo());
                System.out.println("Cantidad: " + item.getCantidad());
                return;
            }
        }
        
        System.out.println("No existe el objeto: " + nombre);
    }
}
