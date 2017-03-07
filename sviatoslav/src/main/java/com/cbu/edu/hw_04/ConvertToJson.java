package com.cbu.edu.hw_04;

import java.lang.reflect.Field;
import java.util.*;


public class ConvertToJson {
    HashMap<String, String> map;

    public HashMap<String, String> convert(Object jClass) throws JsonException, IllegalAccessException {
        map = new LinkedHashMap<>();
        Field[] fields = jClass.getClass().getDeclaredFields();

        if (!jClass.getClass().isAnnotationPresent(Json.class)) {
            throw new JsonException("Shit Happens");
        }
        for (Field field : fields) {
            JsonField anoField = field.getAnnotation(JsonField.class);
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
        Set<Map.Entry<String, String>> entry = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue();

            if (value.matches("-?\\d+") ||
                    value.matches("true") ||
                    value.matches("false")) {
                result.append("\t\"").append(key).append(" : ").append(value).append(",").append("\n");
            } else {
                result.append("\t\"").append(key).append(" : \"").append(value).append("\",").append("\n");
            }
        }
        int ch = result.lastIndexOf(",");
        result.deleteCharAt(ch);
        result.append("}");
        return result.toString();
    }
}
