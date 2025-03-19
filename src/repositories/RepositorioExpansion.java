package repositories;

import exceptions.IdDuplicadoException;
import interfaces.Repositorio;
import models.Expansion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.stream.Collectors;

public class RepositorioExpansion implements Repositorio<Expansion> {
    private HashSet<Expansion> expansiones = new HashSet<>();

    @Override
    public void agregar(Expansion expansion) throws IdDuplicadoException {
       if(expansiones.contains(expansion)){
           throw new IdDuplicadoException("Error! El ID de la expansion ya existe");
       }
        expansiones.add(expansion);
    }

    @Override
    public void eliminar(String id) {
        expansiones.removeIf(e->e.getId().equals(id));
    }

    @Override
    public void mostrarOrdenado() {
        expansiones.stream()
                .sorted((e1,e2)->e1.getId().compareTo(e2.getId()))
                .forEach(expansiones -> System.out.println(expansiones.getTitulo()));
    }

    @Override
    public HashSet<Expansion> filtrarGenero(String genero) {
       return expansiones.stream()
                .filter(e->e.getGenero().equalsIgnoreCase(genero))
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public void modificarAtributo(String id, String atributo, String nuevoValor) {
        for(Expansion expansion : expansiones){
            if(expansion.getId().equals(id)){
                switch(atributo)
                {
                    case "titulo"-> expansion.setTitulo(nuevoValor);
                    case "genero"-> expansion.setGenero(nuevoValor);
                    case "creador"-> expansion.setCreador(nuevoValor);
                    case "lanzamiento" -> {
                        try{
                            LocalDate nuevaFecha = LocalDate.parse(nuevoValor, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            expansion.setLanzamiento(nuevaFecha);
                        }catch (DateTimeParseException dpe)
                        {
                        System.out.println("Error! El valor no es correcto: dd-MM-yyyy");
                        }
                    }
                }
            }
        }
    }
}
