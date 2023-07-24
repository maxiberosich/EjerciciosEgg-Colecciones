/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Comparator;

/**
 *
 * @author Max
 */
public class Pais {

    private String nombre;
    private String capital;
    private Integer cantidadDeHabitantes;

    public Pais() {
    }

    public Pais(String nombre, String capital, Integer cantidadDeHabitantes) {
        this.nombre = nombre;
        this.capital = capital;
        this.cantidadDeHabitantes = cantidadDeHabitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Integer getCantidadDeHabitantes() {
        return cantidadDeHabitantes;
    }

    public void setCantidadDeHabitantes(Integer cantidadDeHabitantes) {
        this.cantidadDeHabitantes = cantidadDeHabitantes;
    }

    public static Comparator<Pais> compararNombre = new Comparator<Pais>() {
        @Override
        public int compare(Pais p1, Pais p2) {
            return p1.getNombre().compareTo(p2.getNombre());
        }
    };

    @Override
    public String toString() {
        return "Pais{" + "nombre=" + nombre + ", capital=" + capital + ", cantidadDeHabitantes=" + cantidadDeHabitantes + '}';
    }

}
