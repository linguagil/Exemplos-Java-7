/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr292;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @author otavio
 */
public class ExecutarMetodoEstatico {
    public static  void concatenaNome(String nome, String sobreNome)  {
  
      System.out.println(nome+sobreNome);
      
      
  
  }
  
  
  public static void main(String[] args) throws Exception, Throwable{
  
  MethodType methodType= MethodType.methodType(void.class,String.class,String.class);
  MethodHandle methodHandle=MethodHandles.publicLookup().findStatic(ExecutarMetodoEstatico.class, "concatenaNome", methodType);
  MethodHandle printer=MethodHandles.insertArguments(methodHandle, 0, "Otávio ");
  printer.invoke(" Java");
  printer.invoke(" Groovy");
          
  
  
  }
}
