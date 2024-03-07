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

      ![image](https://github.com/XimenaRodriguez20/AREP-Taller5/assets/123812926/d7276505-9f02-4802-b915-92ac2af29db5)


## Ejecución por IDE o Comando

* Una vez realizado el paso anterior dirijase al navegador de su preferencia y agregue la siguiente url:

    ~~~                  
      http://localhost:4567/cliente
    ~~~ 

* Cuando ingresa a la url mencionada anteriormente, podra evidenciar la siguiente pagina.

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller5/assets/123812926/2671397b-67bb-4226-8cb9-fabd01c5410f)


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

## Ejecución con Docker

* Primero debera abrir Docker y en la consola del sistema operativo o la terminal del IDE, debera escribir el siguiente comando
 
    ~~~
        docker run -d -p 34000:46000 --name taller5 ximenarodriguez20/arep-taller5:latest 
    ~~~

* Una vez realizado el paso anterior se podra observar en la aplicación Docker el contenedor y la imagen del proyecto.

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller5/assets/123812926/1c252529-435c-4ce5-a183-b2487398d2ee)

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller5/assets/123812926/75e27cc3-cb37-4989-82c6-9d1c2ddbfeba)

* Ahora para ingresar a la pagina web deberemos escribir la siguiente url

    ~~~
        http://localhost:34000/cliente
    ~~~

    ![image](https://github.com/XimenaRodriguez20/AREP-Taller5/assets/123812926/5fac9b5f-bec9-48e6-844d-7e1326169a5f)

    
## Pruebas

* Para verificar las funcionalidades, probamos con los valores que estan por defecto y como podemos ver si esta realizando las respectivas operaciones

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller5/assets/123812926/9365a043-bfc0-4df5-9103-a5ba031014f6)

* Además probamos con otros datos para observar, que su comportamiento sea el correcto

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller5/assets/123812926/41ff971e-7ec4-4c8e-8370-56d8e7bcb8a6)
  

* Tambien se realizo las pruebas de funcionalidades, con la url que se genera al ejecutar el programa con docker

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller5/assets/123812926/b889c5d7-0f91-4f78-b64c-635991a791e8)

* A continuación se mostraran los /endpoints que se implementaron para cada funcionalidad. 

    - Función Seno
      
        ~~~
            http://localhost:34000/sin?numero=2
        ~~~
      
        ![image](https://github.com/XimenaRodriguez20/AREP-Taller5/assets/123812926/b996321b-aaa9-463c-9c08-753e36d068b1)
      
    - Función Coseno
 
        ~~~
            http://localhost:34000/cos?numero=87
        ~~~

        ![image](https://github.com/XimenaRodriguez20/AREP-Taller5/assets/123812926/98061cdc-daa7-4678-b42b-d8228b97fa27)

    - Palindrome
 
        ~~~
            http://localhost:34000/palindrome?palabra=Oso
        ~~~

        ![image](https://github.com/XimenaRodriguez20/AREP-Taller5/assets/123812926/062fd179-7ca5-4260-a799-4f023fa9e064)

    - Vector
 
        ~~~
            http://localhost:34000/vector?numero1=5&numero2=9
        ~~~

        ![image](https://github.com/XimenaRodriguez20/AREP-Taller5/assets/123812926/68a86ef9-f303-4f90-a8cf-b1568e335c21)

## Arquitectura del programa

* Para este programa utilizamos metodos de la libreria Spark para obtener los parametros con los cuales trabajaremos las respectivas funciones matematicas y la determinacion de si una palabra es palindrome, esto con la ayuda de diferentes endpoints los cuales tendran una funcionalidad que se especificaran en la clase SparkWebServer.

* SparkWebServer es la clase donde esta toda la logica, en esta se tendra el metodo httpResponse cual se encarga de devolver el html con los respectivos resultados según los datos que el usuario le proporcione, ya que en este mismo metodos se hara uso de javascript para jalar los datos que el usuario digite y con esto mandarlos a sus respectivas /endpoit donde cada uno se encarga de realizar una funcionalidad en especifico.

## Autor

* **Ximena Rodriguez** 
