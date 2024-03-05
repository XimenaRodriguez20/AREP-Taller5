package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import static java.lang.Integer.parseInt;
import static spark.Spark.port;
import static spark.Spark.get;
import static java.lang.Math. *;


public class SparkWebServer {

    public static void main(String... args){

        port(getPort());
        get("cliente", (req,res) -> {

            String htmlResponse = htmlResponse();
            return htmlResponse;

        });
        
        get("sin", (req,res) -> {
            try{
                Double numero = Double.parseDouble(req.queryParams("numero"));
                Double resultado = sin(numero);
                return resultado;
            } catch (NumberFormatException e) {
                return null;
            }
        });

        get("cos", (req,res) -> {
            Double numero = Double.parseDouble(req.queryParams("numero"));
            Double resultado = cos(numero);
            return resultado;
        });

        get("palindrome", (req,res) -> {
            String palabra = req.queryParams("palabra").toLowerCase();
            StringBuilder conversion = new StringBuilder(palabra);
            String reverso = conversion.reverse().toString();
            return palabra.equals(reverso);
        });

        get("vector", (req,res) -> {
            Double numero1 = Double.parseDouble(req.queryParams("numero1"));
            Double numero2 = Double.parseDouble(req.queryParams("numero2"));
            Double vector = sqrt( Math.pow(numero1,2)+ Math.pow(numero2,2));
            return vector;
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    public static String htmlResponse(){
        String html = "<!DOCTYPE html>\n" +
                "<html>    \n" +
                "<head>        \n" +
                "<title>Funciones</title>        \n" +
                "<meta charset=\"UTF-8\">        \n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">    \n" +
                "</head>    \n" +
                "<style>\n" +
                "  body {\n" +
                "    background: linear-gradient(to bottom, #33ccff 0%, #ff99cc 100%);\n" +
                "  }\n" +
                "</style>"+
                "<body >        \n" +

                "<h1>Funcion seno</h1>        \n" +
                "<label for=\"name\">Ingrese el numero:</label><br>            \n" +
                "<input type=\"text\" id=\"number\" name=\"number\" value=\"\"><br><br>            \n" +
                "<input type=\"button\" value=\"enviar\" onclick=\"loadGetMsg()\">        \n" +
                "</form><div id=\"getrespmsg\"></div>\n" +
                "<script>function loadGetMsg() {\n" +
                "let nameVar = document.getElementById(\"number\").value;                \n" +
                "const xhttp = new XMLHttpRequest();\n" +
                "xhttp.onload = function() {                    \n" +
                "document.getElementById(\"getrespmsg\").innerHTML =                    this.responseText;                }                \n" +
                "xhttp.open(\"GET\", \"/sin?numero=\"+nameVar); xhttp.send();}        </script>       \n" +

                "<h1>Funcion coseno</h1>        \n" +
                "<label for=\"name\">Ingrese el numero:</label><br>            \n" +
                "<input type=\"text\" id=\"valor\" name=\"valor\" value=\"\"><br><br>            \n" +
                "<input type=\"button\" value=\"enviar\" onclick=\"loadMsg()\">        \n" +
                "</form><div id=\"msg\"></div>\n" +
                "<script>function loadMsg() {\n" +
                "let nameVar = document.getElementById(\"valor\").value;                \n" +
                "const xhttp = new XMLHttpRequest();\n" +
                "xhttp.onload = function() {                    \n" +
                "document.getElementById(\"msg\").innerHTML =                    this.responseText;                }                \n" +
                "xhttp.open(\"GET\", \"/cos?numero=\"+nameVar); xhttp.send();}        </script>" +

                " <h1>Palindrome</h1>        \n" +
                "<label for=\"name\">Ingrese la palabra:</label><br>            \n" +
                "<input type=\"text\" id=\"word\" name=\"word\" value=\"\"><br><br>            \n" +
                "<input type=\"button\" value=\"enviar\" onclick=\"load()\">        \n" +
                "</form><div id=\"respuesta\"></div>\n" +
                "<script>function load() {\n" +
                "let nameVar = document.getElementById(\"word\").value;                \n" +
                "const xhttp = new XMLHttpRequest();\n" +
                "xhttp.onload = function() {                    \n" +
                "document.getElementById(\"respuesta\").innerHTML =                    this.responseText;                }                \n" +
                "xhttp.open(\"GET\", \"/palindrome?palabra=\"+nameVar); xhttp.send();}        </script> " +

                "<h1>Vector</h1>        \n" +
                "<label for=\"name\">Ingrese los numeros:</label><br>            \n" +
                "<input type=\"text\" id=\"valor1\" name=\"valor1\" value=\"\"><br><br>            \n" +
                "<input type=\"text\" id=\"valor2\" name=\"valor2\" value=\"\"><br><br>            \n" +
                "<input type=\"button\" value=\"enviar\" onclick=\"prueba()\">        \n" +
                "</form><div id=\"informacion\"></div>\n" +
                "<script>function prueba() {\n" +
                "let nameVar1 = document.getElementById(\"valor1\").value;                \n" +
                "let nameVar2 = document.getElementById(\"valor2\").value;                \n" +
                "const xhttp = new XMLHttpRequest();\n" +
                "xhttp.onload = function() {                    \n" +
                "document.getElementById(\"informacion\").innerHTML =                    this.responseText;                }                \n" +
                "xhttp.open(\"GET\", \"/vector?numero1=\"+nameVar1+\"&numero2=\"+nameVar2); xhttp.send();}        </script> </body> </html>";

        return html;
    }

}