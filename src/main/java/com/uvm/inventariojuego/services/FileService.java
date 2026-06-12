/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uvm.inventariojuego.services;

import com.uvm.inventariojuego.model.Item;

/**
 *
 * @author nimev
 */
public interface FileService {
    
    public boolean salvarItem();
    
    public boolean modificarItem();
    
    public Item getItem();
    
    public boolean eliminarItem();
}
