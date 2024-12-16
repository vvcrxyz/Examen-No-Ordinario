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

public class Encriptado {

    // Método para encriptar texto con AES CBC
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
        
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        
        byte[] encrypted = cipher.doFinal(text.getBytes());
        
        // Convertir el IV y el texto cifrado a Base64 para almacenarlo
        String ivBase64 = Base64.getEncoder().encodeToString(iv);
        String encryptedTextBase64 = Base64.getEncoder().encodeToString(encrypted);
        
        // Devolver el IV junto con el texto cifrado, separados por un separador
        return ivBase64 + ":" + encryptedTextBase64;
    }

    // Método para desencriptar el teléfono utilizando la clave proporcionada
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

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        byte[] decrypted = cipher.doFinal(encrypted);
        return new String(decrypted);
    }

}

