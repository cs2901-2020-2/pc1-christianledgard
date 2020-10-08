package cs.lab;
import java.util.logging.Logger;
import java.util.Scanner;

public class RegistrApp {
    static final Logger logger = Logger.getLogger(RegistrApp.class.getName());

    RegistrApp(){}

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        logger.info("Ingresar el nombre del profesor");
        String professorName= sc.nextLine(); 
        logger.info("Ingresar el Titulo");
        String titulo= sc.nextLine(); 
        logger.info("Ingresar el URL");
        String url= sc.nextLine();

        Boolean status = generarValidacionApp(titulo, url);
        procesoVerificacionApp(professorName, status);

        sc.close();
    }

    static Boolean generarValidacionApp(String titulo, String url) {
        Validacion val = new Validacion(titulo, url);
        Boolean status = val.realizarValidacion();
        return status;
    }

    static void procesoVerificacionApp(String professorName, Boolean status) {
        if(Boolean.TRUE.equals(status)){
            logger.info("Generado Correctamente, notificaciones enviadas");
            Notificacion ce2a = new Notificacion(professorName, status);
            Notificacion dga = new Notificacion(professorName, status);
            Notificacion counterDocentes = new Notificacion(professorName, status);
            Notificacion counterAlumnos = new Notificacion(professorName, status);
            ce2a.getStatus();
            dga.getStatus();
            counterDocentes.getStatus();
            counterAlumnos.getStatus();
        }else{
            logger.info("Error en el formato. Intente nuevamente.");
        }
    }
}
