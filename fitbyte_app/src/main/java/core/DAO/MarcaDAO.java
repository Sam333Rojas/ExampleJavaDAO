/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author developer
 */
public class MarcaDAO {
    
    public static final String SELECT_ALL_SQL = 
            "SELECT id_marca, nombre_marca FROM marca";
    public static final String SELECT_SQL = 
            SELECT_ALL_SQL + " WHERE id_marca = ?";
    public static final String CREATE_SQL =
            "INSERT INTO marca (nombre_marca) VALUES (?)";
    private static final Connection connection = ConnectionProvider.connection;


    public static void crearMarcaDB(Marca marca){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
            statement.setString(1,marca.getNombre_marca());
            statement.executeUpdate();
            System.out.println("marca creada");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void TraerMarcaDB(){
    
    }
    public static void borrarMarcaDB(){
    
    }
    public static void actualizarMarcaDB(){
    
    }
}
