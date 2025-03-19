package UI;

import exceptions.IdDuplicadoException;
import models.Juego;
import repositories.RepositorioJuego;

import java.util.Scanner;

public class MenuJuegos {
    public static void menu() {
        RepositorioJuego rj = new RepositorioJuego();

        Scanner sc = new Scanner(System.in);
        Integer opcion;

        do {
            System.out.println("1. Agregar Juego");
            System.out.println("2. Eliminar Juego");
            System.out.println("3. Mostrar juegos ordenados");
            System.out.println("4. Filtrar juegos por genero");
            System.out.println("5. Modificar un atributo");
            System.out.println("0. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    try {
                        System.out.println("Ingresar ID");
                        String idJuego = sc.next();

                        System.out.println("Ingresar titulo");
                        String titulo = sc.next();

                        System.out.println("Ingresar Creador");
                        String creador = sc.next();

                        System.out.println("Ingresar genero");
                        String genero = sc.next();

                        System.out.println("Ingresar version");
                        String version = sc.next();

                        Juego nuevoJuego = new Juego(idJuego, titulo, creador, genero, version);
                        rj.agregar(nuevoJuego);
                        System.out.println("Juego agregado correctamente");
                    } catch (IdDuplicadoException ide) {
                        System.err.println(ide.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Ingresar ID del Juego a eliminar:");
                    String idEliminar = sc.nextLine();
                    rj.eliminar(idEliminar);
                    System.out.println("Juego eliminado correctamente");
                }
                case 3 -> rj.mostrarOrdenado();
                case 4 -> {
                    System.out.println("Ingresar Género para filtrar:");
                    String generoFiltrar = sc.next();
                    System.out.println(rj.filtrarGenero(generoFiltrar));
                }
                case 5 -> {
                    System.out.println("Ingresar id");
                    String id = sc.next();

                    System.out.println("Ingresar atributo");
                    String atributo = sc.next();

                    System.out.println("Ingresar nuevo valor");
                    String valor = sc.next();

                    rj.modificarAtributo(id, atributo, valor);
                }
                case 0 -> System.out.println("Saliendo...");
            }


        } while (opcion != 0);
    }
}
