/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvm.inventariojuego.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 *
 * @author nimev
 */
@XmlRootElement(name = "Evento")
@XmlAccessorType(XmlAccessType.FIELD)
public class Evento {
    
    @XmlElement
    private Date dateEvento;
    
    @XmlElement
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getDateEvento() {
        return dateEvento;
    }

    public void setDateEvento(Date dateEvento) {
        this.dateEvento = dateEvento;
    }
    
    
}
