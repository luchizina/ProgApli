@echo OFF
echo aqui compilando
pause 
cd ..
pause
chdir
MD pdfs
MD .\build\Culturarte
pause
javac -encoding UTF-8 -d .\build\Culturarte -cp .\lib\* .\src\Persistencia\*.java .\src\Presentacion\*.java .\src\Logica\*.java .\src\Servicios\*.java .\src\Config\*.java 
pause
MD bin
jar cvfm .\bin\Cultu.jar .\src\manifest.txt -C .\build\Culturarte\ .
MD .\bin\lib
XCOPY .\lib .\bin\lib
pause

