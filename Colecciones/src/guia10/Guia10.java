package guia10;

import entidades.Alumno;
import entidades.Libro;
import entidades.Pais;
import entidades.Pelicula;
import entidades.Tienda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import servicios.ServicioAlumno;
import servicios.ServicioLibro;
import servicios.ServicioPais;
import servicios.ServicioPelicula;
import servicios.ServicioTienda;

/**
 *
 * @author Max
 */
public class Guia10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        /* Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El
        programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
        después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide
        salir, se mostrará todos los perros guardados en el ArrayList. */
        //EJERCICIO 1
        /*ArrayList<String> perros = new ArrayList();
        boolean noEsta = true;

        do {
            System.out.println("Ingrese la raza del perro");
            perros.add(leer.next());
            System.out.println("Desea ingresar otro perro. S/N");
        } while (!leer.next().equals("n"));

        System.out.println(perros);*/
        
        /*Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
        un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
        está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
        ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
        la lista ordenada.*/
        //EJERCICIO 2
        /*System.out.println("Que perro quieres buscar?");
        String perroABuscar = leer.next();
        Iterator iteratorPerro = perros.iterator();
        
        while(iteratorPerro.hasNext()){
            if(iteratorPerro.next().equals(perroABuscar)){
                iteratorPerro.remove();
                noEsta = false;
            }
        }
        
        if(noEsta){
            System.out.println("No esta en la lista");            
        }
        Collections.sort(perros);
        System.out.println(perros);   */     

        //EJERCICIO 3 - ALUMNOS
        /*ServicioAlumno as = new ServicioAlumno();
        ArrayList<Alumno> al = as.crearAlumnos();
        
        System.out.println("La lista de alumnos es: \n"  
                + al);
        as.seEncuentra(al);*/
        
        //EJERCICIO 4 - PELICULAS
        /*ServicioPelicula sP = new ServicioPelicula();
        
        ArrayList<Pelicula> listaPelis = sP.crearListaPelicula();
        sP.menuMostrar(listaPelis);*/
        
        //PRUEBA CON EL HASH, TREE Y LISTA EN CONJUNTOS(SET)
        /*HashSet<String> paisesHash = new HashSet<>();
        
        do { 
            System.out.println("Ingrese el pais que desee");
            paisesHash.add(leer.next());
            System.out.println("Desea ingresar otro pais. S/N");
        } while (!leer.next().equalsIgnoreCase("n"));
        
        //ORDENAR UN CONJUNTO(SET), CONVIRTIENDOLO A TREESET
        TreeSet<String> paisesTree = new TreeSet<>(paisesHash);
        
        //ORDENAR UN CONJUNTO(SET), CONVIRTIENDOLO A LISTA
        ArrayList<String> paisesLista = new ArrayList<>(paisesHash);
        
        //MOSTRAR EL HASH
        System.out.println("Hash: " + paisesHash);
        //MOSTRAR EL HASH CONVERTIDO A TREE ORDENADO
        System.out.println("Hash / Tree: " + paisesTree);
        //MOSTRAR EL HASH CONVERTIDO A LISTA
        Collections.sort(paisesLista);
        System.out.println("Hash / Lista: " + paisesLista);
        
        boolean bandera = false;
        System.out.println("Que pais desea eliminar de la lista");
        String paisAEliminar = leer.next();
        Iterator<String> iterator = paisesLista.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().equals(paisAEliminar)){
                paisesHash.remove(paisAEliminar);
                bandera = true;
            }            
        }
        
        if(!bandera)
            System.out.println("El pais que ingresaste no se encuentra en la lista");
        else
            System.out.println("El pais " + paisAEliminar + " fue eliminado correctamente");
        
        System.out.println("Hash: " + paisesHash);*/
        
        //EJERCICIO 5 - PAISES
        /*ServicioPais sp = new ServicioPais();
        
        HashSet<Pais> paisHash = sp.crearPaises();
        sp.ordenarAlfabeticamenteConTree(paisHash);
        sp.ordenarAlfabeticamenteConLista(paisHash);
        System.out.println("");
        sp.eliminarPais(paisHash);*/
        
        //EJERCICIO 6
        /*HashMap<String,Integer> tienda = new HashMap<>();
        do {            
            System.out.println("Ingrese el nombre del producto");
            String producto = leer.next();
            System.out.println("Ingrese el precio del producto");
            Integer precio = leer.nextInt();
            tienda.put(producto, precio);
            System.out.println("Desea ingresar otro producto? S/N");
        } while (!leer.next().equals("n"));
        
        System.out.println(tienda.get("papas"));
        System.out.println(tienda);*/
        
        /*Tienda tienda = new Tienda();
        ServicioTienda st = new ServicioTienda();
        
        st.menu(tienda);*/
        
        //EJERCICIO EXTRA 3
        
        ServicioLibro sl = new ServicioLibro();
        
        HashSet<Libro> biblioteca = new HashSet<>();
        do {        
            Libro libro = new Libro();
            System.out.print("Titulo del libro: ");
            libro.setTitulo(leer.next());
            System.out.print("Autor del libro: ");
            libro.setAutor(leer.next());
            System.out.print("Cantidad de ejemplares: ");
            libro.setNumeroDeEjemplares(leer.nextInt());
            biblioteca.add(libro);
            System.out.println("Desea ingresar otro libro a la biblioteca. S/N");
        } while (!leer.next().equalsIgnoreCase("n"));
        
        int opc;
        do {            
            System.out.println("\nSeleccione la opcion que prefiera:" 
                + "\n1- Lista de libros disponibles." 
                + "\n2- Prestamo de un libro." 
                + "\n3- Devolucion de un libro." 
                + "\n4- Salir");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    sl.mostrarLibros(biblioteca);
                    break;
                case 2:
                    sl.prestamo(biblioteca);
                    break;
                case 3:
                    sl.devolucion(biblioteca);
                    break;
                case 4:
                    System.out.println("Gracias por utilizar nuestros servicios");
                    break;
            }
        } while (opc != 4);
        
        
    }

}
