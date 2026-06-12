package com.uvm.inventariojuego.services.impl;

import com.uvm.inventariojuego.model.Item;
import com.uvm.inventariojuego.services.FileService;

/**
 *
 * @author nimev
 */
public class FileImpl implements FileService{
 
    public boolean salvarItem()
    {
        return true;
    }
    
    public boolean modificarItem()
    {
        return true;
    }
    
    public Item getItem()
    {
        return null;
    }
    
    public boolean eliminarItem()
    {
        return true;
    }
}
