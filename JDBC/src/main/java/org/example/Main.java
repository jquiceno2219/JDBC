package org.example;

import org.example.conexion.v2.ConexionBD;
import org.example.domain.models.Producto;
import org.example.repository.Repository;
import org.example.repository.impl.RepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(Connection conn = ConexionBD.getInstance()){
            Repository<Producto> repository = new RepositoryImpl();
            listProducts(repository);
            getProductById(repository);
//addProduct(repository);
//updateProduct(repository);
            deleteProduct(repository);
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void listProducts(Repository<Producto> repository) {
        List<Producto> products = repository.list();
        products.forEach(System.out::println);
    }

private static void getProductById(Repository<Producto> repository) {
}

}