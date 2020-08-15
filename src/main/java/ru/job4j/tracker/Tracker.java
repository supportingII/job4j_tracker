package ru.job4j.tracker;

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
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item obj = list[index];
            if (obj.getId() == id) {
                rsl = obj;
                break;
            }
        }
        return rsl;
    }
}