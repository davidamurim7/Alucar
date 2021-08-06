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
public class Carro {
    private int id; 
    private double valorDiaria;
    private String cor;
    private String placa; 
    private int km;
    private int fabricacao;
    private String blindagem; 
    private String foto;
    private int idModelo;

    public Carro(int id, double valorDiaria, String cor, String placa, int km, int fabricacao, String blindagem, String foto, int idModelo) {
        this.id = id;
        this.valorDiaria = valorDiaria;
        this.cor = cor;
        this.placa = placa;
        this.km = km;
        this.fabricacao = fabricacao;
        this.blindagem = blindagem;
        this.foto = foto;
        this.idModelo = idModelo;
    }

    public Carro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(int fabricacao) {
        this.fabricacao = fabricacao;
    }

    public String getBlindagem() {
        return blindagem;
    }

    public void setBlindagem(String blindagem) {
        this.blindagem = blindagem;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }
}
