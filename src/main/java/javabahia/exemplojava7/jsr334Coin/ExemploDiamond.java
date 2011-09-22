/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr334Coin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *a ideia agora é mostrar a facilidade de 
 * iniciar as coleções
 * @author otavio
 */
public class ExemploDiamond {

    public static void main(String[] arg) {
        List<String> str = new ArrayList<>();
        List<String> str2 = new ArrayList<>();
        str.add("a");
        str.add("b");
        str.add("c");
        str2.add("d");
        str2.add("e");
        str2.add("f");

        varags(str, str2);


    }

    @SafeVarargs
    static <T> List<T> asList(T... elements) {
        System.out.println(elements);
        return null;
    }

    @SafeVarargs
    static void varags(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; //semantica invalida, mas compila ser atencao
        String s = stringLists[0].get(0); // ClassCastException durante execucao
    }
}
