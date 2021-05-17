package universidadgrupo4.modelo;

import java.time.LocalDate;

public class Alumno {
    protected int idAlumno;
    protected int legajo;
    protected String nombre;
    protected String apellido;
    protected boolean estado;
    protected LocalDate fechNac;


    public Alumno() {
    }

    public Alumno(int idAlumno,int legajo, String nombre, LocalDate fechNac, boolean estado) {
        this.idAlumno = idAlumno;
        this.legajo = legajo;
        this.nombre = nombre;
        this.fechNac = fechNac;
        this.estado = estado;
    }

    public Alumno(int legajo,  String nombre, String apellido, LocalDate fechNac, boolean estado) {
         this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechNac = fechNac;
        this.estado = estado;
    }
    
    public void setFechaNac(LocalDate fechaNac) {
        this.fechNac = fechaNac;
    }
    
    
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFechaNac() {
        return fechNac;
    }
    public String toString(){
        return idAlumno+" "+fechNac+""+estado;
    }

    

}

