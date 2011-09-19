/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr334Coin;

public class ExemploSeparadorDigito {

    public ExemploSeparadorDigito() {
    }
    public static void main(String[] args) {
        long longPrimitivo = 9_99_999_999;
        Long longObjeto = 9__3234_300l;
        double doublePrimitivo = 232_32.32_12d;
        Double doubleObjeto = 88_32.32_12d;
        int binA = 0b01_01;
        int binB = 0b0101_0111;

        if (2222 == 22_22) {
            System.out.println("Valores iguais");
        }

        if (binA == 5) {
            System.out.println("Equivalentes a binario");
        }

    }

    public void antes() {
        long longPrimitivo = 999999999;
        Long longObjeto = 93234300l;
        double doublePrimitivo = 23232.3212d;
        Double doubleObjeto = 8832.3212d;




    }
}
