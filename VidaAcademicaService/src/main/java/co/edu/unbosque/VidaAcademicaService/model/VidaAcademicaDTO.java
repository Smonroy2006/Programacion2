package co.edu.unbosque.VidaAcademicaService.model;

public class VidaAcademicaDTO {

    private String id;
    private String titulo;
    private String Universidad;
    private boolean completado;

    public VidaAcademicaDTO() {
    }

    public VidaAcademicaDTO(String id, String titulo, String universidad, boolean completado) {
        this.id = id;
        this.titulo = titulo;
        Universidad = universidad;
        this.completado = completado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUniversidad() {
        return Universidad;
    }

    public void setUniversidad(String universidad) {
        Universidad = universidad;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
