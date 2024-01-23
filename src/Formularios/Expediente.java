
package Formularios;

import Clases.Cita_;
import Clases.Expediente_;
import Clases.LimitesDatos;
import Clases.Paciente_;
import Clases.Responsable_;
import Clases.Vacunacion_;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;

public class Expediente extends javax.swing.JPanel {
    
    private vet_pet vetPetInstance;
    private Expediente_ expediente;
    File direccion = new File("C:\\ClinicaVetPet_ma22054\\");//ruta donde debe buscar las carpetas hijo
    DefaultTableModel tabla1;
    DefaultTableModel tabla2;
    DefaultTableModel tabla3;
    DefaultTableModel tabla4;
    
    public Expediente(vet_pet vetPetInstance) {
        this.vetPetInstance = vetPetInstance;
        this.expediente = new Expediente_(); 
        initComponents();  
        
        //Responsable
        tabla1 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };        
        String[] nombreColumnasR = {"Nombre", "Apellido", "DUI", "Número de contacto"};
        tabla1.setColumnIdentifiers(nombreColumnasR); 
        tbl_Expediente_Responsable.setModel(tabla1);
        //Paciente
        tabla2 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] nombreColumnasP = {"ID Responsable","Inscripcion","Nombre","Nacimiento","Edad","Sexo","Categoria","Raza","Peso","Altura","Piel"};
        tabla2.setColumnIdentifiers(nombreColumnasP);
        tbl_Expediente_Paciente.setModel(tabla2);
        //Cita
        tabla3 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] nombreColumnasC = {"ID Responsable","Paciente","Fecha","Hora","Motivo"};
        tabla3.setColumnIdentifiers(nombreColumnasC);
        tbl_Expediente_Cita.setModel(tabla3);
        //Vacunacion
        tabla4 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] nombreColumnasV = {"ID Responsable","Paciente","Fecha","Hora","Medicamentos"};
        tabla4.setColumnIdentifiers(nombreColumnasV);
        tbl_Expediente_Vacunacion.setModel(tabla4);
        //Invocamos los métodos que importan los datos de los archivos txt
        expedienteResponsable(direccion); //Invocamos los métodos donde traen los txt
        expedientePaciente(direccion);
        expedienteCita(direccion);
        expedienteVacunacion( direccion);
        
        ((AbstractDocument) txtBuscarExpediente_Responsable.getDocument()).setDocumentFilter(LimitesDatos.getIntFilter(9));        
        ((AbstractDocument) txtBuscarExpediente_Paciente.getDocument()).setDocumentFilter(LimitesDatos.getFilter(15));
        ((AbstractDocument) txtBuscarExpediente_Cita.getDocument()).setDocumentFilter(LimitesDatos.getFilter(150));
        ((AbstractDocument) txtBuscarExpediente_Vacunacion.getDocument()).setDocumentFilter(LimitesDatos.getFilter(150));
    }
    
    //Métodos para exportar datos de los archivos a JTable
    //Table Responsable
    public void expedienteResponsable(File direccion) {           
        File[] archivos = direccion.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                   expedienteResponsable(archivo);
                } else if (archivo.getName().endsWith("Registro_de_responsable.txt")) {
                    System.out.println(archivo.getPath());
                    List<Object[]> listaDatos = expediente.expedienteResponsable_(archivo);
                    for(Object[]datos : listaDatos){
                        // Añadimos los datos a la tabla
                        tabla1.addRow(datos);
                    }
                }
            }
        }
    }    
    //Table Paciente
    public void expedientePaciente(File direccion) {           
        File[] archivos = direccion.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                   expedientePaciente(archivo);
                } else if (archivo.getName().startsWith("Registro_de_paciente_") && archivo.getName().endsWith("p.txt")) {
                    System.out.println(archivo.getPath());
                    List<Object[]> listaDatos = expediente.expedientePaciente_(archivo);
                    for(Object[]datos : listaDatos){
                        // Añadimos los datos a la tabla                        
                        tabla2.addRow(datos);
                    }
                }
            }
        }
    }   
    //Table Cita
    public void expedienteCita(File direccion) {           
        File[] archivos = direccion.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                   expedienteCita(archivo);
                } else if (archivo.getName().endsWith("c.txt")) {
                    System.out.println(archivo.getPath());
                    List<Object[]> listaDatos = expediente.expedienteCita_(archivo);
                    for(Object[]datos : listaDatos){
                        
                        // Imprime los datos antes de añadirlos a la tabla
                        System.out.println(Arrays.toString(datos));
                        // Añadimos los datos a la tabla
                        tabla3.addRow(datos);
                    }
                }
            }
        }
    }  
    //Table Vacunacion
    public void expedienteVacunacion(File direccion) {           
        File[] archivos = direccion.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                   expedienteVacunacion(archivo);
                } else if (archivo.getName().endsWith("v.txt")) {
                    System.out.println(archivo.getPath());
                    List<Object[]> listaDatos = expediente.expedienteVacunacion_(archivo);
                    for(Object[]datos : listaDatos){
                        // Añadimos los datos a la tabla
                        tabla4.addRow(datos);
                    }
                }
            }
        }
    }  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        tblExpediente = new javax.swing.JTabbedPane();
        pnl_ExpedienteResponsable = new javax.swing.JPanel();
        sp_Responsable = new javax.swing.JScrollPane();
        tbl_Expediente_Responsable = new javax.swing.JTable();
        lblBuscarResponsable = new javax.swing.JLabel();
        txtBuscarExpediente_Responsable = new javax.swing.JTextField();
        btnBuscarResponsable = new javax.swing.JButton();
        btnMostrarResponsable = new javax.swing.JButton();
        btnModificarResponsable = new javax.swing.JButton();
        btnBorrarResponsable = new javax.swing.JButton();
        pnl_Expediente_Paciente = new javax.swing.JPanel();
        sp_Paciente = new javax.swing.JScrollPane();
        tbl_Expediente_Paciente = new javax.swing.JTable();
        lblBuscarPaciente = new javax.swing.JLabel();
        txtBuscarExpediente_Paciente = new javax.swing.JTextField();
        btnBuscarPaciente = new javax.swing.JButton();
        btnMostrarPaciente = new javax.swing.JButton();
        btnModificarPaciente = new javax.swing.JButton();
        btnEliminarPaciente = new javax.swing.JButton();
        pnl_Expediente_Cita = new javax.swing.JPanel();
        sp_Cita = new javax.swing.JScrollPane();
        tbl_Expediente_Cita = new javax.swing.JTable();
        lblBuscarCita = new javax.swing.JLabel();
        btnBuscarCita = new javax.swing.JButton();
        txtBuscarExpediente_Cita = new javax.swing.JTextField();
        btnMostrarCita = new javax.swing.JButton();
        btnModificarCita = new javax.swing.JButton();
        btnEliminarCita = new javax.swing.JButton();
        pnl_Expediente_Vacunacion = new javax.swing.JPanel();
        sp_Vacunacion = new javax.swing.JScrollPane();
        tbl_Expediente_Vacunacion = new javax.swing.JTable();
        lblBuscarVacunacion = new javax.swing.JLabel();
        btnBuscarVacunacion = new javax.swing.JButton();
        txtBuscarExpediente_Vacunacion = new javax.swing.JTextField();
        btnMostrarVacunacion = new javax.swing.JButton();
        btnModificarVacunacion = new javax.swing.JButton();
        btnEliminarVacunacion = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));
        setMinimumSize(new java.awt.Dimension(706, 370));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 102, 102));
        lblTitulo.setText("Expediente:");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        pnl_ExpedienteResponsable.setBackground(new java.awt.Color(153, 153, 255));
        pnl_ExpedienteResponsable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_ExpedienteResponsable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Expediente_Responsable.setBackground(new java.awt.Color(153, 153, 255));
        tbl_Expediente_Responsable.setForeground(new java.awt.Color(0, 0, 0));
        tbl_Expediente_Responsable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        sp_Responsable.setViewportView(tbl_Expediente_Responsable);

        pnl_ExpedienteResponsable.add(sp_Responsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 703, 238));

        lblBuscarResponsable.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBuscarResponsable.setForeground(new java.awt.Color(0, 102, 102));
        lblBuscarResponsable.setText("Responsable:");
        pnl_ExpedienteResponsable.add(lblBuscarResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        txtBuscarExpediente_Responsable.setBackground(new java.awt.Color(255, 255, 255));
        pnl_ExpedienteResponsable.add(txtBuscarExpediente_Responsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 250, 180, -1));

        btnBuscarResponsable.setBackground(new java.awt.Color(0, 102, 102));
        btnBuscarResponsable.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarResponsable.setText("Buscar");
        btnBuscarResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarResponsableActionPerformed(evt);
            }
        });
        pnl_ExpedienteResponsable.add(btnBuscarResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));

        btnMostrarResponsable.setBackground(new java.awt.Color(0, 102, 102));
        btnMostrarResponsable.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarResponsable.setText("Mostrar");
        btnMostrarResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarResponsableActionPerformed(evt);
            }
        });
        pnl_ExpedienteResponsable.add(btnMostrarResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        btnModificarResponsable.setBackground(new java.awt.Color(0, 102, 102));
        btnModificarResponsable.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarResponsable.setText("Modificar");
        btnModificarResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarResponsableActionPerformed(evt);
            }
        });
        pnl_ExpedienteResponsable.add(btnModificarResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

        btnBorrarResponsable.setBackground(new java.awt.Color(0, 102, 102));
        btnBorrarResponsable.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarResponsable.setText("Borrar");
        btnBorrarResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarResponsableActionPerformed(evt);
            }
        });
        pnl_ExpedienteResponsable.add(btnBorrarResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, -1, -1));

        tblExpediente.addTab("Responsable", pnl_ExpedienteResponsable);

        pnl_Expediente_Paciente.setBackground(new java.awt.Color(153, 153, 255));
        pnl_Expediente_Paciente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_Expediente_Paciente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Expediente_Paciente.setBackground(new java.awt.Color(153, 153, 255));
        tbl_Expediente_Paciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        sp_Paciente.setViewportView(tbl_Expediente_Paciente);

        pnl_Expediente_Paciente.add(sp_Paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 703, 237));

        lblBuscarPaciente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBuscarPaciente.setForeground(new java.awt.Color(0, 102, 102));
        lblBuscarPaciente.setText("Paciente:");
        pnl_Expediente_Paciente.add(lblBuscarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 74, -1));

        txtBuscarExpediente_Paciente.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Expediente_Paciente.add(txtBuscarExpediente_Paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 182, -1));

        btnBuscarPaciente.setBackground(new java.awt.Color(0, 102, 102));
        btnBuscarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarPaciente.setText("Buscar");
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });
        pnl_Expediente_Paciente.add(btnBuscarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));

        btnMostrarPaciente.setBackground(new java.awt.Color(0, 102, 102));
        btnMostrarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarPaciente.setText("Mostrar");
        btnMostrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarPacienteActionPerformed(evt);
            }
        });
        pnl_Expediente_Paciente.add(btnMostrarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        btnModificarPaciente.setBackground(new java.awt.Color(0, 102, 102));
        btnModificarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarPaciente.setText("Modificar");
        btnModificarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPacienteActionPerformed(evt);
            }
        });
        pnl_Expediente_Paciente.add(btnModificarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

        btnEliminarPaciente.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarPaciente.setText("Borrar");
        btnEliminarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPacienteActionPerformed(evt);
            }
        });
        pnl_Expediente_Paciente.add(btnEliminarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, -1, -1));

        tblExpediente.addTab("Paciente", pnl_Expediente_Paciente);

        pnl_Expediente_Cita.setBackground(new java.awt.Color(204, 153, 255));
        pnl_Expediente_Cita.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_Expediente_Cita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Expediente_Cita.setBackground(new java.awt.Color(204, 153, 255));
        tbl_Expediente_Cita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        sp_Cita.setViewportView(tbl_Expediente_Cita);

        pnl_Expediente_Cita.add(sp_Cita, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 703, 236));

        lblBuscarCita.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBuscarCita.setForeground(new java.awt.Color(0, 102, 102));
        lblBuscarCita.setText("Cita:");
        pnl_Expediente_Cita.add(lblBuscarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 44, -1));

        btnBuscarCita.setBackground(new java.awt.Color(0, 102, 102));
        btnBuscarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarCita.setText("Buscar");
        btnBuscarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCitaActionPerformed(evt);
            }
        });
        pnl_Expediente_Cita.add(btnBuscarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));

        txtBuscarExpediente_Cita.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Expediente_Cita.add(txtBuscarExpediente_Cita, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 182, -1));

        btnMostrarCita.setBackground(new java.awt.Color(0, 102, 102));
        btnMostrarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarCita.setText("Mostrar");
        btnMostrarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCitaActionPerformed(evt);
            }
        });
        pnl_Expediente_Cita.add(btnMostrarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        btnModificarCita.setBackground(new java.awt.Color(0, 102, 102));
        btnModificarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarCita.setText("Modificar");
        btnModificarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCitaActionPerformed(evt);
            }
        });
        pnl_Expediente_Cita.add(btnModificarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

        btnEliminarCita.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCita.setText("Borrar");
        btnEliminarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCitaActionPerformed(evt);
            }
        });
        pnl_Expediente_Cita.add(btnEliminarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, -1, -1));

        tblExpediente.addTab("Cita", pnl_Expediente_Cita);

        pnl_Expediente_Vacunacion.setBackground(new java.awt.Color(204, 153, 255));
        pnl_Expediente_Vacunacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_Expediente_Vacunacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Expediente_Vacunacion.setBackground(new java.awt.Color(204, 153, 255));
        tbl_Expediente_Vacunacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        sp_Vacunacion.setViewportView(tbl_Expediente_Vacunacion);

        pnl_Expediente_Vacunacion.add(sp_Vacunacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 703, 236));

        lblBuscarVacunacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBuscarVacunacion.setForeground(new java.awt.Color(0, 102, 102));
        lblBuscarVacunacion.setText("Vacunación:");
        pnl_Expediente_Vacunacion.add(lblBuscarVacunacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        btnBuscarVacunacion.setBackground(new java.awt.Color(0, 102, 102));
        btnBuscarVacunacion.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarVacunacion.setText("Buscar");
        btnBuscarVacunacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVacunacionActionPerformed(evt);
            }
        });
        pnl_Expediente_Vacunacion.add(btnBuscarVacunacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));

        txtBuscarExpediente_Vacunacion.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Expediente_Vacunacion.add(txtBuscarExpediente_Vacunacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 182, -1));

        btnMostrarVacunacion.setBackground(new java.awt.Color(0, 102, 102));
        btnMostrarVacunacion.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarVacunacion.setText("Mostrar");
        btnMostrarVacunacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarVacunacionActionPerformed(evt);
            }
        });
        pnl_Expediente_Vacunacion.add(btnMostrarVacunacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        btnModificarVacunacion.setBackground(new java.awt.Color(0, 102, 102));
        btnModificarVacunacion.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarVacunacion.setText("Modificar");
        btnModificarVacunacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarVacunacionActionPerformed(evt);
            }
        });
        pnl_Expediente_Vacunacion.add(btnModificarVacunacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

        btnEliminarVacunacion.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminarVacunacion.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarVacunacion.setText("Borrar");
        btnEliminarVacunacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVacunacionActionPerformed(evt);
            }
        });
        pnl_Expediente_Vacunacion.add(btnEliminarVacunacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, -1, -1));

        tblExpediente.addTab("Vacunación", pnl_Expediente_Vacunacion);

        add(tblExpediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 710, 320));
    }// </editor-fold>//GEN-END:initComponents

    // BOTONES " B U S C A R "
    
    private void btnBuscarResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarResponsableActionPerformed
        if(!txtBuscarExpediente_Responsable.getText().isEmpty()){
            String DUI = txtBuscarExpediente_Responsable.getText();
            boolean encontrado = false;
            int filaEncontrada = -1;        
            // Iterar sobre las filas de la tabla
            for (int i = 0; i < tabla1.getRowCount(); i++) {
                String DUIFila = tabla1.getValueAt(i, 2).toString(); // Asumiendo que el DUI es la tercera columna
            
                // Si el DUI de la fila coincide con el DUI ingresado, marcar como encontrado
                if (DUIFila.equals(DUI)) {
                    encontrado = true;
                    filaEncontrada = i;
                    break;
                }
            }        
            // Si se encontró el DUI, resaltar la fila
            if (encontrado) {
                tbl_Expediente_Responsable.setRowSelectionInterval(filaEncontrada, filaEncontrada);
            } else {
                // Si no se encontró el DUI, mostrar un mensaje
                JOptionPane.showMessageDialog(null, "Responsable no encontrado. Registrarlo");
            }        
            // Limpiar el campo de entrada del DUI
            txtBuscarExpediente_Responsable.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese el DUI a buscar");
        }
    }//GEN-LAST:event_btnBuscarResponsableActionPerformed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        if(!txtBuscarExpediente_Paciente.getText().isEmpty()){
            String DUI = txtBuscarExpediente_Paciente.getText();
            boolean encontrado = false;
            int filaEncontrada = -1;                    
            for (int i = 0; i < tabla2.getRowCount(); i++) {
                String DUIFila = tabla2.getValueAt(i, 1).toString();                             
                if (DUIFila.equals(DUI)) {
                    encontrado = true;
                    filaEncontrada = i;
                    break;
                }
            }        
            if (encontrado) {
                tbl_Expediente_Paciente.setRowSelectionInterval(filaEncontrada, filaEncontrada);
            } else {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado. Registrarlo");
            }        
            txtBuscarExpediente_Paciente.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese el DUI a buscar");
        }
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void btnBuscarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCitaActionPerformed
        if(!txtBuscarExpediente_Cita.getText().isEmpty()){
            String DUI = txtBuscarExpediente_Cita.getText();
            boolean encontrado = false;
            int filaEncontrada = -1;                    
            for (int i = 0; i < tabla3.getRowCount(); i++) {
                String DUIFila = tabla3.getValueAt(i, 2).toString();                             
                if (DUIFila.equals(DUI)) {
                    encontrado = true;
                    filaEncontrada = i;
                    break;
                }
            }        
            if (encontrado) {
                tbl_Expediente_Cita.setRowSelectionInterval(filaEncontrada, filaEncontrada);
            } else {
                JOptionPane.showMessageDialog(null, "Cita no encontrada. Registrarla");
            }        
            txtBuscarExpediente_Cita.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese el mótivo de cita a buscar");
        }                
    }//GEN-LAST:event_btnBuscarCitaActionPerformed

    private void btnBuscarVacunacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVacunacionActionPerformed
        if(!txtBuscarExpediente_Vacunacion.getText().isEmpty()){
            String DUI = txtBuscarExpediente_Vacunacion.getText();
            boolean encontrado = false;
            int filaEncontrada = -1;                    
            for (int i = 0; i < tabla4.getRowCount(); i++) {
                String DUIFila = tabla4.getValueAt(i, 2).toString();                             
                if (DUIFila.equals(DUI)) {
                    encontrado = true;
                    filaEncontrada = i;
                    break;
                }
            }        
            if (encontrado) {
                tbl_Expediente_Vacunacion.setRowSelectionInterval(filaEncontrada, filaEncontrada);
            } else {
                JOptionPane.showMessageDialog(null, "Vacunación no encontrado. Registrarla");
            }        
            txtBuscarExpediente_Vacunacion.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese los medicamentos a buscar");
        }
    }//GEN-LAST:event_btnBuscarVacunacionActionPerformed

    // BOTONES " M O S T R A R "
    
    private void btnMostrarResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarResponsableActionPerformed
        // Obtén la fila seleccionada
        int filaSeleccionada = tbl_Expediente_Responsable.getSelectedRow();
        if(filaSeleccionada >=0){
            // Obtén los datos de la fila seleccionada
            String nombre = tabla1.getValueAt(filaSeleccionada, 0).toString();
            String apellido = tabla1.getValueAt(filaSeleccionada, 1).toString();
            String DUI = tabla1.getValueAt(filaSeleccionada, 2).toString();
            String numeroContacto = tabla1.getValueAt(filaSeleccionada, 3).toString();

            JOptionPane.showMessageDialog
            (null, "Clínica Veterinaria 'Vet-Pet'"+
                          "\n"+
                          "\nDatos de responsable del paciente:"+
                          "\n"+
                          "\n-.Nombre: "+nombre+
                          "\n-.Apellido: "+apellido+
                          "\n-.DUI: "+DUI+
                          "\n-.Número de contacto: "+numeroContacto
                          );
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila para mostrar");
        }
    }//GEN-LAST:event_btnMostrarResponsableActionPerformed

    private void btnMostrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarPacienteActionPerformed
        int filaSeleccionada = tbl_Expediente_Paciente.getSelectedRow();
        if(filaSeleccionada >=0){
            //"Inscripcion","Nombre","Nacimiento","Edad","Sexo","Categoria","Raza","Peso","Altura","Piel"
            String Inscripcion = tabla2.getValueAt(filaSeleccionada, 0).toString();
            String Nombre = tabla2.getValueAt(filaSeleccionada, 1).toString();
            String Nacimiento = tabla2.getValueAt(filaSeleccionada, 2).toString();
            String Edad = tabla2.getValueAt(filaSeleccionada, 3).toString();
            String Sexo = tabla2.getValueAt(filaSeleccionada, 4).toString();
            String Categoria = tabla2.getValueAt(filaSeleccionada, 5).toString();
            String Raza = tabla2.getValueAt(filaSeleccionada, 6).toString();
            String Peso = tabla2.getValueAt(filaSeleccionada, 7).toString();
            String Altura = tabla2.getValueAt(filaSeleccionada, 8).toString();
            String Piel = tabla2.getValueAt(filaSeleccionada, 9).toString();
            
            JOptionPane.showMessageDialog
            (null,"Clínica Veterinaria 'Vet-Pet'"+
                          "\n"+
                          "\nDatos del paciente:"+
                          "\n"+
                          "\n-.Fecha de inscripción: "+Inscripcion+
                          "\n-.Nombre: "+Nombre+
                          "\n-.Fecha de nacimiento del paciente: "+Nacimiento+
                          "\n-.Edad del paciente(Ha fecha de inscripcion): "+Edad+
                          "\n-.Sexo: "+Sexo+
                          "\n-.Categoria del paciente: "+Categoria+
                          "\n-.Raza: "+Raza+
                          "\n-.Peso: "+Peso+
                          "\n-.Altura: "+Altura+
                          "\n-.Tipo de piel: "+Piel
                );
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila para mostrar");
        }        
    }//GEN-LAST:event_btnMostrarPacienteActionPerformed

    private void btnMostrarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCitaActionPerformed
        int filaSeleccionada = tbl_Expediente_Cita.getSelectedRow();
        if(filaSeleccionada >= 0){
           //"Fecha","Hora","Motivo" 
           String Fecha = tabla3.getValueAt(filaSeleccionada, 0).toString();
           String Hora = tabla3.getValueAt(filaSeleccionada, 1).toString();
           String Motivo = tabla3.getValueAt(filaSeleccionada, 2).toString();
           JOptionPane.showMessageDialog
            (null, "Clínica Veterinaria 'Vet-Pet'"+
                           "\n"+
                           "\nDatos de la cita: :"+
                           "\n"+
                           "\n-.Fecha: "+Fecha+
                           "\n-.Hora: "+Hora+
                           "\n-.Motido: "+Motivo
                );
        }else{
           JOptionPane.showMessageDialog(null, "Seleccione una fila para mostrar"); 
        }
    }//GEN-LAST:event_btnMostrarCitaActionPerformed

    private void btnMostrarVacunacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarVacunacionActionPerformed
        int filaSeleccionada = tbl_Expediente_Vacunacion.getSelectedRow();
        if(filaSeleccionada >= 0){
           //"Fecha","Hora","Motivo" 
           String Fecha = tabla4.getValueAt(filaSeleccionada, 0).toString();
           String Hora = tabla4.getValueAt(filaSeleccionada, 1).toString();
           String Medicamento = tabla4.getValueAt(filaSeleccionada, 2).toString();
           JOptionPane.showMessageDialog
            (null, "Clínica Veterinaria 'Vet-Pet'"+
                           "\n"+
                           "\nDatos de la Vacunación:"+
                           "\n"+
                           "\n-.Fecha de Vacunación: "+Fecha+
                           "\n-.Hora de vacunación: "+Hora+
                           "\n-.Medicamentos: "+Medicamento
                           );
        }else{
           JOptionPane.showMessageDialog(null, "Seleccione una fila para mostrar"); 
        }
    }//GEN-LAST:event_btnMostrarVacunacionActionPerformed

    //BOTONES " M O D I F I C A R "
    
    private void btnModificarResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarResponsableActionPerformed
        // Obtén la fila seleccionada
        int filaSeleccionada = tbl_Expediente_Responsable.getSelectedRow();
            if(filaSeleccionada >= 0){
            // Obtén los datos de la fila seleccionada
            String nombre = tabla1.getValueAt(filaSeleccionada, 0).toString();
            String apellido = tabla1.getValueAt(filaSeleccionada, 1).toString();
            String DUI = tabla1.getValueAt(filaSeleccionada, 2).toString();
            int numeroContacto = Integer.parseInt(tabla1.getValueAt(filaSeleccionada, 3).toString());
        
            // Crea un nuevo objeto Responsable_ con los datos obtenidos
            Responsable_ responsable = new Responsable_(nombre, apellido, DUI, numeroContacto);
            // Determina la ruta del archivo correspondiente a la fila seleccionada
            String rutaArchivo = "C:\\ClinicaVetPet_ma22054\\" + DUI + "\\Registro_de_responsable.txt";
            // Mostramos el JPanel de responsable
            vetPetInstance.mostrarPanelResponsable(responsable,rutaArchivo);            
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar");
        }
    }//GEN-LAST:event_btnModificarResponsableActionPerformed
    
    //Método de busqueda del archivo a Modificar del Paciente:
    public String buscarDUIResponsable(String DUI_r,String Nombre){
        String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + DUI_r;
        File carpetaBusquedaDUI = new File(rutaCarpeta);
        if (carpetaBusquedaDUI.exists() && carpetaBusquedaDUI.isDirectory()) {
            // La carpeta existe, verifica si el DUI está en el archivo
            String nombreArchivo = "\\Registro_de_paciente_" + Nombre + "p.txt";
            File ficheroBusquedaDUI = new File(carpetaBusquedaDUI, nombreArchivo);
            String busqueda = "DUI responsable° " + DUI_r;           
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
                    return ficheroBusquedaDUI.getPath(); // Devuelve la ruta del archivo si el responsable fue encontrado
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
    private void btnModificarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPacienteActionPerformed
        int filaSeleccionada = tbl_Expediente_Paciente.getSelectedRow();
        if(filaSeleccionada >=0){
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); // Asegurarse de usar el formato correcto
                
                String DUI_r = tabla2.getValueAt(filaSeleccionada, 0).toString();
                Date Inscripcion = formatoFecha.parse(tabla2.getValueAt(filaSeleccionada, 1).toString());
                String Nombre = tabla2.getValueAt(filaSeleccionada, 2).toString();
                Date Nacimiento = formatoFecha.parse(tabla2.getValueAt(filaSeleccionada, 3).toString());
                int Edad = Integer.parseInt(tabla2.getValueAt(filaSeleccionada, 4).toString());
                String Sexo = tabla2.getValueAt(filaSeleccionada, 5).toString();
                String Categoria = tabla2.getValueAt(filaSeleccionada, 6).toString();
                String Raza = tabla2.getValueAt(filaSeleccionada, 7).toString();
                float Peso = Float.parseFloat(tabla2.getValueAt(filaSeleccionada, 8).toString());
                float Altura = Float.parseFloat(tabla2.getValueAt(filaSeleccionada, 9).toString());
                String Piel = tabla2.getValueAt(filaSeleccionada, 10).toString();

                // Crea un nuevo objeto Paciente_ con los datos obtenidos
                Paciente_ paciente = new Paciente_(DUI_r,Inscripcion,Nombre,Nacimiento,Edad,Sexo,Categoria,Raza,Peso,Altura,Piel);
                //ruta del archivo a modificar
                String rutaArchivo = buscarDUIResponsable(DUI_r,Nombre);
                File archivo = null;
                if (rutaArchivo != null) {
                    archivo = new File(rutaArchivo);
                    // Mostramos el JPanel de paciente
                    vetPetInstance.mostrarPanelPaciente(paciente,rutaArchivo);
                } else {
                    // Maneja el caso en que 'buscarDUIResponsable(DUI_r)' devuelva 'null'
                    System.out.println("No se pudo encontrar la ruta del archivo del responsable");
                    return; // Detiene la ejecución del método
                }                
            } catch (ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al parsear las fechas. Asegúrate de que estén en el formato correcto.");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al parsear los números. Asegúrate de que sean números válidos.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar");
        }
    }//GEN-LAST:event_btnModificarPacienteActionPerformed

    //Método de busqueda de archivo a Modificar de Cita:
    public String buscarDUIResponsable_C(String DUI_r,String Paciente,Date Fecha){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + DUI_r;
        File carpetaBusquedaDUI = new File(rutaCarpeta);
        if (carpetaBusquedaDUI.exists() && carpetaBusquedaDUI.isDirectory()) {
            // La carpeta existe, verifica si el DUI está en el archivo
            String nombreArchivo = "\\Registro_de_cita_" + Paciente + "_" + dateFormat.format(Fecha) + "c.txt";
            File ficheroBusquedaDUI = new File(carpetaBusquedaDUI, nombreArchivo);
            String busqueda = "DUI responsable° " + DUI_r; 
            try {
                BufferedReader fil = new BufferedReader(new FileReader(ficheroBusquedaDUI));
                String linea;
                boolean encontrado = false;
                while ((linea = fil.readLine()) != null) {
                    if (linea.toUpperCase().contains(busqueda.toUpperCase())) {                    
                        encontrado = true;
                        break;
                    }
                }
                fil.close();
                if (encontrado) {
                    JOptionPane.showMessageDialog(null, "Cita encontrada");
                    return ficheroBusquedaDUI.getPath(); // Devuelve la ruta del archivo si la cita fue encontrada
                } else {
                    JOptionPane.showMessageDialog(null, "Lo siento no encontramos la cita");
                }
            } catch (IOException e) {
                System.out.println("Ha ocurrido un Error" + e);
                JOptionPane.showMessageDialog(null, "Se ha producido un error");
            }
        }
        return null; // Devuelve null si no se encontró la carpeta o el responsable
    }
    private void btnModificarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCitaActionPerformed
        int filaSeleccionada = tbl_Expediente_Cita.getSelectedRow();
        if(filaSeleccionada >=0){
            try{
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy"); // Asegurarse de usar el formato correcto
                SimpleDateFormat formatoTiempo = new SimpleDateFormat("HH:mm");
                
                String DUI_r = tabla3.getValueAt(filaSeleccionada, 0).toString();
                String Paciente = tabla3.getValueAt(filaSeleccionada, 1).toString();
                Date Fecha = formatoFecha.parse(tabla3.getValueAt(filaSeleccionada, 2).toString());
                Date Hora = formatoTiempo.parse(tabla3.getValueAt(filaSeleccionada, 3).toString());
                String Motivo = tabla3.getValueAt(filaSeleccionada, 4).toString();
                
                // Crea un nuevo objeto Cita_ con los datos obtenidos
                Cita_ cita = new Cita_(Fecha,Hora,Motivo,DUI_r,Paciente);
                //ruta del archivo a modificar
                String rutaArchivo = buscarDUIResponsable_C(DUI_r,Paciente,Fecha);
                File archivo = null;
                if (rutaArchivo != null) {
                    archivo = new File(rutaArchivo);
                    // Mostramos el JPanel de paciente
                    vetPetInstance.mostrarPanelCita(cita,rutaArchivo);
                } else {
                    // Maneja el caso en que 'buscarDUIResponsable(DUI_r)' devuelva 'null'
                    System.out.println("No se pudo encontrar la ruta del archivo del responsable");
                    return; // Detiene la ejecución del método
                }
            }catch (ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al parsear las fechas. Asegúrate de que estén en el formato correcto.");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al parsear los números. Asegúrate de que sean números válidos.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar");
        }
    }//GEN-LAST:event_btnModificarCitaActionPerformed

    //Método de busqueda de archivo a Modificar de Vacunación:
    public String buscarDUIResponsable_V(String DUI_r,String Paciente,Date Fecha){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + DUI_r;
        File carpetaBusquedaDUI = new File(rutaCarpeta);
        if (carpetaBusquedaDUI.exists() && carpetaBusquedaDUI.isDirectory()) {
            // La carpeta existe, verifica si el DUI está en el archivo
            String nombreArchivo = "\\Registro_de_vacunacion_"+ Paciente + "_" + dateFormat.format(Fecha) + "v.txt";
            File ficheroBusquedaDUI = new File(carpetaBusquedaDUI, nombreArchivo);
            String busqueda = "DUI responsable° " + DUI_r; 
            try {
                BufferedReader fil = new BufferedReader(new FileReader(ficheroBusquedaDUI));
                String linea;
                boolean encontrado = false;
                while ((linea = fil.readLine()) != null) {
                    if (linea.toUpperCase().contains(busqueda.toUpperCase())) {                    
                        encontrado = true;
                        break;
                    }
                }
                fil.close();
                if (encontrado) {
                    JOptionPane.showMessageDialog(null, "Vacunación encontrada");
                    return ficheroBusquedaDUI.getPath(); // Devuelve la ruta del archivo si la cita fue encontrada
                } else {
                    JOptionPane.showMessageDialog(null, "Lo siento no encontramos la vacunación");
                }
            } catch (IOException e) {
                System.out.println("Ha ocurrido un Error" + e);
                JOptionPane.showMessageDialog(null, "Se ha producido un error");
            }
        }
        return null;
    }
    private void btnModificarVacunacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarVacunacionActionPerformed
        int filaSeleccionada = tbl_Expediente_Vacunacion.getSelectedRow();
        if(filaSeleccionada >=0){
            try{
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy"); // Asegurarse de usar el formato correcto
                SimpleDateFormat formatoTiempo = new SimpleDateFormat("HH:mm");
                
                String DUI_r = tabla4.getValueAt(filaSeleccionada, 0).toString();
                String Paciente = tabla4.getValueAt(filaSeleccionada, 1).toString();
                Date Fecha = formatoFecha.parse(tabla4.getValueAt(filaSeleccionada, 2).toString());
                Date Hora = formatoTiempo.parse(tabla4.getValueAt(filaSeleccionada, 3).toString());
                String Motivo = tabla4.getValueAt(filaSeleccionada, 4).toString();
                
                // Crea un nuevo objeto Vacunacion_ con los datos obtenidos
                Vacunacion_ vacunacion = new Vacunacion_(Fecha,Hora,Motivo,DUI_r,Paciente);
                //ruta del archivo a modificar
                String rutaArchivo = buscarDUIResponsable_V(DUI_r,Paciente,Fecha);
                File archivo = null;
                if (rutaArchivo != null) {
                    archivo = new File(rutaArchivo);
                    // Mostramos el JPanel de paciente
                    vetPetInstance.mostrarPanelVacunacion(vacunacion,rutaArchivo);
                } else {
                    // Maneja el caso en que 'buscarDUIResponsable(DUI_r)' devuelva 'null'
                    System.out.println("No se pudo encontrar la ruta del archivo del responsable");
                    return; // Detiene la ejecución del método
                }
            }catch (ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al parsear las fechas. Asegúrate de que estén en el formato correcto.");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al parsear los números. Asegúrate de que sean números válidos.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar");
        }
    }//GEN-LAST:event_btnModificarVacunacionActionPerformed

    //BOTONES " B O R R A R "
    
    private void btnBorrarResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarResponsableActionPerformed
        int filaSeleccionada = tbl_Expediente_Responsable.getSelectedRow();
        if(filaSeleccionada >= 0){
            // Obtén el DUI del responsable de la fila seleccionada
            String DUI = tabla1.getValueAt(filaSeleccionada, 2).toString();
        
            // Confirmación de eliminación
            int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro de eliminar este expediente? Al Borrar al responsable, todo expediente relacionado a él se borrará también.", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Elimina la fila de la tabla
                tabla1.removeRow(filaSeleccionada);
            
                // Elimina la carpeta y todos los archivos dentro de ella
                File directorio = new File("C:\\ClinicaVetPet_ma22054\\" + DUI);
                String[]entries = directorio.list();
                    for(String s: entries){
                        File currentFile = new File(directorio.getPath(),s);
                        currentFile.delete();
                    }
                    if(directorio.delete()){
                        JOptionPane.showMessageDialog(null, "El expediente fue eliminado exitosamente");
                    }else{
                        JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el expediente");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_btnBorrarResponsableActionPerformed

    private void btnEliminarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPacienteActionPerformed
        int filaSeleccionada = tbl_Expediente_Paciente.getSelectedRow();
        if(filaSeleccionada >= 0){
            // Obtén el DUI del responsable y el Nombre del paciente de la fila seleccionada
            String DUI = tabla2.getValueAt(filaSeleccionada, 0).toString();
            String Nombre = tabla2.getValueAt(filaSeleccionada, 2).toString();
        
            // Confirmación de eliminación
            int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro de eliminar este expediente? Al Borrar al paciente, todo expediente relacionado a él se borrará también.", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Elimina la fila de la tabla
                tabla2.removeRow(filaSeleccionada);
            
                // Elimina todos los archivos que contienen el nombre del paciente en su nombre
                String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + DUI;
                File carpetaBusquedaDUI = new File(rutaCarpeta);
                FilenameFilter filter = new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.contains(Nombre);
                    }
                };
                File[] archivos = carpetaBusquedaDUI.listFiles(filter);
                if (archivos != null) {
                    for (File archivo : archivos) {
                        boolean isDeleted = archivo.delete();
                        if (!isDeleted) {
                            System.out.println("No se pudo eliminar el archivo: " + archivo.getAbsolutePath());
                        } else {
                            System.out.println("Archivo eliminado: " + archivo.getAbsolutePath());
                        }
                    }
                } else {
                    System.out.println("No se encontraron archivos en la carpeta: " + rutaCarpeta);
                }
                // Elimina las filas relacionadas en la tabla Cita
                for (int i = tabla3.getRowCount() - 1; i >= 0; i--) {
                    if (tabla3.getValueAt(i, 1).toString().equals(DUI)) {
                        tabla3.removeRow(i);
                    }
                }

                // Elimina las filas relacionadas en la tabla Vacunacion
                for (int i = tabla4.getRowCount() - 1; i >= 0; i--) {
                    if (tabla4.getValueAt(i, 1).toString().equals(DUI)) {
                        tabla4.removeRow(i);
                    }
                }
                JOptionPane.showMessageDialog(null, "El expediente fue eliminado exitosamente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_btnEliminarPacienteActionPerformed

    private void btnEliminarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCitaActionPerformed
        int filaSeleccionada = tbl_Expediente_Cita.getSelectedRow();
        if(filaSeleccionada >= 0){
            // Obtén el DUI del responsable y el Nombre del paciente de la fila seleccionada
            String DUI = tabla3.getValueAt(filaSeleccionada, 0).toString();
            String Nombre = tabla3.getValueAt(filaSeleccionada, 1).toString();
        
            // Confirmación de eliminación
            int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro de eliminar esta cita? Al borrar la cita, todos los expedientes relacionados a ella se borrarán también.", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Elimina la fila de la tabla
                tabla3.removeRow(filaSeleccionada);
            
                // Elimina todos los archivos que comienzan con "/Registro_de_cita_" + Nombre
                String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + DUI;
                File carpetaBusquedaDUI = new File(rutaCarpeta);
                FilenameFilter filter = new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.startsWith("Registro_de_cita_" + Nombre);
                    }
                };
                File[] archivos = carpetaBusquedaDUI.listFiles(filter);
                if (archivos != null) {
                    System.out.println("Archivos seleccionados para eliminar: " + archivos.length);
                    for (File archivo : archivos) {
                        System.out.println("Intentando eliminar el archivo: " + archivo.getAbsolutePath());
                        boolean isDeleted = archivo.delete();
                        if (!isDeleted) {
                            System.out.println("No se pudo eliminar el archivo: " + archivo.getAbsolutePath());
                        } else {
                            System.out.println("Archivo eliminado: " + archivo.getAbsolutePath());
                        }
                    }
                } else {
                    System.out.println("No se encontraron archivos en la carpeta: " + rutaCarpeta);
                }
            
                JOptionPane.showMessageDialog(null, "La cita fue eliminada exitosamente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_btnEliminarCitaActionPerformed

    private void btnEliminarVacunacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVacunacionActionPerformed
        int filaSeleccionada = tbl_Expediente_Vacunacion.getSelectedRow();
        if(filaSeleccionada >= 0){
            // Obtén el DUI del responsable y el Nombre del paciente de la fila seleccionada
            String DUI = tabla4.getValueAt(filaSeleccionada, 0).toString();
            String Nombre = tabla4.getValueAt(filaSeleccionada, 1).toString();
        
            // Confirmación de eliminación
            int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro de eliminar esta cita? Al borrar la cita, todos los expedientes relacionados a ella se borrarán también.", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Elimina la fila de la tabla
                tabla4.removeRow(filaSeleccionada);
            
                // Elimina todos los archivos que comienzan con "/Registro_de_cita_" + Nombre
                String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + DUI;
                File carpetaBusquedaDUI = new File(rutaCarpeta);
                FilenameFilter filter = new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.startsWith("Registro_de_vacunacion_" + Nombre);
                    }
                };
                File[] archivos = carpetaBusquedaDUI.listFiles(filter);
                if (archivos != null) {
                    System.out.println("Archivos seleccionados para eliminar: " + archivos.length);
                    for (File archivo : archivos) {
                        System.out.println("Intentando eliminar el archivo: " + archivo.getAbsolutePath());
                        boolean isDeleted = archivo.delete();
                        if (!isDeleted) {
                            System.out.println("No se pudo eliminar el archivo: " + archivo.getAbsolutePath());
                        } else {
                            System.out.println("Archivo eliminado: " + archivo.getAbsolutePath());
                        }
                    }
                } else {
                    System.out.println("No se encontraron archivos en la carpeta: " + rutaCarpeta);
                }
            
                JOptionPane.showMessageDialog(null, "La vacunación fue eliminada exitosamente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_btnEliminarVacunacionActionPerformed
    
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarResponsable;
    private javax.swing.JButton btnBuscarCita;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnBuscarResponsable;
    private javax.swing.JButton btnBuscarVacunacion;
    private javax.swing.JButton btnEliminarCita;
    private javax.swing.JButton btnEliminarPaciente;
    private javax.swing.JButton btnEliminarVacunacion;
    private javax.swing.JButton btnModificarCita;
    private javax.swing.JButton btnModificarPaciente;
    private javax.swing.JButton btnModificarResponsable;
    private javax.swing.JButton btnModificarVacunacion;
    private javax.swing.JButton btnMostrarCita;
    private javax.swing.JButton btnMostrarPaciente;
    private javax.swing.JButton btnMostrarResponsable;
    private javax.swing.JButton btnMostrarVacunacion;
    private javax.swing.JLabel lblBuscarCita;
    private javax.swing.JLabel lblBuscarPaciente;
    private javax.swing.JLabel lblBuscarResponsable;
    private javax.swing.JLabel lblBuscarVacunacion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnl_ExpedienteResponsable;
    private javax.swing.JPanel pnl_Expediente_Cita;
    private javax.swing.JPanel pnl_Expediente_Paciente;
    private javax.swing.JPanel pnl_Expediente_Vacunacion;
    private javax.swing.JScrollPane sp_Cita;
    private javax.swing.JScrollPane sp_Paciente;
    private javax.swing.JScrollPane sp_Responsable;
    private javax.swing.JScrollPane sp_Vacunacion;
    private javax.swing.JTabbedPane tblExpediente;
    private javax.swing.JTable tbl_Expediente_Cita;
    private javax.swing.JTable tbl_Expediente_Paciente;
    private javax.swing.JTable tbl_Expediente_Responsable;
    private javax.swing.JTable tbl_Expediente_Vacunacion;
    private javax.swing.JTextField txtBuscarExpediente_Cita;
    private javax.swing.JTextField txtBuscarExpediente_Paciente;
    private javax.swing.JTextField txtBuscarExpediente_Responsable;
    private javax.swing.JTextField txtBuscarExpediente_Vacunacion;
    // End of variables declaration//GEN-END:variables

    
}
