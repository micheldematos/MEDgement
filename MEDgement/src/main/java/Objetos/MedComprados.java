/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.util.List;

/**
 *
 * @author user_acronus
 */
public class MedComprados {
    
    private String datacompra;   // DATE NOT NULL,
    private Double valorUnMed;   // NUMERIC(10,2) NOT NULL,
    private double valorComp;    // NUMERIC(10,2) NOT NULL,
    private int quantidademed;   // INT NOT NULL,
    private int codmedicamento;  // INT NOT NULL,
    private int codcompra;       // INT NOT NULL,
    
    public Double getValorUnMed() {
        return valorUnMed;
    }
    
    public void setValorUnMed(Double valorUnMed) {
        this.valorUnMed = valorUnMed;
    }
    
    public double getValorComp() {
        return valorComp;
    }
    
    public void setValorComp(double valorComp) {
        this.valorComp = valorComp;
    }    
    
    public String getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(String datacompra) {
        this.datacompra = datacompra;
    }

    public int getQuantidademed() {
        return quantidademed;
    }

    public void setQuantidademed(int quantidademed) {
        this.quantidademed = quantidademed;
    }

    public int getCodmedicamento() {
        return codmedicamento;
    }

    public void setCodmedicamento(int codmedicamento) {
        this.codmedicamento = codmedicamento;
    }

    public int getCodcompra() {
        return codcompra;
    }

    public void setCodcompra(int codcompra) {
        this.codcompra = codcompra;
    }
}
