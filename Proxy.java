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

public class Proxy {
 public static void main(String[] a) {
   final AppSimple appSimple = new AppSimple();
   appSimple.contratarEmpleado();
   appSimple.rechazarEmpleado();
   
   final AppProxy appProxy = new AppProxy("Alfonso",18);
   appProxy.contratarEmpleado();
   appProxy.rechazarEmpleado();
 }
}

    

interface App {
 void contratarEmpleado();

 void rechazarEmpleado();
}



class AppProxy implements App {
 final private String nombre;
 private int edadEmpleado;

 AppProxy(String nombre, int edadEmpelado) {
   this.nombre = nombre;
   this.edadEmpleado = edadEmpleado;
 }


 public void contratarEmpleado() {
   if (edadEmpleado >= 16 && edadEmpleado <50 ) {
     System.out.println("Feliciades Contratado");
     System.out.println(edadEmpleado);
     
   } else {
     rechazarEmpleado();
   }
 }


 public void rechazarEmpleado() {
     if(edadEmpleado <= 15){
 System.out.println("No apto");
 System.out.println(edadEmpleado);
 System.out.println(nombre);
 
     }    
 }
}



class AppSimple implements App {

 public void contratarEmpleado() {
   System.out.println("Empleado contratado");
 }


 public void rechazarEmpleado() {
   System.out.println("Sigue participando");
 }
}
