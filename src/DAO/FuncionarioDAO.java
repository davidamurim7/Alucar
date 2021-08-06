/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Funcionario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class FuncionarioDAO extends ExecuteSQL {

    public FuncionarioDAO(Connection conexao) {
        super(conexao);
    }

    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> lista = new ArrayList<>();
        ResultSet rs = listar("SELECT * FROM tb_funcionario ORDER BY ativo_funcionario, nome_funcionario");
        try {
            if (rs != null) {
                while (rs.next()) {
                    Funcionario f = new Funcionario(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6)
                    );
                    lista.add(f);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public Funcionario selecionaFuncionario(String nome) {
        ResultSet rs = listar("SELECT * FROM tb_funcionario WHERE nome_funcionario = ?", nome);
        Funcionario f = new Funcionario();
        try {
            if (rs != null) {
                while (rs.next()) {
                    f.setId(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setLogin(rs.getString(3));
                    f.setSenha(rs.getString(4));
                    f.setNivel(rs.getString(5));
                    f.setAtivo(rs.getString(6));
                }
                return f;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Funcionario selecionaFuncionario(int id) {
        ResultSet rs = listar("SELECT * FROM tb_funcionario WHERE id_funcionario = ?", String.valueOf(id));
        Funcionario f = new Funcionario();
        try {
            if (rs != null) {
                while (rs.next()) {
                    f.setId(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setLogin(rs.getString(3));
                    f.setSenha(rs.getString(4));
                    f.setNivel(rs.getString(5));
                    f.setAtivo(rs.getString(6));
                }
                return f;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean addFuncionario(Funcionario f) { 
        String dados[] = new String[]{
            f.getNome(),
            f.getLogin(),
            f.getSenha(),
            f.getNivel(),
            f.getAtivo()
        };
        return executar("INSERT INTO tb_funcionario (nome_funcionario, login_funcionario, senha_funcionario, nivel_funcionario, ativo_funcionario) VALUES (?,?,?,?,?)", dados);
    }
    
    public boolean altFuncionario(Funcionario f) { 
        String dados[] = new String[]{
            f.getLogin(),
            f.getSenha(),
            f.getNivel(),
            f.getAtivo(),
            f.getNome()
        };
        return executar("UPDATE tb_funcionario SET login_funcionario = ?, senha_funcionario = ?, nivel_funcionario = ? , ativo_funcionario = ? WHERE nome_funcionario = ?", dados);
    }

    public boolean delFuncionario(Funcionario f) {
        
        return executar("DELETE FROM tb_funcionario WHERE nome_funcionario = ?", f.getNome());
    }
    
    public boolean existeLoginFuncionario(String login) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_funcionario WHERE login_funcionario = ?", login);
        try {
            if (rs != null) {
                while (rs.next()) {
                    existe = true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return existe;
    }
    
    public boolean existeNomeFuncionario(String nome) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_funcionario WHERE nome_funcionario = ?", nome);
        try {
            if (rs != null) {
                while (rs.next()) {
                    existe = true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return existe;
    }
}
