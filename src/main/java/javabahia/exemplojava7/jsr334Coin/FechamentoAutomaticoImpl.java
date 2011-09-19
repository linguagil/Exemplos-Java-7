/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr334Coin;

/**
 *
 * @author otavio
 */
public class FechamentoAutomaticoImpl implements AutoCloseable {

    @Override
    public void close() throws Exception {
     System.out.println("Implementando a classe para ao sair do close ser chamado");
    }
    
}
