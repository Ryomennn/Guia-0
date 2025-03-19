package models;

public class Juego extends Media{
    private String version;

    public Juego(String id, String titulo, String creador, String genero, String version) {
        super(id, titulo, creador, genero);
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "\nJuego{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", creador='" + creador + '\'' +
                ", genero='" + genero + '\'' +
                ", version='" + version + '\'' +
                "}\n";
    }



}
