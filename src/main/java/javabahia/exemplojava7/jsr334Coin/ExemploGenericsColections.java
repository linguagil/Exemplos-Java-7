/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr334Coin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Essa classe tem o objetivo de demonstrar 
 * a facilidade de se trabalhar com 
 * Generics e Colections
 * @author otavio
 */
public class ExemploGenericsColections {

    public static void main(String[] args) {
      
        List<Object> diamont = new ArrayList<>(); //diamont
        List<Bebida> bebidas;
        Map<String, List<Bebida>> maps = new HashMap<>();
        maps.put("dimaont", bebidas = new ArrayList<>());
        maps.put("referenciado", new ArrayList<Bebida>());
//    maps.put("erro",  new ArrayList<>() ); 
        String[] s = {"asdf"};




    }

    public void antes() {

        List<Object> diamont = new ArrayList<Object>(); //diamont
        List<Bebida> bebidas;
        Map<String, List<Bebida>> maps = new HashMap<String, List<Bebida>>();
        maps.put("dimaont", bebidas = new ArrayList<Bebida>());
        maps.put("referenciado", new ArrayList<Bebida>());

        String[] s = {"asdf"};


    }
}
