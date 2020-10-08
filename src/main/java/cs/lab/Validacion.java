package cs.lab;
import java.util.logging.Logger;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.*;  


public class Validacion {

    static final Logger logger = Logger.getLogger(Validacion.class.getName());    
    private Map<String, String> datos = new HashMap<>();
    
    static final String TITULOSTRING = "titulo";
    static final String ENLACESTRING = "enlace";

    public Validacion(String titulo, String enlace){
        this.datos.put(TITULOSTRING, titulo);
        this.datos.put(ENLACESTRING, enlace);
    }

    public Boolean realizarValidacion(){
        Boolean isTituloCorrecto = Pattern.matches("(2020-\\w{2})\\s\\w{2}\\d{4}\\s[ES,EN]{2}\\s.*\\,\\s\\d{2}[/]\\d{2}\\s\\d{2}:\\d{2}-\\d{2}:\\d{2}\\s[/^Laboratorio$/,/^Teoria$/]{4,}.", datos.get(TITULOSTRING)); 
        Boolean isURLCorrecto = Pattern.matches("^https:\\/\\/utec.zoom.us\\/rec\\/share.+", datos.get(ENLACESTRING)); 

        return isTituloCorrecto && isURLCorrecto;
    }


    public String getTitulo() {
        return this.datos.get(TITULOSTRING);
    }

    public String getEnlace() {
        return this.datos.get(ENLACESTRING);
    }

}