/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Pais;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Max
 */
public class ServicioPais {
    
    public HashSet<Pais> crearPaises(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        HashSet<Pais> paisHash = new HashSet<>();
        System.out.println("Ingrese los datos que se requieren para crear un pais");
        do {  
            Pais pais = new Pais();
            System.out.println("Ingrese el nombre:");
            pais.setNombre(leer.next());
            System.out.println("Ingrese la capital del pais");
            pais.setCapital(leer.next());
            System.out.println("Ingrese la cantidad de habitantes");
            pais.setCantidadDeHabitantes(leer.nextInt());
            paisHash.add(pais);
            System.out.print("Desea ingresar otro pais. S/N: ");
        } while (!leer.next().equalsIgnoreCase("n"));
        
        System.out.println("La cantidad de paises ingresados a continuacion:");
        for(Pais p: paisHash){
            System.out.println(p);
        }
        
        return paisHash;
    }
    
    public void ordenarAlfabeticamenteConTree(HashSet<Pais> paisesHash){
        TreeSet<Pais> paisesTree = new TreeSet<>(Pais.compararNombre);
        paisesTree.addAll(paisesHash);
        System.out.println("\n Paises ordenados alfabeticamente:");
        for(Pais p: paisesTree){
            System.out.println(p);
        }
    }
    
    public void ordenarAlfabeticamenteConLista(HashSet<Pais> paisesHash){
        ArrayList<Pais> listaPais = new ArrayList<>(paisesHash);
        Collections.sort(listaPais,Pais.compararNombre);
        System.out.println("\n Lsita");
        Iterator it = listaPais.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
    public void eliminarPais(HashSet<Pais> paisesHash){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        HashSet<Pais> aux = new HashSet<>(paisesHash);
        Iterator<Pais> it = aux.iterator();
        boolean bandera = false;
        
        System.out.print("Ingrese el nombre del pais que desea eliminar: ");
        String paisEliminar = leer.next();
        
        while(it.hasNext()){
            Pais objetoActual = it.next();
            if(objetoActual.getNombre().equals(paisEliminar)){
                paisesHash.remove(objetoActual);
                bandera = true;
            }
        }
        
        if(!bandera){
            System.out.println("El pais ingresado no se encuentra en la lista");
        }else{
            System.out.println("El pais fue eliminado correctamente de la lista");
            ordenarAlfabeticamenteConLista(paisesHash);
        }
        
    }
    
}
