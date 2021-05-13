/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo4.modelo;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;
import java.time.*;

/**
 *
 * @author Usuario
 */
public class AlumnoData {
    private Connection con;
    public AlumnoData(Conexion conexion){
        try{
            con = conexion.getConexion();
        }catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    public List<Alumno>obtenerAlumno(){
        List<Alumno>alumnos = new ArrayList<>();
        try{
            String sql = "SELECT * FROM alumno";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
            Alumno alumno;
            
            while(rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechNac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
        }catch(SQLException ex){
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE,null,ex);
        }
        return alumnos;
    }
    
    public void borrarAlumno(int id){
        
        try{
            String sql="DELETE FROM alumno WHWRE idAlumno=?";
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void actualizarAlumno(Alumno alumno){
        try{
            String sql="UPDATE  alumno SET legajo=?, nombre=?, apellido=?, estado=?, fechNac=? WHERE idAlumno=?";
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getLegajo());
            ps.setString(1, alumno.getNombre());
            ps.setDate(2, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(3, alumno.getEstado());
            ps.executeUpdate();
            
            ps.close();
        }catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void guardarAlumno(Alumno alumno){
         try{
            String sql="INSERT INTO alumno (legajo, nombre, apellido, estado, fechNac) VALUES (?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getLegajo());
            ps.setString(1, alumno.getNombre());
            ps.setDate(2, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(3, alumno.getEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
            }
            
            ps.close();
        }catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE,null,ex);
        }    
    }
    
    
    
}
