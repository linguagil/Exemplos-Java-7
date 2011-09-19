/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.concorrencia;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author otavio
 */
public class Safelock {

    static class Amigo {

        private final String nome;
        private final Lock lock = new ReentrantLock();

        public Amigo(String nome) {
            this.nome = nome;
        }

        public String getName() {
            return this.nome;
        }

        public boolean impedidoComprimento(Amigo bower) {
            Boolean meuLock = false;
            Boolean seuLock = false;
            try {
                meuLock = lock.tryLock();
                seuLock = bower.lock.tryLock();
            } finally {
                if (!(meuLock && seuLock)) {
                    if (meuLock) {
                        lock.unlock();
                        
                    }
                    if (seuLock) {
                        bower.lock.unlock();

                    }
                }
            }
            return meuLock && seuLock;
        }

        public void comprimentar(Amigo amigo) {
            if (impedidoComprimento(amigo)) {
                try {
                    System.out.format("%s: %s nao pode  comprimentar!%n",
                            this.nome, amigo.getName());
                    amigo.retornoComprimento(this);
                } finally {
                    lock.unlock();
                    amigo.lock.unlock();
                }
            } else {
                System.out.format("%s: %s iniciando o comprimento mas"
                        + " eu vi que já estava se comprimentado a ele.%n",
                        this.nome, amigo.getName());
            }
        }

        public void retornoComprimento(Amigo bower) {
            System.out.format("%s: %s voltando do comprimento %n",
                    this.nome, bower.getName());
        }
    }

    static class ComprimentoLoop implements Runnable {

        private Amigo amigo1;
        private Amigo amigo2;

        public ComprimentoLoop(Amigo amigo1, Amigo amigo2) {
            this.amigo1 = amigo1;
            this.amigo2 = amigo2;
        }

        public void run() {
            Random random = new Random();
            for (;;) {
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                }
                amigo2.comprimentar(amigo1);
            }
        }
    }

    public static void main(String[] args) {
        final Amigo luciano = new Amigo("Luciano");
        final Amigo serge = new Amigo("Serge");
        new Thread(new ComprimentoLoop(luciano, serge)).start();
        new Thread(new ComprimentoLoop(serge, luciano)).start();
    }
}
