/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DTO.ClienteDTO;
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
public class ClienteRepository {
    
    private Connection connection;

    public ClienteRepository() {
        connection = DatabaseConfig.getConnection();
    }

    public boolean guardarCliente(ClienteDTO cliente) {
        String sql = "INSERT INTO cliente (cedula, nombre, correo, telefono, plan_id, fecha_pago, monto_pago, objetivo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCedula());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getCorreo());
            stmt.setString(4, cliente.getTelefono());
            stmt.setInt(5, cliente.getPlanId());
            stmt.setDate(6, cliente.getFechaPago());
            stmt.setDouble(7, cliente.getMontoPago());
            stmt.setString(8, cliente.getObjetivo());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ClienteDTO buscarClientePorCedula(String cedula) {
        String sql = "SELECT * FROM cliente WHERE cedula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ClienteDTO(
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean actualizarCliente(ClienteDTO cliente) {
        String sql = "UPDATE cliente SET nombre = ?, correo = ?, telefono = ?, plan_id = ?, fecha_pago = ?, monto_pago = ?, objetivo = ? WHERE cedula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getCorreo());
            stmt.setString(3, cliente.getTelefono());
            stmt.setInt(4, cliente.getPlanId());
            stmt.setDate(5, cliente.getFechaPago());
            stmt.setDouble(6, cliente.getMontoPago());
            stmt.setString(7, cliente.getObjetivo());
            stmt.setString(8, cliente.getCedula());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarCliente(String cedula) {
        String sql = "DELETE FROM cliente WHERE cedula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ClienteDTO> obtenerTodosClientes() {
        List<ClienteDTO> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
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
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
