package org.example.repository.impl;

import org.example.domain.models.Producto;
import org.example.repository.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class RepositoryImpl implements Repository<Producto> {
    private Producto createProduct(ResultSet resultSet) throws
            SQLException {
        Producto producto = new Producto();
        producto.setId(resultSet.getLong("id"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setPrecio(resultSet.getDouble("precio"));
        producto.setFechaRegistro(resultSet.getDate("fecha_registro").toLocalDate());
        return producto;
    }

    @Override
    public List<Producto> list() {
        List<Producto> productoList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from productos")) {
    while (resultSet.next()) {
            Producto producto = createProduct(resultSet);
            productoList.add(producto);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return productoList;
}
@Override
    public Producto byId(Long id) {
        Producto producto = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM productos WHERE id =?")) {
                preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            producto = createProduct(resultSet);
        }
        resultSet.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return producto;
}

    @Override
    public void save(Producto producto) {

    }

    @Override
    public void delete(Long id) {

    }

}
