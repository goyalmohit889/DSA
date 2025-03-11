import java.util.ArrayList;
import java.util.Scanner;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    User head = null;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        System.out.println("User added successfully.");
    }

    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.friendIds.add(userId2);
            user2.friendIds.add(userId1);
            System.out.println("Friend connection added successfully.");
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
            System.out.println("Friend connection removed successfully.");
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            System.out.println("Mutual Friends: ");
            for (int id1 : user1.friendIds) {
                if (user2.friendIds.contains(id1)) {
                    System.out.println("User ID: " + id1);
                }
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ":");
            for (int id : user.friendIds) {
                User friend = findUserById(id);
                System.out.println("User ID: " + friend.userId + ", Name: " + friend.name);
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public void searchUser(int userId, String name) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId || temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found - ID: " + temp.userId + ", Name: " + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println("User: " + temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }

    public User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialMedia socialMedia = new SocialMedia();

        while (true) {
            System.out.println("\n1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display All Friends of a User");
            System.out.println("6. Search User");
            System.out.println("7. Count Friends of Each User");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    socialMedia.addUser(userId, name, age);
                    break;
                case 2:
                    System.out.print("Enter User ID 1: ");
                    int userId1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int userId2 = scanner.nextInt();
                    socialMedia.addFriendConnection(userId1, userId2);
                    break;
                case 3:
                    System.out.print("Enter User ID 1: ");
                    userId1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    userId2 = scanner.nextInt();
                    socialMedia.removeFriendConnection(userId1, userId2);
                    break;
                case 4:
                    System.out.print("Enter User ID 1: ");
                    userId1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    userId2 = scanner.nextInt();
                    socialMedia.findMutualFriends(userId1, userId2);
                    break;
                case 5:
                    System.out.print("Enter User ID: ");
                    userId = scanner.nextInt();
                    socialMedia.displayFriends(userId);
                    break;
                case 6:
                    System.out.print("Enter User ID: ");
                    userId = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    name = scanner.next();
                    socialMedia.searchUser(userId, name);
                    break;
                case 7:
                    socialMedia.countFriends();
                    break;
                case 8:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
