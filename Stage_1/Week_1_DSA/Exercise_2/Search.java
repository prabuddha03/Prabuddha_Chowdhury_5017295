import java.util.Arrays;
import java.util.Comparator;

public class Search {
    public static void main(String[] args) {
        Item[] items = {
                new Item(101, "Gaming PC", "Computers"),
                new Item(102, "Wireless Mouse", "Accessories"),
                new Item(103, "Mechanical Keyboard", "Accessories"),
                new Item(104, "4K Monitor", "Computers"),
                new Item(105, "Bluetooth Speaker", "Audio")
        };

        System.out.println("Linear Search by ID: " + Finder.linearSearchById(items, 103));
        System.out.println("Linear Search by Name: " + Finder.linearSearchByName(items, "4K Monitor"));
        System.out.println("Linear Search by Category: " + Finder.linearSearchByCategory(items, "Audio"));

        Arrays.sort(items);
        System.out.println("Binary Search by ID: " + Finder.binarySearchById(items, 103));

        Arrays.sort(items, Comparator.comparing(Item::getName));
        System.out.println("Binary Search by Name: " + Finder.binarySearchByName(items, "4K Monitor"));

        Arrays.sort(items, Comparator.comparing(Item::getCategory));
        System.out.println("Binary Search by Category: " + Finder.binarySearchByCategory(items, "Audio"));
    }
}

class Item implements Comparable<Item> {
    private final int id;
    private final String name;
    private final String category;

    public Item(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id +", name='" + name + '\'' +", category='" + category + '\'' + '}';
    }

    @Override
    public int compareTo(Item other) {
        return Integer.compare(this.id, other.id);
    }
}

class Finder {
    public static Item linearSearchById(Item[] items, int targetId) {
        for (Item item : items) {
            if (item.getId() == targetId) {
                return item;
            }
        }
        return null;
    }

    public static Item linearSearchByName(Item[] items, String targetName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(targetName)) {
                return item;
            }
        }
        return null;
    }

    public static Item linearSearchByCategory(Item[] items, String targetCategory) {
        for (Item item : items) {
            if (item.getCategory().equalsIgnoreCase(targetCategory)) {
                return item;
            }
        }
        return null;
    }

    public static Item binarySearchById(Item[] items, int targetId) {
        int low = 0;
        int high = items.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Item midItem = items[mid];

            if (midItem.getId() == targetId) {
                return midItem;
            } else if (midItem.getId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static Item binarySearchByName(Item[] items, String targetName) {
        int low = 0;
        int high = items.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Item midItem = items[mid];

            int cmp = midItem.getName().compareToIgnoreCase(targetName);
            if (cmp == 0) {
                return midItem;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static Item binarySearchByCategory(Item[] items, String targetCategory) {
        int low = 0;
        int high = items.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Item midItem = items[mid];

            int cmp = midItem.getCategory().compareToIgnoreCase(targetCategory);
            if (cmp == 0) {
                return midItem;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
