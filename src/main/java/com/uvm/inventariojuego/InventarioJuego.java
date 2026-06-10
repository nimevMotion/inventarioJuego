package com.uvm.inventariojuego;

import com.uvm.inventariojuego.services.LoggerService;
import com.uvm.inventariojuego.services.impl.LogImpl;

/**
 *
 * @author nimev
 */
public class InventarioJuego {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        LoggerService logger = new LogImpl();
        
        logger.salvarEvento("Hola mundooooo");
    }
}
