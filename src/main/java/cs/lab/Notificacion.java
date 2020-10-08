package cs.lab;

public class Notificacion {
    
    private String nombreProfesor;
    private Boolean status;

    
    Notificacion(String nombreProfesor, Boolean status) {
        this.status = status;
        this.nombreProfesor =nombreProfesor;
    }

    public String getNombreProfesor() {
        return this.nombreProfesor;
    }

    public Boolean getStatus() {
        return this.status;
    }




    
}
