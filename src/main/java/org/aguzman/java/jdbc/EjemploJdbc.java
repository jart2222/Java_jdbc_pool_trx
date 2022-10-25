package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.servicio.CatalogoServicio;
import org.aguzman.java.jdbc.servicio.Servicio;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {
        Servicio servicio=new CatalogoServicio();
        System.out.println("============ listar ============");
        servicio.listar().forEach(System.out::println);
        System.out.println("============ Insertar nueva categoria ============");
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminación");

        System.out.println("============ Insertar nuevo producto ============");
        Producto producto = new Producto();
        producto.setNombre("Lampara led escritorio");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date());
        producto.setSku("abcdefgh12");
        servicio.guardarProductoConCategoria(producto,categoria);
        System.out.println("Producto guardado con exito: " + producto.getId());
        servicio.listar().forEach(System.out::println);

    }
}