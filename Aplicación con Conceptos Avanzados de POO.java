interface Servicio {
 void Trabajos();
}
class Plomero implements Servicio {
 public void Trabajos() {System.out.println("Arreglo de tuberia");}
}
abstract class Carpintero implements Servicio {
 String nombre;
 abstract String herramienta();
 Carpintero(String nombre){
     this.nombre=nombre;
     System.out.println(nombre);
 }
}
class AyudanteGeneral extends Carpintero {

    public AyudanteGeneral(String nombre) {
        super(nombre);
    }
 public void Trabajos() {System.out.println("ayuda a la limpieza de area de trabajo");}
 String herramienta() {
     return "Escoba";
 }
}
class AyudanteEspecializado extends Carpintero {

    public AyudanteEspecializado(String nombre) {
        super(nombre);
    }
 public void Trabajos() {System.out.println("Barniza mueble");}
 String herramienta() {
     return "Brocha";
 }
}

public class Polim {
 public static void main(String[] args) {
   final AyudanteEspecializado especializado = new  AyudanteEspecializado("pedro");
   final AyudanteGeneral general = new  AyudanteGeneral("juan");
   final Servicio[] serv = new  Servicio[]{
     new Plomero(),
     especializado,
     general,
     ()->System.out.println("cobrar trabajo")};
   for (final Servicio s: serv) {
     s.Trabajos();
   }
   final Carpintero[] serv2 = new  Carpintero[]{especializado, general};
   for (final Carpintero c: serv2) {
     System.out.println(c.herramienta());
     
     
   }
 }
}

