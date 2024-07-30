import java.util.Scanner;

class Purchase {
    int id;
    String name;
    double amount;

    public Purchase(int id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Purchase ID: " + id + ", Customer: " + name + ", Amount: $" + amount;
    }
}

public class PurchaseSorter {

    public static void sortByBubble(Purchase[] purchases) {
        int size = purchases.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (purchases[j].amount > purchases[j + 1].amount) {
                    Purchase temp = purchases[j];
                    purchases[j] = purchases[j + 1];
                    purchases[j + 1] = temp;
                }
            }
        }
    }

    public static void sortByQuick(Purchase[] purchases, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(purchases, low, high);
            sortByQuick(purchases, low, pivotIndex - 1);
            sortByQuick(purchases, pivotIndex + 1, high);
        }
    }

    private static int partition(Purchase[] purchases, int low, int high) {
        double pivotValue = purchases[high].amount;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (purchases[j].amount <= pivotValue) {
                i++;
                Purchase temp = purchases[i];
                purchases[i] = purchases[j];
                purchases[j] = temp;
            }
        }
        Purchase temp = purchases[i + 1];
        purchases[i + 1] = purchases[high];
        purchases[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of purchases: ");
        int count = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Purchase[] purchases = new Purchase[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for purchase #" + (i + 1) + ":");
            System.out.print("Purchase ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            purchases[i] = new Purchase(id, name, amount);
        }

        System.out.println("\nPurchases before sorting:");
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }

        Purchase[] bubbleSortedPurchases = purchases.clone();
        sortByBubble(bubbleSortedPurchases);
        System.out.println("\nPurchases after Bubble Sort:");
        for (Purchase purchase : bubbleSortedPurchases) {
            System.out.println(purchase);
        }

        Purchase[] quickSortedPurchases = purchases.clone();
        sortByQuick(quickSortedPurchases, 0, quickSortedPurchases.length - 1);
        System.out.println("\nPurchases after Quick Sort:");
        for (Purchase purchase : quickSortedPurchases) {
            System.out.println(purchase);
        }

        scanner.close();
    }
}
