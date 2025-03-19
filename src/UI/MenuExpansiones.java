package UI;

import exceptions.IdDuplicadoException;
import models.Expansion;
import repositories.RepositorioExpansion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuExpansiones {
    public static void menu() {
        RepositorioExpansion re = new RepositorioExpansion();

        Scanner sc = new Scanner(System.in);
        Integer opcion;

        do {
            System.out.println("1. Agregar expansion");
            System.out.println("2. Eliminar expansion");
            System.out.println("3. Mostrar expansiones ordenadas");
            System.out.println("4. Filtrar expansiones por genero");
            System.out.println("5. Modificar un atributo");
            System.out.println("0. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    try {
                        System.out.println("Ingresar ID");
                        String id = sc.next();

                        System.out.println("Ingresar titulo");
                        String titulo = sc.next();

                        System.out.println("Ingresar Creador");
                        String creador = sc.next();

                        System.out.println("Ingresar genero");
                        String genero = sc.next();

                        System.out.println("Ingresar fecha de lanzamiento");
                        LocalDate lanzamiento = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                        Expansion nuevaExpansion = new Expansion(id, titulo, creador, genero, lanzamiento);
                        re.agregar(nuevaExpansion);
                        System.out.println("Expansion agregada correctamente");
                    } catch (IdDuplicadoException ide) {
                        System.err.println(ide.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Ingresar ID de la expansion a eliminar:");
                    String idEliminar = sc.nextLine();
                    re.eliminar(idEliminar);
                    System.out.println("Expansion eliminada correctamente");
                }
                case 3 -> re.mostrarOrdenado();
                case 4 -> {
                    System.out.println("Ingresar Género para filtrar:");
                    String generoFiltrar = sc.next();
                    System.out.println(re.filtrarGenero(generoFiltrar));
                }
                case 5 -> {
                    System.out.println("Ingresar id");
                    String id = sc.next();

                    System.out.println("Ingresar atributo");
                    String atributo = sc.next();

                    System.out.println("Ingresar nuevo valor");
                    String valor = sc.next();

                    re.modificarAtributo(id, atributo, valor);
                }
                case 0 -> System.out.println("Saliendo...");
            }
        } while (opcion != 0);
    }
}
