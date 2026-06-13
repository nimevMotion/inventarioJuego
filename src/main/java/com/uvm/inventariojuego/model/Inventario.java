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
@XmlRootElement(name = "Inventario")
@XmlAccessorType(XmlAccessType.FIELD)
public class Inventario {
    
    @XmlElement(name = "item")
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public void agregarItem(Item item)
    {
        for(Item it : this.items)
        {
            if(it.getNombre().equalsIgnoreCase(it.getDesc()))
            {
                it.setCantidad( it.getCantidad() + 1);
                return;
            }
        }
        
        this.items.add(item);
    }
    
    public void eliminarItem(Item item)
    {
        for(Item it : this.items)
        {
            if(it.getNombre().equalsIgnoreCase(it.getDesc()))
            {
                if(true)
                it.setCantidad( it.getCantidad() + 1);
                return;
            }
        }
    }
 
}
