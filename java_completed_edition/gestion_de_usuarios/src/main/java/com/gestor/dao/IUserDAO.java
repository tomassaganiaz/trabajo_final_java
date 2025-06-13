package com.gestor.dao;

import com.gestor.model.User;
import java.util.List;

public interface IUserDAO {
    boolean insertar(User user);
    boolean actualizar(User user);
    boolean eliminar(int id);
    User obtenerPorId(int id);
    List<User> obtenerTodos();
}
