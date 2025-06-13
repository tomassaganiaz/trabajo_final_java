package com.gestor.observer;

import com.gestor.model.User;

public class EmailObserver implements Observer {

    @Override
    public void update(User user, String evento) {
        // Aquí puedes integrar una librería real de envío de emails,
        // pero para simplicidad, solo imprimimos el mensaje.
        System.out.println("Enviando email: El usuario " + user.getNombre() + " ha tenido el evento: " + evento);
    }
}
