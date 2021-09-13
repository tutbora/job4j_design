package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {
    
    private final Map<String, T> mem = new HashMap<>();
    
    @Override
    public void add(T model) {
            mem.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (mem.containsKey(id)) {
            mem.replace(model.getId(), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (mem.containsKey(id)) {
            mem.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return mem.getOrDefault(id, null);
    }
}