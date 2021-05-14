/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beelbalam1;   
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class BeelBalam1 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-KT6L84G:1433", "sa", "2020640576");
            System.out.println("Conectado con exito");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println("Error :c");
            e.printStackTrace();
        }
    }
    
}
