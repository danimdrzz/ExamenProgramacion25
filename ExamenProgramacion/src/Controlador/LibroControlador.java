package Controlador;

import dao.LibroDao;
import modelo.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LibroControlador {

    private static final LibroDao dao = new LibroDao();
    private static final Scanner sc = new Scanner(System.in);

    public static void menu() throws SQLException {
        int opcion;
        do {
            System.out.println("Bienvenido a la gestion de libros:");
            System.out.println("1. Agrega un nuevo libro");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Editar un libro");
            System.out.println("4. Elimina un libro");
            System.out.println("5. Volver al menu principal");
            System.out.print("¿Que quieres hacer?: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> agregar();
                case 2 -> listar();
                case 3 -> editar();
                case 4 -> eliminar();
            }
        } while (opcion != 5);
    }

    private static void agregar() throws SQLException {
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Año de Publicacion: ");
        int anio = Integer.parseInt(sc.nextLine());
        Libro libro = new Libro(id, titulo, autor, anio);
        dao.insertar(libro);
        System.out.println("Libro agregado.");
    }

    private static void listar() throws SQLException {
        List<Libro> lista = dao.listar();
        System.out.println("Lista de Libros:");
        for (Libro l : lista) {
            System.out.println(l.getId() + " - " + l.getTitulo() + " - " + l.getAutor() + " - " + l.getAnioPublicacion());
        }
    }

    private static void editar() throws SQLException {
        System.out.print("ID del libro a editar: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Nuevo autor: ");
        String autor = sc.nextLine();
        System.out.print("Nuevo año: ");
        int anio = Integer.parseInt(sc.nextLine());
        Libro libro = new Libro(id, titulo, autor, anio);
        dao.actualizar(libro);
        System.out.println("El libro ha sido actualizado:");
    }

    private static void eliminar() throws SQLException {
        System.out.print("ID del libro a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        dao.eliminar(id);
        System.out.println("Libro eliminado.");
    }
}

