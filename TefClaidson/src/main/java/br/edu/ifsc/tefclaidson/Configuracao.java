/*
 * Que a força esteja com você
 */
package br.edu.ifsc.tefclaidson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Claidson
 */
public class Configuracao {

    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream arquivo = new FileInputStream(
                "./conf.properties");
        props.load(arquivo);
        return props;

    }

    public String getPropriedade(String chave) {
        Properties prop;
        try {
            prop = getProp();
            String propriedade = prop.getProperty(chave);
            return propriedade;
        } catch (IOException ex) {
            Logger.getLogger(Configuracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Pau ao pegar propriedade";

    }

    public String putPropriedade(String chave, String valor) {
        Properties prop;
        try {
            prop = getProp();
            prop.setProperty(chave, valor);
            prop.store(new FileOutputStream("./conf.properties"), null);
            return valor;
        } catch (IOException ex) {
            Logger.getLogger(Configuracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Pau ao gravar properties";

    }

}
