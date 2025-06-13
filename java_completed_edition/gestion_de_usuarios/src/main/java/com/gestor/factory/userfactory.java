package com.gestor.factory;

import com.gestor.model.User;

public class UserFactory {

    public enum TipoUsuario {
        ADMIN,
        CLIENTE,
        INVITADO
    }

    public static User crearUsuario(TipoUsuario tipo, int id, String nombre, String email, String rol) {
        switch (tipo) {
            case ADMIN:
                // Podrías crear una subclase AdminUser que extienda User (si quisieras)
                return new User(id, nombre, email, rol);
            case CLIENTE:
                // Podrías crear una subclase ClienteUser si quieres roles específicos
                return new User(id, nombre, email, rol);
            case INVITADO:
                // Otro tipo de usuario
                return new User(id, nombre, email, rol);
            default:
                throw new IllegalArgumentException("Tipo de usuario no soportado");
        }
    }
}
