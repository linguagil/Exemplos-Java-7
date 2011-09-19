/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.concorrencia.fibonacci;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @author otavio
 */
public class FibonacciTarefa extends RecursiveTask<Long> {

    private static final long serialVersionUID = 6136927121059165206L;
    private static final int THRESHOLD = 5;
    private FibonacciProblema problem;
    public long result;

    public FibonacciTarefa(FibonacciProblema problem) {
        this.problem = problem;
    }

    @Override
    public Long compute() {
        if (problem.n < THRESHOLD) { // nao necessario paralelismo
            result = problem.resolver();
        } else {
            FibonacciTarefa worker1 = new FibonacciTarefa(new FibonacciProblema(problem.n - 1));
            FibonacciTarefa worker2 = new FibonacciTarefa(new FibonacciProblema(problem.n - 2));
            worker1.fork();
            result = worker2.compute() + worker1.join();

        }
        return result;
    }
}