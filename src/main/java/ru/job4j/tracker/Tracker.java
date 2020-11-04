package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] list = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        list[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? list[index] : null;
        /*Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item obj = list[index];
            if (obj.getId() == id) {
                rsl = obj;
                break;
            }
        }
        return rsl;*/
    }
    
    public Item[] findAll() {
        Item[] newList = new Item[size];
        int newSize = 0;
        for (int i = 0; i <= size; i++) {
            if (list[i] != null) {
                newList[newSize] = list[i];
                newSize++;
            }
        }
        newList = Arrays.copyOf(newList,newSize);
        return newList;
    }

    public Item[] findByName(String key) {
        Item[] newList = new Item[size];
        int newSize = 0;
        for (int i = 0; i <= size; i++) {
            if (list[i].getName().equals(key)) {
                newList[newSize] = list[i];
                newSize++;
            }
        }
        newList = Arrays.copyOf(newList,newSize);
        return newList;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if(index == -1) return false;
        int tempItemId = list[index].getId();
        list[index] = item;
        list[index].setId(tempItemId);
        return true;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i <= size; i++) {
            if(list[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}