package com.gestor.observer;

import com.gestor.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerObserver implements Observer {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void update(User user, String evento) {
        String fechaHora = LocalDateTime.now().format(formatter);
        System.out.println("[" + fechaHora + "] Evento: " + evento + " para usuario: " + user.getNombre() + " (ID: " + user.getId() + ")");
        // Aquí podrías escribir también a un archivo log si quieres
    }
}
