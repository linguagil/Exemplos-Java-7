/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr292;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 *
 * @author otavio
 */
public class TestGetSet {
    private String teste = "valor Original";

    public static void a(String prefix, String suffix) {

        System.out.println(prefix);
        System.out.println(suffix);

    }

    public static void main(String[] args) throws Exception, Throwable {

        TestGetSet testGetSet = new TestGetSet();
        Field field = null;

        for (Field f : TestGetSet.class.getDeclaredFields()) {
            field = f;
        }

        System.out.println("O valor do atributo eh " + getter(testGetSet, field));
        setter(testGetSet, "valor modificado", field);
         System.out.println("O valor do atributo eh " + getter(testGetSet, field));
    }

    public static Object getter(Object object, Field field) throws NoSuchMethodException, IllegalAccessException, Throwable {
        String fieldName = field.getName();
        MethodType methodType = MethodType.methodType(field.getType().newInstance().getClass());
        String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        MethodHandle methodHandle = MethodHandles.publicLookup().bind(object, methodName, methodType);


        return methodHandle.invoke();
    }

    public static void setter(Object object, Object value, Field field) throws NoSuchMethodException, IllegalAccessException, Throwable {
        String fieldName = field.getName();
        MethodType methodType = MethodType.methodType(void.class, field.getType().newInstance().getClass());
        String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        MethodHandle methodHandle = MethodHandles.publicLookup().bind(object, methodName, methodType);
        MethodHandle printer = MethodHandles.insertArguments(methodHandle, 0, value);

        printer.invoke();
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }
}
