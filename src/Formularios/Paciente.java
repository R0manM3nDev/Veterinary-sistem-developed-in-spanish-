
package Formularios;

import Clases.Expediente_;
import Clases.LimitesDatos;
import Clases.Paciente_;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class Paciente extends javax.swing.JPanel {
    
    String Paciente_sexo,Paciente_categoria;
    Paciente_ paciente;
    Expediente_ expediente;
    private boolean editando = false; //comodin para la funcion Modificar del Expediente
    
    public Paciente() {
        initComponents();
        //inicializamos los JTexField para su uso en el boton Modificar
        expediente = new Expediente_(); 
        
        ((AbstractDocument) txtNombrePaciente.getDocument()).setDocumentFilter(LimitesDatos.getFilter(15));
        ((AbstractDocument) txtEdad.getDocument()).setDocumentFilter(LimitesDatos.getIntFilter(2));
        ((AbstractDocument) txtRaza.getDocument()).setDocumentFilter(LimitesDatos.getFilter(15));
        ((AbstractDocument) txtPeso.getDocument()).setDocumentFilter(LimitesDatos.getFloatFilter(5));
        ((AbstractDocument) txtAltura.getDocument()).setDocumentFilter(LimitesDatos.getFloatFilter(5));
        ((AbstractDocument) txtTipoPiel.getDocument()).setDocumentFilter(LimitesDatos.getFilter(15));
        ((AbstractDocument) txtBuscarDUI.getDocument()).setDocumentFilter(LimitesDatos.getIntFilter(9));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnG_sexo = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        lblFechaIncripcion = new javax.swing.JLabel();
        lblNombrePaciente = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblRaza = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        fmFechaIncripcion = new javax.swing.JFormattedTextField();
        txtNombrePaciente = new javax.swing.JTextField();
        fmFechaNacimiento = new javax.swing.JFormattedTextField();
        txtEdad = new javax.swing.JTextField();
        rbtnSexoM = new javax.swing.JRadioButton();
        rbtnSexoF = new javax.swing.JRadioButton();
        cbxCategoria = new javax.swing.JComboBox<>();
        txtRaza = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        lblAltura = new javax.swing.JLabel();
        lblTipoPiel = new javax.swing.JLabel();
        txtAltura = new javax.swing.JTextField();
        txtTipoPiel = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        lblBuscarDUI = new javax.swing.JLabel();
        txtBuscarDUI = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 153, 255));

        lblTitulo.setBackground(new java.awt.Color(0, 102, 102));
        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 102, 102));
        lblTitulo.setText("Datos del Paciente:");

        lblFechaIncripcion.setBackground(new java.awt.Color(0, 102, 102));
        lblFechaIncripcion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFechaIncripcion.setForeground(new java.awt.Color(0, 102, 102));
        lblFechaIncripcion.setText("Fecha de Inscripción:");

        lblNombrePaciente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNombrePaciente.setForeground(new java.awt.Color(0, 102, 102));
        lblNombrePaciente.setText("Nombre:");

        lblFechaNacimiento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFechaNacimiento.setForeground(new java.awt.Color(0, 102, 102));
        lblFechaNacimiento.setText("Fecha de nacimiento:");

        lblEdad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(0, 102, 102));
        lblEdad.setText("Edad:");

        lblSexo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblSexo.setForeground(new java.awt.Color(0, 102, 102));
        lblSexo.setText("Sexo:");

        lblCategoria.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(0, 102, 102));
        lblCategoria.setText("Categoría:");

        lblRaza.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblRaza.setForeground(new java.awt.Color(0, 102, 102));
        lblRaza.setText("Raza:");

        lblPeso.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPeso.setForeground(new java.awt.Color(0, 102, 102));
        lblPeso.setText("Peso(Lbs):");

        fmFechaIncripcion.setBackground(new java.awt.Color(255, 255, 255));
        fmFechaIncripcion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        txtNombrePaciente.setBackground(new java.awt.Color(255, 255, 255));

        fmFechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));

        txtEdad.setBackground(new java.awt.Color(255, 255, 255));

        rbtnSexoM.setBackground(new java.awt.Color(153, 153, 255));
        btnG_sexo.add(rbtnSexoM);
        rbtnSexoM.setForeground(new java.awt.Color(0, 102, 102));
        rbtnSexoM.setText("Macho");

        rbtnSexoF.setBackground(new java.awt.Color(153, 153, 255));
        btnG_sexo.add(rbtnSexoF);
        rbtnSexoF.setForeground(new java.awt.Color(0, 102, 102));
        rbtnSexoF.setText("Hembra");

        cbxCategoria.setBackground(new java.awt.Color(153, 153, 255));
        cbxCategoria.setForeground(new java.awt.Color(0, 102, 102));
        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------", "Canino", "Felino", "Oviparo", "Reptil", "Roedor" }));
        cbxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCategoriaItemStateChanged(evt);
            }
        });

        txtRaza.setBackground(new java.awt.Color(255, 255, 255));

        txtPeso.setBackground(new java.awt.Color(255, 255, 255));

        lblAltura.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAltura.setForeground(new java.awt.Color(0, 102, 102));
        lblAltura.setText("Altura (m):");

        lblTipoPiel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTipoPiel.setForeground(new java.awt.Color(0, 102, 102));
        lblTipoPiel.setText("Tipo de Piel:");

        txtAltura.setBackground(new java.awt.Color(255, 255, 255));
        txtAltura.setForeground(new java.awt.Color(0, 0, 0));

        txtTipoPiel.setBackground(new java.awt.Color(255, 255, 255));

        btnAgregar.setBackground(new java.awt.Color(0, 102, 102));
        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblBuscarDUI.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBuscarDUI.setForeground(new java.awt.Color(0, 102, 102));
        lblBuscarDUI.setText("Busque DUI del responsable:");

        txtBuscarDUI.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarDUI.setForeground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPeso)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBuscarDUI, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAltura, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtTipoPiel)
                            .addComponent(txtBuscarDUI))
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCategoria)
                                .addGap(147, 147, 147)
                                .addComponent(cbxCategoria, 0, 133, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSexo)
                                .addGap(134, 134, 134)
                                .addComponent(rbtnSexoM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(rbtnSexoF))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEdad)
                                .addGap(180, 180, 180)
                                .addComponent(txtEdad))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombrePaciente)
                                    .addComponent(lblFechaNacimiento)
                                    .addComponent(lblRaza))
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPeso)
                                    .addComponent(txtRaza)
                                    .addComponent(txtNombrePaciente)
                                    .addComponent(fmFechaNacimiento)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFechaIncripcion)
                                .addGap(70, 70, 70)
                                .addComponent(fmFechaIncripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTipoPiel)
                                    .addComponent(lblAltura))
                                .addGap(240, 240, 240))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(lblBuscarDUI)
                    .addComponent(txtBuscarDUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaIncripcion)
                    .addComponent(fmFechaIncripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAltura)
                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombrePaciente)
                    .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoPiel)
                    .addComponent(txtTipoPiel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(fmFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEdad)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSexo)
                            .addComponent(rbtnSexoM)
                            .addComponent(rbtnSexoF)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnAgregar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRaza)
                    .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeso)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public String buscarDUIResponsable(){
        String dui = txtBuscarDUI.getText(); // Obtén el DUI del JTextField
        String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + dui;
        File carpetaBusquedaDUI = new File(rutaCarpeta);

        if (carpetaBusquedaDUI.exists() && carpetaBusquedaDUI.isDirectory()) {
            // La carpeta existe, verifica si el DUI está en el archivo
            File ficheroBusquedaDUI = new File(carpetaBusquedaDUI, "/Registro_de_responsable.txt");
            String busqueda = "DUI° " + dui;

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
                    return rutaCarpeta; // Devuelve la ruta de la carpeta si el responsable fue encontrado
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
        return null; // Devuelve null si no se encontró la carpeta o el responsable
    }
    
    //Modifica Método:
    public void modifEXPaciente(Paciente_ paciente, String rutaArchivo){
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            // Obtiene los datos del archivo
            List<Object[]> listaDatos = expediente.expedientePaciente_(archivo);
            for(Object[]datos : listaDatos){
                
                // Añade los datos a los JTextField
                    this.txtBuscarDUI.setText(datos[0].toString());
                    this.fmFechaIncripcion.setText(datos[1].toString());
                    this.txtNombrePaciente.setText(datos[2].toString());
                    this.fmFechaNacimiento.setText(datos[3].toString());
                    this.txtEdad.setText(datos[4].toString());
                    //"Sexo" no es un JTextField
                    //"Categoría" no es un JTextField
                    this.txtRaza.setText(datos[7].toString());
                    this.txtPeso.setText(datos[8].toString());
                    this.txtAltura.setText(datos[9].toString());
                    this.txtTipoPiel.setText(datos[10].toString());
                
                // Forza a Swing a redibujar los campos con el nuevo texto
                    this.txtBuscarDUI.repaint();
                    this.txtBuscarDUI.setEditable(false);
                    this.fmFechaIncripcion.repaint();
                    this.txtNombrePaciente.repaint();
                    this.fmFechaNacimiento.repaint();
                    this.txtEdad.repaint();
                    //"Sexo" no es un JTextField
                    //"Categoría" no es un JTextField
                    this.txtRaza.repaint();
                    this.txtPeso.repaint();
                    this.txtAltura.repaint();
                    this.txtTipoPiel.repaint();                
            } 
        }
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(!fmFechaIncripcion.getText().isEmpty()){
            if(!txtNombrePaciente.getText().isEmpty()){
                if(!fmFechaNacimiento.getText().isEmpty()){
                    if(!txtEdad.getText().isEmpty()){
                        ButtonModel seleccionarSexo = btnG_sexo.getSelection();
                        if(seleccionarSexo == rbtnSexoM.getModel()){
                            Paciente_sexo = "Maculino";
                        }else if(seleccionarSexo == rbtnSexoF.getModel()){
                            Paciente_sexo = "Femenino";
                        }else{
                            JOptionPane.showMessageDialog(null, "Llene el sexo del paciente");
                        }
                        //validacion de que el JComboBox no sea el item 0
                        if(cbxCategoria.getSelectedIndex() == 0){
                            JOptionPane.showMessageDialog(null, "El item seleccionado no es válido");
                            cbxCategoria.setSelectedIndex(-1);                        
                        }else{
                            String seleccionCategoria= cbxCategoria.getSelectedItem().toString();    
                            if(!seleccionCategoria.isEmpty()){
                                switch(seleccionCategoria){
                                    case"Canino":   
                                        Paciente_categoria = "Canino";
                                    break; 
                                    case"Felino":
                                        Paciente_categoria = "Felino";
                                    break;
                                    case"Oviparo":
                                        Paciente_categoria = "Oviparo";
                                    break;
                                    case"Reptil":
                                        Paciente_categoria = "Reptil";
                                    break;
                                    case"Roedor":
                                        Paciente_categoria = "Roedor";
                                    break;
                                }
                                if(!txtRaza.getText().isEmpty()){
                                    if(!txtPeso.getText().isEmpty()){
                                       if(!txtAltura.getText().isEmpty()){
                                            if(!txtTipoPiel.getText().isEmpty()){                                            
                                                if(!txtBuscarDUI.getText().isEmpty() && txtBuscarDUI.getText().length()==9){                                                                                                    
                                                    String rutaCarpeta = buscarDUIResponsable();
                                                    if(rutaCarpeta != null){
                                                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                                        dateFormat.setLenient(false); // Configurado SimpleDateFormat para que sea estricto
                                                        try {
                                                            String Responsable_dui =txtBuscarDUI.getText();//Variable de DUI
                                                            String Paciente_nombre = txtNombrePaciente.getText();//Variable del nombre
                                                            Date fechaInscripcion = null;
                                                            Date fechaNacimiento = null;
                                                            // Validar la fecha de inscripción en el formato correcto
                                                            try {
                                                                if(!fmFechaIncripcion.getText().isEmpty()){
                                                                    fechaInscripcion = dateFormat.parse(fmFechaIncripcion.getText());
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "Corrija el formato de la fecha de inscripción");
                                                                    return;
                                                                }
                                                            } catch (ParseException ex) {
                                                                JOptionPane.showMessageDialog(null, "Corrija el formato de la fecha de inscripción");
                                                                Logger.getLogger(Paciente_.class.getName()).log(Level.SEVERE, null, ex);
                                                                return;
                                                            }
                                                            
                                                            // Validar la fecha de nacimiento en el formato correcto
                                                            try {   
                                                                if(!fmFechaNacimiento.getText().isEmpty()){
                                                                    fechaNacimiento = dateFormat.parse(fmFechaNacimiento.getText());
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "Corrija el formato de la fecha de nacimiento");
                                                                    return;
                                                                }
                                                            } catch (ParseException ex) {
                                                                JOptionPane.showMessageDialog(null, "Corrija el formato de la fecha de nacimiento");
                                                                Logger.getLogger(Paciente_.class.getName()).log(Level.SEVERE, null, ex);
                                                                return;
                                                            }
                                                            
                                                            // Si las fechas son válidas, entonces se crea el objeto Paciente_
                                                            if(fechaInscripcion != null && fechaNacimiento != null){
                                                                paciente = new Paciente_(
                                                                this.txtBuscarDUI.getText(),
                                                                dateFormat.parse(fmFechaIncripcion.getText()),
                                                                this.txtNombrePaciente.getText(),
                                                                dateFormat.parse(fmFechaNacimiento.getText()),
                                                                Integer.parseInt(this.txtEdad.getText()),
                                                                Paciente_sexo,
                                                                Paciente_categoria, 
                                                                this.txtRaza.getText(),
                                                                Float.parseFloat(this.txtPeso.getText()),
                                                                Float.parseFloat(this.txtAltura.getText()),
                                                                this.txtTipoPiel.getText()
                                                            );
                                                            if(editando){
                                                                JOptionPane.showMessageDialog(null, "Paciente Modificado con éxito");
                                                                //Actualiza expediente del Paciente
                                                                Expediente_ expedientePaciente = new Expediente_();
                                                                expedientePaciente.setPaciente(paciente);
                                                                expedientePaciente.actualizarPaciente(Responsable_dui,Paciente_nombre, paciente);
                                                            }else{
                                                                JOptionPane.showMessageDialog(null, "Paciente registrado con éxito");                                                                                                                    
                                                                Expediente_ expedientePaciente = new Expediente_();
                                                                expedientePaciente.setPaciente(paciente);
                                                                expedientePaciente.registrarPaciente(Responsable_dui,Paciente_nombre,paciente);//Envía el dato a la clase Expediente  
                                                            }
                                                            // Restablece la variable 'editando' a 'false'
                                                            editando = false; 
                                                            }                                                    
                                                        } catch (ParseException ex) {                                                    
                                                            Logger.getLogger(Paciente_.class.getName()).log(Level.SEVERE, null, ex);
                                                        } 
                                                    }else{
                                                        JOptionPane.showMessageDialog(null, "Registre un responsable para agregar un paciente");
                                                    }                                                                                                                                                                                                              
                                                }else{
                                                   JOptionPane.showMessageDialog(null, "Registre un responsable para agregar un paciente");
                                                    txtBuscarDUI.requestFocus(); 
                                                }                                                
                                           }else{
                                                JOptionPane.showMessageDialog(null, "Llene el tipo de piel del paciente");
                                                txtTipoPiel.requestFocus();
                                            }
                                       }else{
                                            JOptionPane.showMessageDialog(null, "Llene la altura del paciente");
                                            txtAltura.requestFocus();
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Llene el peso del paciente");
                                        txtPeso.requestFocus();
                                    }                                                    
                                }else{
                                    JOptionPane.showMessageDialog(null, "Llene la raza del paciente");
                                    txtRaza.requestFocus();
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Llene la categoría del paciente");
                                txtEdad.requestFocus();
                            } 
                            }
                        }else{
                        JOptionPane.showMessageDialog(null, "Llene la edad del paciente");
                        txtEdad.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Llene la fecha de nacimiento del paciente");
                    fmFechaNacimiento.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Llene el nombre del paciente");
                txtNombrePaciente.requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Llene la fecha de inscripción");
            fmFechaIncripcion.requestFocus();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
    
    //obliga al usuario a que no pueda seleccionar el item 
    private void cbxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCategoriaItemStateChanged
        JComboBox comboBox = (JComboBox) evt.getSource();
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (comboBox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "El item seleccionado no es válido");
                comboBox.setSelectedIndex(-1);
            } else {
                // Aquí puedes crear tu objeto
                System.out.println("Objeto creado con la opción: " + comboBox.getSelectedItem());
            }
        }
    }//GEN-LAST:event_cbxCategoriaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.ButtonGroup btnG_sexo;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JFormattedTextField fmFechaIncripcion;
    private javax.swing.JFormattedTextField fmFechaNacimiento;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblBuscarDUI;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblFechaIncripcion;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombrePaciente;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblRaza;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTipoPiel;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rbtnSexoF;
    private javax.swing.JRadioButton rbtnSexoM;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtBuscarDUI;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombrePaciente;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtRaza;
    private javax.swing.JTextField txtTipoPiel;
    // End of variables declaration//GEN-END:variables
}
