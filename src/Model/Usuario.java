/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author David
 */
public class Usuario {
    
    private static int idUser;
    private static String nomeUser;
    private static String loginUser;
    private static String senhaUser;
    private static String nivelUser;
    private static String ativoUser;

    public Usuario() {
    }

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        Usuario.idUser = idUser;
    }

    public static String getNomeUser() {
        return nomeUser;
    }

    public static void setNomeUser(String nomeUser) {
        Usuario.nomeUser = nomeUser;
    }

    public static String getLoginUser() {
        return loginUser;
    }

    public static void setLoginUser(String loginUser) {
        Usuario.loginUser = loginUser;
    }

    public static String getSenhaUser() {
        return senhaUser;
    }

    public static void setSenhaUser(String senhaUser) {
        Usuario.senhaUser = senhaUser;
    }

    public static String getNivelUser() {
        return nivelUser;
    }

    public static void setNivelUser(String nivelUser) {
        Usuario.nivelUser = nivelUser;
    }
    
    public static String getAtivoUser() {
        return ativoUser;
    }

    public static void setAtivoUser(String ativoUser) {
        Usuario.ativoUser = ativoUser;
    }
    
    
}
