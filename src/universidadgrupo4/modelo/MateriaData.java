/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo4.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author martin.flores
 */
public class MateriaData {
    
    private Connection con;
    public MateriaData(Conexion conexion){
        try{
            con = conexion.getConexion();
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"error de conexion");
        }
    }
     public void desactivarMateria(int id){
        
        try{
            String sql="UPDATE materia SET estado=false WHWRE idMateria=?";
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(2, id);
            
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"error de conexion");
        }
    }
     public void guardarMateria(Materia materia){
         try{
            String sql="INSERT INTO materia (nombreMateria, anio, estado, ) VALUES (?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
   
            ps.setString(1, materia.getNombreMateria());
             ps.setInt(2,materia.getAnio());
            ps.setBoolean(3, materia.getEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                materia.setIdMateria(rs.getInt(1));
            }
            
            ps.close();
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"error de conexion");
        } 
     }
      public void actualizarMateria(Materia materia){
        try{
            String sql="UPDATE  materia SET  nombre=?, anio, estado=? WHERE idMateria=?";
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, materia.getNombreMateria());
            ps.setInt(2,materia.getAnio());
            ps.setBoolean(3, materia.getEstado());
            ps.executeUpdate();
            
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error de conexion");
        }
    }
      public List <Materia> buscarMateria(int id){
           Materia materia; 
            ArrayList<Materia> materias = new ArrayList<>();
            
          try{ 
            String sql="SELECT * FROM  materia ";
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
           
            
            while(rs.next()){
              materia=new Materia();
              materia.setNombreMateria(rs.getString("nombreMateria"));
              materia.setIdMateria((rs.getInt("idMateria")));
              materia.setEstado(rs.getBoolean("estado"));
              materia.setAnio(rs.getInt("anio"));
              materias.add(materia);
            }
                
            
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error de conexion");
        }
         return materias; 
    }
          
}
