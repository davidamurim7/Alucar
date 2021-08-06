/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Aluguel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class AluguelDAO extends ExecuteSQL{
    
    public AluguelDAO(Connection conexao) {
        super(conexao);
        
    }
    
    public List<Aluguel> listarAlugueis() {
        List<Aluguel> lista = new ArrayList<>();
        ResultSet rs = listar("SELECT * FROM tb_aluguel ORDER BY data_aluguel");
        try {
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getBoolean(4),
                            rs.getInt(5),
                            rs.getInt(6),
                            rs.getInt(7)
                    );
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean addAluguel(Aluguel f) { 
        String dados[] = new String[]{
            f.getDataAluguel(),
            f.getDataDevolucao(),
            f.getFinalizar() ? "1" : "0",
            String.valueOf(f.getIdCliente()),
            String.valueOf(f.getIdFuncionario()),
            String.valueOf(f.getIdCarro())
        };
        return executar("INSERT INTO tb_aluguel (data_aluguel, data_devolucao_aluguel, finalizar_aluguel, id_cliente_aluguel, id_funcionario_aluguel, id_carro_aluguel) VALUES (?,?,?,?,?,?)", dados);
    }
    
    public boolean altAluguel(Aluguel f) { 
        String dados[] = new String[]{
            f.getDataAluguel(),
            f.getDataDevolucao(),
            String.valueOf(f.getIdCliente()),
            String.valueOf(f.getIdFuncionario()),
            String.valueOf(f.getIdCarro())
        };
        return executar("UPDATE tb_aluguel SET data_aluguel = ?, data_devolucao_aluguel = ?, id_cliente_aluguel = ?, id_funcionario_aluguel = ? WHERE finalizar_aluguel = '0' AND id_carro_aluguel = ?", dados);
    }
    
    public boolean existeAluguel(int id_carro) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_aluguel WHERE finalizar_aluguel = '0' AND id_carro_aluguel = ?", String.valueOf(id_carro));
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
    
    public Aluguel selecionaAluguel(int id_carro) {
        ResultSet rs = listar("SELECT * FROM tb_aluguel WHERE finalizar_aluguel = '0' AND id_carro_aluguel = ?", String.valueOf(id_carro));
        Aluguel a = new Aluguel();
        try {
            if (rs != null) {
                while (rs.next()) {
                    a.setId(rs.getInt(1));
                    a.setDataAluguel(rs.getString(2));
                    a.setDataDevolucao(rs.getString(3));
                    a.setFinalizar(rs.getBoolean(4));
                    a.setIdCliente(rs.getInt(5));
                    a.setIdFuncionario(rs.getInt(6));
                    a.setIdCarro(rs.getInt(7));
                }
                return a;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean finAluguel(int id_carro) {
        
        return executar("UPDATE tb_aluguel SET finalizar_aluguel = '1' WHERE id_carro_aluguel = ?", String.valueOf(id_carro));
    }
    
    public boolean delAluguel(int id_carro) {
        
        return executar("DELETE FROM tb_aluguel WHERE finalizar_aluguel = '0' AND id_carro_aluguel = ?", String.valueOf(id_carro));
    }
}
