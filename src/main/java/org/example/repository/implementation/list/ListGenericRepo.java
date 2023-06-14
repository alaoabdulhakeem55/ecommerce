package org.example.repository.implementation.list;

import org.example.exceptions.DBException;
import org.example.model.Identifiable;
import org.example.repository.GenericRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ListGenericRepo<T extends Identifiable> implements GenericRepo <T> {
    private final List<T> list;
    private final String name;


    public ListGenericRepo(List<T> list, String name) {
        this.list = list;
        this.name = name;


    }

    @Override
    public String generate(int position) {
        return String.format("%S_%d", name,  position + 1);

    }

    @Override
    public List<T> getList() {
        return new ArrayList<>(list);
    }

    public T update(T item) {
        for(int i=0; i<list.size(); i++) {
            if(Objects.equals(list.get(i).getId(), item.getId())) {
                list.set(i, item);
                return item;
            }
        }
        return null;

    }

    @Override
    public T getById(String id) {
        for(int i=0; i<list.size(); i++) {
            String generatedId = generate(i);
            if(generatedId.equals(id)) {
                return list.get(i);
            }
        }
        throw new DBException("Item not found");
    }

    @Override
    public T deleteById(String id) {
        T item = getById(id);
        list.remove(item);
        return item;
    }

    @Override
    public T save(T item) {
        if(!item.getId().isBlank()) {
            return this.update(item);
        }
        String id = this.generate(this.getList().size());

        item.setId(id);
        list.add(item);
        return item;

    }
}
