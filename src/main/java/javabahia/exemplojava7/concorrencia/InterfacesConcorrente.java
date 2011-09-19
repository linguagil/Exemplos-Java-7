/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.concorrencia;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author otavio
 */
public class InterfacesConcorrente {
    ThreadPoolExecutor executor=null;
    public void main(){
   
        
    }

    
// Executor
// ExecutorService  
// ScheduledExecutorService
   
    class Exemplo1 implements Executor{

        @Override
        public void execute(Runnable command) {
        command.run();
      
        }
    }
    class Exemplo2 implements ExecutorService{

        @Override
        public void shutdown() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public List<Runnable> shutdownNow() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean isShutdown() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean isTerminated() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public <T> Future<T> submit(Callable<T> task) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public <T> Future<T> submit(Runnable task, T result) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Future<?> submit(Runnable task) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void execute(Runnable command) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

      
    }
     class Exemplo3 implements ScheduledExecutorService{

        @Override
        public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void shutdown() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public List<Runnable> shutdownNow() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean isShutdown() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean isTerminated() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public <T> Future<T> submit(Callable<T> task) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public <T> Future<T> submit(Runnable task, T result) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Future<?> submit(Runnable task) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void execute(Runnable command) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
     
     
     
     
     }
}
