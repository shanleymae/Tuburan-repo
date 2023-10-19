import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    String name;
    double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - Php " + price;
    }
}

public class RestaurantApp {
    static ArrayList<MenuItem> menuItems = new ArrayList<>();
    static ArrayList<MenuItem> orders = new ArrayList<>();
    static double total = 0;

    public static void main(String[] args) {
        
        menuItems.add(new MenuItem("C1", 100.00));
        menuItems.add(new MenuItem("C2", 150.00));
        menuItems.add(new MenuItem("C3", 200.00));
        menuItems.add(new MenuItem("R1", 35.00));
        menuItems.add(new MenuItem("R2", 50.00));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i));
            }
            System.out.println("6. Show Orders");
            System.out.println("7. Exit");
            
            System.out.print("Enter order: ");
            int choice = scanner.nextInt();
            
            if (choice == 7) {
                break;
            } else if (choice == 6) {
                showOrders();
            } else if (choice >= 1 && choice <= menuItems.size()) {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                MenuItem selectedItem = menuItems.get(choice - 1);
                double subtotal = quantity * selectedItem.price;
                total += subtotal;
                orders.add(new MenuItem(selectedItem.name, subtotal));
                System.out.println("\nAdded " + quantity + " " + selectedItem.name + " to your order.");
            } else {
                System.out.println("\nInvalid choice. Please try again.");
            }
        }

        // Display summary
        System.out.println("\nSummary:");
        for (MenuItem item : orders) {
            System.out.println(item.name + " - Php " + item.price);
        }
        System.out.println("Total Price: Php " + total);
        System.out.println("Total Price in USD: $ " + total / 50); // Assuming 1 USD = 50 PHP
    }

    public static void showOrders() {
        System.out.println("\nOrders:");
        for (MenuItem item : orders) {
            System.out.println(item.name + " - Php " + item.price);
        }
        System.out.println("Total Price: Php " + total);
        System.out.println("Total Price in USD: $ " + total / 50); // Assuming 1 USD = 50 PHP
    }
}
