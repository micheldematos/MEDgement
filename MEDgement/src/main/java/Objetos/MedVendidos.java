/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author miche
 */
public class MedVendidos {
    
    private String datavenda; // DATE NOT NULL,
    private double valorUnMed; // NUMERIC(10,2) NOT NULL,
    private double valorvenda; // NUMERIC(10,2) NOT NULL,
    private int quantidademed; // INT NOT NULL,
    private int codmedicamento; // INT NOT NULL,
    private int codpedido; // INT NOT NULL,

    /**
     * @return the datavenda
     */
    public String getDatavenda() {
        return datavenda;
    }

    /**
     * @param datavenda the datavenda to set
     */
    public void setDatavenda(String datavenda) {
        this.datavenda = datavenda;
    }

    /**
     * @return the valorUnMed
     */
    public double getValorUnMed() {
        return valorUnMed;
    }

    /**
     * @param valorUnMed the valorUnMed to set
     */
    public void setValorUnMed(double valorUnMed) {
        this.valorUnMed = valorUnMed;
    }

    /**
     * @return the valorvenda
     */
    public double getValorvenda() {
        return valorvenda;
    }

    /**
     * @param valorvenda the valorvenda to set
     */
    public void setValorvenda(double valorvenda) {
        this.valorvenda = valorvenda;
    }

    /**
     * @return the quantidademed
     */
    public int getQuantidademed() {
        return quantidademed;
    }

    /**
     * @param quantidademed the quantidademed to set
     */
    public void setQuantidademed(int quantidademed) {
        this.quantidademed = quantidademed;
    }

    /**
     * @return the codmedicamento
     */
    public int getCodmedicamento() {
        return codmedicamento;
    }

    /**
     * @param codmedicamento the codmedicamento to set
     */
    public void setCodmedicamento(int codmedicamento) {
        this.codmedicamento = codmedicamento;
    }

    /**
     * @return the codpedido
     */
    public int getCodpedido() {
        return codpedido;
    }

    /**
     * @param codpedido the codpedido to set
     */
    public void setCodpedido(int codpedido) {
        this.codpedido = codpedido;
    }
}
