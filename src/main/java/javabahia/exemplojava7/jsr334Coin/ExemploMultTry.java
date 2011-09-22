/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr334Coin;

import java.io.File;

/**
 *Esse objeto tem o objetivo de demonstrar o uso de Multy try
 * @author otavio
 */
public class ExemploMultTry {

    public static void main(String[] arg) {
        File origem = new File("java.txt");
        File destino = new File("java7.txt");

        ExemploARM arm = new ExemploARM();
        try {

            arm.copiarArquivo(origem, destino);

        } catch (Exception ex) {
        }



    }
}
