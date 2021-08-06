/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public abstract class ExecuteSQL {
    
    private Connection conexao;
    private Statement statement;
    private PreparedStatement preStatement;
    private ResultSet resultset;

    public ExecuteSQL(Connection conexao) {
        this.conexao = conexao;
    }
    
    protected ResultSet listar(String sql) {
        try {
            preStatement = conexao.prepareStatement(sql); 
            resultset = preStatement.executeQuery();
        } catch (SQLException sqlex) {
            System.out.println("Não foi possível"
                    + "executar o comando" + sqlex + ", o sql passado foi" + sql);
        }
        return resultset;
    }
    
    protected ResultSet listar(String sql, String valor) {
        try {
            preStatement = conexao.prepareStatement(sql);
            preStatement.setString(1, valor); 
            resultset = preStatement.executeQuery();
        } catch (SQLException sqlex) {
            System.out.println("Não foi possível"
                    + "executar o comando" + sqlex + ", o sql passado foi" + sql);
        }
        return resultset;
    }
    
    protected ResultSet listar(String sql, String[] valores) {
        try {
            preStatement = conexao.prepareStatement(sql);
            for(int i=0;i<valores.length;i++){
               preStatement.setString(i+1, valores[i]); 
            }
            resultset = preStatement.executeQuery();
        } catch (SQLException sqlex) {
            System.out.println("Não foi possível"
                    + "executar o comando" + sqlex + ", o sql passado foi" + sql);
        }
        return resultset;
    }
    
    protected boolean executar(String sql, String valor){
        int resposta = 0;
        try {
            preStatement = conexao.prepareStatement(sql);
            preStatement.setString(1, valor); 
            resposta = preStatement.executeUpdate();
        } catch (SQLException sqlex) {
            System.out.println("Não foi possível"
                    + "executar o comando" + sqlex + ", o sql passado foi" + sql);
        }
        if(resposta > 0 )
            return true;
        else
            return false;
    }
    
    protected boolean executar(String sql, String[] valores){
        int resposta = 0;
        try {
            preStatement = conexao.prepareStatement(sql);
            for(int i=0;i<valores.length;i++){
               preStatement.setString(i+1, valores[i]); 
            }
            resposta = preStatement.executeUpdate();
        } catch (SQLException sqlex) {
            System.out.println("Não foi possível"
                    + "executar o comando" + sqlex + ", o sql passado foi" + sql);
        }
        if(resposta > 0 )
            return true;
        else
            return false;
    }
    
}
