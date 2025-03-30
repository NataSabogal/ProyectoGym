/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectodiseniomaven;

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
         Connection con = DatabaseConfig.getConnection();
        if (con != null) {
            System.out.println("coneccion exitosa!!");
        } else {
            System.out.println("No conecto");
        }
    }
}
