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
            Double numero = Double.parseDouble(req.queryParams("numero"));
            Double resultado = sin(numero);
            return resultado;
        });

        get("cos", (req,res) -> {
            Double numero = Double.parseDouble(req.queryParams("numero"));
            Double resultado = cos(numero);
            return resultado;
        });

        get("palindrome", (req,res) -> {
            String palabra = req.queryParams("palabra");
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
                "<title>Form Example</title>        \n" +
                "<meta charset=\"UTF-8\">        \n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">    \n" +
                "</head>    \n" +
                "<body>        \n" +
                "<h1>Funcion seno</h1>        \n" +
                "<form action=\"/hello\">           \n" +
                "<label for=\"name\">Name:</label><br>            \n" +
                "<input type=\"text\" id=\"name\" name=\"name\" value=\"John\"><br><br>            \n" +
                "<input type=\"button\" value=\"Submit\" onclick=\"loadGetMsg()\">        \n" +
                "</form><div id=\"getrespmsg\"></div>\n" +
                "<script>function loadGetMsg() {\n" +
                "let nameVar = document.getElementById(\"name\").value;                \n" +
                "const xhttp = new XMLHttpRequest();\n" +
                "xhttp.onload = function() {                    \n" +
                "document.getElementById(\"getrespmsg\").innerHTML =                    this.responseText;                }                \n" +
                "xhttp.open(\"GET\", \"/sin?numero=\"+nameVar); xhttp.send();}        </script>       \n"+

                "<h1>Funcion cos</h1>        \n" +
                "<form action=\"/hola\">           \n" +
                "<label for=\"name\">Name:</label><br>            \n" +
                "<input type=\"text\" id=\"valor\" name=\"valor\" value=\"John\"><br><br>            \n" +
                "<input type=\"button\" value=\"enviar\" onclick=\"loadMsg()\">        \n" +
                "</form><div id=\"msg\"></div>\n" +
                "<script>function loadMsg() {\n" +
                "let nameVar = document.getElementById(\"valor\").value;                \n" +
                "const xhttp = new XMLHttpRequest();\n" +
                "xhttp.onload = function() {                    \n" +
                "document.getElementById(\"msg\").innerHTML =                    this.responseText;                }                \n" +
                "xhttp.open(\"GET\", \"/cos?numero=\"+nameVar); xhttp.send();}        </script> ";

        return html;
    }

}