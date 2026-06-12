package com.uvm.inventariojuego.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nimev
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    
    @XmlElement
    private String nombre;
    
    @XmlElement
    private String desc;
    
    @XmlElement
    private String tipo;
    
    @XmlElement
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @XmlElement
    private Map<String, String> usos = new HashMap<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Map<String, String> getUsos() {
        return usos;
    }

    public void setUsos(Map<String, String> usos) {
        this.usos = usos;
    }
}
