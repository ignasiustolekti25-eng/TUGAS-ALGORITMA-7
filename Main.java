import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // -----------------------------
        // 1️⃣ Print pattern using loops
        // -----------------------------
        System.out.println("Pattern 1:");
        int[] nums = {6, 2, 7, 1, 8, 0, 9, -1, 10};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");

        // -----------------------------
        // 2️⃣ Loop inside loop pattern
        // -----------------------------
        System.out.println("Pattern 2:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0)
                    System.out.print("A ");
                else
                    System.out.print("B ");
            }
            System.out.println();
        }

        System.out.println("\nPattern 3:");
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (j <= i)
                    System.out.print("X ");
                else
                    System.out.print("_ ");
            }
            System.out.println();
        }

        // -----------------------------
        // 3️⃣ Multiple number input + stats
        // -----------------------------
        System.out.print("\nEnter numbers (space separated): ");
        String[] input = sc.nextLine().split(" ");
        int[] values = new int[input.length];
        int sum = 0, max, min;

        for (int i = 0; i < input.length; i++) {
            values[i] = Integer.parseInt(input[i]);
        }

        max = values[0];
        min = values[0];
        for (int n : values) {
            sum += n;
            if (n > max) max = n;
            if (n < min) min = n;
        }
        double avg = (double) sum / values.length;

        System.out.println("Largest number: " + max);
        System.out.println("Lowest number: " + min);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);

        // -----------------------------
        // 4️⃣ Name pattern
        // -----------------------------
        System.out.print("\nEnter your name: ");
        String name = sc.nextLine().toUpperCase();

        System.out.println("Output:");
        for (int i = 0; i < name.length(); i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(name.charAt(j) + " ");
            }
            System.out.println();
        }

        // -----------------------------
        // 5️⃣ Discount calculator
        // -----------------------------
        int pricePerItem = 20000;
        int quantity = 35;
        int discountPercent = (quantity / 10) * 5;
        if (discountPercent > 50) discountPercent = 50;

        double totalPrice = quantity * pricePerItem;
        double discountAmount = totalPrice * discountPercent / 100.0;
        double finalPrice = totalPrice - discountAmount;

        System.out.println("\nQuantity: " + quantity);
        System.out.println("Discount: " + discountPercent + "%");
        System.out.println("Total Price after discount: Rp " + finalPrice);

        // -----------------------------
        // 6️⃣ Palindrome check
        // -----------------------------
        System.out.print("\nEnter a word to check palindrome: ");
        String word = sc.nextLine().toLowerCase();
        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equals(reversed))
            System.out.println(word + " is a palindrome.");
        else
            System.out.println(word + " is NOT a palindrome.");

        // -----------------------------
        // 7️⃣ Login simulation
        // -----------------------------
        ArrayList<String> usernames = new ArrayList<>(Arrays.asList(
                "budi", "andi", "nina", "siti", "nugraha"));
        ArrayList<String> passwords = new ArrayList<>(Arrays.asList(
                "123", "abc", "pass", "000", "xyz"));

        System.out.print("\nEnter username: ");
        String u = sc.nextLine();
        System.out.print("Enter password: ");
        String p = sc.nextLine();

        boolean valid = false;
        for (int i = 0; i < usernames.size(); i++) {
            if (u.equals(usernames.get(i)) && p.equals(passwords.get(i))) {
                valid = true;
                break;
            }
        }

        if (valid)
            System.out.println("Username and password valid, you can login into the dashboard.");
        else
            System.out.println("Wrong username and password.");

        sc.close();
    }
}

