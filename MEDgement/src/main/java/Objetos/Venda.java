/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author michel.matos
 */
public class Venda {
    
    private int codpedido;
    private String datavenda;
    private String formapagamentovenda;
    private Double valorpedidovenda;
    private int coddrogaria;
    private int emissaoNf;

    /**
     * @return the emissaoNf
     */
    public int getEmissaoNf() {
        return emissaoNf;
    }

    /**
     * @param emissaoNf the emissaoNf to set
     */
    public void setEmissaoNf(int emissaoNf) {
        this.emissaoNf = emissaoNf;
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
     * @return the formapagamentovenda
     */
    public String getFormapagamentovenda() {
        return formapagamentovenda;
    }

    /**
     * @param formapagamentovenda the formapagamentovenda to set
     */
    public void setFormapagamentovenda(String formapagamentovenda) {
        this.formapagamentovenda = formapagamentovenda;
    }

    /**
     * @return the valorpedidovenda
     */
    public Double getValorpedidovenda() {
        return valorpedidovenda;
    }

    /**
     * @param valorpedidovenda the valorpedidovenda to set
     */
    public void setValorpedidovenda(Double valorpedidovenda) {
        this.valorpedidovenda = valorpedidovenda;
    }

    /**
     * @return the coddrogaria
     */
    public int getCoddrogaria() {
        return coddrogaria;
    }

    /**
     * @param coddrogaria the coddrogaria to set
     */
    public void setCoddrogaria(int coddrogaria) {
        this.coddrogaria = coddrogaria;
    }
}
