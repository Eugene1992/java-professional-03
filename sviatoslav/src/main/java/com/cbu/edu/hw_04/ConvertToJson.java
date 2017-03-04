package com.cbu.edu.hw_04;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created by Sviatoslav on 02.03.2017.
 */
public class ConvertToJson {
    HashMap<String, String> map;

    public HashMap<String, String> convert(Object jClass) throws JsonExeption, IllegalAccessException {
        map = new HashMap<>();
        Field[] fields = jClass.getClass().getDeclaredFields();
        JsonField anoField = jClass.getClass().getAnnotation(JsonField.class);

        if (!jClass.getClass().isAnnotationPresent(Json.class)) {
            throw new JsonExeption("Shit Happens");
        }
        for (Field field : fields) {
            field.setAccessible(true);
            if (anoField != null && anoField.name().isEmpty()) {
                map.put(field.getName(), field.get(jClass).toString());
            } else if (anoField != null && !anoField.name().isEmpty()) {
                map.put(anoField.name(), field.get(jClass).toString());
            }
        }
        return map;
    }

    public String toJson() {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (String k : map.keySet()) {
            String key = map.get(k);
            String value = map.get(k);
            result.append("\"" + key + " \" : " + value);
        }
        return result.toString();
    }
}
