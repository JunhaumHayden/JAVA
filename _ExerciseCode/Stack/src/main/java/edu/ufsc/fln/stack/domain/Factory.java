package edu.ufsc.fln.stack.domain;

import java.lang.reflect.Array;

public class Factory<T> {
    private final Class<T> type;

    public Factory(Class<T> type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public T[] newArray(int size) {
        return (T[]) Array.newInstance(type, size);
    }
}
