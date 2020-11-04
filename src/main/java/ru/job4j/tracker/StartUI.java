package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item());
        Item findItem = tracker.findById(1);

        System.out.println(findItem.getId());
    }
}
