/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

/*
 * La clase Encriptado proporciona métodos para encriptar y desencriptar textos utilizando el algoritmo AES en modo CBC con un relleno PKCS5.
 * La encriptación y desencriptación se realizan utilizando una clave de 16 bytes y un vector de inicialización (IV) aleatorio.
 * La clase utiliza Base64 para codificar y decodificar el texto cifrado y el IV.
 */
public class Encriptado {

    /**
     * Encripta un texto utilizando AES en modo CBC con un IV aleatorio y una clave proporcionada.
     * 
     * @param text El texto que se desea encriptar.
     * @param key La clave de 16 bytes para la encriptación.
     * @return El texto encriptado en formato Base64, que incluye el IV y el texto cifrado, separados por un ':'.
     * @throws Exception Si ocurre algún error durante el proceso de encriptación.
     */
    public static String encrypt(String text, String key) throws Exception {
        // Asegurarse de que la clave tenga 16 bytes
        if (key.length() < 16) {
            key = String.format("%-16s", key);  // Rellenar con espacios hasta 16 bytes
        } else if (key.length() > 16) {
            key = key.substring(0, 16);  // Recortar a 16 bytes
        }

        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        
        // Generar un IV aleatorio de 16 bytes
        byte[] iv = new byte[16]; // AES requiere un IV de 16 bytes
        new java.security.SecureRandom().nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        
        // Crear el objeto Cipher para realizar la encriptación
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        
        // Realizar la encriptación
        byte[] encrypted = cipher.doFinal(text.getBytes());
        
        // Convertir el IV y el texto cifrado a Base64 para almacenarlos
        String ivBase64 = Base64.getEncoder().encodeToString(iv);
        String encryptedTextBase64 = Base64.getEncoder().encodeToString(encrypted);
        
        // Devolver el IV y el texto cifrado en Base64, separados por ':'
        return ivBase64 + ":" + encryptedTextBase64;
    }

    /**
     * Desencripta un texto previamente encriptado utilizando AES en modo CBC con la clave proporcionada.
     * 
     * @param encryptedText El texto encriptado en formato Base64, que incluye el IV y el texto cifrado, separados por un ':'.
     * @param key La clave de 16 bytes para la desencriptación.
     * @return El texto desencriptado.
     * @throws Exception Si ocurre algún error durante el proceso de desencriptación.
     */
    public static String decrypt(String encryptedText, String key) throws Exception {
        // Asegurarse de que la clave tenga 16 bytes
        if (key.length() < 16) {
            key = String.format("%-16s", key);  // Rellenar con espacios hasta 16 bytes
        } else if (key.length() > 16) {
            key = key.substring(0, 16);  // Recortar a 16 bytes
        }

        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

        // Separar el IV del texto cifrado
        String[] parts = encryptedText.split(":");

        if (parts.length != 2) {
            throw new IllegalArgumentException("El formato del texto cifrado es incorrecto.");
        }

        byte[] iv = Base64.getDecoder().decode(parts[0]); // IV
        byte[] encrypted = Base64.getDecoder().decode(parts[1]); // Texto cifrado

        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Crear el objeto Cipher para realizar la desencriptación
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        // Realizar la desencriptación
        byte[] decrypted = cipher.doFinal(encrypted);
        
        // Convertir el resultado a cadena de texto
        return new String(decrypted);
    }
}




