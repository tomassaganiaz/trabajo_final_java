package com.gestor.builder;

import com.gestor.model.User;

public class UserBuilder {
    private int id;
    private String nombre;
    private String email;
    private String rol;

    public UserBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setRol(String rol) {
        this.rol = rol;
        return this;
    }

    public User build() {
        return new User(id, nombre, email, rol);
    }
}
