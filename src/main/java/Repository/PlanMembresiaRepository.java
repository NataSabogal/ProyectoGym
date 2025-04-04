/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DTO.PlanMembresiaDTO;
import database.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArrayDeque;

/**
 *
 * @author nataliasabogalrada
 */
public class PlanMembresiaRepository {
    
    private Connection connection;
    
    public PlanMembresiaRepository() {
        connection = DatabaseConfig.getConnection(); 
    }

    public boolean guardarPlan(PlanMembresiaDTO plan) {
        String sql = "INSERT INTO plan_membresia (nombre, descripcion, precio, duracion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, plan.getNombre());
            stmt.setString(2, plan.getDescripcion());
            stmt.setDouble(3, plan.getPrecio());
            stmt.setInt(4, plan.getDuracion());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public PlanMembresiaDTO buscarPlan(String nombre) {
        String sql = "SELECT * FROM plan_membresia WHERE nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new PlanMembresiaDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("duracion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //traer todas las menbresias
    public List<PlanMembresiaDTO> buscarPlan() {
        String sql = "SELECT * FROM plan_membresia";
        List <PlanMembresiaDTO> planes = new ArrayDeque<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {
                planes.add(new PlanMembresiaDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("duracion")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planes;
    }

    public boolean actualizarPlan(PlanMembresiaDTO plan) {
        String sql = "UPDATE plan_membresia SET descripcion = ?, precio = ?, duracion = ? WHERE nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, plan.getDescripcion());
            stmt.setDouble(2, plan.getPrecio());
            stmt.setInt(3, plan.getDuracion());
            stmt.setString(4, plan.getNombre());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarPlan(String nombre) {
        String sql = "DELETE FROM plan_membresia WHERE nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<PlanMembresiaDTO> obtenerTodosPlanes() {
        List<PlanMembresiaDTO> planes = new ArrayList<>();
        String sql = "SELECT * FROM plan_membresia";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                PlanMembresiaDTO plan = new PlanMembresiaDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("duracion")
                );
                planes.add(plan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planes;
    }
    
    public PlanMembresiaDTO buscarPlanPorId(int id) {
        String sql = "SELECT * FROM plan_membresia WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new PlanMembresiaDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("duracion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public PlanMembresiaDTO buscarPlanPorNombre(String nombre) {
    String sql = "SELECT * FROM plan_membresia WHERE nombre = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, nombre);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new PlanMembresiaDTO(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("duracion")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
    
}
