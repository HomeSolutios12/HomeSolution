public class CtrlProyecto {
    public static void main(String[] args) {
        try {


            formDatos.recuperarDatos("DaniCarreolas", "Plomero", "Revisa Coladeras");
            InfoContratista.imprime = "Datos del contratista " + ", " + InfoContratista.nombre + ", " + InfoContratista.rol + ", " + InfoContratista.servicio;
        } catch (Exception e) {
            InfoContratista.imprime = e.getMessage();
        }
        formDatos.muestraRespuesta();
    }
}
class formDatos {
    static void recuperarDatos(String nombre, String rol, String servicio) {
        InfoContratista.nombre = nombre;
        InfoContratista.rol = rol;
        InfoContratista.servicio = servicio;
    }
    static void muestraRespuesta() {
        System.out.println(InfoContratista.imprime);
    }
}

public class InfoContratista {
    static String nombre;
    static String rol;
    static String servicio;
    static String imprime;
}