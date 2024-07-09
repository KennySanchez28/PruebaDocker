import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Producto {
    String nombre;
    int cantidad;
    double precio;

    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public double calcularSubtotal() {
        return cantidad * precio;
    }
}

class Factura {
    List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularSubtotal();
        }
        return total;
    }

    public void imprimirFactura() {
        System.out.println("Factura:");
        System.out.println("=====================================");
        for (Producto producto : productos) {
            System.out.printf("%-20s %5d %10.2f %10.2f\n", producto.nombre, producto.cantidad, producto.precio, producto.calcularSubtotal());
        }
        System.out.println("=====================================");
        System.out.printf("Total: %35.2f\n", calcularTotal());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Factura factura = new Factura();

        while (true) {
            System.out.print("Ingrese el nombre del producto (o 'fin' para terminar): ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();

            System.out.print("Ingrese el precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea

            Producto producto = new Producto(nombre, cantidad, precio);
            factura.agregarProducto(producto);
        }

        factura.imprimirFactura();
        scanner.close();
    }
}

