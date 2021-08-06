/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author David
 */
public class Metodos {
    
    public static String transDataHoraIngPort(String dataHora){
        String[] d = dataHora.split(" ");
        String[] d1 = d[0].split("-");
        String d2 = d[1].substring(0,8);
        return d1[2]+"/"+d1[1]+"/"+d1[0]+"  "+d2;
    }
    
    public static String transDataIngPort(String data){
        String[] d = data.split("-");
        return d[2]+"/"+d[1]+"/"+d[0];
    }
    
    public static boolean validarEmail(String email) {
        if ((email == null) || (email.trim().length() == 0)) {
            return false;
        }
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static void copiarArquivo(File arquivo, File destino) throws IOException {
        if (destino.exists()) {
            destino.delete();
        }
        FileChannel arquivoChannel = null;
        FileChannel destinoChannel = null;
        try {
            arquivoChannel = new FileInputStream(arquivo).getChannel();
            destinoChannel = new FileOutputStream(destino).getChannel();
            arquivoChannel.transferTo(0, arquivoChannel.size(),
                    destinoChannel);
        } finally {
            if (arquivoChannel != null && arquivoChannel.isOpen()) {
                arquivoChannel.close();
            }
            if (destinoChannel != null && destinoChannel.isOpen()) {
                destinoChannel.close();
            }
        }
    }
}
