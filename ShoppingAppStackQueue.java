import java.util.*;

class Item {
    String item;
    int price;
    int qty;
    int subtotal;

    // Constructor
    public Item(String item, int price, int qty) {
        this.item = item;
        this.price = price;
        this.qty = qty;
        this.subtotal = price * qty;
    }

    @Override
    public String toString() {
        return String.format("%-10s %7d %5d %9d", item, price, qty, subtotal);
    }
}

public class ShoppingAppStackQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Item> stack = new Stack<>();
        Queue<Item> queue = new LinkedList<>();

        // Manual entries (default data)
        stack.push(new Item("Bags", 100000, 2));
        stack.push(new Item("Hat", 20000, 2));
        queue.add(new Item("Bags", 100000, 2));
        queue.add(new Item("Hat", 20000, 2));

        String answer;
        do {
            System.out.print("Enter item name: ");
            String name = scanner.nextLine();

            int price = 0;
            while (true) {
                try {
                    System.out.print("Enter item price: ");
                    price = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number for price.");
                }
            }

            int qty = 0;
            while (true) {
                try {
                    System.out.print("Enter item quantity: ");
                    qty = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number for quantity.");
                }
            }

            Item newItem = new Item(name, price, qty);
            stack.push(newItem);
            queue.add(newItem);

            System.out.print("Do you want to add another item? (yes/no): ");
            answer = scanner.nextLine().trim().toLowerCase();

        } while (answer.equals("yes"));

        // ===== STACK EXPERIMENT =====
        System.out.println("\n===== STACK EXPERIMENT =====");
        System.out.println("Peek top item: " + stack.peek().item);
        System.out.println("Pop (remove top item): " + stack.pop().item);
        System.out.println("New top item after pop: " + (stack.empty() ? "Empty" : stack.peek().item));

        // Display Stack contents
        System.out.println("\nNo  Item       Price   Qty   Subtotal");
        System.out.println("----------------------------------------");
        int i = 1, total = 0;
        for (Item it : stack) {
            System.out.printf("%-3d %s\n", i++, it);
            total += it.subtotal;
        }
        System.out.println("----------------------------------------");
        System.out.println("Total " + total);

        // ===== QUEUE EXPERIMENT =====
        System.out.println("\n===== QUEUE EXPERIMENT =====");
        System.out.println("Peek front item: " + queue.peek().item);
        System.out.println("Poll (remove first item): " + queue.poll().item);
        System.out.println("New front item after poll: " + (queue.peek() != null ? queue.peek().item : "Empty"));

        System.out.println("\nRemaining items in Queue:");
        i = 1;
        total = 0;
        for (Item it : queue) {
            System.out.printf("%-3d %s\n", i++, it);
            total += it.subtotal;
        }
        System.out.println("----------------------------------------");
        System.out.println("Total " + total);
    }
}
