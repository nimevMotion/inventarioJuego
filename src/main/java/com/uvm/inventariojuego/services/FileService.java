/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uvm.inventariojuego.services;

import com.uvm.inventariojuego.model.Inventario;

/**
 *
 * @author nimev
 */
public interface FileService {
    
    public boolean salvarIventario(Inventario inv);
    public Inventario getInventario();
}
