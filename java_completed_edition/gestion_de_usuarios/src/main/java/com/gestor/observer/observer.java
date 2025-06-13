package com.gestor.observer;

import com.gestor.model.User;

public interface Observer {
    void update(User user, String evento);
}
