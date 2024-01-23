
package Formularios;

import Clases.Expediente_;
import Clases.LimitesDatos;
import javax.swing.JOptionPane;
import Clases.Responsable_;
import java.io.File;
import java.util.List;
import javax.swing.text.AbstractDocument;

public class Responsable extends javax.swing.JPanel {

    private String responsable_dui;
    private boolean editando = false; //comodin para la funcion Modificar del Expediente
    Responsable_ responsable;
    Expediente_ expediente;
    
    public Responsable() {
        initComponents();  
        //inicializamos los JTexField para su uso en el boton Modificar
        expediente = new Expediente_();        
        //Limita los caracteres a escribir en los campos
        ((AbstractDocument) txtNombreResponsable.getDocument()).setDocumentFilter(LimitesDatos.getFilter(15));
        ((AbstractDocument) txtApellido.getDocument()).setDocumentFilter(LimitesDatos.getFilter(15));
        ((AbstractDocument) txtDUI.getDocument()).setDocumentFilter(LimitesDatos.getFilter(9));
        ((AbstractDocument) txtNumeroContacto.getDocument()).setDocumentFilter(LimitesDatos.getIntFilter(8));
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblDUI = new javax.swing.JLabel();
        lblNumContacto = new javax.swing.JLabel();
        txtNombreResponsable = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDUI = new javax.swing.JTextField();
        txtNumeroContacto = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 255));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 102, 102));
        lblTitulo.setText("Datos de Responsable:");

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 102, 102));
        lblNombre.setText("Nombre:");

        lblApellido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(0, 102, 102));
        lblApellido.setText("Apellido:");

        lblDUI.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDUI.setForeground(new java.awt.Color(0, 102, 102));
        lblDUI.setText("DUI:");

        lblNumContacto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNumContacto.setForeground(new java.awt.Color(0, 102, 102));
        lblNumContacto.setText("Número de Contacto:");

        txtNombreResponsable.setBackground(new java.awt.Color(255, 255, 255));

        txtApellido.setBackground(new java.awt.Color(255, 255, 255));

        txtDUI.setBackground(new java.awt.Color(255, 255, 255));

        txtNumeroContacto.setBackground(new java.awt.Color(255, 255, 255));

        btnAgregar.setBackground(new java.awt.Color(0, 102, 102));
        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(txtNombreResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDUI, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(txtDUI, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNumContacto)
                        .addGap(85, 85, 85)
                        .addComponent(txtNumeroContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTitulo)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtNombreResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellido)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnAgregar)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDUI)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtDUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumContacto)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtNumeroContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getResponsable_dui() {
        return this.responsable_dui;
    }

    public int getResponsable_duiAsInt() {
        return Integer.parseInt(this.responsable_dui);
    } 
    
    public void modifExResponsable(Responsable_ responsable, String rutaArchivo){
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            // Obtiene los datos del archivo
            List<Object[]> listaDatos = expediente.expedienteResponsable_(archivo);
            for(Object[]datos : listaDatos){
                // Añade los datos a los JTextField
                this.txtNombreResponsable.setText(datos[0].toString());
                this.txtApellido.setText(datos[1].toString());
                this.txtDUI.setText(datos[2].toString());
                this.txtNumeroContacto.setText(datos[3].toString());
                this.editando = true;
                // Forza a Swing a redibujar los campos con el nuevo texto
                this.txtNombreResponsable.repaint();
                this.txtApellido.repaint();
                this.txtDUI.repaint();
                this.txtDUI.setEditable(false);
                this.txtNumeroContacto.repaint();
                /* Imprime los datos para verificar que se están estableciendo correctamente
                System.out.println("Nombre: " + this.txtNombreResponsable.getText());
                System.out.println("Apellido: " + this.txtApellido.getText());
                System.out.println("DUI: " + this.txtDUI.getText());
                System.out.println("Número de contacto: " + this.txtNumeroContacto.getText());*/
            } 
        }
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(!txtNombreResponsable.getText().isEmpty()){
            if(!txtApellido.getText().isEmpty()){
                if(txtDUI.getText().length() == 9){//Obligo a que el DUI sea de 9 digitos
                    if(!txtNumeroContacto.getText().isEmpty()){                        
                        responsable = new Responsable_(
                            this.txtNombreResponsable.getText(),
                            this.txtApellido.getText(),
                            this.txtDUI.getText(),
                            Integer.parseInt(this.txtNumeroContacto.getText())                            
                         );                        
                        if(editando){
                            JOptionPane.showMessageDialog(null, "Responsable Modificado con éxito");
                            // Actualiza el expediente para el responsable
                            Expediente_ expedienteResponsable = new Expediente_();
                            expedienteResponsable.setResponsable(responsable);
                            expedienteResponsable.actualizarResponsable();
                        }else{
                            JOptionPane.showMessageDialog(null, "Responsable de mascota registrado");
                            // Crear el expediente para el responsable
                            Expediente_ expedienteResponsable = new Expediente_();
                            expedienteResponsable.setResponsable(responsable);
                            expedienteResponsable.crearCarpetaMadre();
                            expedienteResponsable.crearCarpetasHijo();
                            expedienteResponsable.registrarResponsable();
                        }
                        // Restablece la variable 'editando' a 'false'
                        editando = false;                                                                
                    }else{
                        JOptionPane.showMessageDialog(null, "Llene el número de contacto del responsable");
                        txtNumeroContacto.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El DUI debe ser completo (9 digitos)");
                    txtDUI.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Llene el apellido del responsable");
                txtApellido.requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Llene el nombre del responsable");
            txtNombreResponsable.requestFocus();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblDUI;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumContacto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDUI;
    private javax.swing.JTextField txtNombreResponsable;
    private javax.swing.JTextField txtNumeroContacto;
    // End of variables declaration//GEN-END:variables
}
