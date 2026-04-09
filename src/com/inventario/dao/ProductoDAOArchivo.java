package com.inventario.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.inventario.entidades.Producto;

public class ProductoDAOArchivo implements IProductoDAO {

    private static final String RUTA_ARCHIVO = "datos/productos.txt";

    @Override
    public void guardar(Producto producto) {
        try {
            asegurarArchivoExiste();

            try (BufferedWriter writer = Files.newBufferedWriter(
                    Paths.get(RUTA_ARCHIVO),
                    java.nio.file.StandardOpenOption.APPEND)) {
                writer.write(convertirALinea(producto));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar producto: " + e.getMessage());
        }
    }

    @Override
    public List<Producto> listarTodos() {
        List<Producto> productos = new ArrayList<>();

        try {
            asegurarArchivoExiste();

            try (BufferedReader reader = Files.newBufferedReader(Paths.get(RUTA_ARCHIVO))) {
                String linea;

                while ((linea = reader.readLine()) != null) {
                    if (!linea.trim().isEmpty()) {
                        productos.add(convertirAProducto(linea));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }

        return productos;
    }

    @Override
    public Producto buscarPorId(int id) {
        List<Producto> productos = listarTodos();

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }

        return null;
    }

    @Override
    public void actualizar(Producto producto) {
        List<Producto> productos = listarTodos();

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == producto.getId()) {
                productos.set(i, producto);
                break;
            }
        }

        reescribirArchivo(productos);
    }

    @Override
    public void eliminar(int id) {
        List<Producto> productos = listarTodos();
        List<Producto> productosActualizados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getId() != id) {
                productosActualizados.add(producto);
            }
        }

        reescribirArchivo(productosActualizados);
    }

    private void reescribirArchivo(List<Producto> productos) {
        try {
            asegurarArchivoExiste();

            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(RUTA_ARCHIVO))) {
                for (Producto producto : productos) {
                    writer.write(convertirALinea(producto));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al reescribir archivo: " + e.getMessage());
        }
    }

    private void asegurarArchivoExiste() throws IOException {
        Path path = Paths.get(RUTA_ARCHIVO);
        Path parent = path.getParent();

        if (parent != null && Files.notExists(parent)) {
            Files.createDirectories(parent);
        }

        if (Files.notExists(path)) {
            Files.createFile(path);
        }
    }

    private String convertirALinea(Producto producto) {
        return producto.getId() + "|"
                + producto.getNombre() + "|"
                + producto.getCantidad() + "|"
                + String.format(Locale.US, "%.2f", producto.getPrecio());
    }

    private Producto convertirAProducto(String linea) {
        String[] datos = linea.split("\\|");

        int id = Integer.parseInt(datos[0]);
        String nombre = datos[1];
        int cantidad = Integer.parseInt(datos[2]);
        double precio = Double.parseDouble(datos[3]);

        return new Producto(id, nombre, cantidad, precio);
    }
}
