/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr334Coin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *Essa classe tem como objetivo demonstrar a utilizacao do Automatic Resource Management, 
 * em que agora a jvm pode gerenciar tais recursos
 * @author otavio
 */
public class ExemploARM {

    /**
     * metodo com o objetivo de copiar as informacoes de um arquivo para o 
     * outro
     * @param original arquivo com o conteudo a ser copiado
     * @param copiado arquivo que receberao os valores 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void copiarArquivo(File original, File copiado) {

        try (Connection connection = ConnectionFactory.getConnection();
                OutputStream out = new FileOutputStream(copiado);
                InputStream in = new FileInputStream(original);) {

            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
                persistenciaLinha(connection);
            }
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            tratamentoExcecao();
        }
        //sera fechado automaticamente apos operacao


    }

    private static void tratamentoExcecao() {
    }

    private static void persistenciaLinha(Connection connection) {
    }
}
