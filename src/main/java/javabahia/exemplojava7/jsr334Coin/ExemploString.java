/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr334Coin;

/**
 *Demonstrando o recurso de switch com Strings
 * @author otavio
 */
public class ExemploString {

    public static void main(String[] args) {
        String bebida = "cafe";
        switch (bebida) {
            case "cafe":
            case "cha":
                System.out.println("Vai precisar de leite");
                break;
            case "suco":
                System.out.println("Vai precisar de acucar");
                break;
            case "refrigerante":
                System.out.println("Vai precisar de gelo");
                break;
        }

        switch (bebida) {

            case "cafe":
                System.out.println("Vai precisar de leite");
                break;
            case "suco":
                System.out.println("Vai precisar de acucar");
                break;
            case "refrigerante":
                System.out.println("Vai precisar de gelo");
                break;

            default:
                System.out.println("Bebida desconhecida");
                break;
        }
    }
}
