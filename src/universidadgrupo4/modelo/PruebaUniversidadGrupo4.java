/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo4.modelo;

import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class PruebaUniversidadGrupo4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conexion = null;
        try{
          conexion = new Conexion("jdbc:mysql://localhost/universidadgrupo4","root","");
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error de driver");
        }
        LocalDate fecha=LocalDate.of(2020, 2, 12);
        Alumno a=new Alumno(212114,"Juan","Gimenez",fecha,true);
        AlumnoData aD=new AlumnoData(conexion);
        aD.borrarAlumno(2);
        
    }
    
}