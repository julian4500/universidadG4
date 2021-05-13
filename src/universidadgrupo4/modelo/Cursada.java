package universidadgrupo4.modelo;

public class Cursada {
protected int idCursada;
protected Alumno idAlumno;
protected Materia idMateria;
protected int nota;

    public Cursada(int idCursada, Alumno idAlumno, Materia idMateria, int nota) {
        this.idCursada = idCursada;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.nota = nota;
    }

    public Cursada(Alumno idAlumno, Materia idMateria, int nota) {
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.nota = nota;
    }

    public Cursada() {
    }
    


}
