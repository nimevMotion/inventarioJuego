package com.uvm.inventariojuego.services.impl;

import com.uvm.inventariojuego.config.JAXBConfig;
import com.uvm.inventariojuego.model.Inventario;
import com.uvm.inventariojuego.services.FileService;
import com.uvm.inventariojuego.util.Constantes;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author nimev
 */
public class FileImpl implements FileService{
 
    public boolean salvarIventario(Inventario inv)
    {
        try{
            JAXBContext context = JAXBConfig.getContext();
            FileWriter xml = new FileWriter(Constantes.PATH_ARCHIVOS + File.separator + Constantes.FILENAME_INVENTARIO);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(inv, xml);
            return true;
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    public Inventario getInventario()
    {
        Inventario inventario = null;
        try{
            JAXBContext context = JAXBConfig.getContext();
            File xml = new File(Constantes.PATH_ARCHIVOS + File.separator + Constantes.FILENAME_INVENTARIO);
            
            if(!xml.exists())
            {
//                System.out.println("Se crear inventario");
//                inventario = new Inventario();
//                
//                File carpeta = xml.getParentFile();
//                
//                if(!carpeta.exists())
//                    carpeta.mkdirs();
//                
//                Marshaller marshaller = context.createMarshaller();
//                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                return new Inventario();
            }
            Unmarshaller unmarshaller = context.createUnmarshaller();
            inventario = (Inventario) unmarshaller.unmarshal(xml);
            return inventario;
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
}
