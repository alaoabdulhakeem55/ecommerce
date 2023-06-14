package org.example.repository.implementation.map;

import org.example.exceptions.DBException;
import org.example.model.Identifiable;
import org.example.repository.GenericRepo;

import java.util.HashMap;
import java.util.Map;

public abstract class MapGenericRepo<T extends Identifiable> implements GenericRepo <T> {
    private final Map<String, T> map;
    private final String name;


    public MapGenericRepo(Map<String, T> map, String name) {
        this.map = map;
        this.name = name;
    }

    @Override
    public String generate(int position) {
        return String.format("%S_%d", name,  position + 1);

    }

    @Override
    public Map<String, T> getList() {
        return new HashMap<>(map);
    }

    public T update(T item) {
       return map.put(item.getId(), item);
    }

    @Override
    public T getById(String id) {
        T t = map.get(id);
        if(t != null) {
            return t;
        }
        throw new DBException("Item not found");
    }

    @Override
    public T deleteById(String id) {
      return map.remove(id);
    }

    @Override
    public T save(T item) {
        if(!item.getId().isBlank()) {
            return this.update(item);
        }
        String id = this.generate(this.getList().size());

        item.setId(id);
        map.put(item.getId(), item);
        return item;
    }
}
