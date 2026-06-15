/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvm.inventariojuego.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Iterator;
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

    /**
     * Agrega un item al inventario.
     * Si ya existe un item con el mismo nombre (sin distinguir mayúsculas),
     * en lugar de duplicarlo, suma la cantidad al item existente.
     *
     * @param item El item a agregar o cuya cantidad se va a incrementar.
     */
    public void agregarItem(Item item) {
        // Busca si ya existe un item con el mismo nombre
        for (Item it : this.items) {
            if (it.getNombre().equalsIgnoreCase(item.getNombre())) {
                // Si existe, suma la cantidad en lugar de duplicar
                it.setCantidad(
                        it.getCantidad() + item.getCantidad()
                );
                return; // Sale del método, ya no es necesario agregar
            }
        }
        // Si no existe, agrega el item como nuevo
        this.items.add(item);
    }

    public Inventario() {
        this.items = new ArrayList<>();
    }

    public void eliminarItem(Item item) {
        Iterator<Item> iterator = this.items.iterator();

        while (iterator.hasNext()) {
            Item it = iterator.next();
            if (it.getNombre().equalsIgnoreCase(item.getNombre())) {
                if (it.getCantidad() > 1) {
                    it.setCantidad(it.getCantidad() - 1);
                } else {
                    iterator.remove(); 
                }
                return; 
            }
        }
    }
    
    public Item getItem(String nombre)
    {
        Iterator<Item> iterator = this.items.iterator();
        
        while(iterator.hasNext())
        {
            Item item = iterator.next();
            if(item.getNombre().equalsIgnoreCase(nombre))
            {
                return item;
            }
        }
        return null;
    }
}
