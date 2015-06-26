/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.Criptografia;

import Entidades.CartãoDeCredito;
import de.flexiprovider.api.keys.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author xulipaxulepa
 */
public class ConversorUtil {

    public String converteHexadecimalParaString(byte[] valorHexadecial) {
        StringBuilder valorConvertido = new StringBuilder();
        for (byte caracter : valorHexadecial) {
            valorConvertido.append(String.format("%02x", 0xFF & caracter));

        }
        return valorConvertido.toString();
    }

    public String ConverteMD5(String texto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algoritmo = MessageDigest.getInstance("MD5");
        byte[] codigoHashHexaDecial = algoritmo.digest(texto.getBytes("UTF-8"));
        String codigoHashFinal = converteHexadecimalParaString(codigoHashHexaDecial);
        return (codigoHashFinal);
    }

    public String EncriptaCipher(CartãoDeCredito cartao) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        byte[] mensagem = cartao.getNumeroCartão().getBytes();

        // Usando chave de 128-bits (16 bytes)
        byte[] chave = "chave de 16bytes".getBytes();
        
        // Encriptando...
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"));
        byte[] encrypted = cipher.doFinal(mensagem);
        return Arrays.toString(mensagem);
    }
    
    public String DesencriptaCipher(CartãoDeCredito cartao) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        byte[] mensagem = cartao.getNumeroCartão().getBytes();

        // Usando chave de 128-bits (16 bytes)
        byte[] chave = "chave de 16bytes".getBytes();
        byte[] encrypted = cipher.doFinal(mensagem);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(chave, "AES"));
            byte[] decrypted = cipher.doFinal(encrypted);
 
            return(new String(decrypted));

    }
}
