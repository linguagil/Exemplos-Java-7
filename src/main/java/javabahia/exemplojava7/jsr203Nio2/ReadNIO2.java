/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr203Nio2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author otavio
 */
public class ReadNIO2 {

    public static void main(String[] args) throws IOException, Exception {

//        escrevendoArquivo();
//        lendoArquivo();
//        copiandoArquivo();
//        movendoArquivo();
//        AcoesArquivo.criarArquivo();
//        criarDiretorio();
//        propriedadesPath(Paths.get("textoCopy.txt"));
//        AcoesArquivo.criarLinkSimbolico();


        Path path = Paths.get("arquivo.txt");
        
        LendoEscrevendoArquivos.acessoEscalavel(Paths.get("textoCopy.txt"));

    }
}
