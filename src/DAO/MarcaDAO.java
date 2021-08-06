/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Marca;
import Model.Modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class MarcaDAO extends ExecuteSQL{
    
    public MarcaDAO(Connection conexao) {
        super(conexao);
    }
    
    public List<Marca> listarMarcas() {
        List<Marca> lista = new ArrayList<>();
        ResultSet rs = listar("SELECT * FROM tb_marca ORDER BY nome_marca");
        try {
            if (rs != null) {
                while (rs.next()) {
                    Marca c = new Marca(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3)
                    );
                    lista.add(c);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public int retornaIdMarca(String nome) {
        ResultSet rs = listar("SELECT id_marca FROM tb_marca WHERE nome_marca = ?", nome);
        int id = -1;
        try {
            if (rs != null) {
                while (rs.next()) {
                    id = rs.getInt(1);
                }
            }  
 
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return id;
    }
    
    public Marca selecionaMarca(int id) {
        ResultSet rs = listar("SELECT * FROM tb_marca WHERE id_marca = ?", String.valueOf(id));
        Marca m = new Marca();
        try {
            if (rs != null) {
                while (rs.next()) {
                    m.setId(rs.getInt(1));
                    m.setNome(rs.getString(2));
                    m.setDescricao(rs.getString(3));
                }
                return m;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Marca selecionaMarca(String nome) {
        ResultSet rs = listar("SELECT * FROM tb_marca WHERE nome_marca = ?",nome);
        Marca m = new Marca();
        try {
            if (rs != null) {
                while (rs.next()) {
                    m.setId(rs.getInt(1));
                    m.setNome(rs.getString(2));
                    m.setDescricao(rs.getString(3));
                }
                return m;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean addMarca(Marca m) { 
        String dados[];
        dados = new String[]{
            m.getNome(),
            m.getDescricao()
        };
        return executar("INSERT INTO tb_marca (nome_marca, descricao_marca) VALUES (?,?)", dados);
    }
    
    public boolean altMarca(Marca m) { 
        String dados[] = new String[]{
            m.getDescricao(),
            m.getNome()
        };
        return executar("UPDATE tb_marca SET descricao_marca = ? WHERE nome_marca = ?", dados);
    }

    public boolean delMarca(Marca m) {
        
        return executar("DELETE FROM tb_marca WHERE nome_marca = ?", m.getNome());
    }
    
    public boolean existeNomeMarca(String nome) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_marca WHERE nome_marca = ?", nome);
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