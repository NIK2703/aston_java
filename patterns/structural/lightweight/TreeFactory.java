package ru.aston.ogurnoy_na.patterns.structural.lightweight;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "_" + color + "_" + texture;
        TreeType type = treeTypes.get(key);

        if (type == null) {
            type = new TreeType(name, color, texture);
            treeTypes.put(key, type);
            System.out.println("Создан новый тип дерева: " + key);
        }

        return type;
    }

    public static int getTreeTypesCount() {
        return treeTypes.size();
    }
}