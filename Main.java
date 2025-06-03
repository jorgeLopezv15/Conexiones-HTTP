public class Main {                

    public static void main(String[] args) { 

        // Creamos un objeto de tipo Consulta y pasamos "rojo.json"
        // Esto hará que se conecte a esa ruta y muestre el contenido
        Consulta consulta1 = new Consulta("rojo.json");
        Consulta consulta2 = new Consulta("amarillo.json");
        Consulta consulta3 = new Consulta("verde.json");
        Consulta consulta4 = new Consulta(".json");
    }
}