/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvm.inventariojuego.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
/**
 *
 * @author nimev
 */
@XmlRootElement(name = "Eventos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Eventos {
    
//    @XmlElement
//    private Evento evento;
    
    @XmlElement(name = "evento")
    private List<Evento> listaEventos;

//    public Evento getEvento() {
//        return evento;
//    }
//
//    public void setEvento(Evento evento) {
//        this.evento = evento;
//    }

    public List<Evento> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }
    
    public void addEvento(Evento evento)
    {
        this.listaEventos.add(evento);
    }
}
