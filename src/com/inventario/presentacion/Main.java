package com.inventario.presentacion;

import com.inventario.dao.ProductoDAOArchivo;
import com.inventario.servicio.ProductoServicio;

public class Main {

    public static void main(String[] args) {
        ProductoDAOArchivo dao = new ProductoDAOArchivo();
        ProductoServicio servicio = new ProductoServicio(dao);
        Menu menu = new Menu(servicio);
        menu.iniciar();
    }
}
