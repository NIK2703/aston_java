package ru.aston.ogurnoy_na.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Component {
    private String name;
    private List<Component> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("\nДиректория: " + name);
        System.out.println("Содержимое (" + children.size() + " элементов):");
        for (Component component : children) {
            component.showDetails();
        }
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }
}