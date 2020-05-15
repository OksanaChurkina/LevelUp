package org.levelup.job.list.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionApp {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {

        Car carObj = new Car("Rio");
        Class<?> carClass =carObj.getClass();

        Field[] publicFields = carClass.getFields();
        for(Field publicField : publicFields){

        }

        Field modelField = carClass.getField("model");
        System.out.println("private field name: " + carObj.getName());
        modelField.setAccessible(true);
        modelField.set(carObj, "Solaris");
        System.out.println("changed field value: " + carObj.getModel());

        Method changeModelMethod = carClass.getDeclaredMethod("changeModel", String.class);
        changeModelMethod.setAccessible(true);
        changeModelMethod.invoke(carObj, "Polo");

        System.out.println("field method after private method invokation: " + carObj.getModel());

        Constructor<?> carConstruktor = carClass.getDeclaredConstructor(String.class, String.class);
        carConstruktor.setAccessible(true);


    }
}
