
package Clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Cita_ extends Paciente_{
    private Date Cita_Fecha;
    private Date Cita_hora;
    private String Cita_motivo;
    String responsable_DUICita;
    String paciente_nombreCita;
    
    public Cita_(Date Cita_Fecha,Date Cita_hora,String Cita_motivo,String responsable_DUICita,String paciente_nombreCita){
        this.Cita_Fecha=Cita_Fecha;
        this.Cita_hora=Cita_hora;
        this.Cita_motivo=Cita_motivo;
        this.responsable_DUICita=responsable_DUICita;
        this.paciente_nombreCita=paciente_nombreCita;
    }
    
    public Cita_(){
        
    }

    //Getters and Setters

    public Date getCita_Fecha() {
        return Cita_Fecha;
    }

    public void setCita_Fecha(Date Cita_Fecha) {
        this.Cita_Fecha = Cita_Fecha;
    }

    public Date getCita_hora() {
        return Cita_hora;
    }

    public void setCita_hora(Date Cita_hora) {
        this.Cita_hora = Cita_hora;
    }

    public String getCita_motivo() {
        return Cita_motivo;
    }

    public void setCita_motivo(String Cita_motivo) {
        this.Cita_motivo = Cita_motivo;
    }

    public String getResponsable_DUICita() {
        return responsable_DUICita;
    }

    public void setResponsable_DUICita(String responsable_DUICita) {
        this.responsable_DUICita = responsable_DUICita;
    }

    public String getPaciente_nombreCita() {
        return paciente_nombreCita;
    }

    public void setPaciente_nombreCita(String paciente_nombreCita) {
        this.paciente_nombreCita = paciente_nombreCita;
    }    
    
    //Mostrar objeto creado
    
    public void mostrarCita(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");        
        String formato_fecha = dateFormat.format(Cita_Fecha);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String formato_hora = timeFormat.format(Cita_hora);
        
        JOptionPane.showMessageDialog
        (null, "Clínica Veterinaria 'Vet-Pet'"+
                           "\n"+
                           "\nDatos de la cita: :"+
                           "\n"+
                           "\n-.DUI responsable: "+responsable_DUICita+
                           "\n-.Nombre del paciente: "+paciente_nombreCita+
                           "\n-.Fecha: "+formato_fecha+
                           "\n-.Hora: "+formato_hora+
                           "\n-.Motido: "+Cita_motivo
                );
    }
}
