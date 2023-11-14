package org.example.model.store.iterators;

import org.example.model.Toy;

import java.util.Iterator;
import java.util.List;

public class ToysIterator implements Iterator {
    private int index;
    private List<Toy> toysList;

    public ToysIterator(List<Toy> toysList) {
        this.toysList = toysList;
    }

    @Override
    public boolean hasNext() {
        return index < toysList.size();
    }

    @Override
    public Toy next() {
        return toysList.get(index++);
    }
}
