package com.cbs.edu.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Test {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Car car = new Car("Model X", 5, 9012);

        Class aClass = car.getClass();

        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String canonicalName = aClass.getCanonicalName();
        String typeName = aClass.getTypeName();
        System.out.println(name);
        System.out.println(simpleName);
        System.out.println(canonicalName);
        System.out.println(typeName);

        /*Field[] publicFields = aClass.getFields();

        for (Field field : publicFields) {
            String fieldName = field.getName();
            System.out.println(fieldName);
        }*/

        Field[] declaredFields = aClass.getDeclaredFields();

        for (Field field : declaredFields) {
            Class type = field.getType();
            field.setAccessible(true);
            String fieldName = field.getName();
            Object fieldValue = field.get(car);
            System.out.println(type.getSimpleName() + " " + fieldName + " = " + fieldValue);
        }

        System.out.println(car.getVolume());

        Field fieldValue = aClass.getDeclaredField("volume");
        fieldValue.setAccessible(true);
        fieldValue.setInt(car, 7777);

        System.out.println(car.getVolume());

        Annotation[] declaredAnnotations = fieldValue.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            Class annotationType = declaredAnnotation.annotationType();
            System.out.println(annotationType.getName());
        }

        int modifiers = fieldValue.getModifiers();
        System.out.println(Modifier.isPrivate(modifiers));
        System.out.println(Modifier.isStatic(modifiers));

        boolean annotationPresent = fieldValue.isAnnotationPresent(MyAnnotation.class);
        System.out.println(annotationPresent);

        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getParameterCount());
            Class[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println(parameterType.getSimpleName());
            }
        }


        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

        Method printVolume = aClass.getDeclaredMethod("printVolume");
        printVolume.setAccessible(true);
        printVolume.invoke(car, null);

        Car newCar = (Car)aClass.newInstance();

    }
}
