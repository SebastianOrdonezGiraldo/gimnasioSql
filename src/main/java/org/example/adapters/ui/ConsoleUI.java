package org.example.adapters.ui;

import org.example.adapters.persistence.HibernateProductRepositoryAdapter;
import org.example.application.ProductServiceImpl;
import org.example.domain.Product;
import org.example.ports.in.ProductServicePort;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private static ProductServicePort productService = new ProductServiceImpl(new HibernateProductRepositoryAdapter());
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            ejecutarOpcion(opcion);
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== CRUD de Productos =====");
        System.out.println("1. Crear producto");
        System.out.println("2. Listar todos los productos");
        System.out.println("3. Obtener producto por ID");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearProducto();
                break;
            case 2:
                listarProductos();
                break;
            case 3:
                obtenerProductoPorId();
                break;
            case 4:
                actualizarProducto();
                break;
            case 5:
                eliminarProducto();
                break;
            case 6:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida. Inténtelo de nuevo.");
                break;
        }
    }

    private static void crearProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del producto: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        Product product = new Product();
        product.setName(nombre);
        product.setDescription(descripcion);
        product.setPrice(precio);

        productService.createProduct(product);
        System.out.println("Producto creado exitosamente.");
    }

    private static void listarProductos() {
        List<Product> productos = productService.getAllProducts();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\nLista de productos:");
            for (Product product : productos) {
                System.out.println(product);
            }
        }
    }

    private static void obtenerProductoPorId() {
        System.out.print("Ingrese el ID del producto: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea

        Product product = productService.getProductById(id);
        if (product == null) {
            System.out.println("No se encontró ningún producto con el ID " + id);
        } else {
            System.out.println(product);
        }
    }

    private static void actualizarProducto() {
        System.out.print("Ingrese el ID del producto a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea

        Product product = productService.getProductById(id);
        if (product == null) {
            System.out.println("No se encontró ningún producto con el ID " + id);
            return;
        }

        System.out.print("Ingrese el nuevo nombre del producto (o presione Enter para mantener el actual): ");
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.isEmpty()) {
            product.setName(nuevoNombre);
        }

        System.out.print("Ingrese la nueva descripción del producto (o presione Enter para mantener la actual): ");
        String nuevaDescripcion = scanner.nextLine();
        if (!nuevaDescripcion.isEmpty()) {
            product.setDescription(nuevaDescripcion);
        }

        System.out.print("Ingrese el nuevo precio del producto (o presione Enter para mantener el actual): ");
        String nuevoPrecioStr = scanner.nextLine();
        if (!nuevoPrecioStr.isEmpty()) {
            double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
            product.setPrice(nuevoPrecio);
        }

        productService.updateProduct(product);
        System.out.println("Producto actualizado exitosamente.");
    }

    private static void eliminarProducto() {
        System.out.print("Ingrese el ID del producto a eliminar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea

        Product product = productService.getProductById(id);
        if (product == null) {
            System.out.println("No se encontró ningún producto con el ID " + id);
        } else {
            productService.deleteProduct(id);
            System.out.println("Producto eliminado exitosamente.");
        }
    }
}
