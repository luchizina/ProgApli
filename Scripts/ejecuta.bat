@echo OFF
echo aqui ejecutando
pause 
SET hola=%~dp0
echo %hola%
cd ..
pause
chdir>hola.txt
SET /p nana=< hola.txt
cd %nana%
chdir
pause
java -jar .\hola22\Cultu.jar
pause