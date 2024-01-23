
package Formularios;

import Clases.Expediente_;
import Clases.LimitesDatos;
import Clases.Vacunacion_;
import com.toedter.calendar.JCalendar;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class Vacunacion extends javax.swing.JPanel {

    String fechaCita;
    String horaCita;
    Expediente_ expediente;
    Vacunacion_ vacunacion;
    private boolean editando = false; //comodin para la funcion Modificar del Expediente
    
    public  Vacunacion() {
        initComponents();
            //inicializamos los JTexField para su uso en el boton Modificar
            expediente = new Expediente_(); 
            cldFecha.setMinSelectableDate(new Date());//fecha mínima (actual)
            Date nextYear = new Date();//fecha máxima(hasta un año)
            nextYear.setYear(nextYear.getYear() + 1);
            cldFecha.setMaxSelectableDate(nextYear);
            fechaCita=LocalDate.now().getDayOfMonth()+"-"+LocalDate.now().getMonthValue()+"-"+LocalDate.now().getYear();
            txtFecha.setText(fechaCita);
            
            // Cuando se selecciona una nueva fecha, actualiza el JText
            cldFecha.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    if ("calendar".equals(e.getPropertyName())) {
                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                        txtFecha.setText(format.format(((JCalendar) e.getSource()).getDate()));
                    }
                }
            });
            
            //Limita los caracteres a escribir en los campos
            ((AbstractDocument) txtMedicamento.getDocument()).setDocumentFilter(LimitesDatos.getFilter(50));
            ((AbstractDocument) txtBuscarDUI.getDocument()).setDocumentFilter(LimitesDatos.getFilter(9));
            ((AbstractDocument) txtBuscarPaciente.getDocument()).setDocumentFilter(LimitesDatos.getFilter(15));
    }

    public void calcularHora(){
        horaCita=cbxHoraCita.getSelectedItem()+":"+cbxMinutosCita.getSelectedItem();
        txtHoraCompleta.setText(horaCita);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblFechaVacunacion = new javax.swing.JLabel();
        lblHoraCita = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        cbxHoraCita = new javax.swing.JComboBox<>();
        cbxMinutosCita = new javax.swing.JComboBox<>();
        txtHoraCompleta = new javax.swing.JTextField();
        lblCita = new javax.swing.JLabel();
        txtMedicamento = new javax.swing.JTextField();
        cldFecha = new com.toedter.calendar.JCalendar();
        btnAgregar = new javax.swing.JButton();
        lblBuscarDUI = new javax.swing.JLabel();
        txtBuscarDUI = new javax.swing.JTextField();
        lblBuscarNombreMascota = new javax.swing.JLabel();
        txtBuscarPaciente = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 153, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 102, 102));
        lblTitulo.setText("Datos de Vacunación:");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        lblFechaVacunacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFechaVacunacion.setForeground(new java.awt.Color(0, 102, 102));
        lblFechaVacunacion.setText("Fecha de Vacunación:");
        add(lblFechaVacunacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        lblHoraCita.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblHoraCita.setForeground(new java.awt.Color(0, 102, 102));
        lblHoraCita.setText("Hora:");
        add(lblHoraCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 56, -1, -1));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 80, -1));

        cbxHoraCita.setBackground(new java.awt.Color(204, 153, 255));
        cbxHoraCita.setForeground(new java.awt.Color(0, 102, 102));
        cbxHoraCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "08", "09", "10", "11", "01", "02", "03", "04" }));
        cbxHoraCita.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxHoraCitaItemStateChanged(evt);
            }
        });
        add(cbxHoraCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 51, -1, -1));

        cbxMinutosCita.setBackground(new java.awt.Color(204, 153, 255));
        cbxMinutosCita.setForeground(new java.awt.Color(0, 102, 102));
        cbxMinutosCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45" }));
        cbxMinutosCita.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMinutosCitaItemStateChanged(evt);
            }
        });
        add(cbxMinutosCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 51, -1, -1));

        txtHoraCompleta.setEditable(false);
        txtHoraCompleta.setBackground(new java.awt.Color(255, 255, 255));
        add(txtHoraCompleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 54, 50, -1));

        lblCita.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCita.setForeground(new java.awt.Color(0, 102, 102));
        lblCita.setText("Medicamentos:");
        add(lblCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 93, -1, -1));

        txtMedicamento.setBackground(new java.awt.Color(255, 255, 255));
        add(txtMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 94, 160, -1));

        cldFecha.setBackground(new java.awt.Color(204, 153, 255));
        cldFecha.setForeground(new java.awt.Color(0, 102, 102));
        cldFecha.setDecorationBackgroundColor(new java.awt.Color(255, 255, 255));
        add(cldFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 280, 180));

        btnAgregar.setBackground(new java.awt.Color(0, 102, 102));
        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        lblBuscarDUI.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBuscarDUI.setForeground(new java.awt.Color(0, 102, 102));
        lblBuscarDUI.setText("DUI del responsable:");
        add(lblBuscarDUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 56, -1, -1));

        txtBuscarDUI.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarDUI.setForeground(new java.awt.Color(0, 102, 102));
        add(txtBuscarDUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 57, 124, -1));

        lblBuscarNombreMascota.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBuscarNombreMascota.setForeground(new java.awt.Color(0, 102, 102));
        lblBuscarNombreMascota.setText("Nombre de paciente:");
        add(lblBuscarNombreMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 88, -1, -1));

        txtBuscarPaciente.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarPaciente.setForeground(new java.awt.Color(0, 102, 102));
        add(txtBuscarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 89, 124, -1));
    }// </editor-fold>//GEN-END:initComponents
   
    private void cbxHoraCitaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxHoraCitaItemStateChanged
        calcularHora();
    }//GEN-LAST:event_cbxHoraCitaItemStateChanged

    private void cbxMinutosCitaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMinutosCitaItemStateChanged
        calcularHora();
    }//GEN-LAST:event_cbxMinutosCitaItemStateChanged

    public String buscarDUIResponsableYPaciente(){
        String dui = txtBuscarDUI.getText(); 
        String nombre =txtBuscarPaciente.getText();
        
        String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + dui;
        File carpetaBusquedaDUI = new File(rutaCarpeta);

        if (carpetaBusquedaDUI.exists() && carpetaBusquedaDUI.isDirectory()) {            
            File ficheroBusquedaDUI = new File(carpetaBusquedaDUI, "Registro_de_responsable.txt");
            File ficheroBusquedaPaciente = new File(carpetaBusquedaDUI, "Registro_de_paciente_" + nombre + "p.txt");//definimos el identificador único
            String busqueda = "DUI° " + dui;
            String busquedaNombre = "Nombre° "+nombre;

            try {
                BufferedReader fil = new BufferedReader(new FileReader(ficheroBusquedaDUI));
                String linea;
                boolean encontrado = false;
                while ((linea = fil.readLine()) != null) {
                    if (linea.toUpperCase().equalsIgnoreCase(busqueda)) {                    
                        encontrado = true;
                        break;
                    }
                }
                fil.close();
            
                if (encontrado) {
                    JOptionPane.showMessageDialog(null, "Responsable encontrado");
                    BufferedReader filPaciente = new BufferedReader(new FileReader(ficheroBusquedaPaciente));
                    boolean encontradoNombre = false;
                    while ((linea = filPaciente.readLine()) != null) {
                        if (linea.toUpperCase().startsWith(busquedaNombre.toUpperCase())) {                    
                            encontradoNombre = true;
                            break;
                        }
                    }
                    filPaciente.close();
                    if (encontradoNombre) {
                        JOptionPane.showMessageDialog(null, "Paciente encontrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Lo siento no encontramos al paciente");
                    }
                    return rutaCarpeta; 
                } else {
                    JOptionPane.showMessageDialog(null, "Lo siento no encontramos al responsable");
                }
            } catch (IOException e) {
                System.out.println("Ha ocurrido un Error" + e);
                JOptionPane.showMessageDialog(null, "Se ha producido un error");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un DUI válido");
        }
        return null; 
    }

    //Modifica Método:
    public void modifEXVacunacion(Vacunacion_ vacunacion,String rutaArchivo){
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            List<Object[]> listaDatos = expediente.expedienteVacunacion_(archivo);
            for(Object[]datos : listaDatos){
                // Añade los datos a los JTextField
                    this.txtBuscarDUI.setText(datos[0].toString());
                    this.txtBuscarPaciente.setText(datos[1].toString());
                    this.txtFecha.setText(datos[2].toString());
                    this.txtHoraCompleta.setText(datos[3].toString());
                    this.txtMedicamento.setText(datos[4].toString());
                // Forza a Swing a redibujar los campos con el nuevo texto
                    this.txtBuscarDUI.repaint();
                    this.txtBuscarDUI.setEditable(false);
                    this.txtBuscarPaciente.repaint();
                    this.txtFecha.repaint();
                    this.txtHoraCompleta.repaint();
                    this.txtMedicamento.repaint();
            }
        } 
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (!txtFecha.getText().isEmpty()) {
            if (!txtHoraCompleta.getText().isEmpty()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setLenient(false);
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                timeFormat.setLenient(false);
                if (!txtMedicamento.getText().isEmpty()) {
                    if(!txtBuscarDUI.getText().isEmpty()){
                        if(!txtBuscarPaciente.getText().isEmpty()){
                            String rutaCarpeta = buscarDUIResponsableYPaciente(); 
                            if(rutaCarpeta !=null){
                                try {
                                    String Responsable_dui =txtBuscarDUI.getText();
                                    String Paciente_nombre = txtBuscarPaciente.getText();
                                    String fecha = txtFecha.getText();
                                    String hora = txtHoraCompleta.getText();
                                    vacunacion = new Vacunacion_(
                                        dateFormat.parse(txtFecha.getText()),
                                        timeFormat.parse(txtHoraCompleta.getText()),
                                        this.txtMedicamento.getText(),
                                        this.txtBuscarDUI.getText(),
                                        this.txtBuscarPaciente.getText()                                            
                                    );  
                                    if(editando){
                                        JOptionPane.showMessageDialog(null, "Vacunación modificada con éxito");
                                        // Modificamos el expediente de la vacunación
                                        Expediente_ expedienteVacunacion = new Expediente_();
                                        expedienteVacunacion.setVacunacion(vacunacion);
                                        expedienteVacunacion.actualizacionVacunacion(Responsable_dui, Paciente_nombre, vacunacion);
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Vacunación registrada");
                                        // Crear el expediente para la vacunación
                                        Expediente_ expedienteVacunacion = new Expediente_();
                                        expedienteVacunacion.setVacunacion(vacunacion);
                                        expedienteVacunacion.registrarVacunación(Responsable_dui,Paciente_nombre,vacunacion); 
                                    }                                    
                                } catch (ParseException ex) {                        
                                    ex.printStackTrace();
                                } 
                            }else{
                               JOptionPane.showMessageDialog(null, "Registre un responsable y su mascota para agregar un vacunación");
                           }                            
                       }else{
                           JOptionPane.showMessageDialog(null, "Diganos el nombre del paciente");
                       }
                   }else{
                       JOptionPane.showMessageDialog(null, "Ingrese el DUI del responsable");
                   }                     
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese los medicamentos a vacunar");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Defina una hora");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Defina una fecha");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cbxHoraCita;
    private javax.swing.JComboBox<String> cbxMinutosCita;
    private com.toedter.calendar.JCalendar cldFecha;
    private javax.swing.JLabel lblBuscarDUI;
    private javax.swing.JLabel lblBuscarNombreMascota;
    private javax.swing.JLabel lblCita;
    private javax.swing.JLabel lblFechaVacunacion;
    private javax.swing.JLabel lblHoraCita;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtBuscarDUI;
    private javax.swing.JTextField txtBuscarPaciente;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHoraCompleta;
    private javax.swing.JTextField txtMedicamento;
    // End of variables declaration//GEN-END:variables
}
