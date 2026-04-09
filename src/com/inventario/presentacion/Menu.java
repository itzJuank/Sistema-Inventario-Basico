package com.inventario.presentacion;

import java.util.List;
import java.util.Scanner;

import com.inventario.entidades.Producto;
import com.inventario.servicio.IProductoServicio;

public class Menu {

    private IProductoServicio servicio;
    private Scanner scanner;

    public Menu(IProductoServicio servicio) {
        this.servicio = servicio;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");

            try {
                switch (opcion) {
                    case 1:
                        registrarProducto();
                        break;
                    case 2:
                        listarProductos();
                        break;
                    case 3:
                        buscarProducto();
                        break;
                    case 4:
                        actualizarProducto();
                        break;
                    case 5:
                        eliminarProducto();
                        break;
                    case 0:
                        System.out.println("\nCerrando sistema de inventario...");
                        break;
                    default:
                        System.out.println("\nOpcion no valida. Intente nuevamente.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: " + e.getMessage());
            }

            if (opcion != 0) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n======================================");
        System.out.println("      SISTEMA DE INVENTARIO");
        System.out.println("======================================");
        System.out.println("1. Registrar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar producto por ID");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("0. Salir");
        System.out.println("======================================");
    }

    private void registrarProducto() {
        System.out.println("\n--- Registrar producto ---");

        int id = leerEntero("ID: ");
        String nombre = leerTexto("Nombre: ");
        int cantidad = leerEntero("Cantidad: ");
        double precio = leerDouble("Precio: ");

        Producto producto = new Producto(id, nombre, cantidad, precio);
        servicio.registrarProducto(producto);

        System.out.println("\nProducto registrado correctamente.");
    }

    private void listarProductos() {
        System.out.println("\n--- Lista de productos ---");

        List<Producto> productos = servicio.obtenerTodos();

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    private void buscarProducto() {
        System.out.println("\n--- Buscar producto ---");

        int id = leerEntero("Ingrese el ID: ");
        Producto producto = servicio.buscarPorId(id);

        if (producto == null) {
            System.out.println("No encontrado");
            return;
        }

        System.out.println(producto);
    }

    private void actualizarProducto() {
        System.out.println("\n--- Actualizar producto ---");

        int id = leerEntero("ID del producto a actualizar: ");
        Producto existente = servicio.buscarPorId(id);

        if (existente == null) {
            System.out.println("No encontrado");
            return;
        }

        String nombre = leerTexto("Nuevo nombre: ");
        int cantidad = leerEntero("Nueva cantidad: ");
        double precio = leerDouble("Nuevo precio: ");

        Producto productoActualizado = new Producto(id, nombre, cantidad, precio);
        servicio.actualizarProducto(productoActualizado);

        System.out.println("\nProducto actualizado correctamente.");
    }

    private void eliminarProducto() {
        System.out.println("\n--- Eliminar producto ---");

        int id = leerEntero("ID del producto a eliminar: ");
        Producto producto = servicio.buscarPorId(id);

        if (producto == null) {
            System.out.println("No encontrado");
            return;
        }

        String confirmacion = leerTexto("¿Esta seguro? (s/n): ");

        if (confirmacion.equalsIgnoreCase("s")) {
            servicio.eliminarProducto(id);
            System.out.println("\nProducto eliminado correctamente.");
            return;
        }

        System.out.println("\nOperacion cancelada.");
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero decimal valido.");
            }
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}
