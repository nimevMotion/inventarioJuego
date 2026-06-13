/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvm.inventariojuego.config;

import com.uvm.inventariojuego.model.Eventos;
import com.uvm.inventariojuego.model.Inventario;
import jakarta.xml.bind.JAXBContext;

/**
 *
 * @author nimev
 */
public class JAXBConfig {
    
    private static final JAXBContext INSTANCE;

    static {
        try {
            INSTANCE = JAXBContext.newInstance(Eventos.class, Inventario.class);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Error inicializando JAXBContext: " + e.getMessage());
        }
    }

    private JAXBConfig() {}

    public static JAXBContext getContext() {
        return INSTANCE;
    }
}
