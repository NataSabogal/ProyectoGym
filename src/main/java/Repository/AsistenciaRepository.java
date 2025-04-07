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
        String buscarClienteSQL = "SELECT id FROM Cliente WHERE cedula = ?";
        String insertarAsistenciaSQL = "INSERT INTO Asistencia (cliente_cedula, cliente_id, fecha, hora_entrada) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement buscarStmt = conn.prepareStatement(buscarClienteSQL); PreparedStatement insertarStmt = conn.prepareStatement(insertarAsistenciaSQL)) {

            // Obtener el cliente_id
            buscarStmt.setString(1, cedula);
            ResultSet rs = buscarStmt.executeQuery();

            int clienteId = -1; // Valor por defecto si no se encuentra el cliente
            if (rs.next()) {
                clienteId = rs.getInt("id");
            } else {
                System.out.println("No se encontró un cliente con la cédula proporcionada.");
                return false; // No continuar si no se encuentra el cliente
            }

            // Insertar la asistencia
            insertarStmt.setString(1, cedula);
            insertarStmt.setInt(2, clienteId); // Usar el cliente_id encontrado
            insertarStmt.setDate(3, java.sql.Date.valueOf(fecha));
            insertarStmt.setTime(4, java.sql.Time.valueOf(horaEntrada));

            int rowsInserted = insertarStmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar asistencia: " + e.getMessage());
            return false;
        }
    }

    public boolean guardarAsistencia(String cedula) {
        String sql = "INSERT INTO Asistencia (cliente_cedula) VALUES (?)";
        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cedula);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public AsistenciaDTO buscarAsistenciaPorCedula(String cedula) {
        String sql = "SELECT c.id, c.cedula, c.nombre, c.correo, c.telefono, "
                + "c.plan_id, c.fecha_pago, c.monto_pago, "
                + "a.fecha, a.hora_entrada "
                + "FROM Asistencia a "
                + "JOIN Cliente c ON a.cliente_cedula = c.cedula "
                + "WHERE c.cedula = ?";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

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
                        rs.getDouble("monto_pago"),
                        rs.getString("objetivo")
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
