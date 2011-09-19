/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr203Nio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author otavio
 */
public class AcoesArquivo {

    public static void movendoArquivo(Path arquivoOrigem, Path arquivoDestino) throws Exception {
        Files.move(arquivoOrigem, arquivoDestino, StandardCopyOption.REPLACE_EXISTING);
        
    }

    public static void copiandoArquivo(Path arquivoOrigem, Path arquivoDestino) throws Exception {
        Files.copy(arquivoOrigem, arquivoDestino, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void deletandoArquivo(Path arquivo) throws Exception {
        Files.delete(arquivo);
    }

    public static Path criarArquivo(String arquivo) throws Exception {
        return Files.createFile(Paths.get(arquivo));
    }

    public static Path criarDiretorio(String diretorio) throws Exception {
        return Files.createDirectories(Paths.get(diretorio));
    }

    public static void criarLinkSimbolico(Path linkSimbolico, Path arquivo) throws Exception {
        Files.createSymbolicLink(linkSimbolico, arquivo);
    }

    public static void criarLinkRigido(Path link, Path arquivo) throws Exception {
        Files.createLink(link, arquivo);
    }
}
