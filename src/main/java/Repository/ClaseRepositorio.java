/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DTO.AdminDTO;
import DTO.ClaseDTO;
import database.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author bran-
 */
public class ClaseRepositorio {

    public ClaseRepositorio() {

    }

   public boolean saveClase(ClaseDTO clase) {
    String buscarIdSQL = "SELECT id FROM entrenador WHERE cedula = ?";
    String insertarClaseSQL = "INSERT INTO clase (nombre, entrenador_id, fecha_clase, hora_clase) VALUES (?, ?, ?, ?)";

    try (Connection conn = DatabaseConfig.getConnection();
         PreparedStatement buscarStmt = conn.prepareStatement(buscarIdSQL);
         PreparedStatement insertarStmt = conn.prepareStatement(insertarClaseSQL)) {

        // Buscar ID del entrenador por la cédula
        buscarStmt.setString(1, clase.getEntrenadorDTO());  
        ResultSet rs = buscarStmt.executeQuery();

        if (rs.next()) {
            int idEntrenador = rs.getInt("id"); 

            // Conversión de java.util.Date a java.sql.Date
            java.sql.Date fechaSQL = new java.sql.Date(clase.getFechaClase().getTime());

            // Insertar la clase con el ID obtenido
            insertarStmt.setString(1, clase.getNombreClase());
            insertarStmt.setInt(2, idEntrenador);
            insertarStmt.setDate(3, fechaSQL); // Conversión aplicada aquí
            insertarStmt.setString(4, clase.getHoraClase());

            int rowsInserted = insertarStmt.executeUpdate();
            return rowsInserted > 0;
        } else {
            System.out.println("No se encontró un entrenador con la cédula proporcionada.");
            return false;
        }

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}


}
