/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Carro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class CarroDAO extends ExecuteSQL{
    
    public CarroDAO(Connection conexao) {
        super(conexao);
    }
    
    public List<Carro> listarCarro() {
        List<Carro> lista = new ArrayList<>();
        ResultSet rs = listar("SELECT * FROM tb_carro ORDER BY placa_carro");
        try {
            if (rs != null) {
                while (rs.next()) {
                    Carro c = new Carro(
                            rs.getInt(1),
                            rs.getDouble(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getInt(9)
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
    
    public boolean addCarro(Carro c) { 
        String dados[] = new String[]{
            String.valueOf(c.getValorDiaria()),
            c.getCor(),
            c.getPlaca(),
            String.valueOf(c.getKm()),
            String.valueOf(c.getFabricacao()),
            c.getBlindagem(),
            c.getFoto(),
            String.valueOf(c.getIdModelo())
        };
        return executar("INSERT INTO tb_carro (valor_diaria_carro, cor_carro, placa_carro, km_carro, fabricacao_carro, blindagem_carro, foto_carro, id_modelo_carro) VALUES (?,?,?,?,?,?,?,?)", dados);
    }
    
    public boolean altCarro(Carro c) { 
        String dados[] = new String[]{
            String.valueOf(c.getValorDiaria()),
            c.getCor(),
            String.valueOf(c.getKm()),
            String.valueOf(c.getFabricacao()),
            c.getBlindagem(),
            c.getFoto(),
            String.valueOf(c.getIdModelo()),
            c.getPlaca(),
        };
        return executar("UPDATE tb_carro SET valor_diaria_carro = ?, cor_carro = ?, km_carro = ? , fabricacao_carro = ? , blindagem_carro = ?, foto_carro = ? , id_modelo_carro = ?  WHERE placa_carro = ?", dados);
    }
    
    public boolean delCarro(Carro c) {
        
        return executar("DELETE FROM tb_carro WHERE placa_carro = ?", c.getPlaca());
    }
    
    public boolean existeCarro(String placa) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_carro WHERE placa_carro = ?", placa);
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
    
    public Carro selecionaCarro(String placa) {
        ResultSet rs = listar("SELECT * FROM tb_carro WHERE placa_carro = ?", placa);
        Carro c = new Carro();
        try {
            if (rs != null) {
                while (rs.next()) {
                    c.setId(rs.getInt(1));
                    c.setValorDiaria(rs.getDouble(2));
                    c.setCor(rs.getString(3));
                    c.setPlaca(rs.getString(4));
                    c.setKm(rs.getInt(5));
                    c.setFabricacao(rs.getInt(6));
                    c.setBlindagem(rs.getString(7));
                    c.setFoto(rs.getString(8));
                    c.setIdModelo(rs.getInt(9));
                }
                return c;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Carro selecionaCarro(int id) {
        ResultSet rs = listar("SELECT * FROM tb_carro WHERE id_carro = ?", String.valueOf(id));
        Carro c = new Carro();
        try {
            if (rs != null) {
                while (rs.next()) {
                    c.setId(rs.getInt(1));
                    c.setValorDiaria(rs.getDouble(2));
                    c.setCor(rs.getString(3));
                    c.setPlaca(rs.getString(4));
                    c.setKm(rs.getInt(5));
                    c.setFabricacao(rs.getInt(6));
                    c.setBlindagem(rs.getString(7));
                    c.setFoto(rs.getString(8));
                    c.setIdModelo(rs.getInt(9));
                }
                return c;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
