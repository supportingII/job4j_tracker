package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item newItem = tracker.add(new Item());
        Item findItem = tracker.findById(newItem.getId());

        System.out.println(findItem.getId());
    }
}
