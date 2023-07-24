/*
Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio, 
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar 
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio. 
Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package servicios;

import entidades.Tienda;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Max
 */
public class ServicioTienda {

    Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");

    private void agregarProductos(Tienda tienda) {
        HashMap<String, Integer> productos = tienda.getProducto();
        do {
            System.out.println("Ingrese el nombre del producto:");
            String nombre = leer.next();
            System.out.println("Ingrese el precio del producto:");
            Integer precio = leer.nextInt();
            productos.put(nombre, precio);
            tienda.setProducto(productos);
            System.out.println("Desea ingresar otro producto. S/N");
        } while (!leer.next().equalsIgnoreCase("n"));
    }

    private void mostrarProductos(Tienda tienda) {
        //Dentro de la clase, tenemos que ingresar al keyset() y luego podemos iterar
        Iterator it = tienda.getProducto().keySet().iterator();
        while(it.hasNext()){
            //Para guardar la key donde nos posicionamos tenemos que poner el toString()
            String key = it.next().toString();
            //Luego para mostrar el precio de la key donde nos encontramos tenemos que buscar en la clase con get y enviarle el key que tenemos
            System.out.println("Producto = " + key + ", Precio = $" + tienda.getProducto().get(key));
        }
    }

    private void modificarPrecioProducto(Tienda tienda) {
        System.out.println("Ingrese el nombre del producto que quiere modificar su precio:");
        String productoAModificar = leer.next();
        if (tienda.getProducto().containsKey(productoAModificar)) {
            System.out.println("Ingrese el nuevo precio:");
            tienda.getProducto().replace(productoAModificar, leer.nextInt());
            System.out.println("El precio del producto fue modificado correctamente.");
        } else {
            System.out.println("El producto ingresado no existe en la lista");
        }
    }

    private void eliminarProducto(Tienda tienda) {
        System.out.println("Ingrese el nombre del producto que desea eliminar:");
        String productoAEliminar = leer.next();
        if (tienda.getProducto().containsKey(productoAEliminar)) {
            tienda.getProducto().remove(productoAEliminar);
            System.out.println("El producto fue eliminado correctamente.");
        } else {
            System.out.println("El producto ingresado no existe en la lista");
        }
    }

    public void menu(Tienda tienda) {
        int opc;
        do {
            System.out.println("Seleccione la opcion que desee realizar: "
                    + "\n1- Ingresar producto"
                    + "\n2- Modificar precio de un producto"
                    + "\n3- Eliminar un producto"
                    + "\n4- Mostrar los productos de la tienda"
                    + "\n5- Salir");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    agregarProductos(tienda);
                    break;
                case 2:
                    modificarPrecioProducto(tienda);
                    break;
                case 3:
                    eliminarProducto(tienda);
                    break;
                case 4:
                    mostrarProductos(tienda);
                    break;
                case 5:
                    System.out.println("Gracias por utilizar nuestros servicios");
                    break;
            }
        } while (opc != 5);
    }

}
