
package Formularios;

import Clases.Cita_;
import Clases.Paciente_;
import Clases.Responsable_;
import Clases.Vacunacion_;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class vet_pet extends javax.swing.JFrame {
    
    public vet_pet() {
        initComponents(); 
        portada portada_ = new portada();
        mostrarPaneles(portada_);
    }   
    
    private void mostrarPaneles(JPanel p){
        p.setSize(706, 370);
        p.setLocation(0,0);      
        pnlContenedor.removeAll();
        pnlContenedor.add(p, BorderLayout.CENTER);
        pnlContenedor.revalidate();
        pnlContenedor.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblCVVetPet = new javax.swing.JLabel();
        lblSlogan = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblOpciones = new javax.swing.JLabel();
        btnResponsable = new javax.swing.JButton();
        btnPaciente = new javax.swing.JButton();
        btnCita = new javax.swing.JButton();
        btnVacunación = new javax.swing.JButton();
        btnExpediente = new javax.swing.JButton();
        pnlContenedor = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        lblVerExpediente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/pata.png")).getImage());

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));

        lblCVVetPet.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblCVVetPet.setForeground(new java.awt.Color(0, 102, 102));
        lblCVVetPet.setText("Clínica Veterinaria ");

        lblSlogan.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lblSlogan.setForeground(new java.awt.Color(0, 102, 102));
        lblSlogan.setText("¡Cuidamos a tus amigos con cariño!");

        lblOpciones.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblOpciones.setForeground(new java.awt.Color(0, 102, 102));
        lblOpciones.setText("¿Qué deseas hacer? Agregar:");

        btnResponsable.setBackground(new java.awt.Color(153, 153, 255));
        btnResponsable.setForeground(new java.awt.Color(0, 102, 102));
        btnResponsable.setText("Responsable");
        btnResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponsableActionPerformed(evt);
            }
        });

        btnPaciente.setBackground(new java.awt.Color(153, 153, 255));
        btnPaciente.setForeground(new java.awt.Color(0, 102, 102));
        btnPaciente.setText("Paciente");
        btnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacienteActionPerformed(evt);
            }
        });

        btnCita.setBackground(new java.awt.Color(204, 153, 255));
        btnCita.setForeground(new java.awt.Color(0, 102, 102));
        btnCita.setText("Cita");
        btnCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitaActionPerformed(evt);
            }
        });

        btnVacunación.setBackground(new java.awt.Color(204, 153, 255));
        btnVacunación.setForeground(new java.awt.Color(0, 102, 102));
        btnVacunación.setText("Vacunación");
        btnVacunación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVacunaciónActionPerformed(evt);
            }
        });

        btnExpediente.setBackground(new java.awt.Color(255, 255, 204));
        btnExpediente.setForeground(new java.awt.Color(0, 102, 102));
        btnExpediente.setText("Expediente");
        btnExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpedienteActionPerformed(evt);
            }
        });

        pnlContenedor.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        lblVerExpediente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblVerExpediente.setForeground(new java.awt.Color(0, 102, 102));
        lblVerExpediente.setText("Revisar:");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(lblSlogan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCVVetPet)
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(btnResponsable)
                                .addGap(27, 27, 27)
                                .addComponent(btnPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCita, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnVacunación)))
                        .addComponent(lblOpciones)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVerExpediente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExpediente, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(47, 47, 47))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(lblCVVetPet)
                .addGap(3, 3, 3)
                .addComponent(lblSlogan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOpciones)
                    .addComponent(lblVerExpediente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResponsable)
                    .addComponent(btnPaciente)
                    .addComponent(btnCita)
                    .addComponent(btnVacunación)
                    .addComponent(btnExpediente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponsableActionPerformed
        Responsable panelResponsable= new Responsable();
        mostrarPaneles(panelResponsable);
    }//GEN-LAST:event_btnResponsableActionPerformed
    //Método para Modificar en JPanel_Expediente: RESPONSABLE
    public void mostrarPanelResponsable(Responsable_ responsable,String rutaArchivo) {
        Responsable panelResponsable = new Responsable();    
        // Carga los datos del objeto Responsable_ en el panel para el boton Modificar
        panelResponsable.modifExResponsable(responsable,rutaArchivo);    
        mostrarPaneles(panelResponsable);
    }
    
    private void btnPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacienteActionPerformed
        Paciente panelPaciente= new Paciente();
        mostrarPaneles(panelPaciente);
    }//GEN-LAST:event_btnPacienteActionPerformed
    //Método para Modificar en JPanel_Expediente: PACIENTE
    public void mostrarPanelPaciente(Paciente_ paciente, String rutaArchivo){
       Paciente panelPaciente = new Paciente();
       panelPaciente.modifEXPaciente(paciente, rutaArchivo);
       mostrarPaneles(panelPaciente);
    }
    
    private void btnCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitaActionPerformed
        Cita panelCita= new Cita();
        mostrarPaneles(panelCita);
    }//GEN-LAST:event_btnCitaActionPerformed
    //Método para Modificar en JPanel_Expediente: CITA
    public void mostrarPanelCita(Cita_ cita, String rutaArchivo){
       Cita panelCita = new Cita();
       panelCita.modifEXCita(cita, rutaArchivo);
       mostrarPaneles(panelCita);
    }
    
    private void btnVacunaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVacunaciónActionPerformed
        Vacunacion panelVacunacion= new Vacunacion();
        mostrarPaneles(panelVacunacion);
    }//GEN-LAST:event_btnVacunaciónActionPerformed
    //Método para Modificar en JPanel_Expediente: VACUNACION
    public void mostrarPanelVacunacion(Vacunacion_ vacunacion, String rutaArchivo){
        Vacunacion  panelVacunacion = new Vacunacion();
        panelVacunacion.modifEXVacunacion(vacunacion, rutaArchivo);
        mostrarPaneles(panelVacunacion);
    }
    
    private void btnExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpedienteActionPerformed
        Expediente panelExpedienten = new Expediente(this);
        mostrarPaneles(panelExpedienten);
    }//GEN-LAST:event_btnExpedienteActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vet_pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vet_pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vet_pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vet_pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vet_pet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCita;
    private javax.swing.JButton btnExpediente;
    private javax.swing.JButton btnPaciente;
    private javax.swing.JButton btnResponsable;
    private javax.swing.JButton btnVacunación;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCVVetPet;
    private javax.swing.JLabel lblOpciones;
    private javax.swing.JLabel lblSlogan;
    private javax.swing.JLabel lblVerExpediente;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables

    
}
