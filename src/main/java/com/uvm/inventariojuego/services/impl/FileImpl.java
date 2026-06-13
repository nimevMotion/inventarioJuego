package com.uvm.inventariojuego.services.impl;

import com.uvm.inventariojuego.config.JAXBConfig;
import com.uvm.inventariojuego.model.Inventario;
import com.uvm.inventariojuego.model.Item;
import com.uvm.inventariojuego.services.FileService;
import com.uvm.inventariojuego.util.Constantes;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

/**
 *
 * @author nimev
 */
public class FileImpl implements FileService{
 
    public boolean salvarItem()
    {
        try{
            JAXBContext context = JAXBConfig.getContext();
            File xml = new File(Constantes.PATH_ARCHIVOS + File.separator + Constantes.FILENAME_INVENTARIO);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Inventario inventario = (Inventario) unmarshaller.unmarshal(xml);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
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
