import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    Item head = null;

    // Add item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
        System.out.println("Item added at the beginning.");
    }

    // Add item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
        System.out.println("Item added at the end.");
    }

    // Remove item by ID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("No items available.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }

    // Update quantity by ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search item by ID or Name
    public void searchItem(String query) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(query) || temp.itemName.equalsIgnoreCase(query)) {
                System.out.println("Item ID: " + temp.itemId + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Sort by Name or Price
    public void sortInventory(String criteria, boolean ascending) {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            Item current = head;
            while (current.next != null) {
                boolean condition = false;
                if (criteria.equalsIgnoreCase("name")) {
                    condition = ascending ? current.itemName.compareTo(current.next.itemName) > 0 :
                                current.itemName.compareTo(current.next.itemName) < 0;
                } else if (criteria.equalsIgnoreCase("price")) {
                    condition = ascending ? current.price > current.next.price :
                                current.price < current.next.price;
                }
                if (condition) {
                    // Swap values
                    String tempName = current.itemName;
                    int tempId = current.itemId;
                    int tempQuantity = current.quantity;
                    double tempPrice = current.price;

                    current.itemName = current.next.itemName;
                    current.itemId = current.next.itemId;
                    current.quantity = current.next.quantity;
                    current.price = current.next.price;

                    current.next.itemName = tempName;
                    current.next.itemId = tempId;
                    current.next.quantity = tempQuantity;
                    current.next.price = tempPrice;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("Inventory sorted by " + criteria + ".");
    }

    // Display all items
    public void displayAllItems() {
        if (head == null) {
            System.out.println("No items available.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("Item ID: " + temp.itemId + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: $" + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Remove Item by ID");
            System.out.println("4. Update Quantity by ID");
            System.out.println("5. Search Item by ID or Name");
            System.out.println("6. Calculate Total Inventory Value");
            System.out.println("7. Sort Inventory by Name/Price");
            System.out.println("8. Display All Items");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    inventory.addAtBeginning(name, id, qty, price);
                    break;
                case 2:
                    System.out.print("Enter Item Name: ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    id = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    price = scanner.nextDouble();
                    inventory.addAtEnd(name, id, qty, price);
                    break;
                case 3:
                    System.out.print("Enter Item ID to remove: ");
                    id = scanner.nextInt();
                    inventory.removeItemById(id);
                    break;
                case 4:
                    System.out.print("Enter Item ID to update: ");
                    id = scanner.nextInt();
                    System.out.print("Enter New Quantity: ");
                    qty = scanner.nextInt();
                    inventory.updateQuantity(id, qty);
                    break;
                case 5:
                    System.out.print("Enter Item ID or Name to search: ");
                    scanner.nextLine();
                    inventory.searchItem(scanner.nextLine());
                    break;
                case 6:
                    inventory.calculateTotalValue();
                    break;
                case 7:
                    System.out.print("Sort by Name or Price? ");
                    scanner.nextLine();
                    String criteria = scanner.nextLine();
                    System.out.print("Sort in ascending order? (true/false): ");
                    boolean ascending = scanner.nextBoolean();
                    inventory.sortInventory(criteria, ascending);
                    break;
                case 8:
                    inventory.displayAllItems();
                    break;
                case 9:
                    scanner.close();
                    return;
            }
        }
    }
}
