/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr203Nio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author otavio
 */
public class LendoEscrevendoArquivos {

    public static void lendoArquivo(Path arquivo) throws Exception {
        Charset charset = Charset.forName("UTF-8");


        String strLine = null;
        try (BufferedReader reader = Files.newBufferedReader(arquivo, charset)) {

            while ((strLine = reader.readLine()) != null) {

                System.out.println("Arquivo " + strLine);

            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }

    public static void escrevendoArquivo(Path arquivo, String texto) throws Exception {

        Charset charset = Charset.forName("UTF-8");


        try (BufferedWriter writer = Files.newBufferedWriter(arquivo, charset)) {
            writer.write(texto, 0, texto.length());

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }

    public static void acessoEscalavel(Path path) throws Exception {
        String s = "acesso escalável!\n";
        byte data[] = s.getBytes();
        ByteBuffer out = ByteBuffer.wrap(data);

        ByteBuffer copy = ByteBuffer.allocate(12);

        try (FileChannel fc = (FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE))) {
            //lendo os 12 primeiros bytes do arquivo
            int nread;
            do {
                nread = fc.read(copy);
                byte[] bytearr = copy.array();

                String ss = new String(bytearr);
                System.out.println("lendo: " + ss);

            } while (nread != -1 && copy.hasRemaining());

            //escrevendo a string no comeco do arquivo
            fc.position(0);
            while (out.hasRemaining()) {

                fc.write(out);
            }

            out.rewind();

            //movendo para o final do arquivo  copiado os 12 bytes
            //e no final do arquivo escrever novamente
            long length = fc.size();
            fc.position(length - 1);
            copy.flip();
            while (copy.hasRemaining()) {
                fc.write(copy);
            }
            while (out.hasRemaining()) {
                fc.write(out);
            }
        }



    }
}
