package models;

public abstract class Media implements Comparable<Media> {
    protected String id;
    protected String titulo;
    protected String creador;
    protected String genero;

    public Media(String id, String titulo, String creador, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
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

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int compareTo(Media o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return id.equals(media.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
