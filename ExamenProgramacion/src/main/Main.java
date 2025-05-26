package main;

import Controlador.LibroControlador;
import controlador.LectorControlador;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Gestion de una Biblioteca");
            System.out.println("1. Gestionar libros");
            System.out.println("2. Gestionar lectores");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    LibroControlador.menu();
                    break;
                case 2:
                    LectorControlador.menu();
                    break;
                case 3:
                    System.out.println("Saliendo de la biblioteca");
                    break;
                default:
                    System.out.println("Esa opcion no está disponible.");
            }
        } while (opcion != 3);
    }
}