/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class UsuarioDAO extends FuncionarioDAO{
    
    public UsuarioDAO(Connection conexao) {
        super(conexao);
    }
    
    public boolean logarUsuario(String login, String senha) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_funcionario WHERE login_funcionario = ? AND senha_funcionario = ?", new String[]{login, senha});
        try {
            if (rs != null) {
                while (rs.next()) {
                    Usuario.setIdUser(rs.getInt(1));
                    Usuario.setNomeUser(rs.getString(2));
                    Usuario.setLoginUser(rs.getString(3));
                    Usuario.setSenhaUser(rs.getString(4));
                    Usuario.setNivelUser(rs.getString(5));
                    Usuario.setAtivoUser(rs.getString(6));
                    existe = true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return existe;
    }
    
    
    
}
