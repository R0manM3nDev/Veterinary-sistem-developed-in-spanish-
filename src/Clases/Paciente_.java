
package Clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class Paciente_ extends Responsable_{
    private Date Paciente_inscripcion;
    private String Paciente_nombre;
    private Date Paciente_fechaNacimiento;
    private int Paciente_edad;
    private String Paciente_sexo;
    private String Paciente_categoria;
    private String Paciente_raza;
    private float Paciente_Peso;
    private float Paciente_altura;
    private String Paciente_tipoPiel;
    String responsable_DUI;
    
    public Paciente_(String responsable_DUI,Date Paciente_inscripcion,String Paciente_nombre,Date Paciente_fechaNacimiento,
    int Paciente_edad,String Paciente_sexo,String Paciente_categoria,String Paciente_raza,float Paciente_Peso,
    float Paciente_altura,String Paciente_tipoPiel){
        
        this.responsable_DUI=responsable_DUI;
        this.Paciente_inscripcion=Paciente_inscripcion;
        this.Paciente_nombre=Paciente_nombre;
        this.Paciente_fechaNacimiento=Paciente_fechaNacimiento;
        this.Paciente_edad=Paciente_edad;
        this.Paciente_sexo=Paciente_sexo;
        this.Paciente_categoria=Paciente_categoria;
        this.Paciente_raza=Paciente_raza;
        this.Paciente_Peso=Paciente_Peso;
        this.Paciente_altura=Paciente_altura;
        this.Paciente_tipoPiel=Paciente_tipoPiel;
    }
    
    public Paciente_(){
        
    }
    
    //Getters and setters

    public String getResponsable_DUI() {
        return responsable_DUI;
    }

    public void setResponsable_DUI(String responsable_DUI) {
        this.responsable_DUI = responsable_DUI;
    }    
    
    public Date getPaciente_inscripcion() {
        return Paciente_inscripcion;
    }

    public void setPaciente_inscripcion(Date Paciente_inscripcion) {
        this.Paciente_inscripcion = Paciente_inscripcion;
    }

    public String getPaciente_nombre() {
        return Paciente_nombre;
    }

    public void setPaciente_nombre(String Paciente_nombre) {
        this.Paciente_nombre = Paciente_nombre;
    }

    public Date getPaciente_fechaNacimiento() {
        return Paciente_fechaNacimiento;
    }

    public void setPaciente_fechaNacimiento(Date Paciente_fechaNacimiento) {
        this.Paciente_fechaNacimiento = Paciente_fechaNacimiento;
    }

    public int getPaciente_edad() {
        return Paciente_edad;
    }

    public void setPaciente_edad(int Paciente_edad) {
        this.Paciente_edad = Paciente_edad;
    }

    public String getPaciente_sexo() {
        return Paciente_sexo;
    }

    public void setPaciente_sexo(String Paciente_sexo) {
        this.Paciente_sexo = Paciente_sexo;
    }

    public String getPaciente_categoria() {
        return Paciente_categoria;
    }

    public void setPaciente_categoria(String Paciente_categoria) {
        this.Paciente_categoria = Paciente_categoria;
    }

    public String getPaciente_raza() {
        return Paciente_raza;
    }

    public void setPaciente_raza(String Paciente_raza) {
        this.Paciente_raza = Paciente_raza;
    }

    public float getPaciente_Peso() {
        return Paciente_Peso;
    }

    public void setPaciente_Peso(float Paciente_Peso) {
        this.Paciente_Peso = Paciente_Peso;
    }

    public float getPaciente_altura() {
        return Paciente_altura;
    }

    public void setPaciente_altura(float Paciente_altura) {
        this.Paciente_altura = Paciente_altura;
    }

    public String getPaciente_tipoPiel() {
        return Paciente_tipoPiel;
    }

    public void setPaciente_tipoPiel(String Paciente_tipoPiel) {
        this.Paciente_tipoPiel = Paciente_tipoPiel;
    }
        
    
    //calcular la edad del paciente
    
    public int calcularEdad(Date fechaNacimiento, Date fechaInscripcion) {
        Calendar fechaNac = Calendar.getInstance();
        Calendar fechaInsc = Calendar.getInstance();
        fechaNac.setTime(fechaNacimiento);
        fechaInsc.setTime(fechaInscripcion);

        int edad = fechaInsc.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        
        if (fechaNac.get(Calendar.MONTH) > fechaInsc.get(Calendar.MONTH) ||
            (fechaNac.get(Calendar.MONTH) == fechaInsc.get(Calendar.MONTH) && fechaNac.get(Calendar.DATE) > fechaInsc.get(Calendar.DATE))) {
                edad--;
            }

        return edad;
    }

    //Mostrar objeto creado
    
    public void mostrarPaciente(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formato_Inscripcion = dateFormat.format(Paciente_inscripcion);
        String formato_Nacimiento = dateFormat.format(Paciente_fechaNacimiento);
        Paciente_edad = calcularEdad(Paciente_fechaNacimiento, Paciente_inscripcion);
        
        JOptionPane.showMessageDialog
        (null,"Clínica Veterinaria 'Vet-Pet'"+
                          "\n"+
                          "\nDatos del paciente:"+
                          "\n"+
                          "\n-.DUI responsable: "+responsable_DUI+
                          "\n-.Fecha de inscripción: "+formato_Inscripcion+
                          "\n-.Nombre: "+Paciente_nombre+
                          "\n-.Fecha de nacimiento del paciente: "+formato_Nacimiento+
                          "\n-.Edad del paciente(Ha fecha de inscripcion): "+Paciente_edad+
                          "\n-.Sexo: "+Paciente_sexo+
                          "\n-.Categoria del paciente: "+Paciente_categoria+
                          "\n-.Raza: "+Paciente_raza+
                          "\n-.Peso: "+Paciente_Peso+
                          "\n-.Altura: "+Paciente_altura+
                          "\n-.Tipo de piel: "+Paciente_tipoPiel
                );
    }
    
}
