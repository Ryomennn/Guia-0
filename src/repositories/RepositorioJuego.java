package repositories;

import exceptions.IdDuplicadoException;
import interfaces.Repositorio;
import models.Juego;

import java.util.HashSet;
import java.util.stream.Collectors;

public class RepositorioJuego implements Repositorio<Juego> {
    HashSet<Juego> juegos = new HashSet<>();

    @Override
    public void agregar(Juego juego) throws IdDuplicadoException {
        if (juegos.contains(juego)) {
            throw new IdDuplicadoException("Error! El ID del juego ya existe");
        }
        juegos.add(juego);
    }

    @Override
    public void eliminar(String id) {

    }

    @Override
    public void mostrarOrdenado() {
        juegos.stream()
                .sorted((j1, j2) -> j1.getTitulo().compareTo(j2.getTitulo()))
                .forEach(juego -> System.out.println(juego.getTitulo()));
    }

    @Override
    public HashSet<Juego> filtrarGenero(String genero) {
        return juegos.stream()
                .filter(j->j.getGenero().equalsIgnoreCase(genero))
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public void modificarAtributo(String id, String atributo, String nuevoValor) {
        for(Juego juego: juegos) {
            if(juego.getId().equals(id)) {
                switch(atributo) {
                    case "titulo" -> juego.setTitulo(nuevoValor);
                    case "genero" -> juego.setGenero(nuevoValor);
                    case "creador" -> juego.setCreador(nuevoValor);
                    case "version" -> juego.setVersion(nuevoValor);

                }
                System.out.println("Modificado correctamente!!!");
                System.out.println(juego);
            }
        }
    }
}
