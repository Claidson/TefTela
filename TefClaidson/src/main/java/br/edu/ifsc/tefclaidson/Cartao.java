/*
 * Que a forÃ§a esteja com vocÃª
 */
package br.edu.ifsc.tefclaidson;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Claidson
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cartao")
public class Cartao implements Serializable {

    private int ID = 0;
    private String numero;
    private String nome;
    private int cvv;
    private int agencia;
    private int verificadorAgencia;
    private int conta;
    private int verificadorConta;
    private int titularConta;
    private int bandeira;

    public Cartao() {
    }


    @Override
    public String toString() {
        String band;
        if (bandeira == 1) {
            band = "VISA";
        } else {
            band = "MASTER";
        }
        return "ID " + ID
                + " Numero " + numero
                + " Nome " + nome
                + " cvv " + cvv
                + " Agencia " + agencia
                + " -" + verificadorAgencia
                + " Conta " + conta
                + " -" + verificadorConta
                + " Titular " + titularConta
                + " Bandeira " + band;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getVerificadorAgencia() {
        return verificadorAgencia;
    }

    public void setVerificadorAgencia(int verificadorAgencia) {
        this.verificadorAgencia = verificadorAgencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getVerificadorConta() {
        return verificadorConta;
    }

    public void setVerificadorConta(int verificadorConta) {
        this.verificadorConta = verificadorConta;
    }

    public int getTitularConta() {
        return titularConta;
    }

    public void setTitularConta(int titularConta) {
        this.titularConta = titularConta;
    }

    public int getBandeira() {
        return bandeira;
    }

    public void setBandeira(int bandeira) {

        this.bandeira = bandeira;
    }

}
