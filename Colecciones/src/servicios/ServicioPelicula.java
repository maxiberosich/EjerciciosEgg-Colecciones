/*
En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
crear otra Pelicula o no.
 */
package servicios;

import entidades.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Max
 */
public class ServicioPelicula {

    private Scanner leer = new Scanner(System.in);

    public ArrayList<Pelicula> crearListaPelicula() {
        ArrayList<Pelicula> listaPelis = new ArrayList<>();
        Pelicula peli;

        do {
            System.out.println("Ingrese el titulo");
            String titulo = leer.next();
            System.out.println("Ingrese el director");
            String director = leer.next();
            System.out.println("Ingrese la duracion");
            Integer duracion = leer.nextInt();
            peli = new Pelicula(titulo, director, duracion);
            listaPelis.add(peli);
            System.out.println("Desea ingresar otra pelicula. S/N");
        } while (!leer.next().equalsIgnoreCase("n"));

        return listaPelis;
    }

    /*
    • Mostrar en pantalla todas las películas.
    • Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
    • Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en
    pantalla.
    • Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
    pantalla.
    • Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
    • Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
     */
    public void menuMostrar(ArrayList<Pelicula> listaPelis) {
//        Iterator<Pelicula> iteratorPelis = listaPelis.iterator();
        int opc;
        do {
            System.out.println("Elija la opcion que desee: \n"
                    + "1- Mostrar todas las peliculas. \n"
                    + "2- Mostrar todas las peliculas con una duracion mayor a 1 hora. \n"
                    + "3- Mostrar todas las peliculas ordenadas de MAYOR a menor, con respecto a la duracion. \n"
                    + "4- Mostrar todas las peliculas ordenadas de MENOR a mayor, con respecto a la duracion. \n"
                    + "5- Mostrar todas las peliculas ordenadas alfabeticamente por titulo. \n"
                    + "6- Mostrar todas las peliculas ordenadas alfabeticamente por director. \n"
                    + "7- Salir");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println(listaPelis.toString());
                    break;
                case 2:
                    for(Pelicula peli: listaPelis){
                        if(peli.getDuracion() > 1){
                            System.out.println(peli);
                        }
                    }
                    break;
                case 3:
                    Collections.sort(listaPelis, Pelicula.compararDuracion);
                    Collections.reverse(listaPelis);
                    System.out.println(listaPelis);
                    break;
                case 4:
                    Collections.sort(listaPelis, Pelicula.compararDuracion);
                    System.out.println(listaPelis);
                    break;
                case 5:
                    Collections.sort(listaPelis, Pelicula.compararTitulo);
                    System.out.println(listaPelis);
                    break;
                case 6:
                    Collections.sort(listaPelis, Pelicula.compararDirector);
                    System.out.println(listaPelis);
                    break;
                case 7:
                    System.out.println("Gracias por utilizar nuestros servicios, vuelvas prontos");
                    break;
            }
        } while (opc != 7);
    }

}
