/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beelbalam1;

import javax.swing.JOptionPane;

/**
 *
 * @author Anahi SC
 */
public class PanelTarjeta extends javax.swing.JPanel {

    /**
     * Creates new form PanelTarjeta
     */

    Window PanelWindow;
    //PARA ALMACENAR LOS DATOS (DE TARJETA) DEL NUEVO USUARIO 
    ProcCrearUsuario paCrearUsuario = new ProcCrearUsuario();
    public static PanelRegistro panReg = new PanelRegistro();
    public PanelTarjeta() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumTarjeta = new javax.swing.JTextField();
        txtNombreRepTarjeta = new javax.swing.JTextField();
        txtApPaternoTarjeta = new javax.swing.JTextField();
        txtApMaternoNumTarjeta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCVCTarjeta = new javax.swing.JTextField();
        txtMesTarjeta = new javax.swing.JTextField();
        txtAnioTarjeta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnConfTarjeta = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("REGISTRO DE TARJETA DE CRÉDITO/DÉBITO");

        jLabel2.setText("TITULAR DE LA TARJETA:");

        jLabel3.setText("NÚMERO DE TARJETA:");

        jLabel4.setText("FECHA DE VENCIMIENTO:");

        jLabel5.setText("CVC: ");

        txtApPaternoTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApPaternoTarjetaActionPerformed(evt);
            }
        });

        jLabel6.setText("        NOMBRE/S                       AP. PATERNO                    AP. MATERNO");

        jLabel7.setText("    MM        AA");

        btnConfTarjeta.setText("ENVIAR DATOS");
        btnConfTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfTarjetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCVCTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtMesTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtAnioTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNumTarjeta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombreRepTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApPaternoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addComponent(txtApMaternoNumTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnConfTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(237, 237, 237))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreRepTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApPaternoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApMaternoNumTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMesTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnioTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCVCTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfTarjeta)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtApPaternoTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApPaternoTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApPaternoTarjetaActionPerformed

    private void btnConfTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfTarjetaActionPerformed
        //PARA OBTENER LOS DATOS DEL Panel DE TARJETA 
        if(txtNumTarjeta.getText().length()>17||
                txtNumTarjeta.getText().isEmpty()||
                txtNombreRepTarjeta.getText().length()>30||
                txtNombreRepTarjeta.getText().isEmpty()||
                txtApPaternoTarjeta.getText().length()>15||
                txtApPaternoTarjeta.getText().isEmpty()||
                txtApMaternoNumTarjeta.getText().length()>15||
                txtApMaternoNumTarjeta.getText().isEmpty()||
                txtMesTarjeta.getText().length()>3||
                txtMesTarjeta.getText().isEmpty()||
                txtAnioTarjeta.getText().length()>3||
                txtAnioTarjeta.getText().isEmpty()||
                txtCVCTarjeta.getText().length()>4||
                txtCVCTarjeta.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "¡Error! Alguno o varios datos son incorrectos (demasiado largo o vacio)");
            txtNumTarjeta.setText(" ");
            txtNombreRepTarjeta.setText(" ");
            txtApPaternoTarjeta.setText(" ");
            txtApMaternoNumTarjeta.setText(" ");
            txtMesTarjeta.setText(" ");
            txtAnioTarjeta.setText(" ");
            txtCVCTarjeta.setText(" ");
        }else{
            //System.out.println("nusuario: "+panReg.nUsuario);
            paCrearUsuario.setNombreU(panReg.nUsuario);
            paCrearUsuario.setContraseniaU(panReg.cont);
            paCrearUsuario.setNumCelularU(panReg.numCel);
            paCrearUsuario.setCorreoU(panReg.correo);
            
            paCrearUsuario.setNumeroT(txtNumTarjeta.getText());
            
            String nombreRecibido = txtNombreRepTarjeta.getText();
            
            String[] nombres = nombreRecibido.split("\\s+");
            if(nombres.length == 1){
                paCrearUsuario.setNombreT(txtNombreRepTarjeta.getText());
                paCrearUsuario.setSegNombreT(" ");
                System.out.println("Solo un nombre: "+nombres[0]);
            }else if(nombres.length == 2){
                paCrearUsuario.setNombreT(nombres[0]);
                paCrearUsuario.setSegNombreT(nombres[1]);
                System.out.println("Primer nombre: "+nombres[0]);
                System.out.println("Segundo nombre: "+nombres[1]);
            }
            paCrearUsuario.setPrimerApT(txtApPaternoTarjeta.getText());
            paCrearUsuario.setSegApT(txtApMaternoNumTarjeta.getText());
            paCrearUsuario.setFechaT(Integer.parseInt(txtMesTarjeta.getText().concat(txtAnioTarjeta.getText())));
            paCrearUsuario.setCvcT(Integer.parseInt(txtCVCTarjeta.getText()));
            paCrearUsuario.setPtosAcum(0);
            //LLAMAMOS AL PROC ALMACENADO PARA QUE CREE EL USUARIO 
            paCrearUsuario.hacerConexion();
            //Verificaaaaar que se haya podido generar usuario
            /*if(se creo correctamente el usuario)
                llama a window
            else if(el usuario ya existia)
                se regresa al panel de registrar usuario*/
            PanelWindow = new Window();
            PanelWindow.setBounds(this.getBounds());
            this.removeAll();
            this.add(PanelWindow);
            this.updateUI();
        }


        
    }//GEN-LAST:event_btnConfTarjetaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfTarjeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtAnioTarjeta;
    private javax.swing.JTextField txtApMaternoNumTarjeta;
    private javax.swing.JTextField txtApPaternoTarjeta;
    private javax.swing.JTextField txtCVCTarjeta;
    private javax.swing.JTextField txtMesTarjeta;
    private javax.swing.JTextField txtNombreRepTarjeta;
    private javax.swing.JTextField txtNumTarjeta;
    // End of variables declaration//GEN-END:variables
}
