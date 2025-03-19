package interfaces;
import exceptions.IdDuplicadoException;
import models.Media;
import java.util.HashSet;


public interface Repositorio <T extends Media>{
    void agregar(T t) throws IdDuplicadoException;
    void eliminar(String id);
    void mostrarOrdenado();
    HashSet<T> filtrarGenero(String genero);
    void modificarAtributo (String id, String atributo, String nuevoValor);
}
