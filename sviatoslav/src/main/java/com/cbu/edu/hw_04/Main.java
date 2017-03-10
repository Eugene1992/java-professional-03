package com.cbu.edu.hw_04;

/**
 * Created by Sviatoslav on 02.03.2017.
 */
public class Main {
    public static void main(String[] args) throws JsonException, IllegalAccessException {
        ConvertToJson json = new ConvertToJson();
        Human human = new Human("name", 18, true, 183, "not far");
        json.convert(human);
        System.out.println(json.toJson());
    }
}
