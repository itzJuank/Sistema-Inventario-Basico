package com.inventario.servicio;

import java.util.List;

import com.inventario.entidades.Producto;

public interface IProductoServicio {

    void registrarProducto(Producto producto);

    List<Producto> obtenerTodos();

    Producto buscarPorId(int id);

    void actualizarProducto(Producto producto);

    void eliminarProducto(int id);
}
