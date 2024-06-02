//package org.example.adapters.ui;
//import org.example.adapters.persistence.HibernateMiembroRepositoryAdapter;
//import org.example.application.MiembroServiceImpl;
//import org.example.domain.Miembro;
//import org.example.ports.in.MiembroServicePort;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class MiembroUI {
//    private MiembroServicePort miembroService = new MiembroServiceImpl(new HibernateMiembroRepositoryAdapter());
//    private Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        MiembroUI ui = new MiembroUI();
//        int opcion;
//        do {
//            ui.mostrarMenu();
//            opcion = ui.scanner.nextInt();
//            ui.scanner.nextLine();
//            ui.ejecutarOpcion(opcion);
//        } while (opcion != 5);
//    }
//
//    private void mostrarMenu() {
//        System.out.println("\n===== Aplicación de Registro de Miembros =====");
//        System.out.println("1. Registrar miembro");
//        System.out.println("2. Actualizar miembro");
//        System.out.println("3. Eliminar miembro");
//        System.out.println("4. Mostrar todos los miembros");
//        System.out.println("5. Salir");
//        System.out.print("Ingrese una opción: ");
//    }
//
//    private void ejecutarOpcion(int opcion) {
//        switch (opcion) {
//            case 1:
//                registrarMiembro();
//                break;
//            case 2:
//                actualizarMiembro();
//                break;
//            case 3:
//                eliminarMiembro();
//                break;
//            case 4:
//                mostrarMiembros();
//                break;
//            case 5:
//                System.out.println("¡Hasta luego!");
//                break;
//            default:
//                System.out.println("Opción inválida. Intente nuevamente.");
//        }
//    }
//
//    private void registrarMiembro() {
//        System.out.print("Ingrese el nombre del miembro: ");
//        String nombre = scanner.nextLine();
//        System.out.print("Ingrese el apellido del miembro: ");
//        String apellido = scanner.nextLine();
//        System.out.print("Ingrese la edad del miembro: ");
//        int edad = scanner.nextInt();
//        System.out.print("Ingrese el número de membresía(Cedula): ");
//        int numeroMembresia = scanner.nextInt();
//
//        Miembro miembro = new Miembro(null, nombre, apellido, edad, numeroMembresia);
//        miembroService.registrarMiembro(miembro);
//        System.out.println("Miembro registrado correctamente.");
//    }
//
//    private void actualizarMiembro() {
//        System.out.print("Ingrese el número de membresía del miembro a actualizar: ");
//        int numeroMembresia = scanner.nextInt();
//        scanner.nextLine();  // Consumir el salto de línea
//
//        System.out.print("Ingrese el nuevo nombre del miembro: ");
//        String nombre = scanner.nextLine();
//        System.out.print("Ingrese el nuevo apellido del miembro: ");
//        String apellido = scanner.nextLine();
//        System.out.print("Ingrese la nueva edad del miembro: ");
//        int edad = scanner.nextInt();
//
//        Miembro miembro = new Miembro(null, nombre, apellido, edad, numeroMembresia);
//        miembroService.actualizarMiembro(miembro);
//        System.out.println("Miembro actualizado correctamente.");
//    }
//
//    private void eliminarMiembro() {
//        System.out.print("Ingrese el número de membresía del miembro a eliminar: ");
//        int numeroMembresia = scanner.nextInt();
//        miembroService.eliminarMiembro(numeroMembresia);
//        System.out.println("Miembro eliminado correctamente.");
//    }
//
//    private void mostrarMiembros() {
//        List<Miembro> miembros = miembroService.obtenerMiembros();
//        System.out.println("\nLista de miembros:");
//        for (Miembro miembro : miembros) {
//            System.out.println(miembro);
//        }
//    }
//}
//