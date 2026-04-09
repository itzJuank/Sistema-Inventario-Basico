package com.inventario.servicio;

import java.util.List;

import com.inventario.dao.IProductoDAO;
import com.inventario.entidades.Producto;

public class ProductoServicio implements IProductoServicio {

    private IProductoDAO dao;

    public ProductoServicio(IProductoDAO dao) {
        this.dao = dao;
    }

    @Override
    public void registrarProducto(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null ni vacio");
        }

        if (producto.getCantidad() < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }

        if (producto.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }

        if (buscarPorId(producto.getId()) != null) {
            throw new IllegalArgumentException("ID ya existe");
        }

        dao.guardar(producto);
    }

    @Override
    public List<Producto> obtenerTodos() {
        return dao.listarTodos();
    }

    @Override
    public Producto buscarPorId(int id) {
        return dao.buscarPorId(id);
    }

    @Override
    public void actualizarProducto(Producto producto) {
        dao.actualizar(producto);
    }

    @Override
    public void eliminarProducto(int id) {
        dao.eliminar(id);
    }
}
