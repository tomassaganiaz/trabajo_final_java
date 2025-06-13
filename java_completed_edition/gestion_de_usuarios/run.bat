@echo off
echo Compilando el proyecto...
mvn clean package

echo Ejecutando la aplicación...
java -jar target\gestor-usuarios-1.0-jar-with-dependencies.jar

pause
