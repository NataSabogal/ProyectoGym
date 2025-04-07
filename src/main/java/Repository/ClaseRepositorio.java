/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DTO.ClaseDTO;
import database.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bran-
 */
public class ClaseRepositorio {

    public ClaseRepositorio() {

    }

    public boolean saveClase(ClaseDTO clase) {
        String buscarClaseSQL = "SELECT id FROM clase WHERE nombre = ?";
        String insertarClaseSQL = "INSERT INTO clase (nombre, descripcion) VALUES (?, ?)";
        String buscarEntrenadorSQL = "SELECT id FROM entrenador WHERE cedula = ?";
        String insertarHorarioSQL = "INSERT INTO horario_clase (clase_id, entrenador_id, fecha, hora) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement buscarClaseStmt = conn.prepareStatement(buscarClaseSQL); PreparedStatement insertarClaseStmt = conn.prepareStatement(insertarClaseSQL, PreparedStatement.RETURN_GENERATED_KEYS); PreparedStatement buscarEntrenadorStmt = conn.prepareStatement(buscarEntrenadorSQL); PreparedStatement insertarHorarioStmt = conn.prepareStatement(insertarHorarioSQL)) {

            // Verificar si la clase ya existe
            buscarClaseStmt.setString(1, clase.getNombreClase());
            ResultSet claseRs = buscarClaseStmt.executeQuery();

            int claseId;
            if (claseRs.next()) {
                claseId = claseRs.getInt("id"); // Obtener el ID de la clase existente
            } else {
                // Insertar nueva clase
                insertarClaseStmt.setString(1, clase.getNombreClase());
                insertarClaseStmt.setString(2, "Descripción predeterminada"); // Cambia si tienes un campo para descripción
                insertarClaseStmt.setDate(3, clase.getFechaClase());
                insertarClaseStmt.executeUpdate();

                // Obtener el ID generado
                ResultSet generatedKeys = insertarClaseStmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    claseId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID de la nueva clase.");
                }
            }

            // Buscar el ID del entrenador
            buscarEntrenadorStmt.setString(1, clase.getEntrenadorDTO());
            ResultSet entrenadorRs = buscarEntrenadorStmt.executeQuery();

            if (!entrenadorRs.next()) {
                System.out.println("No se encontró un entrenador con la cédula proporcionada.");
                return false;
            }
            int entrenadorId = entrenadorRs.getInt("id");

            // Insertar el horario en la tabla horario_clase
            insertarHorarioStmt.setInt(1, claseId);
            insertarHorarioStmt.setInt(2, entrenadorId);
            insertarHorarioStmt.setDate(3, clase.getFechaClase());
            insertarHorarioStmt.setString(4, clase.getHoraClase());

            int rowsInserted = insertarHorarioStmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            return false;
        }
    }
}
