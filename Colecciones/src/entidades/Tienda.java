/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.HashMap;

/**
 *
 * @author Max
 */
public class Tienda {
    HashMap<String,Integer> producto;

    public Tienda() {
        this.producto = new HashMap<>();
    }

    public Tienda(HashMap<String, Integer> producto) {
        this.producto = producto;
    }

    public HashMap<String, Integer> getProducto() {
        return producto;
    }

    public void setProducto(HashMap<String, Integer> producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Tienda{" + "producto=" + producto + '}';
    }
    
    
}
