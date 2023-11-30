/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author michel.matos
 */
public class Compra {
    
    private int CodCompra; 
    private String DataCompra; 
    private String DataEntregaCompra; 
    private int NumeroNFCompra; 
    private double ValorNFCompra; 
    private String FormaPagamentoCompra; 
    private int CodFornecedor; // Herdado
    
    private int codMedAnterior; // ********************************************* VERIFICAR ATRIBUTO DE ARMAZENAMENTO DE HISTÓRICO

    /**
     * @return the codMedAnterior
     */
    public int getCodMedAnterior() {
        return codMedAnterior;
    }

    /**
     * @param codMedAnterior the codMedAnterior to set
     */
    public void setCodMedAnterior(int codMedAnterior) {
        this.codMedAnterior = codMedAnterior;
    }

    /**
     * @return the CodCompra
     */
    public int getCodCompra() {
        return CodCompra;
    }

    /**
     * @param CodCompra the CodCompra to set
     */
    public void setCodCompra(int CodCompra) {
        this.CodCompra = CodCompra;
    }

    /**
     * @return the CodFornecedor
     */
    public int getCodFornecedor() {
        return CodFornecedor;
    }

    /**
     * @param CodFornecedor the CodFornecedor to set
     */
    public void setCodFornecedor(int CodFornecedor) {
        this.CodFornecedor = CodFornecedor;
    }

    /**
     * @return the DataCompra
     */
    public String getDataCompra() {
        return DataCompra;
    }

    /**
     * @param DataCompra the DataCompra to set
     */
    public void setDataCompra(String DataCompra) {
        this.DataCompra = DataCompra;
    }

    /**
     * @return the DataEntregaCompra
     */
    public String getDataEntregaCompra() {
        return DataEntregaCompra;
    }

    /**
     * @param DataEntregaCompra the DataEntregaCompra to set
     */
    public void setDataEntregaCompra(String DataEntregaCompra) {
        this.DataEntregaCompra = DataEntregaCompra;
    }

    /**
     * @return the NumeroNFCompra
     */
    public int getNumeroNFCompra() {
        return NumeroNFCompra;
    }

    /**
     * @param NumeroNFCompra the NumeroNFCompra to set
     */
    public void setNumeroNFCompra(int NumeroNFCompra) {
        this.NumeroNFCompra = NumeroNFCompra;
    }

    /**
     * @return the ValorNFCompra
     */
    public double getValorNFCompra() {
        return ValorNFCompra;
    }

    /**
     * @param ValorNFCompra the ValorNFCompra to set
     */
    public void setValorNFCompra(double ValorNFCompra) {
        this.ValorNFCompra = ValorNFCompra;
    }
    
    /**
     * @return the FormaPagamentoCompra
     */
    public String getFormaPagamentoCompra() {
        return FormaPagamentoCompra;
    }

    /**
     * @param FormaPagamentoCompra the FormaPagamentoCompra to set
     */
    public void setFormaPagamentoCompra(String FormaPagamentoCompra) {
        this.FormaPagamentoCompra = FormaPagamentoCompra;
    }
}
