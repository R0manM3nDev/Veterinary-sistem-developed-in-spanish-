
package Clases;

import javax.swing.JOptionPane;


public class Responsable_ {
    private String Responsable_nombre;
    private String Responsable_apellido;
    private String Responsable_dui;
    private int Responsable_numeroContacto;
    
    public Responsable_(String Responsable_nombre,String Responsable_apellido,
    String Responsable_dui,int Responsable_numeroContacto){
        this.Responsable_nombre=Responsable_nombre;
        this.Responsable_apellido=Responsable_apellido; 
        this.Responsable_dui=Responsable_dui;
        this.Responsable_numeroContacto=Responsable_numeroContacto;
    }
    
    public Responsable_(){
        
    }
    
    //Getters and setters

    public String getResponsable_nombre() {
        return Responsable_nombre;
    }

    public void setResponsable_nombre(String Responsable_nombre) {
        this.Responsable_nombre = Responsable_nombre;
    }

    public String getResponsable_apellido() {
        return Responsable_apellido;
    }

    public void setResponsable_apellido(String Responsable_apellido) {
        this.Responsable_apellido = Responsable_apellido;
    }        
    
    public String getResponsable_dui() {
        return Responsable_dui;
    }

    public void setResponsable_dui(String Responsable_dui) {
        this.Responsable_dui = Responsable_dui;
    }

    public int getResponsable_numeroContacto() {
        return Responsable_numeroContacto;
    }

    public void setResponsable_numeroContacto(int Responsable_numeroContacto) {
        this.Responsable_numeroContacto = Responsable_numeroContacto;
    }
    
    //Mostrar objeto creado
    
    public void mostrarResponsable(){
        JOptionPane.showMessageDialog
        (null, "Clínica Veterinaria 'Vet-Pet'"+
                          "\n"+
                          "\nDatos de responsable del paciente:"+
                          "\n"+
                          "\n-.Nombre: "+Responsable_nombre+
                          "\n-.Apellido: "+Responsable_apellido+
                          "\n-.DUI: "+Responsable_dui+
                          "\n-.Número de contacto: "+Responsable_numeroContacto
                          );
    }
        
}
