/*
En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.
 */
package servicios;

import entidades.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Max
 */
public class ServicioAlumno {

    private final Scanner leer = new Scanner(System.in);

    public ArrayList<Alumno> crearAlumnos() {

        Alumno estudiante;
        ArrayList<Alumno> lista = new ArrayList<>();
        do {
            ArrayList<Integer> notas = new ArrayList<>();
            System.out.println("Ingrese el nombre del alumno");
            String nombre = leer.next();
            System.out.println("Ingrese las 3 notas del alumno");
            int n1 = leer.nextInt();
            int n2 = leer.nextInt();
            int n3 = leer.nextInt();
            notas.add(n1);
            notas.add(n2);
            notas.add(n3);
            estudiante = new Alumno(nombre, notas);
            lista.add(estudiante);
            System.out.println("Desea ingresar otro alumno. S/N");
        } while (!leer.next().equalsIgnoreCase("n"));
        return lista;
    }

    /*Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.*/
    public void seEncuentra(ArrayList<Alumno> lista) {
        boolean esta = false;
        System.out.println("Ingrese el nombre del alumno que desee conocer su nota final");
        String nombre = leer.next();
        for (Alumno alumno : lista) {
            if (alumno.getNombre().equals(nombre)) {
                System.out.println("El promedio final del alumno " 
                        + alumno.getNombre() + " es " 
                        + notaFinal(alumno) );
                esta = true;
            }
        }
        if (!esta) {
            System.out.println("El alumno que esta buscando, no se encuentra en la lista");
        }
    }

    private float notaFinal(Alumno al) {
        int suma = 0;
        Iterator iterator = al.getNotas().iterator();
        while (iterator.hasNext()) {
            suma = suma + (int) iterator.next();
        }
        return suma /= 3;
    }
}
