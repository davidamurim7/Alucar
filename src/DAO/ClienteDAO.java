/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class ClienteDAO extends ExecuteSQL {

    public ClienteDAO(Connection conexao) {
        super(conexao);
    }

    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<>();
        ResultSet rs = listar("SELECT * FROM tb_cliente ORDER BY nome_cliente");
        try {
            if (rs != null) {
                while (rs.next()) {
                    Cliente c = new Cliente(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7)
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

    public Cliente selecionaCliente(String cpf) {
        ResultSet rs = listar("SELECT * FROM tb_cliente WHERE cpf_cliente = ?", cpf);
        Cliente c = new Cliente();
        try {
            if (rs != null) {
                while (rs.next()) {
                    c.setId(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setDataNascimento(rs.getDate(3));
                    c.setCpf(rs.getString(4));
                    c.setTelefone(rs.getString(5));
                    c.setEmail(rs.getString(6));
                    c.setEndereco(rs.getString(7));
                }
                return c;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public Cliente selecionaCliente(int id) {
        ResultSet rs = listar("SELECT * FROM tb_cliente WHERE id_cliente = ?", String.valueOf(id));
        Cliente c = new Cliente();
        try {
            if (rs != null) {
                while (rs.next()) {
                    c.setId(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setDataNascimento(rs.getDate(3));
                    c.setCpf(rs.getString(4));
                    c.setTelefone(rs.getString(5));
                    c.setEmail(rs.getString(6));
                    c.setEndereco(rs.getString(7));
                }
                return c;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean addCliente(Cliente c) {
        String dados[] = new String[]{
            c.getNome(),
            new SimpleDateFormat("yyyy-MM-dd").format(c.getDataNascimento()),
            c.getCpf(),
            c.getTelefone(),
            c.getEmail(),
            c.getEndereco()
        };
        return executar("INSERT INTO tb_cliente (nome_cliente, data_nascimento_cliente, cpf_cliente, telefone_cliente, email_cliente, endereco_cliente) VALUES (?,?,?,?,?,?)", dados);
    }

    public boolean altCliente(Cliente c) {
        String dados[] = new String[]{
            String.valueOf(c.getNome()),
            String.valueOf(c.getDataNascimento()),
            String.valueOf(c.getTelefone()),
            String.valueOf(c.getEmail()),
            String.valueOf(c.getEndereco()),
            String.valueOf(c.getCpf()),};
        return executar("UPDATE tb_cliente SET nome_cliente = ?, data_nascimento_cliente = ? , telefone_cliente = ? , email_cliente = ?, endereco_cliente = ? WHERE cpf_cliente = ?", dados);
    }

    public boolean delCliente(Cliente c) {

        return executar("DELETE FROM tb_cliente WHERE cpf_cliente = ?", c.getCpf());
    }

    public boolean existeCliente(String cpf) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_cliente WHERE cpf_cliente = ?", cpf);
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
