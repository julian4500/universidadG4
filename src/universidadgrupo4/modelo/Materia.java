package universidadgrupo4.modelo;

public class Materia {
    protected int idMateria;
    protected String nombreMateria;
    protected int anio;
    protected boolean estado;

    public Materia() {
    }

    public Materia(int idMateria, String nombreMateria, int anio, boolean estado) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.anio = anio;
        this.estado = estado;
    }

    public Materia(String nombreMateria, int anio, boolean estado) {
        this.nombreMateria = nombreMateria;
        this.anio = anio;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Materia{" + "id_materia=" + idMateria + ", nombreMateria=" + nombreMateria + ", anio=" + anio + ", estado=" + estado + '}';

    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int id_materia) {
        this.idMateria = id_materia;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
