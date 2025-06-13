package com.gestor.controller;

import com.gestor.dao.IUserDAO;
import com.gestor.dao.UserDAO;
import com.gestor.factory.UserFactory;
import com.gestor.model.User;
import com.gestor.observer.Subject;
import com.gestor.observer.EmailObserver;
import com.gestor.observer.LoggerObserver;

import java.util.List;
import java.util.Scanner;

public class MenuController {
    private static MenuController instancia;
    private IUserDAO userDAO;
    private Subject subject;
    private Scanner scanner;

    private MenuController() {
        userDAO = new UserDAO();
        subject = new Subject();
        subject.addObserver(new EmailObserver());
        subject.addObserver(new LoggerObserver());
        scanner = new Scanner(System.in);
    }

    public static MenuController getInstance() {
        if (instancia == null) {
            instancia = new MenuController();
        }
        return instancia;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero("Selecciona una opción: ");
            switch (opcion) {
                case 1 -> agregarUsuario();
                case 2 -> actualizarUsuario();
                case 3 -> eliminarUsuario();
                case 4 -> listarUsuarios();
                case 5 -> salir = true;
                default -> System.out.println("Opción inválida, intenta nuevamente.");
            }
        }
        System.out.println("Saliendo del sistema. ¡Hasta luego!");
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú de Gestión de Usuarios ---");
        System.out.println("1. Agregar usuario");
        System.out.println("2. Actualizar usuario");
        System.out.println("3. Eliminar usuario");
        System.out.println("4. Listar usuarios");
        System.out.println("5. Salir");
    }

    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Error: Debes ingresar un número entero.");
            System.out.print(mensaje);
            scanner.next();
        }
        return scanner.nextInt();
    }

    private String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }

    private void agregarUsuario() {
        System.out.println("\n--- Agregar Usuario ---");
        scanner.nextLine(); // limpiar buffer
        String nombre = leerLinea("Nombre: ");
        String email = leerLinea("Email: ");
        String rol = leerLinea("Rol: ");

        User user = UserFactory.crearUsuario(UserFactory.TipoUsuario.CLIENTE, 0, nombre, email, rol);
        if (userDAO.insertar(user)) {
            System.out.println("Usuario agregado correctamente.");
            subject.notifyObservers(user, "creado");
        } else {
            System.out.println("Error al agregar usuario.");
        }
    }

    private void actualizarUsuario() {
        System.out.println("\n--- Actualizar Usuario ---");
        int id = leerEntero("ID del usuario a actualizar: ");
        User existente = userDAO.obtenerPorId(id);
        if (existente == null) {
            System.out.println("No se encontró usuario con ese ID.");
            return;
        }
        scanner.nextLine(); // limpiar buffer
        String nombre = leerLinea("Nuevo nombre (" + existente.getNombre() + "): ");
        String email = leerLinea("Nuevo email (" + existente.getEmail() + "): ");
        String rol = leerLinea("Nuevo rol (" + existente.getRol() + "): ");

        // Si el usuario no ingresa nada, conserva el valor anterior
        if (!nombre.isBlank()) existente.setNombre(nombre);
        if (!email.isBlank()) existente.setEmail(email);
        if (!rol.isBlank()) existente.setRol(rol);

        if (userDAO.actualizar(existente)) {
            System.out.println("Usuario actualizado correctamente.");
            subject.notifyObservers(existente, "actualizado");
        } else {
            System.out.println("Error al actualizar usuario.");
        }
    }

    private void eliminarUsuario() {
        System.out.println("\n--- Eliminar Usuario ---");
        int id = leerEntero("ID del usuario a eliminar: ");
        User user = userDAO.obtenerPorId(id);
        if (user == null) {
            System.out.println("No se encontró usuario con ese ID.");
            return;
        }
        if (userDAO.eliminar(id)) {
            System.out.println("Usuario eliminado correctamente.");
            subject.notifyObservers(user, "eliminado");
        } else {
            System.out.println("Error al eliminar usuario.");
        }
    }

    private void listarUsuarios() {
        System.out.println("\n--- Lista de Usuarios ---");
        List<User> usuarios = userDAO.obtenerTodos();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (User u : usuarios) {
                System.out.println("ID: " + u.getId() + ", Nombre: " + u.getNombre() +
                        ", Email: " + u.getEmail() + ", Rol: " + u.getRol());
            }
        }
    }

    private String leerLinea(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }
}
