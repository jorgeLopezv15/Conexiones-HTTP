
// Importamos clases necesarias para trabajar con conexiones HTTP y lectura de datos
import java.io.BufferedReader;                // Para leer el texto de la respuesta línea por línea
import java.io.InputStreamReader;             // Convierte flujo de bytes en caracteres legibles
import java.net.HttpURLConnection;            // Clase para hacer conexiones HTTP (GET, POST, etc.)
import java.net.URL;                          // Representa una URL (dirección web)

public class Consulta {                       
    
    // Constructor de la clase Consulta, recibe como parámetro una ruta (por ejemplo: "rojo.json")
    public Consulta(String ruta){
        try {
            
            // Construimos la URL completa uniendo la base y la ruta que se pasó como argumento
            String urlUsuario = "https://semaforo-706f7-default-rtdb.firebaseio.com/" + ruta;

            // Creamos el objeto URL con la dirección completa
            URL url = new URL(urlUsuario);
            
            // Abrimos una conexión HTTP a la URL y la convertimos a tipo HttpURLConnection
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Indicamos que vamos a hacer una solicitud de tipo GET
            con.setRequestMethod("GET");

            // Creamos un lector para leer la respuesta del servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            // Usamos StringBuilder para juntar todo el texto línea por línea
            StringBuilder content = new StringBuilder();
            String inputLine;

            // Leemos cada línea de la respuesta y la agregamos al contenido
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Cerramos el lector y la conexión
            in.close();
            con.disconnect();

            // Mostramos en consola el contenido leído desde la URL
            System.out.println(content.toString());

        } catch (Exception e) {
            // Si algo sale mal, mostramos el error en consola
            System.out.println("Error: " + e);
        }
    }
}