package com.uvm.inventariojuego.services.impl;

import com.uvm.inventariojuego.model.Inventario;
import com.uvm.inventariojuego.model.Item;
import com.uvm.inventariojuego.services.FileService;
import com.uvm.inventariojuego.services.InventarioService;
import com.uvm.inventariojuego.services.LoggerService;

/**
 *
 * @author nimev
 */
public class InventarioImpl implements InventarioService {

    private final FileService fileService;
    private final LoggerService log;

    public InventarioImpl() {
        this.fileService = new FileImpl();
        this.log = new LogImpl();
    }

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

}
