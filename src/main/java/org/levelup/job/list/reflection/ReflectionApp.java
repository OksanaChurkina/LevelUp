package org.levelup.job.list.reflection;

public class ReflectionApp {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        Car carObj = new Car("Rio");
        Class<?> carClass =carObj.getClass();

        carClass.getFields();

    }
}
