/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Camila
 */
public class ModeloDAO extends ExecuteSQL{
    

    public ModeloDAO(Connection conexao) {
        super(conexao);
    }

    public List<Modelo> listarModelo() {
        List<Modelo> lista = new ArrayList<>();
        ResultSet rs = listar("SELECT * FROM tb_modelo ORDER BY nome_modelo");
        try {
            if (rs != null) {
                while (rs.next()) {
                    Modelo m = new Modelo(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5)
                    );
                    lista.add(m);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public Modelo selecionaModelo(String nome) {
        ResultSet rs = listar("SELECT * FROM tb_modelo WHERE nome_modelo = ?", nome);
        Modelo m = new Modelo();
        try {
            if (rs != null) {
                while (rs.next()) {
                    m.setId(rs.getInt(1));
                    m.setNome(rs.getString(2));
                    m.setDescricao(rs.getString(3));
                    m.setPorte(rs.getString(4));
                    m.setIdMarca(rs.getInt(5));
                }
                return m;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Modelo selecionaModelo(int id) {
        ResultSet rs = listar("SELECT * FROM tb_modelo WHERE id_modelo = ?", String.valueOf(id));
        Modelo m = new Modelo();
        try {
            if (rs != null) {
                while (rs.next()) {
                    m.setId(rs.getInt(1));
                    m.setNome(rs.getString(2));
                    m.setDescricao(rs.getString(3));
                    m.setPorte(rs.getString(4));
                    m.setIdMarca(rs.getInt(5));
                }
                return m;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean addModelo(Modelo m) { 
        String dados[] = new String[]{
            m.getNome(),
            m.getDescricao(),
            m.getPorte(),
            String.valueOf(m.getIdMarca())
        };
        return executar("INSERT INTO tb_modelo (nome_modelo, descricao_modelo, porte_modelo, id_marca_modelo) VALUES (?,?,?,?)", dados);
    }
    
    public boolean altModelo(Modelo m) { 
        String dados[] = new String[]{
            m.getDescricao(),
            m.getPorte(),
            String.valueOf(m.getIdMarca()),
            m.getNome()
        };
        return executar("UPDATE tb_modelo SET descricao_modelo = ?, porte_modelo = ?, id_marca_modelo = ? WHERE nome_modelo = ?", dados);
    }

    public boolean delModelo(Modelo m) {
        
        return executar("DELETE FROM tb_modelo WHERE nome_modelo = ?", m.getNome());
    }
    
    public boolean existeNomeModelo(String nome) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_modelo WHERE nome_modelo = ?", nome);
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