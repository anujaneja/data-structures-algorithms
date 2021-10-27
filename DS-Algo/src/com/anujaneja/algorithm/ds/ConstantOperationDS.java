package com.anujaneja.algorithm.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ConstantOperationDS<T> {
    private ArrayList<T>    elements;
    final private Map<T, Integer> elementToIndex = new HashMap<>();

    //O(1) operation...
    public boolean insert(T data) {
        if (elementToIndex.get(data) != null) {
            return false;
        }
        elements.add(data);
        elementToIndex.put(data, elements.size() - 1);
        return true;
    }

    // removing from last element index is O(1) operations....
    public boolean remove(T data) {
        if (elementToIndex.get(data) != null) {
            int lastElementIndex = elements.size() - 1;
            int elementIndex = elementToIndex.get(data);
            //Swap logic...
            T temp = elements.get(elementIndex);
            elements.set(elementIndex, elements.get(lastElementIndex));
            elements.set(lastElementIndex, temp);
            //Update swapped element index as well...and remove data from elementToIndex...
            elementToIndex.put(elements.get(elementIndex),elementIndex);
            elementToIndex.remove(data);
            //O(1) operation....
            elements.remove(lastElementIndex);

            return true;
        }
        return false;
    }

    public T getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(elements.size());
        return elements.get(randomIndex);
    }

    // Return index if element exists otherwise return null...
    public Integer search(T data) {
        return elementToIndex.get(data);
    }
}
