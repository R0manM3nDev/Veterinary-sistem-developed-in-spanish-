
package Clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Vacunacion_ extends Paciente_{
    private Date Vacunacion_fecha;
    private Date Vacunacion_hora;
    private String Medicamentos;
    String responsable_DUIVac;
    String paciente_nombreVac;
    
    public Vacunacion_(Date Vacunacion_fecha,Date Vacunacion_hora,String Medicamentos,String responsable_DUIVac,String paciente_nombreVac){
       this.Vacunacion_fecha=Vacunacion_fecha;
       this.Vacunacion_hora=Vacunacion_hora;
       this.Medicamentos=Medicamentos;
       this.responsable_DUIVac = responsable_DUIVac;
       this.paciente_nombreVac=paciente_nombreVac;
    }
   public Vacunacion_(){
       
   }
   
   //Getters and setters

    public Date getVacunacion_fecha() {
        return Vacunacion_fecha;
    }

    public void setVacunacion_fecha(Date Vacunacion_fecha) {
        this.Vacunacion_fecha = Vacunacion_fecha;
    }

    public Date getVacunacion_hora() {
        return Vacunacion_hora;
    }

    public void setVacunacion_hora(Date Vacunacion_hora) {
        this.Vacunacion_hora = Vacunacion_hora;
    }

    public String getMedicamentos() {
        return Medicamentos;
    }

    public void setMedicamentos(String Medicamentos) {
        this.Medicamentos = Medicamentos;
    }

    public String getResponsable_DUIVac() {
        return responsable_DUIVac;
    }

    public void setResponsable_DUIVac(String responsable_DUIVac) {
        this.responsable_DUIVac = responsable_DUIVac;
    }

    public String getPaciente_nombreVac() {
        return paciente_nombreVac;
    }

    public void setPaciente_nombreVac(String paciente_nombreVac) {
        this.paciente_nombreVac = paciente_nombreVac;
    }
   
    //Mostrar objeto creado
    
    public void mostrarVacunacion(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");        
        String formato_fecha = dateFormat.format(Vacunacion_fecha);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String formato_hora = timeFormat.format(Vacunacion_hora);
        
        JOptionPane.showMessageDialog
        (null, "Clínica Veterinaria 'Vet-Pet'"+
                           "\n"+
                           "\nDatos de la Vacunación:"+
                           "\n"+
                           "\n-.DUI responsable: "+responsable_DUIVac+
                           "\n-.Nombre del paciente: "+paciente_nombreVac+
                           "\n-.Fecha de Vacunación: "+formato_fecha+
                           "\n-.Hora de vacunación: "+formato_hora+
                           "\n-.Medicamentos: "+Medicamentos
                           );
    }
}
