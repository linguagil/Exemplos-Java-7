/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.concorrencia;

import java.io.Serializable;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 *
 * @author otavio
 */
public class MeuObjeto implements Serializable {

    private String atributo;

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public MeuObjeto(String atributo) {
        this.atributo = atributo;
    }

    public static void main(String[] arg) {
        AtomicReference<MeuObjeto> meubojeto = new AtomicReference<>();
        System.out.println(meubojeto.get());//imprime nulo
        meubojeto.set(new MeuObjeto("valor Atributo"));
        System.out.println(meubojeto.get().getAtributo());//imprime valor Atributo
        AtomicReferenceArray<MeuObjeto> usuarios = new AtomicReferenceArray(10);
        // array atomico com o tamanho 10       
        usuarios.getAndSet(1, new MeuObjeto("Setando objeto 1"));



        BlockingDeque<MeuObjeto> fila = new LinkedBlockingDeque<>();
        ConcurrentMap<String, MeuObjeto> mapa = new ConcurrentHashMap();
        ConcurrentNavigableMap<String, MeuObjeto> maps = new ConcurrentSkipListMap<>();

    }
}
