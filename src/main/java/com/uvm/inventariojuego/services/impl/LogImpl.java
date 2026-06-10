package com.uvm.inventariojuego.services.impl;

import com.uvm.inventariojuego.model.Evento;
import com.uvm.inventariojuego.model.Eventos;
import com.uvm.inventariojuego.services.LoggerService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.util.Date;

/**
 *
 * @author nimev
 */
public class LogImpl implements LoggerService{
    
    /**
     *
     * @param desc
     */
    @Override
    public void salvarEvento(String desc)
    {
        try{
            JAXBContext context = JAXBContext.newInstance(Eventos.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Evento evento = new Evento();
            evento.setDescripcion(desc);
            evento.setDateEvento(new Date());

            Eventos eventos = new Eventos();
            eventos.setEvento(evento);
            marshaller.marshal(eventos, System.out);
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
}

