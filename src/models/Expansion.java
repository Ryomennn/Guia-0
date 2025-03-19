package models;

import java.time.LocalDate;
import java.util.Date;

public class Expansion extends Media{
    private LocalDate lanzamiento;

    public Expansion(String id, String titulo, String creador, String genero, LocalDate lanzamiento) {
        super(id, titulo, creador, genero);
        this.lanzamiento = lanzamiento;
    }

    public LocalDate getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(LocalDate lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    @Override
    public String toString() {
        return "Expansion{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", creador='" + creador + '\'' +
                ", genero='" + genero + '\'' +
                ", lanzamiento=" + lanzamiento +
                "}\n";
    }
}
