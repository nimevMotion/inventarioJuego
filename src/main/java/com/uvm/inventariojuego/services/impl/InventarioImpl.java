package com.uvm.inventariojuego.services.impl;
import com.uvm.inventariojuego.model.Inventario;
import com.uvm.inventariojuego.model.Item;
import com.uvm.inventariojuego.services.FileService;
import com.uvm.inventariojuego.services.InventarioService;
import com.uvm.inventariojuego.services.LoggerService;
import java.util.List;

public class InventarioImpl implements InventarioService {
    private final FileService fileService;
    private final LoggerService log;

    public InventarioImpl(Inventario inventarioModel) {
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

    @Override
    public List<Item> getItems() {          
        Inventario inventario = fileService.getInventario();
        if (inventario == null) {
            return new java.util.ArrayList<>();
        }
        return inventario.getItems();
    }
}