package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-");
            this.showMenu();
            System.out.println("Select: ");
            int numberMenu = Integer.parseInt(scanner.nextLine());
            if ( numberMenu == 0 ) {
                System.out.println("--- Creat a new item ---");
                System.out.println("Enter name:");
                String nameItem = scanner.nextLine();
                Item item = new Item(nameItem);
                tracker.add(item);
            }else if ( numberMenu == 1 ) {
                System.out.println("--- All items ---");
                for ( Item item : tracker.findAll() ) {
                    showItem( item );
                }
            }else if ( numberMenu == 2 ) {
                System.out.println("--- Replace item ---");
                int id = getEnterIdItem( scanner );
                String nameItem =  getEnterNameItem( scanner );
                Item newItem = new Item(nameItem);
                if( tracker.replace( id, newItem ) ) {
                    System.out.println("Replace complete.");
                } else {
                    System.out.println("Replace not complete. Maybe item 'id' not exist.");
                }
            }else if ( numberMenu == 3 ) {
                System.out.println("--- Delete item ---");
                int id = getEnterIdItem( scanner );
                if( tracker.delete(id) ) {
                    System.out.println("Item delete.");
                } else {
                    System.out.println("Item not delete. Maybe item 'id' not exist.");
                }
            }else if ( numberMenu == 4 ) {
                System.out.println("--- Find item by Id ---");
                int id = getEnterIdItem( scanner );
                Item item = tracker.findById(id);
                if ( item == null ) {
                    System.out.println("Item not found.");
                } else {
                    showItem(item);
                }
            }else if ( numberMenu == 5 ) {
                System.out.println("--- Find item by name ---");
                String nameItem = getEnterNameItem( scanner );
                Item[] itemList = tracker.findByName(nameItem);
                if ( itemList.length == 0) {
                    System.out.println("Item not found.");
                } else {
                    for ( Item item : itemList ) {
                        showItem( item );
                    }
                }
            }else if ( numberMenu == 6 ) {
                run = false;
            }else {
                System.out.println("Number is not correct.");
            }
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-");
        }
    }

    private int getEnterIdItem( Scanner scanner ) {
        System.out.println("Enter id: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private String getEnterNameItem( Scanner scanner ) {
        System.out.println("Enter name: ");
        return scanner.nextLine();
    }

    private void showItem( Item item ) {
        System.out.println("----------------");
        System.out.println("id: " + item.getId());
        System.out.println("name: " + item.getName());
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
