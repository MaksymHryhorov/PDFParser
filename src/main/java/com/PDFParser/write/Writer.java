package com.PDFParser.write;

import com.PDFParser.model.Model;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class Writer {
    /**
     * Write raw to console
     * @param person columns from model
     * @param str fields to fill model columns
     */
    @SneakyThrows
    public void writeToConsole(Model person, String[] str) {
        Class<?> cls = person.getClass();

        StringBuilder values = new StringBuilder();
        for (int i = 0; i <= str.length - 1; i++) {
            Field field = cls.getDeclaredField(str[i]);
            values.append(field.getName()).append(" ");
            field.setAccessible(true);
            values.append(field.get(person)).append(" ");
        }

        System.out.println(values);
    }
}
