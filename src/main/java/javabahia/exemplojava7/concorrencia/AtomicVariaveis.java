/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.concorrencia;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author otavio
 */
public class AtomicVariaveis {

    static class AtomicCounter {

        private AtomicInteger contador = new AtomicInteger(0);

        public void increment() {


            System.out.println("Incrementando " + contador.incrementAndGet());
        }

        public void decrement() {
            System.out.println("Decrementando " + contador.decrementAndGet());

        }

        public int value() {
            return contador.get();
        }
    }

    static class Produtor implements Runnable {

        private AtomicCounter atomicCounter;
        
        

        public Produtor(AtomicCounter contador) {
            this.atomicCounter = contador;


        }

        @Override
        public void run() {
            while (true) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                atomicCounter.increment();


            }
        }
    }

    static class Consumidor implements Runnable {

        private AtomicCounter atomicCounter;

        public Consumidor(AtomicCounter contador) {
            this.atomicCounter = contador;


        }

        @Override
        public void run() {
            while (true) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                if (atomicCounter.value() > 0) {
                    atomicCounter.decrement();
                } else {
                    System.out.println("Não foi possível consumir serviço");
                }

            }
        }
    }

    public static void main(String[] args) {

        AtomicCounter atomicCounter = new AtomicCounter();
        AtomicReference<MeuObjeto> objetoAtomico = new AtomicReference<>(new MeuObjeto("construtor"));
        objetoAtomico.get().getAtributo();

//        Thread consumidor = new Thread(new Consumidor(atomicCounter));
//        Thread produtor = new Thread(new Produtor(atomicCounter));
//        consumidor.start();
//        produtor.start();
        Executor consumidor = Executors.newSingleThreadExecutor();
        Executor produtor = Executors.newSingleThreadExecutor();
        consumidor.execute(new Consumidor(atomicCounter));
        produtor.execute(new Produtor(atomicCounter));
    }
}
