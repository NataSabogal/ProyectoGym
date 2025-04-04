package Repository;

import DTO.ClienteDTO;
import database.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bran-
 */
public class AdminPagoRepository {

    private Connection connection;

    public AdminPagoRepository() {
        connection = DatabaseConfig.getConnection();
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
                        rs.getDouble("monto_pago")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
