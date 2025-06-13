gestor-usuarios/
├── pom.xml                      <-- archivo de Maven (gestor de dependencias/build)
├── .gitignore                   <-- para ignorar archivos no deseados en Git
├── README.md                    <-- documentación del proyecto
├── users.db                     <-- base de datos SQLite (si ya existe)
├── run.bat                      <-- script para Windows (opcional)
├── run.sh                       <-- script para Linux/Mac (opcional)
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── gestor/
        │           ├── Main.java                 <-- clase principal
        │           ├── config/                   <-- Configuración general
        │           │   └── Config.java
        │           ├── dao/                      <-- Clases DAO e interfaces
        │           │   ├── UserDAO.java
        │           │   └── IUserDAO.java
        │           ├── model/                    <-- Entidades del sistema
        │           │   ├── User.java
        │           │   └── Role.java
        │           ├── observer/                 <-- Observadores
        │           │   ├── Observer.java
        │           │   ├── Subject.java
        │           │   ├── LoggerObserver.java
        │           │   └── EmailObserver.java
        │           ├── factory/                  <-- Factory Pattern
        │           │   └── UserFactory.java
        │           ├── builder/                  <-- Builder Pattern
        │           │   └── UserBuilder.java
        │           ├── service/                  <-- Lógica de negocio (servicio)
        │           │   └── UserService.java
        │           └── ui/                       <-- Interfaz de usuario (CLI / GUI)
        │               └── MenuController.java
        └── resources/
            ├── config.properties                <-- configuración por defecto
            ├── config-prod.properties           <-- configuración para producción
            ├── messages_es.properties           <-- i18n Español
            ├── messages_en.properties           <-- i18n Inglés
            └── log4j.properties                 <-- configuración de logging
