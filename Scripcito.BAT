@echo OFF
echo aqui compilando
pause 
SET hola=%~dp0
cd %hola%
javac -encoding UTF-8 -d .\build\Culturarte -cp .\lib\* .\src\Persistencia\*.java .\src\Presentacion\*.java .\src\Logica\*.java .\src\Servicios\*.java .\src\Config\*.java
pause
jar cvfm hoy.jar manifest.txt -C .\build\Culturarte\Logica\*.class .\build\Culturarte\Persistencia\*.class .\build\Culturarte\Presentacion\*.class .\build\Servicios\Logica\*.class
pause
java -jar hoy.jar
pause