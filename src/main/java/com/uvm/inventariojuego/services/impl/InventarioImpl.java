package com.uvm.inventariojuego.services.impl;

import com.uvm.inventariojuego.model.Inventario;
import com.uvm.inventariojuego.model.Item;
import com.uvm.inventariojuego.services.FileService;
import com.uvm.inventariojuego.services.InventarioService;
import com.uvm.inventariojuego.services.LoggerService;
import java.util.List;
import java.util.Scanner;

public class InventarioImpl implements InventarioService {

    private final FileService fileService;
    private final LoggerService log;

    public InventarioImpl() {
        this.fileService = new FileImpl();
        this.log = new LogImpl();
    }

    @Override
    public boolean agregarItem(Item item) {
        Inventario inventario = fileService.getInventario();
        if (inventario == null) {
            return false;
        } else {
            inventario.agregarItem(item);
            log.salvarEvento("Se ha agregago el item " + item.getNombre());
            return fileService.salvarIventario(inventario);
        }
    }

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
                System.out.print("Se agrega un " + item.getNombre() + " al inventario");
                item.setCantidad(teclado.nextInt());

                inventario.agregarItem(item);
                fileService.salvarIventario(inventario);
                System.out.println("-> Objeto modificado correctamente.");
            } else {
                System.out.println("-> Numero invalido.");
                return;
            }
        }
    }

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
}
