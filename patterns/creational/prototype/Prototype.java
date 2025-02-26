package ru.aston.ogurnoy_na.patterns.creational.prototype;

public interface Prototype extends Cloneable {
    Prototype clone() throws CloneNotSupportedException;
}