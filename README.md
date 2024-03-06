# AREP-Taller5 AREP - TALLER DE DE MODULARIZACIÓN CON VIRTUALIZACIÓN E INTRODUCCIÓN A DOCKER

En este laboratorio crearemos una aplicación web pequeña usando el micro-framework de Spark, además de esto usaremos DockerHub como repositorio de la imagen de nuestro proyecto lo cual permitira más flexibilidad, ya que cualquier persona puede consultar mi aplicación. Por otro lado, utilizamos servicios REST para recibir las respectivas peticiones que tiene que recibir nuestra calculadora.

## Prerequisitos

* Se debe tener minimo: Maven, Java, Git y Docker. Si desea el paso a paso de cada uno de estas instalaciones de manera más visual para mejor comprensión, puede buscar una breve explicacion en Youtube, sin embargo, adjunto los links de las paginas oficiales donde indican paso a paso su respectiva instalación.

    - Git <br>
      <https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Instalaci%C3%B3n-de-Git>
    - Maven <br>
      <https://maven.apache.org/install.html>
    - Java <br>
      <https://www.java.com/es/download/help/windows_manual_download.html>
    - Docker <br>
      <https://docs.docker.com/desktop/install/windows-install/>

## Construido con

* [Maven](https://maven.apache.org/) - Manejo de dependencias y la estructura de las carpetas
* [Git](https://git-scm.com/) - Control de versiones
* [Java](https://www.java.com/en/download/help/whatis_java.html) - Lenguaje de Programación
* [Docker](https://www.docker.com/) - Contenedores 

## Empezando

* Para obtener una copia del proyecto en su maquina local:

    - Se debe ubicar en la carpeta donde desea bajar el proyecto y le da click donde señala la flecha y esribe cmd:

      ![image](https://github.com/XimenaRodriguez20/AREP-Taller2/assets/123812926/52f8f03c-3b3e-48cf-bd2c-f7b029c2d8bb)

    - Despues de esto debe escribir el el siguiente comando:

      ~~~                  
      git clone https://github.com/XimenaRodriguez20/AREP-Taller5.git
      ~~~                                                                   

* Para poder correr el codigo abra el IDE de su preferencia y ejecute la clase:
    - SparkWebServer

## Ejecución

* Una vez realizado el paso anterior dirijase al navegador de su preferencia y agregue la siguiente url:

    ~~~                  
      http://localhost:4567/cliente
    ~~~ 

* Cuando ingresa a esa url puede evidenciar la siguiente pagina.

* Además tambien puede arrancar correr la aplicación por comando, para esto debe realizar los siguientes pasos:
    
  - Acceder al directorio donde se encuentra el proyecto
    
    ~~~
        cd AREP-Taller5
    ~~~
  
  - Debera utilizar el siguiente comando, para generar la carpeta target

    ~~~
        mvn clean install
    ~~~

  - Por ultimo debera ejecutar el siguiente comando, pero este varia para windows y linux toca tener cuidado
    
    Windows
    ~~~
        java -cp "target/classes;target/dependency/*" org.arep.SparkWebServer
    ~~~
    
    Linux
    ~~~
        java -cp "target/classes:target/dependency/*" org.arep.SparkWebServer
    ~~~
    
## Pruebas

* Para verificar las funcionalidades probamos con los valores que estan por defecto y como podemos ver si esta realizando las respectivas operaciones:

* Además probamos con otros datos para observar, si su comportamiento sigue siendo el correcto


*  Si desea  tambien en la terminal del IDE puede correr la carpeta test de la siguiente forma:

    ~~~
    mvn test
    ~~~

## Arquitectura del programa

* Para este programa utilizamos metodos de la libreria Spark para obtener los datos con los cuales trabajaremos las respectivas funciones matematicas y la determinacion de si una palabra es palindrome, en la clase SparkWebServer se encuentra toda la logica donde tenemos un metodo el cual se encarga de devolvernos el html con los respectivos resultados segun los datos que el usuario le proporcione, hay mismo hacemos uso de javascript para jalar los datos que el usuario digite y con esto mandarlos a sus respectivas /endpoit donde cada uno se encarga de realizar una funcion en especifico

## Autor

* **Ximena Rodriguez** 
