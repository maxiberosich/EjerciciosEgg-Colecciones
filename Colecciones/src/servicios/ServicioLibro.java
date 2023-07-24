/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Libro;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Max
 */
public class ServicioLibro {
    Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
    
    public boolean prestamo(HashSet<Libro> biblioteca){
        boolean bandera = false;
        System.out.println("Ingrese el titulo del libro que desea pedir prestado:");
        String titulo = leer.next();
        Iterator<Libro> it = biblioteca.iterator();
        while(it.hasNext()){
            Libro lib = it.next();
            if(lib.getTitulo().equalsIgnoreCase(titulo)){
                if(lib.getNumeroDeEjemplaresPrestados()<lib.getNumeroDeEjemplares()){
                    lib.setNumeroDeEjemplaresPrestados(lib.getNumeroDeEjemplaresPrestados() + 1);
                    System.out.println("Disfrute de su libro");
                    bandera = true;
                }else{
                    System.out.println("Lo lamentamos mucho, no disponemos de mas copias de " + titulo 
                            + " por el momento");
                }                
            }
        }
        return bandera;
    }
    
    public boolean devolucion(HashSet<Libro> biblioteca){
        System.out.println("Ingrese el titulo del libro que desea devolver:");
        String libroADevolver = leer.next();
        Iterator<Libro> it = biblioteca.iterator();
        while(it.hasNext()){
            Libro libro = it.next();
            if(libro.getTitulo().equalsIgnoreCase(libroADevolver) && libro.getNumeroDeEjemplaresPrestados()>0){
                libro.setNumeroDeEjemplaresPrestados(libro.getNumeroDeEjemplaresPrestados()-1);
                System.out.println("Gracias por devolver el libro. Cuando lo prefiera, puede elegir otro para llevar");
                return true;
            }
        }
        System.out.println("No le prestamos ese libro antes");
        return false;
    }
    
    public void mostrarLibros(HashSet<Libro> biblioteca){
        Iterator<Libro> it = biblioteca.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
}
