package com.uvm.inventariojuego.services.impl;

import com.uvm.inventariojuego.model.Evento;
import com.uvm.inventariojuego.model.Eventos;
import com.uvm.inventariojuego.services.LoggerService;
import com.uvm.inventariojuego.util.Constantes;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nimev
 */
public class LogImpl implements LoggerService {

    /**
     *
     * @param desc
     */
    @Override
    public void salvarEvento(String desc) {

        Eventos eventos = null;
        List<Evento> listEventos = new ArrayList<>();
        try {

            //valida si el archivo existe 
            File log = new File(Constantes.PATH_ARCHIVOS + File.separator + Constantes.FILENAME_LOG);

            JAXBContext context = JAXBContext.newInstance(Eventos.class);

            if (!log.exists()) {
                //Creara el archivo nuevo
                System.out.println("Archivo no existe, se creara uno nuevo...");

                eventos = new Eventos();
                File carpeta = log.getParentFile();
                carpeta.mkdirs();
                System.out.println(carpeta.getAbsolutePath());
                Evento evento = new Evento(new Date(), desc);
//                evento.setDescripcion(desc);
//                evento.setDateEvento(new Date());
                listEventos.add(evento);
                eventos.setListaEventos(listEventos);

                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(eventos, log);

                System.out.println("Se ha creado el archivo " + log.getName());
            } else {
                Evento evento = new Evento(new Date(), desc);
                //Valida si es mas grande de LIMITE_LOG_BYTES
                if (log.length() > Constantes.LIMITE_LOG_BYTES) {
                    String filename = (log.toString()).replace(".xml", "_" + new Date() + ".xml");
                    File oldLog = new File(filename);
                    if (log.renameTo(oldLog)) {
                        System.out.println("El ha respaldado el historial");
                    }
                    eventos = new Eventos();

                } else {
                    Unmarshaller unmarshaller = context.createUnmarshaller();
                    eventos = (Eventos) unmarshaller.unmarshal(log);
                }
                eventos.addEvento(evento);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                marshaller.marshal(eventos, log);
                System.out.println(log.getAbsolutePath());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
