/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectodiseniomaven;

import Ventanas.VentanaCrearAdmin;
import database.DatabaseConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author nataliasabogalrada
 */
public class ProyectoDisenioMaven {

    public static void main(String[] args) {
        VentanaCrearAdmin admin = new VentanaCrearAdmin();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);
        
        
         Connection con = DatabaseConfig.getConnection();
        if (con != null) {
            System.out.println("coneccion exitosa!!");
        } else {
            System.out.println("No conecto");
        }
    }
}
