
package Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;          
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Expediente_ extends Paciente_{
    private Responsable_ responsable;
    public String carpetaMadre; //Variable de la ruta de almacenamiento general
       
    
    //métodos para acceder a las diferentes clases
    public void setResponsable(Responsable_ responsable){
        this.responsable = responsable;
    }    
    public void setPaciente(Paciente_ paciente){
    }
    public void setCita(Cita_ cita) {
    }
    public void setVacunacion(Vacunacion_ vacunacion){
    }

    public String getCarpetaMadre() {
        return carpetaMadre;
    }

    public void setCarpetaMadre(String carpetaMadre) {
        this.carpetaMadre = carpetaMadre;
    }
    
    //ruta de almacenamiento general
    public Expediente_(){                   
        this.carpetaMadre= "C:\\ClinicaVetPet_ma22054\\";        
    }
    
    //creación ruta de almacenamiento general
    public void crearCarpetaMadre() {   
        File directorioMadre = new File(carpetaMadre);
        if (!directorioMadre.exists()) {
            if (directorioMadre.mkdirs()) {
                System.out.println("Carpeta madre creada");
            } else {
                System.out.println("Carpeta madre existente");
            }
        }
    }
    
    //Crea las diferentes carpetas para expedientes
    public void crearCarpetasHijo() {  
        File directorioHijo = new File(carpetaMadre + String.valueOf(responsable.getResponsable_dui()));//Define DUI del responsable como nombre de la carpeta
        if (!directorioHijo.exists()) {
            if (directorioHijo.mkdirs()) {
                System.out.println("Expediente creado");
            } else {
                System.out.println("Error: no se pudo crear el expediente");
            }
        }
    }
    
    //R E S P O N S A B L E
    
    //Crea el archivo con para los diferentes registros    
    public void registrarResponsable() { 
        File archivo = new File(carpetaMadre +  String.valueOf(responsable.getResponsable_dui()) + "/Registro_de_responsable.txt");
        try {
            if (archivo.createNewFile()) {                             
                
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(
                        "\nNombre° "+responsable.getResponsable_nombre()+
                        "\nApellido° "+responsable.getResponsable_apellido()+
                        "\nDUI° "+responsable.getResponsable_dui()+
                        "\nNúmero de contacto° "+responsable.getResponsable_numeroContacto()                        
                    );
                bw.close();
                System.out.println("Archivo creado");
            } else {
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Métodos para leer archivos de Responsable    
    public List<Object[]> expedienteResponsable_(File archivo) {
        List<Object[]> listaDatos = new ArrayList<>();
        HashMap<String, String> valores = verResponsableTXT(archivo);
        Object[] xResponsable = new Object[4];
        xResponsable[0] = valores.get("Nombre");
        xResponsable[1] = valores.get("Apellido");
        xResponsable[2] = valores.get("DUI");
        xResponsable[3] = valores.get("Número de contacto");
        listaDatos.add(xResponsable);
        return listaDatos;
    }    
    public HashMap<String, String> verResponsableTXT(File archivo) {
        HashMap<String, String> valores = new HashMap<>();
        Scanner obj;
        try {
            obj = new Scanner(archivo);
            while (obj.hasNextLine()) {
                String linea = obj.nextLine();
                String[] partes = linea.split("°");
                if (partes.length >= 2) {
                    String campo = partes[0].trim();
                    String valor = partes[1].trim();
                    valores.put(campo, valor);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Excepción: " + ex);
        }
        return valores;
    }
    //Método de actualizacion de archivo de Responsable
    public void actualizarResponsable() {
        File archivo = new File(carpetaMadre +  String.valueOf(responsable.getResponsable_dui()) + "/Registro_de_responsable.txt");
        try {
            if (archivo.exists()) {
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(
                    "\nNombre° "+responsable.getResponsable_nombre()+
                    "\n.Apellido° "+responsable.getResponsable_apellido()+
                    "\nDUI° "+responsable.getResponsable_dui()+
                    "\n.Número de contacto° "+responsable.getResponsable_numeroContacto()                        
                    );
                bw.close();
                System.out.println("Archivo actualizado");
            } else {
                System.out.println("El archivo no existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //P A C I E N T E
    
    //crea el .txt si encuentra el DUI del responsable desde el JPanel 
    public void registrarPaciente(String Responsable_dui,String Paciente_nombre,Paciente_ paciente){//recibe el DUI del JPanel Paciente
        String uniqueFileName = "/Registro_de_paciente_" + paciente.getPaciente_nombre() + "p.txt";//define un identificador único
        String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + Responsable_dui;
        File archivo = new File(rutaCarpeta + uniqueFileName);
        try {
            if (archivo.createNewFile()) {                            
                System.out.println("Archivo creado");
            } else {
                System.out.println("El archivo ya existe");
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String formato_Inscripcion = dateFormat.format(paciente.getPaciente_inscripcion());
            String formato_Nacimiento = dateFormat.format(paciente.getPaciente_fechaNacimiento());                

            // Calcula la edad del paciente
            int edadPaciente = calcularEdad(paciente.getPaciente_fechaNacimiento(), 
            paciente.getPaciente_inscripcion());

            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(
                    "\nDUI responsable° "+paciente.getResponsable_DUI()+
                    "\nFecha de inscripción° "+formato_Inscripcion+
                    "\nNombre° "+paciente.getPaciente_nombre()+
                    "\nFecha de nacimiento del paciente° "+formato_Nacimiento+
                    "\nEdad del paciente(Ha fecha de inscripcion° "+edadPaciente+
                    "\nSexo° "+paciente.getPaciente_sexo()+
                    "\nCategoria del paciente° "+paciente.getPaciente_categoria()+
                    "\nRaza° "+paciente.getPaciente_raza()+
                    "\nPeso° "+paciente.getPaciente_Peso()+
                    "\nAltura° "+paciente.getPaciente_altura()+
                    "\nTipo de piel° "+paciente.getPaciente_tipoPiel()
                );  
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Métodos para leer archivo de Paciente
    public List<Object[]> expedientePaciente_(File archivo) {
        List<Object[]> listaDatos = new ArrayList<>();
        HashMap<String, String> valores = verPacienteTXT(archivo);
        Object[] xPaciente = new Object[11];
        xPaciente[0] = valores.get("DUI responsable");
        xPaciente[1] = valores.get("Fecha de inscripción");
        xPaciente[2] = valores.get("Nombre");
        xPaciente[3] = valores.get("Fecha de nacimiento del paciente");
        xPaciente[4] = valores.get("Edad del paciente(Ha fecha de inscripcion)");
        xPaciente[5] = valores.get("Sexo");
        xPaciente[6] = valores.get("Categoria del paciente");
        xPaciente[7] = valores.get("Raza");
        xPaciente[8] = valores.get("Peso");
        xPaciente[9] = valores.get("Altura");
        xPaciente[10] = valores.get("Tipo de piel");
        listaDatos.add(xPaciente);
        return listaDatos;
    }  
    public HashMap<String, String> verPacienteTXT(File archivo) {
        HashMap<String, String> valores = new HashMap<>();
        Scanner obj;
        try {
            obj = new Scanner(archivo);
            while (obj.hasNextLine()) {
                String linea = obj.nextLine();
                String[] partes = linea.split("°");
                if (partes.length >= 2) {
                    String campo = partes[0].trim();
                    String valor = partes[1].trim();
                    valores.put(campo, valor);                    
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Excepción: " + ex);
        }
        return valores;
    }
    //Método de actualizacion de archivo de Paciente
    public void actualizarPaciente(String Responsable_dui, String Paciente_nombre,Paciente_ paciente){
        String uniqueFileName = "/Registro_de_paciente_" + paciente.getPaciente_nombre() + "p.txt";//define un identificador único
        String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + Responsable_dui;
        File archivo = new File(rutaCarpeta + uniqueFileName);
        try {
            if (archivo.exists()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String formato_Inscripcion = dateFormat.format(paciente.getPaciente_inscripcion());
                String formato_Nacimiento = dateFormat.format(paciente.getPaciente_fechaNacimiento());                
                // Calcula la edad del paciente
                int edadPaciente = calcularEdad(paciente.getPaciente_fechaNacimiento(), 
                paciente.getPaciente_inscripcion());
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(
                    "\nDUI responsable° "+paciente.getResponsable_DUI()+
                    "\nFecha de inscripción° "+formato_Inscripcion+
                    "\nNombre° "+paciente.getPaciente_nombre()+
                    "\nFecha de nacimiento del paciente° "+formato_Nacimiento+
                    "\nEdad del paciente(Ha fecha de inscripcion)° "+edadPaciente+
                    "\nSexo° "+paciente.getPaciente_sexo()+
                    "\nCategoria del paciente° "+paciente.getPaciente_categoria()+
                    "\nRaza° "+paciente.getPaciente_raza()+
                    "\nPeso° "+paciente.getPaciente_Peso()+
                    "\nAltura° "+paciente.getPaciente_altura()+
                    "\nTipo de piel° "+paciente.getPaciente_tipoPiel()                     
                    );
                bw.close();
                System.out.println("Archivo actualizado");
            } else {
                System.out.println("El archivo no existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }           
    
    //C I T A
    
    public void registarCita(String Responsable_dui, String Paciente_nombre,Cita_ cita){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");//definir con "-" en el formato para la creación de textos, ya que "/" o ":" no pueden registrarse
        String formattedDate = dateFormat.format(cita.getCita_Fecha());//definimos la fecha de la cita como identificador
        String uniqueFileName = "/Registro_de_cita_" + Paciente_nombre+ "_" + formattedDate + "c.txt";
        String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + Responsable_dui;
        File archivo = new File(rutaCarpeta + uniqueFileName);
        try {
            if (archivo.createNewFile()) {                       
                System.out.println("Archivo creado");
            } else {
                System.out.println("El archivo ya existe");
            }             
            String formato_fecha = dateFormat.format(cita.getCita_Fecha());
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String formato_hora = timeFormat.format(cita.getCita_hora());

            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write( 
                    "\nDUI responsable° "+cita.getResponsable_DUICita()+
                    "\nNombre del paciente° "+cita.getPaciente_nombreCita()+
                    "\nFecha° "+formato_fecha+
                    "\nHora° "+formato_hora+
                    "\nMotido° "+cita.getCita_motivo()
                );
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Métodos para leer el archivo de cita
    public List<Object[]> expedienteCita_(File archivo) {
        List<Object[]> listaDatos = new ArrayList<>();
        HashMap<String, String> valores = verResponsableTXT(archivo);
        Object[] xResponsable = new Object[5];
        xResponsable[0] = valores.get("DUI responsable");
        xResponsable[1] = valores.get("Nombre del paciente");
        xResponsable[2] = valores.get("Fecha");
        xResponsable[3] = valores.get("Hora");
        xResponsable[4] = valores.get("Motido");
        listaDatos.add(xResponsable);
        return listaDatos;
    } 
    public HashMap<String, String> verCitaTXT(File archivo) {
        HashMap<String, String> valores = new HashMap<>();
        Scanner obj;
        try {
            obj = new Scanner(archivo);
            while (obj.hasNextLine()) {
                String linea = obj.nextLine();
                String[] partes = linea.split("°");
                if (partes.length >= 2) {
                    String campo = partes[0].trim();
                    String valor = partes[1].trim();
                    valores.put(campo, valor);                    
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Excepción: " + ex);
        }
        return valores;
    }
    //Método de actualización de cita
    public void actualizarCita(String Responsable_dui, String Paciente_nombre,Cita_ cita){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");//definir con "-" en el formato para la creación de textos, ya que "/" o ":" no pueden registrarse
        String formattedDate = dateFormat.format(cita.getCita_Fecha());//definimos la fecha de la cita como identificador
        String uniqueFileName = "/Registro_de_cita_" + Paciente_nombre+ "_" + formattedDate + "c.txt";
        String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + Responsable_dui;
        File archivo = new File(rutaCarpeta + uniqueFileName);
        try{
            if (archivo.exists()) {
                String formato_fecha = dateFormat.format(cita.getCita_Fecha());
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                String formato_hora = timeFormat.format(cita.getCita_hora());

                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                    bw.write( 
                        "\nDUI responsable° "+cita.getResponsable_DUICita()+
                        "\nNombre del paciente° "+cita.getPaciente_nombreCita()+
                        "\nFecha° "+formato_fecha+
                        "\nHora° "+formato_hora+
                        "\nMotido° "+cita.getCita_motivo()
                    );
                bw.close();
                System.out.println("Archivo actualizado");
            }else{
                System.out.println("El archivo no existe");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //V A C U N A C I Ó N
    
    public void registrarVacunación(String Responsable_dui,String Paciente_nombre,Vacunacion_ vacunacion){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");//definir con "-" en el formato para la creación de textos, ya que "/" o ":" no pueden registrarse
        String formattedDate = dateFormat.format(vacunacion.getVacunacion_fecha());
        String uniqueFileName = "\\Registro_de_vacunacion_"+ Paciente_nombre + "_" + formattedDate + "v.txt";
        String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + Responsable_dui;
        File archivo = new File(rutaCarpeta + uniqueFileName);
        try {
            if (archivo.createNewFile()) {                                
                System.out.println("Archivo creado");
            } else {
                System.out.println("El archivo ya existe");
            }
                    
            String formato_fecha = dateFormat.format(vacunacion.getVacunacion_fecha());
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String formato_hora = timeFormat.format(vacunacion.getVacunacion_hora());

            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(
                    "\nDUI responsable° "+vacunacion.getResponsable_DUIVac()+
                    "\nNombre del paciente° "+vacunacion.getPaciente_nombreVac()+
                    "\nFecha° "+formato_fecha+
                    "\nHora° "+formato_hora+
                    "\nMedicamento° "+vacunacion.getMedicamentos()
                );
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }            
    //Métodos para leer el archivo de Vacunacion
    public List<Object[]> expedienteVacunacion_(File archivo) {
        List<Object[]> listaDatos = new ArrayList<>();
        HashMap<String, String> valores = verResponsableTXT(archivo);
        Object[] xResponsable = new Object[5];
        xResponsable[0] = valores.get("DUI responsable");
        xResponsable[1] = valores.get("Nombre del paciente");
        xResponsable[2] = valores.get("Fecha");
        xResponsable[3] = valores.get("Hora");
        xResponsable[4] = valores.get("Medicamento");
        listaDatos.add(xResponsable);
        return listaDatos;
    } 
    public HashMap<String, String> verVacunacionTXT(File archivo) {
        HashMap<String, String> valores = new HashMap<>();
        Scanner obj;
        try {
            obj = new Scanner(archivo);
            while (obj.hasNextLine()) {
                String linea = obj.nextLine();
                String[] partes = linea.split("°");
                if (partes.length >= 2) {
                    String campo = partes[0].trim();
                    String valor = partes[1].trim();
                    valores.put(campo, valor);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Excepción: " + ex);
        }
        return valores;
    }
    //Método de actualización de vacunación
    public void actualizacionVacunacion(String Responsable_dui, String Paciente_nombre,Vacunacion_ vacunacion){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");//definir con "-" en el formato para la creación de textos, ya que "/" o ":" no pueden registrarse
        String formattedDate = dateFormat.format(vacunacion.getVacunacion_fecha());
        String uniqueFileName = "\\Registro_de_vacunacion_"+ Paciente_nombre + "_" + formattedDate + "v.txt";
        String rutaCarpeta = "C:\\ClinicaVetPet_ma22054\\" + Responsable_dui;
        File archivo = new File(rutaCarpeta + uniqueFileName);
        try{
            if (archivo.exists()) {
                String formato_fecha = dateFormat.format(vacunacion.getVacunacion_fecha());
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                String formato_hora = timeFormat.format(vacunacion.getVacunacion_hora());

                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                    bw.write( 
                        "\nDUI responsable° "+vacunacion.getResponsable_DUIVac()+
                        "\nNombre del paciente° "+vacunacion.getPaciente_nombreVac()+
                        "\nFecha° "+formato_fecha+
                        "\nHora° "+formato_hora+
                        "\nMedicamento° "+vacunacion.getMedicamentos()
                    );
                bw.close();
                System.out.println("Archivo actualizado");
            }else{
                System.out.println("El archivo no existe");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
