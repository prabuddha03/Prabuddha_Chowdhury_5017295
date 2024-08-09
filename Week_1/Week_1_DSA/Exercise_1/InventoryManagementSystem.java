import java.util.ArrayList;
import java.util.List;

class Item {
    private String id;
    private String name;
    private int count;
    private double cost;

    public Item(String id, String name, int count, double cost) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Item [ID=%s, Name=%s, Count=%d, Cost=%.2f]",
                id, name, count, cost);
    }
}

class Stock {
    private List<Item> itemList;

    public Stock() {
        itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemList.add(item);
        System.out.println("\nItem Added:");
        System.out.printf("ID: %s\nName: %s\n", item.getId(), item.getName());
    }

    public void updateItem(Item item) {
        boolean exists = false;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getId().equals(item.getId())) {
                itemList.set(i, item);
                exists = true;
                System.out.println("\nItem Updated:");
                System.out.printf("ID: %s\nName: %s\n", item.getId(), item.getName());
                break;
            }
        }
        if (!exists) {
            System.out.println("\nItem not found in the stock.");
        }
    }

    public void removeItem(String id) {
        boolean exists = false;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getId().equals(id)) {
                Item removedItem = itemList.remove(i);
                exists = true;
                System.out.println("\nItem Removed:");
                System.out.println(removedItem);
                break;
            }
        }
        if (!exists) {
            System.out.println("\nItem not found in the stock.");
        }
    }

    public Item getItem(String id) {
        for (Item item : itemList) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void showAllItems() {
        System.out.println("\nAll Items:");
        if (itemList.isEmpty()) {
            System.out.println("No items found.");
        } else {
            for (Item item : itemList) {
                System.out.println();
                System.out.printf("ID: %s\n", item.getId());
                System.out.printf("Name: %s\n", item.getName());
                System.out.printf("Count: %d\n", item.getCount());
                System.out.printf("Cost: %.2f\n", item.getCost());
                System.out.println();
            }
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Stock stock = new Stock();

        Item item1 = new Item("I01", "Item A", 100, 200.0);
        Item item2 = new Item("I02", "Item B", 20, 300.0);
        stock.addItem(item1);
        stock.addItem(item2);

        stock.showAllItems();

        Item updatedItem1 = new Item("I01", "Updated Item A", 150, 150.0);
        stock.updateItem(updatedItem1);

        System.out.println("\nDetails of Item ID I01:");
        Item singleItem = stock.getItem("I01");
        if (singleItem != null) {
            System.out.println(singleItem);
        } else {
            System.out.println("Item not found.");
        }

        stock.removeItem("I02");

        stock.showAllItems();
    }
}
