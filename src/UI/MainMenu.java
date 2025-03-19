package UI;

import java.util.Scanner;

public class MainMenu {
    public static final void menu() {
        Scanner sc = new Scanner(System.in);
        Integer opcion;

        do {
            System.out.println("--> Menu Principal <---");
            System.out.println("1--> Menu juegos");
            System.out.println("2--> Menu expansiones");
            System.out.println("0--> Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Menu juegos");
                    MenuJuegos.menu();
                }
                case 2 -> {
                    System.out.println("Menu expansiones");
                    MenuExpansiones.menu();
                }

                case 0 -> System.out.println("Saliendo...");
                default -> {
                    System.out.println("Opcion invalida, intente nuevamente...");
                    sc.close();
                }
            }
        } while (opcion != 0);
    }
}
