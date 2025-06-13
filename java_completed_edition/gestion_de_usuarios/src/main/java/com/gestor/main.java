package com.gestor;

import com.gestor.controller.MenuController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestión de usuarios.");
        MenuController menu = MenuController.getInstance();
        menu.iniciar();
    }
}
