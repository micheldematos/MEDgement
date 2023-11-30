/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author michel.matos
 */
public class Usuario {

    /**
     * @return the codusuario
     */
    public int getCodusuario() {
        return codusuario;
    }

    /**
     * @param codusuario the codusuario to set
     */
    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    /**
     * @return the senhausuario
     */
    public String getSenhausuario() {
        return senhausuario;
    }

    /**
     * @param senhausuario the senhausuario to set
     */
    public void setSenhausuario(String senhausuario) {
        this.senhausuario = senhausuario;
    }

    /**
     * @return the nomecompleto
     */
    public String getNomecompleto() {
        return nomecompleto;
    }

    /**
     * @param nomecompleto the nomecompleto to set
     */
    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the tipousuario
     */
    public int getTipousuario() {
        return tipousuario;
    }

    /**
     * @param tipousuario the tipousuario to set
     */
    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
    }

    /**
     * @return the situacaousuario
     */
    public int getSituacaousuario() {
        return situacaousuario;
    }

    /**
     * @param situacaousuario the situacaousuario to set
     */
    public void setSituacaousuario(int situacaousuario) {
        this.situacaousuario = situacaousuario;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    private int codusuario;
    private String senhausuario;
    private String nomecompleto;
    private String cpf;
    private int tipousuario;
    private int situacaousuario;
    private String cargo;
    
}
