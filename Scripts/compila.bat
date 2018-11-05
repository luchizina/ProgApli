@echo OFF
echo aqui compilando
pause 
SET hola=%~dp0
echo %hola%
cd ..
pause
chdir>hola.txt
SET /p nana=< hola.txt
echo %nana%
cd %nana%
MD .\build\Culturarte
pause
javac -encoding UTF-8 -d .\build\Culturarte -cp .\lib\* .\src\Persistencia\*.java .\src\Presentacion\*.java .\src\Logica\*.java .\src\Servicios\*.java .\src\Config\*.java 
pause
MD hola22
jar cvfm .\hola22\Cultu.jar .\src\manifest.txt -C .\build\Culturarte\ .
MD .\hola22\lib
XCOPY .\lib .\hola22\lib
pause

