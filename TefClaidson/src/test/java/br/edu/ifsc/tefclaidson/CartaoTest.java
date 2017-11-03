/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.tefclaidson;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Claidson
 */
public class CartaoTest {
    CartaoController controle;
    String cartaoLinha = "49840010002000017880USUARIO SOBRENO001000020011";
    public CartaoTest() {
        try {
            controle = new CartaoController();
        } catch (IOException ex) {
            Logger.getLogger(CartaoTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CartaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    @Test
    public void testCartaoLinha() {
        Cartao teste = controle.geraCartao(cartaoLinha);
        Assert.assertEquals("4984001000200001", teste.getNumero());
        Assert.assertEquals("0USUARIO SOBRENO", teste.getNome());
        Assert.assertEquals(788, teste.getCvv());
        Assert.assertEquals(10, teste.getAgencia());
        Assert.assertEquals(0, teste.getVerificadorAgencia());
        Assert.assertEquals(20, teste.getConta());
        Assert.assertEquals(0, teste.getVerificadorConta());
        Assert.assertEquals(1, teste.getTitularConta());
        Assert.assertEquals(1, teste.getBandeira());
    }

   

   
    
}
