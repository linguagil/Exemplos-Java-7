/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.concorrencia.fibonacci;

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author otavio
 */
public class ShowDemo {

    public static void main(String[] args) {

        // Verifica o número de processadores
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Numero de processamento " + processors);

        long n = 45;


        FibonacciProblema bigProblem = new FibonacciProblema(n);

//        FibonacciTarefa tarefa = new FibonacciTarefa(bigProblem);
//        ForkJoinPool pool = new ForkJoinPool(processors);
//        pool.invoke(tarefa);

//        long result = tarefa.result;
        long result = bigProblem.resolver();
        System.out.println("Computed Result: " + result);



    }
}
