/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.concorrencia.fibonacci;

/**
 *
 * @author otavio
 */
public class FibonacciProblema {

    public long n;

    public FibonacciProblema(long n) {
        this.n = n;
    }

    public long resolver() {
        return fibonacci(n);
    }

    private long fibonacci(long n) {
//        System.out.println("Thread: " + Thread.currentThread().getName() + " calculates " + n);
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
