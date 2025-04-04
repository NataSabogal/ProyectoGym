/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DTO.AsistenciaDTO;
import DTO.ClienteDTO;
import database.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author bran-
 */
public class AsistenciaRepository {

    private Connection connection;

    public AsistenciaRepository() {
        connection = DatabaseConfig.getConnection();

    }

    public boolean saveAsistencia(String cedula, LocalDate fecha, LocalTime horaEntrada) {
        String sql = "INSERT INTO Asistencia (cliente_cedula, fecha, hora_entrada) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cedula); // Usar la cédula directamente
            stmt.setDate(2, java.sql.Date.valueOf(fecha)); // Convertir LocalDate a SQL Date
            stmt.setTime(3, java.sql.Time.valueOf(horaEntrada)); // Convertir LocalTime a SQL Time

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


public AsistenciaDTO buscarAsistenciaPorCedula(String cedula) {
    String sql = "SELECT c.id, c.cedula, c.nombre, c.correo, c.telefono, " +
                 "c.plan_id, c.fecha_pago, c.monto_pago, " +
                 "a.fecha, a.hora_entrada " +
                 "FROM Asistencia a " +
                 "JOIN Cliente c ON a.cliente_cedula = c.cedula " +
                 "WHERE c.cedula = ?";

    try (Connection conn = DatabaseConfig.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cedula);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Crear objeto ClienteDTO con todos los atributos
            ClienteDTO cliente = new ClienteDTO(
                rs.getInt("id"),
                rs.getString("cedula"),
                rs.getString("nombre"),
                rs.getString("correo"),
                rs.getString("telefono"),
                rs.getInt("plan_id"),
                rs.getDate("fecha_pago"),
                rs.getDouble("monto_pago")
            );

            // Crear objeto AsistenciaDTO con el cliente y los datos de asistencia
            return new AsistenciaDTO(
                cliente,
                rs.getDate("fecha").toLocalDate(),
                rs.getTime("hora_entrada").toLocalTime()
            );
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null; // Retorna null si no se encuentra la asistencia
}



    
}
