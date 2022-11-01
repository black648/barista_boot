package org.barista.framework.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConvertUtil {


    //String Map -> Object Map
    public static Map<String, Object> stringMapToObjectMap(Map<String, String> targetMap) {
        Map<String, Object> convertMap = new HashMap<String, Object>();

        for (Map.Entry<String, String> entry: targetMap.entrySet()) {
            convertMap.put(entry.getKey(), entry.getValue());
        }

        return convertMap;
    }

    //DTO -> Map
    public static Map<String, Object> dtoToMap(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return Collections.emptyMap();
        }

        Map<String, Object> convertMap = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            convertMap.put(field.getName(), field.get(obj));
        }
        return convertMap;
    }

    //Map -> DTO
    public static <T> T mapToDTO(Map<String, Object> map, Class<T> type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (type == null) {
            throw new NullPointerException("Class is Null");
        }

        T instance = type.getConstructor().newInstance();

        if (ObjectUtil.isEmpty(map)) {
            return instance;
        }

        Field[] fields = type.getDeclaredFields();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            for (Field field : fields) {
                field.setAccessible(true);

                if (entry.getValue().getClass().equals(field.getType())
                        && entry.getKey().equals(field.getName())) {
                    field.set(instance, map.get(field.getName()));
                }
            }
        }
        return instance;
    }
}
