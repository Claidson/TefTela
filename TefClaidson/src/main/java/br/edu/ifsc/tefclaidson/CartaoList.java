package br.edu.ifsc.tefclaidson;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@XmlRootElement(name = "cartoes")
@XmlAccessorType(XmlAccessType.FIELD)
public class CartaoList {

    @XmlElement(name = "cartao")
    private ArrayList<Cartao> cartoes;

    public CartaoList(ArrayList<Cartao> lista) {
        this.cartoes = lista;
    }

    public CartaoList() {
    }

    public void setCartoes(ArrayList<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public ArrayList<Cartao> getCartoes() {
        return cartoes;
    }

}