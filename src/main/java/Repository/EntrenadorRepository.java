/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DTO.EntrenadorDTO;
import database.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nataliasabogalrada
 */
public class EntrenadorRepository {
    
    private Connection connection;

    public EntrenadorRepository() {
         connection = DatabaseConfig.getConnection();
    }
    
    public boolean guardarEntrenador(EntrenadorDTO  entrenador) {
        String sql = "INSERT INTO entrenador (cedula, nombre, correo, telefono) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, entrenador.getCedula());
            stmt.setString(2, entrenador.getNombre());
            stmt.setString(3, entrenador.getCorreo());
            stmt.setString(4, entrenador.getTelefono());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EntrenadorDTO buscarEntrenador(String cedula) {
        String sql = "SELECT * FROM entrenador WHERE cedula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new EntrenadorDTO(
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("telefono")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean actualizarEntrenador(EntrenadorDTO entrenador) {
        String sql = "UPDATE entrenador SET nombre=?, correo=?, telefono=? WHERE cedula=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, entrenador.getNombre());
            stmt.setString(2, entrenador.getCorreo());
            stmt.setString(3, entrenador.getTelefono());
            stmt.setString(4, entrenador.getCedula());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarEntrenador(String cedula) {
        String sql = "DELETE FROM entrenador WHERE cedula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public List<EntrenadorDTO> obtenerTodosEntrenadores() {
    List<EntrenadorDTO> entrenadores = new ArrayList<>();
    String sql = "SELECT cedula, nombre, correo, telefono FROM entrenador"; 
    
    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        
        while (rs.next()) {
            String cedula = rs.getString("cedula");
            String nombre = rs.getString("nombre");
            String correo = rs.getString("correo");
            String telefono = rs.getString("telefono");
            
            EntrenadorDTO entrenador = new EntrenadorDTO(cedula, nombre, correo, telefono);
            entrenadores.add(entrenador);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return entrenadores;
}
}
