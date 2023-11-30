/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author michel.matos
 */
public class Medicamento {
    
    private int codmedicamento;
    private String nomemedicamento;
    private String descricaomedicamento;
    private String dataultimacompra;
    private Double valorcusto;
    private Double valorvenda;
    private int situacaomed = 1;
    private int quantidadeestoque;
    private int codfornecedor;

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
     * @return the nomemedicamento
     */
    public String getNomemedicamento() {
        return nomemedicamento;
    }

    /**
     * @param nomemedicamento the nomemedicamento to set
     */
    public void setNomemedicamento(String nomemedicamento) {
        this.nomemedicamento = nomemedicamento;
    }

    /**
     * @return the descricaomedicamento
     */
    public String getDescricaomedicamento() {
        return descricaomedicamento;
    }

    /**
     * @param descricaomedicamento the descricaomedicamento to set
     */
    public void setDescricaomedicamento(String descricaomedicamento) {
        this.descricaomedicamento = descricaomedicamento;
    }

    /**
     * @return the dataultimacompra
     */
    public String getDataultimacompra() {
        return dataultimacompra;
    }

    /**
     * @param dataultimacompra the dataultimacompra to set
     */
    public void setDataultimacompra(String dataultimacompra) {
        this.dataultimacompra = dataultimacompra;
    }

    /**
     * @return the valorcusto
     */
    public Double getValorcusto() {
        return valorcusto;
    }

    /**
     * @param valorcusto the valorcusto to set
     */
    public void setValorcusto(Double valorcusto) {
        this.valorcusto = valorcusto;
    }

    /**
     * @return the valorvenda
     */
    public Double getValorvenda() {
        return valorvenda;
    }

    /**
     * @param valorvenda the valorvenda to set
     */
    public void setValorvenda(Double valorvenda) {
        this.valorvenda = valorvenda;
    }

    /**
     * @return the situacaomed
     */
    public int getSituacaomed() {
        return situacaomed;
    }

    /**
     * @param situacaomed the situacaomed to set
     */
    public void setSituacaomed(int situacaomed) {
        this.situacaomed = situacaomed;
    }

    /**
     * @return the quantidadeestoque
     */
    public int getQuantidadeestoque() {
        return quantidadeestoque;
    }

    /**
     * @param quantidadeestoque the quantidadeestoque to set
     */
    public void setQuantidadeestoque(int quantidadeestoque) {
        this.quantidadeestoque = quantidadeestoque;
    }
    
    public int getCodfornecedor() {
        return codfornecedor;
    }
    
    public void setCodfornecedor(int codfornecedor) {
        this.codfornecedor = codfornecedor;
    }
}
