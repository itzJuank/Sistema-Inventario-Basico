package com.inventario.dao;

import java.util.List;

import com.inventario.entidades.Producto;

public interface IProductoDAO {

    void guardar(Producto producto);

    List<Producto> listarTodos();

    Producto buscarPorId(int id);

    void actualizar(Producto producto);

    void eliminar(int id);
}
