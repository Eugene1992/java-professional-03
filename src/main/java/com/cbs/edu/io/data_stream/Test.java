package com.cbs.edu.io.data_stream;

import java.io.*;

/**
 * Класс DataOutputStream представляет поток вывода и предназначен для записи данных примитивных типов,
 * таких, как int, double и т.д. Для записи каждого из примитивных типов предназначен свой метод:
 * <p>
 * writeBoolean(boolean v) :  записывает в поток булевое однобайтовое значение
 * writeByte(int v):          записывает в поток 1 байт, которые представлен в виде целочисленного значения
 * writeChar(int v):          записывает 2-байтовое значение char
 * writeDouble(double v):     записывает в поток 8-байтовое значение double
 * writeFloat(float v):       записывает в поток 4-байтовое значение float
 * writeInt(int v):           записывает в поток целочисленное значение int
 * writeLong(long v):         записывает в поток значение long
 * writeShort(int v):         записывает в поток значение short
 * writeUTF(String str):      записывает в поток строку в кодировке UTF-8
 */
public class Test {
    public static void main(String[] args) {
        Person tom = new Person("Tom", 35, 1.75, true);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("src\\main\\java\\com\\cbs\\edu\\io\\data_stream\\file"))) {
            dos.writeUTF(tom.name);
            dos.writeInt(tom.age);
            dos.writeDouble(tom.height);
            dos.writeBoolean(tom.married);
            System.out.println("Запись в файл произведена");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (DataInputStream dos = new DataInputStream(new FileInputStream("src\\main\\java\\com\\cbs\\edu\\io\\data_stream\\file"))) {
            String name = dos.readUTF();
            int age = dos.readInt();
            double height = dos.readDouble();
            boolean married = dos.readBoolean();
            System.out.printf("Человека зовут: %s , его возраст: %d , его рост: %f метров, женат/замужем: %b",
                    name, age, height, married);
        }
        catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    static class Person {
        public String name;
        public int age;
        public double height;
        public boolean married;

        public Person(String n, int a, double h, boolean m) {
            this.name = n;
            this.height = h;
            this.age = a;
            this.married = m;
        }
    }
}


