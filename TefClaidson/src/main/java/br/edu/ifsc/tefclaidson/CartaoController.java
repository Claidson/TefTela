
/*
 * Que a força esteja com você
 */
package br.edu.ifsc.tefclaidson;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Claidson
 */
@XmlRootElement(name = "cartoes")
@XmlAccessorType(XmlAccessType.FIELD)
public class CartaoController {

    @XmlElement(name = "cartao")
    CartaoDAO dao = new CartaoDAO();

    public CartaoController() throws FileNotFoundException, IOException, ClassNotFoundException {
       // lerListaCartoesObjeto();

    }

    public enum Bandeira {

        VISA(1), MASTER(2);
        private final int codigo;

        Bandeira(int codigo) {
            this.codigo = codigo;
        }

        int codigo() {
            return codigo;
        }

        public static Bandeira porCodigo(int codigo) {
            for (Bandeira bandeira : Bandeira.values()) {
                if (codigo == bandeira.codigo()) {
                    return bandeira;
                }
            }
            throw new IllegalArgumentException("Codigo inválido");
        }
    }

    public enum ModoExportacao {

        XML, JSON;
    }

    private void geraNumeroCartao(Cartao cartao) {

        int bandeiragerada = VerificaBandeira(cartao.getBandeira());
        String novoCartao = String.format("%04d", bandeiragerada)
                + String.format("%04d", cartao.getAgencia())
                + String.format("%04d", cartao.getConta())
                + String.format("%04d", cartao.getTitularConta());
        cartao.setNumero(novoCartao);
        cartao.setID(getProximaID());
        if (cartao.getCvv() == 0) {
            cartao.setCvv(geraCvv());

        }

    }

    public Cartao geraCartao(String linha) {
        Cartao cartao = new Cartao();
        int numBandeira = Integer.parseInt(linha.substring(0, 4));
        cartao.setBandeira(VerificaBandeira(numBandeira));
        cartao.setCvv(Integer.parseInt(linha.substring(16, 19)));
        cartao.setNome(linha.substring(19, 35).toUpperCase());
        cartao.setAgencia(Integer.parseInt(linha.substring(35, 39)));
        cartao.setVerificadorAgencia(Integer.parseInt(linha.substring(39, 40)));
        cartao.setConta(Integer.parseInt(linha.substring(40, 44)));
        cartao.setVerificadorConta(Integer.parseInt(linha.substring(44, 45)));
        cartao.setTitularConta(Integer.parseInt(linha.substring(45, 46)));
        geraNumeroCartao(cartao);

        return cartao;
    }

    private String getCartaoAsString(Cartao cartao) {
        return String.format("%16.16s", cartao.getNumero())
                + String.format("%03d", cartao.getCvv())
                + String.format("%16.16s", cartao.getNome())
                + String.format("%04d", cartao.getAgencia())
                + String.format("%01d", cartao.getVerificadorAgencia())
                + String.format("%04d", cartao.getConta())
                + String.format("%01d", cartao.getVerificadorConta())
                + String.format("%01d", cartao.getTitularConta())
                + String.format("%01d", cartao.getBandeira()) + "\n";

    }

    public static int geraCvv() {
        Random geradorAleatorio = new Random();
        int cvvGerado = geradorAleatorio.nextInt(900) + 100;
        return cvvGerado;
    }

    public static int VerificaBandeira(int num) {
        int bandeira = num;
        if (num == 1) {
            bandeira = 4984;
        } else if (num == 2) {
            bandeira = 5162;
        } else if (num == 4984) {
            bandeira = 1;
        } else if (num == 5162) {
            bandeira = 2;
        }
        return bandeira;
    }

    public int getProximaID() {
        Configuracao conf = new Configuracao();
        String chave = "ultimo.id.cartao";
        int id;
        id = Integer.parseInt(conf.getPropriedade(chave));
        id++;
        String valorID = String.valueOf(id);
        conf.putPropriedade(chave, valorID);
        return id;
    }

    // ler um arquivo texto
    public void lerListaCartoesTxt(File file) {
        Scanner s;
        try {
            s = new Scanner(file);
            while (s.hasNext()) {
                String linha = s.nextLine();
                dao.inserir(geraCartao(linha));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao lex cartoes.txt");
            Logger.getLogger(CartaoController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
//Para ler uma lista de Objetos de cartoes ArrayList<Cartao> cartoes de um arquivo cartoes.dat

    public void lerListaCartoesObjeto(File file) throws ClassNotFoundException {
        FileInputStream leituraDat;
        try {
            leituraDat = new FileInputStream(file);
            ObjectInputStream leitorObjeto = new ObjectInputStream(leituraDat);
            ArrayList<Cartao> cartoes = (ArrayList<Cartao>) leitorObjeto.readObject();
            dao.setCartoes(cartoes);
            leituraDat.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nao achou dat de cartoes objeto");
            Logger.getLogger(CartaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Erro ao carregar dat de cartoes objeto");
            Logger.getLogger(CartaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void lerListaJson(File file) {
        try {
            //Converte String JSON para objeto Java
            Gson gson = new Gson();
            CartaoList listaJson = gson.fromJson(new FileReader(file), CartaoList.class);

        } catch (IOException e) {
            System.out.println("Pau ao ler JSon");
        }
    }

    public void lerListaXML(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CartaoList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            CartaoList cartaoList = (CartaoList) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException ex) {
            Logger.getLogger(CartaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvarListaXML(File file) {
        try {
            File arquivo = new File( file.toString() + ".xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance(CartaoList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(new CartaoList((ArrayList<Cartao>) dao.getTodos()), System.out);
            jaxbMarshaller.marshal(new CartaoList((ArrayList<Cartao>) dao.getTodos()), new File(arquivo.getCanonicalPath()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro no salvar objeto em cartoes.XML");

        }
    }

    //Para salvar uma lista de Objetos de cartoes ArrayList<Cartao> cartoes num arquivo cartoes.dat
    public void salvarListaObjeto(File file) {
        try {
             File arquivo = new File( file.toString() + ".dat" );
            FileOutputStream fos = new FileOutputStream(arquivo);
            ObjectOutputStream gravador = new ObjectOutputStream(fos);
            gravador.writeObject(dao.getTodos());
            gravador.flush();
        } catch (Exception e) {
            System.out.println("Erro no salvar objeto em cartoes .dat");

        }
    }

    public void salvarListaTxt(File file) {
        // salvar uma lista de cartões presentes em uma String (preenchida com linhas de cartoes) em cartoes.txt
        try {
            File arquivo = new File( file.toString() + ".txt" );
            FileWriter fw = new FileWriter(arquivo);
            for (Cartao cartao : dao.getTodos()) {
                fw.write(getCartaoAsString(cartao));
            }
            fw.flush();
        } catch (IOException ex) {
            System.out.println("Erro ao gravar arquivo com linhas");

            Logger.getLogger(CartaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void salvarListaJson(File file) {
        try {
            File arquivo = new File( file.toString() + ".json" );
            Gson gson = new Gson();
            String json = gson.toJson(new CartaoList((ArrayList<Cartao>) dao.getTodos()));
            FileWriter writer = new FileWriter(arquivo);
            writer.write(json);
            writer.close();
        } catch (Exception e) {
            System.out.println("Erro no salvar objeto em cartoes .Json");

        }
    }

    public void salvarListaJsonXML(ModoExportacao modo) {
        try {
            if (modo == ModoExportacao.XML) {
                JAXBContext jaxbContext = JAXBContext.newInstance(CartaoList.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.marshal(new CartaoList((ArrayList<Cartao>) dao.getTodos()), System.out);
                jaxbMarshaller.marshal(new CartaoList((ArrayList<Cartao>) dao.getTodos()), new File("cartoes.xml"));
            } else if (modo == ModoExportacao.JSON) {
                Gson gson = new Gson();
                String json = gson.toJson(new CartaoList((ArrayList<Cartao>) dao.getTodos()));
                FileWriter writer = new FileWriter("cartoes.json");
                writer.write(json);
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Erro no exportar lista de cartões para xml e json\n");

        }
    }

//searchByNome(String nome): retorna todos os cartões cujo nome do cliente iniciem com <nome>
    public ArrayList<Cartao> searchByNome(String nome) {
        ArrayList<Cartao> encontrados = new ArrayList();
        for (Cartao cartoes : dao.getTodos()) {
            if (cartoes.getNome().contains(nome)) {
                encontrados.add(cartoes);
            }
        }
        return encontrados;
    }

//searchByNumeroCartao(String cartao): retorna todos os cartões que sejam exatamente o número do cartão
    public ArrayList<Cartao> searchByNumeroCartao(String cartao) {
        ArrayList<Cartao> encontrados = new ArrayList();
        for (Cartao cartoes : dao.getTodos()) {
            if (cartoes.getNumero().equals(cartao)) {
                encontrados.add(cartoes);
            }
        }
        return encontrados;
    }
// searchByBandeira(Bandeira bandeira): retorna todos os cartões de uma bandeira específica (utilizar o Enum)

    public ArrayList<Cartao> searchByBandeira(Bandeira bandeira) {
        ArrayList<Cartao> encontrados = new ArrayList();
        for (Cartao cartoes : dao.getTodos()) {
            if (bandeira.codigo == cartoes.getBandeira()) {
                encontrados.add(cartoes);
            }
        }
        return encontrados;
    }
// searchByAgencia(Integer agencia, Integer agenciaDv): retorna todos os cartões de uma agência/dv específica

    public ArrayList<Cartao> searchByAgencia(Integer agencia, Integer agenciaDv) {
        ArrayList<Cartao> encontrados = new ArrayList();
        for (Cartao cartoes : dao.getTodos()) {
            if (cartoes.getAgencia() == agencia && cartoes.getVerificadorAgencia() == agenciaDv) {
                encontrados.add(cartoes);
            }
        }
        return encontrados;
    }

//  searchByConta(Integer conta, Integer contaDv): retorna todos os cartões de uma conta/dv específica
    public ArrayList<Cartao> searchByConta(Integer conta, Integer contaDv) {
        ArrayList<Cartao> encontrados = new ArrayList();
        for (Cartao cartoes : dao.getTodos()) {
            if (cartoes.getConta() == conta && cartoes.getVerificadorConta() == contaDv) {
                encontrados.add(cartoes);
            }
        }
        return encontrados;
    }

    // searchByContaTitular(Integer conta, Integer contaDv, Integer titular): retorna todos os cartões do titular de uma conta/dv específica
    public ArrayList<Cartao> searchByContaTitular(Integer conta, Integer contaDv, Integer titular) {
        ArrayList<Cartao> encontrados = new ArrayList();
        for (Cartao cart : dao.getTodos()) {
            if (cart.getConta() == conta && cart.getVerificadorConta() == contaDv && cart.getTitularConta() == titular) {
                encontrados.add(cart);
            }
        }
        return encontrados;
    }

    public boolean add(Cartao cartao) {
        Cartao cartaoSelecionado = null;
        geraNumeroCartao(cartao);
        for (Cartao cart : dao.getTodos()) {
            if (cart.getNumero().equals(cartao.getNumero())) {
                cartaoSelecionado = cartao;
                System.out.println("Cartao existe\n " + cartaoSelecionado.getNumero());
            }
        }
        if (cartaoSelecionado == null) {
            dao.inserir(cartao);
            System.out.println("Cartao inserido\n " + cartao.getNumero());
            return true;
        } else {
            return false;
        }
    }

// removeByNumero(String cartao): remove um cartão passando o seu número da lista de cartões
    public boolean removeByNumero(String cartao) {
        Cartao cartaoSelecionado = null;
        for (Cartao cart : dao.getTodos()) {
            if (cart.getNumero().equals(cartao)) {
                cartaoSelecionado = cart;
                break;
            }
        }
        if (cartaoSelecionado != null) {
            dao.remover(cartaoSelecionado);
            return true;
        }
        return false;
    }
// remove(Cartao cartao): remove um cartão passando um cartão como parâmetro

    public void remove(Cartao cartao) {
        Cartao cartaoSelecionado = null;
        for (Cartao cart : dao.getTodos()) {
            if (cart == cartao) {
                cartaoSelecionado = cart;
            }
        }
        if (cartaoSelecionado != null) {
            dao.remover(cartaoSelecionado);
        }
    }
// altera(Cartao cartao): altera os dados do cartão. Neste método o cartão passado como parâmetro terá que regerar o número do cartão e em seguida salvar no banco.

    public void altera(Cartao cartao) {
        for (Cartao cart : dao.getTodos()) {
            if (cart == cartao) {

            }
        }

    }
}
