/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beelbalam1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Anahi SC
 */
public class ProcCancelarReserva {
    private int codReserva;

    public int getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(int codReserva) {
        this.codReserva = codReserva;
    }
    
    public void hacerConexionCR(){
        try {
            Connection miConexionBU = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-KT6L84G:1433", "sa", "2020640576");
            CallableStatement resConexionCR;
            resConexionCR = miConexionBU.prepareCall("{call CANCELAR_RESERVA(?)}");
            resConexionCR.setInt(1,getCodReserva());
            JOptionPane.showMessageDialog(null, "Se ha cancelado correctamente la reserva");
        } catch (Exception e) {
            System.out.println("Ha habido un error al cancelar la reserva");
            System.out.println(e);
        }
    }
}
