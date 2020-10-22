/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.Alimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author developer
 */

public class AlimentoDAO {
    
    public static final String SELECT_ALL_SQL = "SELECT id_alimento, nombre_alimento, marca_id FROM alimento";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE id_alimento = ?";
    public static final String CREATE_SQL = "INSERT INTO alimento (nombre_alimento, marca_id) VALUES (?,?)";
    public static final String UPDATE_SQL = "UPDATE alimento SET nombre_alimento = ? , marca_id = ? WHERE id_alimento = ?";
    public static final String DELETE_SQL = "DELETE FROM alimento WHERE id_alimento = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    
    public static Alimento find(int id_alimento){        
        Alimento alimento = new Alimento();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, id_alimento);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        alimento = new Alimento(
                                resultset.getInt("id_alimento"),
                                resultset.getString("nombre_alimento"),
                                resultset.getInt("marca_id"));                    
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return alimento;
      }
    
    public static ArrayList<Alimento> findAll(){ 
        ArrayList<Alimento> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while(resultSet.next()){
                        Alimento alimento;
                        alimento = new Alimento(
                                resultSet.getInt("id_alimento"),
                                resultSet.getString("nombre_alimento"),
                                resultSet.getInt("marca_id")
                        );
                        data.add(alimento);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("no se pudieron traer los alimentos");
            System.out.println(e);
        }
        return data;
    }
    
    public static int create(Alimento alimento){
        try (PreparedStatement stmnt = connection.prepareStatement(CREATE_SQL)) {
          stmnt.setString(1, alimento.getNombre_alimento());
          stmnt.setInt(2, alimento.getMarca_id()); 
          return stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    public static int update(Alimento alimento){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
                statement.setString(1, alimento.getNombre_alimento());
                statement.setInt(2, alimento.getMarca_id());
                statement.setInt(3, alimento.getId_alimento());
                return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
    public static int delete(int id_alimento){
        
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, id_alimento);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }

}
