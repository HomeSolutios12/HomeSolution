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


import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;

import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import static java.util.Arrays.asList;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



public class AES {
    
    
    
	public static void main(String[] args) {
            
          
		
		String contraseña1 = new String();
                String contraseña2 = new String();
                String contraseña3 = new String();
		String strCipherText = new String();
		String strDecryptedText = new String();
		
                String strCipherText2 = new String();
		String strDecryptedText2 = new String();
                
                String strCipherText3 = new String();
		String strDecryptedText3 = new String();
		try{
		/**
		
                *paso 1. Generar una clave AES usando KeyGenerator
                * Inicializar el tamaño de clave a 128. 
		 * 
		 */
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey secretKey = keyGen.generateKey();
		
		/**
                 * 
                *  Paso 2. Cree un cifrado especificando los siguientes parámetros
                * una. Nombre del algoritmo - aquí está AES
		 */
		
		Cipher aesCipher = Cipher.getInstance("AES");
		
		/**
		 *  
                    Paso 3. Inicializar el cifrado para cifrado
		 */
		
		aesCipher.init(Cipher.ENCRYPT_MODE,secretKey);
		
		/**
		 * Paso 4. Cifrar los datos
                    * 1. Declarar / Inicializar los datos. Aquí los datos son de tipo String.
                    * 2. Convertir el texto de entrada a bytes
                    * 3. Cifrar los bytes utilizando el método doFinal.
		 */
		contraseña1 = "simon 2345";
		byte[] byteDataToEncrypt = contraseña1.getBytes();
		byte[] byteCipherText = aesCipher.doFinal(byteDataToEncrypt); 
		strCipherText = new BASE64Encoder().encode(byteCipherText);
               
                contraseña2 = "Pancho123";
		byte[] byteDataToEncrypt2 = contraseña2.getBytes();
		byte[] byteCipherText2 = aesCipher.doFinal(byteDataToEncrypt2); 
		strCipherText2 = new BASE64Encoder().encode(byteCipherText2);
                
                
                contraseña3 = "Ari234";
		byte[] byteDataToEncrypt3 = contraseña3.getBytes();
                    System.out.println("contraseña: "+contraseña3.getBytes());
		byte[] byteCipherText3 = aesCipher.doFinal(byteDataToEncrypt3); 
		 strCipherText3= new BASE64Encoder().encode(byteCipherText3);
                System.out.println("contraseña:ss "+strCipherText3);
                
                
                
		Contratista contra1 = new Contratista("PANCHO",strCipherText);
                
                Contratista contra2 = new Contratista("LUIS",strCipherText2);
                Contratista contra3 = new Contratista("Ari",strCipherText3);
                Rol rol1 = new Rol("electricista");
                rol1.contratistas = asList(contra1,contra2,contra3);
                Rol rol2 = new Rol("Carpintero");
                Contratista contra4 = new Contratista("lalo",strCipherText);
                rol2.contratistas = asList(contra4);
                final Contratista luis = new Contratista("simon",strCipherText2);
                final Contratista pedro = new Contratista("Aria",strCipherText3);
                final Rol electricista = new Rol("electrisita");
                final Rol albanil = new Rol("albanil");
                final Rol carpintero = new Rol("Carpintero");
                luis.rol = electricista;
                pedro.rol = albanil;
                contra1.rol = electricista;
                contra2.rol = electricista;
                contra3.rol = electricista;
                contra4.rol = carpintero;
            
            
		
		/**
		 *  paso 5. desencriptar datos
		 *  		1. Inicializar el cifrado para descifrado
                 * 2. Descifrar los bytes de cifrado utilizando el método doFinal 
		 */
		aesCipher.init(Cipher.DECRYPT_MODE,secretKey,aesCipher.getParameters());
		byte[] byteDecryptedText = aesCipher.doFinal(byteCipherText);
		luis.contraseña = new String(byteDecryptedText);
                
		System.out.println("El usuario: " +luis.nombre+" contraseña desencriptada : "+luis.contraseña);
                
                aesCipher.init(Cipher.DECRYPT_MODE,secretKey,aesCipher.getParameters());
		byte[] byteDecryptedText2 = aesCipher.doFinal(byteCipherText2);
		pedro.contraseña = new String(byteDecryptedText2);
                System.out.println("El usuario: " +pedro.nombre+" contraseña desencriptada : "+pedro.contraseña);

                aesCipher.init(Cipher.DECRYPT_MODE,secretKey,aesCipher.getParameters());
		byte[] byteDecryptedText3 = aesCipher.doFinal(byteCipherText3);
		contra4.contraseña = new String(byteDecryptedText3);
                System.out.println("El usuario: " +contra4.nombre+" contraseña desencriptada : "+contra4.contraseña);

		}
                
		
		catch (NoSuchAlgorithmException noSuchAlgo)
		{
			System.out.println(" No Such Algorithm exists " + noSuchAlgo);
		}
		
			catch (NoSuchPaddingException noSuchPad)
			{
				System.out.println(" No existe el algoritmo" + noSuchPad);
			}
		
				catch (InvalidKeyException invalidKey)
				{
					System.out.println(" invalido clave " + invalidKey);
				}
				
				catch (BadPaddingException badPadding)
				{
					System.out.println(" Mal Padding " + badPadding);
				}
				
				catch (IllegalBlockSizeException illegalBlockSize)
				{
					System.out.println(" Tamaño de bloque ilegal" + illegalBlockSize);
				}
				
				catch (InvalidAlgorithmParameterException invalidParam)
				{
					System.out.println(" Parametro invalido" + invalidParam);
				}

            
	}

}







public class Contratista{
   String contraseña;
   String nombre;
   Rol rol;
  
 public Contratista(String nombre,String contraseña) {
   this.nombre = nombre;
   this.contraseña = contraseña;
   System.out.println("el nombre de usuario es: "+nombre +" La contraseña encriptada es:" +contraseña);
   
 }

  
 
   

}



package aes;


import java.util.List;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

class Rol{
   
  String nombre;
  
  List<Contratista> contratistas;
   
 
   public Rol(String nombre) {
   this.nombre = nombre;

 }

 
}
