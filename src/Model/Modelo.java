/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author marcelo
 */
public class Modelo {
    private int id; 
    private String nome;
    private String descricao; 
    private String porte;
    private int idMarca; 

    public Modelo(int id, String nome, String descricao, String porte, int idMarca) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.porte = porte;
        this.idMarca = idMarca;
    }

    public Modelo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
 
}
