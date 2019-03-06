/* 
Cuatrimestre: 2019-1
grupo: 901
nombre del equipo: Nova
integrantes del equipo:
Bruno Santiago Celestino
Lara Juarez Jose Brandon
Pérez Hernández Ana Jazmín
Tíare Sánchez Medina
Suárez Escamilla Martin idelfonso
 */
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
   final AyudanteEspecializado especializado = new  AyudanteEspecializado(args [0]);
   final AyudanteGeneral general = new  AyudanteGeneral(args [1]);
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
