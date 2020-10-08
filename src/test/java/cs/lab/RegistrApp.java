package cs.lab;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;
import java.util.logging.Logger;


class RegistrAppTest {
    static final Logger logger = Logger.getLogger(RegistrAppTest.class.getName());    

    @Test
    public void testCase0(){
        generic(0);
    }

    @Test
    public void testCase1() {
        generic(1);
    }



    @Test(invocationCount = 100, threadPoolSize = 100)
    public void testCase2() {
        long startTime = System.currentTimeMillis();
        generic(2);
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        Assert.assertTrue(timeElapsed < 500);
    }

    @Test
    public void testCase3() {
        generic(3);
    }

    @Test
    public void testCase4() {
        generic(4);
    }

    @Test
    public void testCase5() {
        List<String> lines = readFile(1, "input");

        String professorName = "Jesus";
        
        String titulo = lines.get(0);  
        String enlace = lines.get(1);  
        
        Validacion val = new Validacion(titulo,enlace);
        Boolean status = val.realizarValidacion();

        Notificacion CE2A = new Notificacion(professorName,status);

        Assert.assertEquals(CE2A.getNombreProfesor(), professorName);
        Assert.assertEquals(CE2A.getStatus(), status);
    }

    @Test
    public void testCase6(){
        List<String> lines = readFile(1, "input");

        String professorName = "Jesus";

        String titulo = lines.get(0);
        String enlace = lines.get(1);

        RegistrApp ra = new RegistrApp();

        Assert.assertEquals(ra.generarValidacionApp(titulo,enlace), Boolean.TRUE);
        Assert.assertEquals(ra.procesoVerificacionApp("Jesus",Boolean.TRUE), Boolean.TRUE);
    }



    private void generic(int i) {
        List<String> lines = readFile(i, "input");
        Boolean expectedResult = Boolean.parseBoolean(readOutput(i));

        String titulo = lines.get(0);  
        String enlace = lines.get(1);  
        
        Validacion val = new Validacion(titulo,enlace);
        Boolean status = val.realizarValidacion();

        Assert.assertEquals(status, expectedResult);
    }


    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }
    private String readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines.get(0);
    }
    
};