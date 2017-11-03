
/*
 * Que a força esteja com você
 */
package br.edu.ifsc.tefclaidson;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Claidson
 */
public class CartaoDAO {

    private ArrayList<Cartao> cartoes = new ArrayList();

    public CartaoDAO() {
        carregarTodos();
    }
    
    

    public void inserir(Cartao cartao) {
        cartoes.add(cartao);
        salvarTodos();
    }

    public void remover(Cartao cartao) {
        Cartao cartaoSelecionado = null;
        for (Cartao cart : cartoes) {
            if (cart == cartao) {
                cartaoSelecionado = cart;
            }
        }
        if (cartaoSelecionado != null) {
            cartoes.remove(cartaoSelecionado);
        }
          salvarTodos();
    }

    public void alterar(Cartao cartao) {
        for (Cartao cart : cartoes) {
            if (cart.getID() == cartao.getID()) {
                cart.setNome(cartao.getNome());
                cart.setNumero(cartao.getNumero());
                cart.setAgencia(cartao.getAgencia());
                cart.setVerificadorAgencia(cartao.getVerificadorAgencia());
                cart.setConta(cartao.getConta());
                cart.setVerificadorConta(cartao.getVerificadorConta());
                cart.setBandeira(cartao.getBandeira());
                cart.setTitularConta(cartao.getTitularConta());
                cart.setCvv(cartao.getCvv());
            }
        }
    }

    public List<Cartao> getTodos() {

        return cartoes;

    }

    private void salvarTodos() {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(new CartaoList(cartoes));
            FileWriter writer = new FileWriter("cartoes.json");
            writer.write(json);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro no salvar objeto em cartoes.Json");
        }
    }

    private void carregarTodos() {
        try {
            //Converte String JSON para objeto Java
            Gson gson = new Gson();
            CartaoList listaJson = gson.fromJson(new FileReader("cartoes.json"), CartaoList.class);
            cartoes = listaJson.getCartoes();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Pau ao ler JSon");
        }
    }

    public void setCartoes(ArrayList<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

}
